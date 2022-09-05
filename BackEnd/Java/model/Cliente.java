package model;

import java.util.Date;



public class Cliente {
	private int id_cliente;
	private String nome;
	private Date dataNasc;
	private String sexo;
	private String cpf;
	private String telefone;
	private String email;
	private String senha;
	
	public Cliente() {
	}

	public Cliente(int id_cliente, String nome, Date dataNasc, String sexo, String cpf, String telefone, String email,
			String senha) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	public void mostarCliente() {
	System.out.println("==========");
	System.out.println("Cliente: " + this.nome + " ID: " + this.id_cliente);
	System.out.println("CPF: " + this.cpf);
	System.out.println("Data de Nascimento: " + this.dataNasc);
	System.out.println("Email: " + this.email + " Telefone: " + this.telefone + "\n");
	//A senha não será mostrada por ser informação confudencial de acordo
	// com a regra de negocio do projeto
	}

	public int getId_Cliente() {
		return id_cliente;
	}

	public void setId_Cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
		
	}

}
