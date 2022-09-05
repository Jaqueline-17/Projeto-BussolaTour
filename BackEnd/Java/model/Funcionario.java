package model;

public class Funcionario {
	private int id_funcionario;
	private String nome;
	private String nivelAces;
	private String acesso;
	private String senha;
	
	public Funcionario() {
	}

	public Funcionario(int id_funcionario, String nome, String nivelAces, String acesso, String senha) {
		super();
		this.id_funcionario = id_funcionario;
		this.nome = nome;
		this.nivelAces = nivelAces;
		this.acesso = acesso;
		this.senha = senha;
	}

	public void mostrarFunc(){
		System.out.println("==========");
		System.out.println("Nome: " + this.nome + " Id: " + this.id_funcionario);
		System.out.println("Nível de Acesso: " + this.nivelAces);
		System.out.println("Acesso: " + acesso + "\n");
	}

	public int getId_Funcionario() {
		return id_funcionario;
	}

	public void setId_Funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
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
