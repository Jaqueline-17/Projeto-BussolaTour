package view;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import model.Cliente;
import model.Funcionario;
import model.Pacote;
import model.Pedidos;
import model.dao.ClienteDao;
import model.dao.FuncionarioDao;
import model.dao.PacoteDao;
import model.dao.PedidoDao;

public class TelaConsole {

	public static void main(String[] args) {
		int opcao1;
		int opcao2;
	
		ClienteDao clienteDao = new ClienteDao();
		Cliente cliente = new Cliente();
		PacoteDao pacoteDao = new PacoteDao();
		Pacote pacote = new Pacote();
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = new Funcionario();
		PedidoDao pedidoDao = new PedidoDao();
		
		//Definição de Scanners para cada função devido aos bugs
		Scanner string = new Scanner(System.in);
		Scanner numero = new Scanner(System.in);
		Scanner entradaNomes = new Scanner(System.in); //Absorve apenas as entradas de nomes compostos
		
		String tipoPacote = "";
		int id_pacote = 0;
		int id_cliente = 0;
		int id_funcionario = 0;
		
		do {
		System.out.println("====== Sistema de CAD Bússola Tour ======\n");
		System.out.println("Escolha o Tipo: \n");
		System.out.println("[1] - Cliente");
		System.out.println("[2] - Pacote de Viagem");
		System.out.println("[3] - Funcionário");
		System.out.println("[4] - Pedido");
		System.out.println("[0] - Sair");
		opcao1 = numero.nextInt();
		
		switch(opcao1) {
		
		case 1:
			do {
				System.out.println("====== CLIENTE ======\n");
				System.out.println("[1] - Inserir");
				System.out.println("[2] - Atualizar");
				System.out.println("[3] - Remover");
				System.out.println("[4] - Visualizar");
				System.out.println("[5] - Selecionar por ID");
				System.out.println("[0] - Voltar ao Menu Principal");
				opcao2 = numero.nextInt();
				
				switch(opcao2) {
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
					System.out.println("\n==== Cliente Criado com Sucesso! ====");
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
					cliente.setId_Cliente(numero.nextInt());
					
					clienteDao.atualizarCliente(cliente);
					System.out.println("\n==== Cliente Atualizado com Sucesso! ====");
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
						c.mostarCliente();
					}
					System.out.println("\n==== Final da Visualização ==== \n");
					break;
				
				case 5:
					System.out.println("====== Visualizar Cliente Pelo ID ========");
					System.out.println("Digite o ID do Cliente:");
					int id1 = numero.nextInt();
					Cliente c2 = clienteDao.selecionarPorId(id1);
					c2.mostarCliente();
					System.out.println("\n==== Final da Visualização ==== \n");
					break;
				}
			} while(opcao2 != 0);
			
			break;
		
		case 2:
			do {
				System.out.println("===== PACOTE DE VIAGEM ======\n");
				System.out.println("[1] - Inserir");
				System.out.println("[2] - Atualizar");
				System.out.println("[3] - Remover");
				System.out.println("[4] - Visualizar");
				System.out.println("[5] - Selecionar por ID");
				System.out.println("[0] - Voltar ao Menu Principal");
				opcao2 = numero.nextInt();
				
				switch(opcao2) {
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
					System.out.println("==== Pacote Criado com Sucesso! ====\n");
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
					System.out.println("Insira o Horário de Saída (00:00):");
					pacote.setHorSaida(string.next());
					System.out.println("Insira o Horário de Chegada (00:00):");
					pacote.setHorChegada(string.next());
					System.out.println("Insira o meio de Transporte: ");
					pacote.setTransporte(string.next());
					System.out.println("Insira o ID do Pacote que deseja atualizar: ");
					pacote.setId_Pacote(numero.nextInt());
					
					pacoteDao.atualizarPacote(pacote);
					System.out.println("==== Pacote Atualizado com Sucesso! ====\n");
					break;
				
				case 3:
					System.out.println("====== Remover Pacote ========");
					System.out.println("Digite o ID do Pacote que deseja remover: ");
					int id = numero.nextInt();
					
					pacoteDao.removerPacote(id);
					System.out.println("==== Pacote Removido com Sucesso! ====\n");
					break;
					
				case 4:
					System.out.println("====== Visualizar Pacotes ========");
					for(Pacote p: pacoteDao.verPacotes()) {
						p.mostrarPacote();
						}
						System.out.println("\n==== Final da Visualização ==== \n");
					break;
				
				case 5:
					System.out.println("====== Visualizar Pacote Pelo ID ========");
					System.out.println("Digite o ID do Pacote:");
					int id1 = numero.nextInt();
					Pacote p2 = pacoteDao.selecionarPorId(id1);
					p2.mostrarPacote();
					System.out.println("\n==== Final da Visualização ==== \n");
					break;
				}
			}while(opcao2 != 0);
			
			break;
		
		case 3:
			do {
				System.out.println("===== FUNCIONÁRIOS ======\n");
				System.out.println("[1] - Inserir");
				System.out.println("[2] - Atualizar");
				System.out.println("[3] - Remover");
				System.out.println("[4] - Visualizar");
				System.out.println("[5] - Selecionar por ID");
				System.out.println("[0] - Voltar ao Menu Principal");
				opcao2 = numero.nextInt();
				
				switch(opcao2) {
				case 1:
					System.out.println("======= Inserir Funcionário ======");
					System.out.println("Digite o Nome do Funcionário:");
					funcionario.setNome(entradaNomes.nextLine());
					entradaNomes.nextLine();
					System.out.println("Digite o Nível de Acesso [Alto] [Médio] [Baixo]:");
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
					System.out.println("Insira o Nível de Acesso [Alto] [Médio] [Baixo]: ");
					funcionario.setNivelAces(string.next());
					System.out.println("Insira o Acesso:");
					funcionario.setAcesso(string.next());
					System.out.println("Insira a Senha");
					funcionario.setSenha(string.next());
					System.out.println("Insira o ID do Funcionário que deseja atualizar:");
					funcionario.setId_Funcionario(numero.nextInt());
					
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
						f.mostrarFunc();				}
					System.out.println("\n==== Final da Visualização ==== \n");
					break;
				
				case 5:
					System.out.println("====== Visualizar Funcionário Pelo ID ========");
					System.out.println("Digite o ID do Funcionário:");
					int id1 = numero.nextInt();
					Funcionario f2 = funcionarioDao.selecionarPorId(id1);
					f2.mostrarFunc();
					System.out.println("\n==== Final da Visualização ==== \n");
					break;
				}
			}while(opcao2 != 0);
			break;
			
		case 4:
			do {
				System.out.println("===== PEDIDO ======\n");
				System.out.println("[1] - Inserir");
				System.out.println("[2] - Atualizar");
				System.out.println("[3] - Remover");
				System.out.println("[4] - Visualizar");
				System.out.println("[5] - Selecionar por ID");
				System.out.println("[0] - Voltar ao Menu Principal");
				System.out.println("\n*ANTES DE USAR ESTE MENU, CERTIFIQUE-SE QUE PACOTES, CLIENTES E FUNCIONÁRIOS JÁ FORAM CRIADOS!* \n");
				opcao2 = numero.nextInt();
				
				
				switch(opcao2) {
				case 1:
					System.out.println("===== Cadastrar Pedido ======\n");
					System.out.println("Digite o ID do Pacote de Viagens:");
					id_pacote = numero.nextInt();
					System.out.println("Digite o ID do Cliente:");
					id_cliente = numero.nextInt();
					System.out.println("Digite o ID do Funcionario:");
					id_funcionario = numero.nextInt();
					
					Pacote pacote1 = pacoteDao.selecionarPorId(id_pacote);
					Cliente cliente1 = clienteDao.selecionarPorId(id_cliente);
					Funcionario funcionario1 = funcionarioDao.selecionarPorId(id_funcionario);
					Pedidos pedido = new Pedidos(pacote1, cliente1, funcionario1);
					pedidoDao.criarPedido(pedido);
					System.out.println("==== Pedido Criado com Sucesso! ====");
					break;
					
				case 2:
					System.out.println("===== Atualizar Pedido ======\n");
					System.out.println("Insira o ID do Pacote de Viagens:");
					id_pacote = numero.nextInt();
					System.out.println("Insira o ID do Cliente:");
					id_cliente = numero.nextInt();
					System.out.println("Insira o ID do Funcionario:");
					id_funcionario = numero.nextInt();
					
					Pacote pacote2 = pacoteDao.selecionarPorId(id_pacote);
					Cliente cliente2 = clienteDao.selecionarPorId(id_cliente);
					Funcionario funcionario2 = funcionarioDao.selecionarPorId(id_funcionario);
					Pedidos pedido1 = new Pedidos(pacote2, cliente2, funcionario2);
					pedidoDao.atualizarPedido(pedido1);
					System.out.println("==== Pedido Atualizado com Sucesso! ====");
					break;
					
				case 3:
					System.out.println("====== Remover Pedido ========");
					System.out.println("Digite o ID do Pedido que deseja remover: ");
					int id = numero.nextInt();
					
					pedidoDao.deletarPedido(id);
					System.out.println("==== Pedido Removido com Sucesso! ====");
					break;
					
				case 4:
					System.out.println("====== Visualizar Pedidos ========");
					for(Pedidos p : pedidoDao.verPedidos()) {
						System.out.println("========");
						System.out.println("ID do Pedido: " + p.getId_Pedido() + "\nID do Pacote: " + p.getPacote().getId_Pacote() + "\nTipo: " + p.getPacote().getTipo()
											+ "\nID do Cliente: " + p.getCliente().getId_Cliente() + "\nID do Funcionario: " + p.getFuncionario().getId_Funcionario());
						System.out.println("========");
						}
					System.out.println("\n==== Final da Visualização ==== \n");
					break;

				case 5:
					System.out.println("====== Visualizar Pedido Pelo ID ========");
					System.out.println("Digite o ID do Pedido:");
					int id1 = numero.nextInt();
					Pedidos p2 = pedidoDao.selecionarPedido(id1);
					System.out.println("========");
					System.out.println("ID do Pedido: " + p2.getId_Pedido() + "\nID do Pacote: " + p2.getPacote().getId_Pacote() + "\nTipo: " + p2.getPacote().getTipo() 
							+ "\nID do Cliente: " + p2.getCliente().getId_Cliente() + "\nID do Funcionario: " + p2.getFuncionario().getId_Funcionario());
					System.out.println("========");
					System.out.println("\n==== Final da Visualização ==== \n");
					break;	
				}
				
			} while(opcao2 != 0);
			break;
		}
		}while(opcao1 != 0);
		
		System.out.println("====== Fim do Programa ======");
		string.close();
		numero.close();
		entradaNomes.close();
	}

}
