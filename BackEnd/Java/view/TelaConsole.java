package view;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import model.Cliente;
import model.Funcionario;
import model.Pacote;
import model.dao.ClienteDao;
import model.dao.FuncionarioDao;
import model.dao.PacoteDao;

public class TelaConsole {

	public static void main(String[] args) {
		int op1;
		int op2;
	
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = new Cliente();
		PacoteDao pacoteDao = new PacoteDao();
		Pacote pacote = new Pacote();
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = new Funcionario();
		//Definição de Scanners para cada função devido aos bugs
		Scanner string = new Scanner(System.in);
		Scanner numero = new Scanner(System.in);
		Scanner entradaNomes = new Scanner(System.in); //Absorve apenas as entradas de nomes compostos
		
		do {
		System.out.println("===== Sistema de CAD Bússola Tour ======\n");
		System.out.println("Escolha o Tipo: ");
		System.out.println("1 - Cliente");
		System.out.println("2 - Pacote de Viagem");
		System.out.println("3 - Funcionário");
		System.out.println("0 - Sair");
		op1 = numero.nextInt();
		
		switch(op1) {
		
		case 1:
			System.out.println("====== Cliente ======\n");
			System.out.println("1 - Inserir");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Remover");
			System.out.println("4 - Visualizar");
			op2 = numero.nextInt();
			
			switch(op2) {
			case 1:
				System.out.println("====== Inserir Cliente ========");
				System.out.println("Digite o nome do cliente");
				cliente.setNome(entradaNomes.nextLine());
				entradaNomes.nextLine(); //bug!
				//FORMATAÇÃO DE INSERÇÃO DE DATA
				System.out.println("Data de Nascimento (dd/mm/aaaa):");
				String dataDigitada = string.next();
				String []data = dataDigitada.split("/");
				GregorianCalendar g1 = new GregorianCalendar();
				g1.set(GregorianCalendar.DAY_OF_MONTH, Integer.parseInt(data[0]));
				g1.set(GregorianCalendar.MONTH, Integer.parseInt(data[1])-1);
				g1.set(GregorianCalendar.YEAR, Integer.parseInt(data[2]));
				cliente.setDataNasc((Date) g1.getTime());
			
				System.out.println("Sexo:");
				cliente.setSexo(string.next());
				System.out.println("CPF :");
				cliente.setCpf(string.next());
				System.out.println("Telefone:");
				cliente.setTelefone(string.next());
				System.out.println("Email");
				cliente.setEmail(string.next());
				System.out.println("Senha:");
				cliente.setSenha(string.next());
				
				clienteDao.criarCliente(cliente);
				System.out.println("==== Cliente Criado com Sucesso! ====");
				break;
			
			case 2: 
				System.out.println("====== Atualizar Cliente ========");
				System.out.println("Inserir Nome:");
				cliente.setNome(entradaNomes.nextLine());
				entradaNomes.nextLine();//bug!
				System.out.println("Inserir Data de Nascimneto (dd/mm/aaaa)");
				String dataEntrada = string.next();
				String []date = dataEntrada.split("/");
				GregorianCalendar g2 = new GregorianCalendar();
				g2.set(GregorianCalendar.DAY_OF_MONTH, Integer.parseInt(date[0]));
				g2.set(GregorianCalendar.MONTH, Integer.parseInt(date[1])-1);
				g2.set(GregorianCalendar.YEAR, Integer.parseInt(date[2]));
				cliente.setDataNasc((Date) g2.getTime());
				System.out.println("Inserir Sexo:");
				cliente.setSexo(string.next());
				System.out.println("Inserir CPF :");
				cliente.setCpf(string.next());
				System.out.println("Inserir Telefone:");
				cliente.setTelefone(string.next());
				System.out.println("Inserir Email");
				cliente.setEmail(string.next());
				System.out.println("Inserir Senha:");
				cliente.setSenha(string.next());
				System.out.println("Digite o ID do Cliente que deseja atualizar:");
				cliente.setId(numero.nextInt());
				
				clienteDao.atualizarCliente(cliente);
				System.out.println("==== Cliente Atualizado com Sucesso! ====");
				break;
			
			case 3:
				System.out.println("====== Remover Cliente ========");
				System.out.println("Digite o ID do CLinete que deseja remover:");
				int id = numero.nextInt();
				
				clienteDao.removerCliente(id);
				System.out.println("==== Cliente Removido com Sucesso! ====");
				break;
			case 4:
				System.out.println("====== Visualizar Clientes ========");
				for(Cliente c: clienteDao.verClientes()) {
				System.out.println("----------------------");
				System.out.printf("Nome: %s \n" + "Data de Nascimento: %s \n" + "Sexo: %s \n" + "CPF: %s \n" 
						+ "Telefone: %s \n" + "Email: %s \n" + "Senha: %s", c.getNome(), c.getDataNasc(), c.getSexo(), c.getCpf(), 
							c.getTelefone(), c.getEmail(), c.getSenha() +"\n");
				System.out.println("----------------------");
				}
				System.out.println("==== Final da Visualização ==== \n");
				break;
			}
			break;
		
		case 2:
			System.out.println("===== Pacote de Viagem ======\n");
			System.out.println("1 - Inserir");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Remover");
			System.out.println("4 - Visualizar");
			op2 = string.nextInt();
			
			switch(op2) {
			case 1:
				System.out.println("====== Inserir Pacote ========");
				System.out.println("Digite o Tipo do Pacote:");
				pacote.setTipo(string.next());
				System.out.println("Cidade de Partida:");
				pacote.setPartida(entradaNomes.nextLine());
				entradaNomes.nextLine();//bug!
				System.out.println("Cidade de Destino:");
				pacote.setDestino(entradaNomes.nextLine());
				entradaNomes.nextLine();//bug!
				System.out.println("Horário de Saída (00:00):");
				pacote.setHorSaida(string.next());				
				System.out.println("Horário de Chegada (00:00):");
				pacote.setHorChegada(string.next());
				System.out.println("Qual o meio de Transporte:");
				pacote.setTransporte(string.next());
				
				pacoteDao.criarPacote(pacote);
				System.out.println("==== Pacote Criado com Sucesso! ====");
				break;
			
			case 2: 
				System.out.println("====== Atualizar Pacote ========");
				System.out.println("Insira o Tipo: ");
				pacote.setTipo(string.next());
				System.out.println("Insira a Cidade de Partida:");
				pacote.setPartida(entradaNomes.nextLine());
				entradaNomes.nextLine();//bug!
				System.out.println("Insira a Cidade de Destino:");
				pacote.setDestino(entradaNomes.nextLine());
				entradaNomes.nextLine();//bug!
				System.out.println("Insira o Horário de Saída:");
				pacote.setHorSaida(string.next());
				System.out.println("Insira o Horário de Chegada:");
				pacote.setHorChegada(string.next());
				System.out.println("Insira o meio de Transporte: ");
				pacote.setTransporte(string.next());
				System.out.println("Insira o ID do Pacote que deseja atualizar: ");
				pacote.setId(numero.nextInt());
				
				pacoteDao.atualizarPacote(pacote);
				System.out.println("==== Pacote Atualizado com Sucesso! ====");
				break;
			
			case 3:
				System.out.println("====== Remover Pacote ========");
				System.out.println("Digite o ID do Pacote que deseja remover: ");
				int id = numero.nextInt();
				
				pacoteDao.removerPacote(id);
				System.out.println("==== Pacote Removido com Sucesso! ====");
				break;
				
			case 4:
				System.out.println("====== Visualizar Pacotes ========");
				for(Pacote p: pacoteDao.verPacotes()) {
					System.out.println("----------------------");
					System.out.printf("Tipo: %s \n" + "Partida: %s \n" + "Destino: %s \n" + "Horário de Saída: %s \n" 
							+ "Horário de Chegada: %s \n" + "Transporte: %s \n" , p.getTipo(), p.getPartida(), p.getDestino(), p.getHorSaida(), 
							p.getHorChegada(), p.getTransporte() +"\n");
					System.out.println("----------------------");
					}
					System.out.println("==== Final da Visualização ==== \n");
				break;
			}
			break;
		
		case 3:
			System.out.println("===== Funcionários ======\n");
			System.out.println("1 - Inserir");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Remover");
			System.out.println("4 - Visualizar");
			op2 = string.nextInt();
			
			switch(op2) {
			case 1:
				System.out.println("======= Inserir Funcionário ======");
				System.out.println("Digite o Nome do Funcionário:");
				funcionario.setNome(entradaNomes.nextLine());
				entradaNomes.nextLine();
				System.out.println("Digite o Nível de Acesso:");
				funcionario.setNivelAces(string.next());
				System.out.println("Digite o Acesso:");
				funcionario.setAcesso(string.next());
				System.out.println("Digite a Senha");
				funcionario.setSenha(string.next());				
				
				funcionarioDao.inserirFunc(funcionario);
				System.out.println("==== Funcionário Criado com Sucesso! ====");
				break;
			
			case 2: 
				System.out.println("======= Atualizar Funcionário ======");
				System.out.println("Insira o Nome:");
				funcionario.setNome(entradaNomes.nextLine());
				entradaNomes.nextLine();
				System.out.println("Insira o Nível de Acesso:");
				funcionario.setNivelAces(string.next());
				System.out.println("Insira o Acesso:");
				funcionario.setAcesso(string.next());
				System.out.println("Insira a Senha");
				funcionario.setSenha(string.next());
				System.out.println("Insira o ID do Funcionário que deseja atualizar:");
				funcionario.setId(numero.nextInt());
				
				funcionarioDao.atualizarFunc(funcionario);
				System.out.println("==== Funcionário Atualizado com Sucesso! ====");
				break;
			
			case 3:
				System.out.println("======= Remover Funcionário ======");
				System.out.println("Digite o ID do Funcionário que deseja remover: ");
				int id = numero.nextInt();
				
				funcionarioDao.removerFunc(id);
				System.out.println("==== Funcionário Removido com Sucesso! ====");
				break;
			
			case 4:
				System.out.println("====== Visualizar Funcionários ========");
				for(Funcionario f: funcionarioDao.verFunc()) {
					System.out.println("----------------------");
					System.out.printf("Nome: %s \n" + "Nível de Acesso: %s \n" + "Acesso: %s \n" + "Senha: %s \n" 
							, f.getNome(), f.getNivelAces(), f.getAcesso(), f.getSenha() + "\n");
					System.out.println("----------------------");
				}
				break;
			}
			break;
		}
		}while(op1 != 0);
		
		System.out.println("====== Fim do Programa ======");
		string.close();
		numero.close();
		entradaNomes.close();
	}

}
