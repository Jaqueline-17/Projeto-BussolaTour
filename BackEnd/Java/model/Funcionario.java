package model;

public class Funcionario {
	private int id;
	private String nome;
	private String nivelAces;
	private String acesso;
	private String senha;
	
	public void mostrarFunc(){
		System.out.println("======= Funcionário ========");
		System.out.println("Nome: " + this.nome + " Id: " + this.id);
		System.out.println("Nível de Acesso: " + this.nivelAces + " Acesso: " + acesso);
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

	public String getNivelAces() {
		return nivelAces;
	}

	public void setNivelAces(String nivelAces) {
		this.nivelAces = nivelAces;
	}

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
