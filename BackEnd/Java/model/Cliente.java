package model;

import java.util.Date;



public class Cliente {
	private int id;
	private String nome;
	private Date dataNasc;
	private String sexo;
	private String cpf;
	private String telefone;
	private String email;
	private String senha;
	
	public Cliente() {
		super();
	}

	public Cliente(int id, String nome, Date dataNasc, String sexo, String cpf, String telefone, String email,
			String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	public void mostarCliente() {
	System.out.println("======== Cliente =========");
	System.out.println("Cliente: " + this.nome + " id: " + this.id);
	System.out.println("Nascimento: " + this.dataNasc);
	System.out.println("Data de Nascimento: " + this.dataNasc);
	System.out.println("Email: " + this.email + " Telefone: " + this.telefone);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
