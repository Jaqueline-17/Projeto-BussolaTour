	package model;

public class Pedidos {
	private int id_pedido;
	private Pacote pacote;
	private Cliente cliente;
	private Funcionario funcionario;
	
	public Pedidos() {
	}
	
	public Pedidos(Pacote pacote, Cliente cliente, Funcionario funcionario) {
		this.pacote = pacote;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}
	
	public int getId_Pedido() {
		return id_pedido;
	}
	public void setId_Pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Pacote getPacote() {
		return pacote;
	}
	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
