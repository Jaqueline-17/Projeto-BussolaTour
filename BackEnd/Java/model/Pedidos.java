package model;

public class Pedidos {
	private int id;
	private String tipoPacote;
	private int idPacote;
	private int idCliente;
	private int idFuncionario;
	
	public int getIdPedido() {
		return id;
	}
	public void setIdPedido(int id) {
		this.id = id;
	}
	public String getTipoPacote() {
		return tipoPacote;
	}
	public void setTipoPacote(String tipoPacote) {
		this.tipoPacote = tipoPacote;
	}
	public int getIdPacote() {
		return idPacote;
	}
	public void setIdPacote(int idPacote) {
		this.idPacote = idPacote;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	
	
	
}
