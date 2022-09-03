package model;

public class Pacote {
	private int id;
	private String tipo;
	private String partida;
	private String destino;
	private String horSaida;
	private String horChegada;
	private String transporte;
	

	public void mostrarDestino(){
	System.out.println("========= Pacote ==========");
	System.out.println("ID  Pacote: " + id + " Tipo: " + tipo);
	System.out.println("Partida: " + partida);
	System.out.println("Destino: " + destino);
	System.out.println("Horário de Saída: " + horSaida);
	System.out.println("Horário de Chegada: " + horChegada);
	System.out.println("Meio de Transporte: " + transporte	);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPartida() {
		return partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getHorSaida() {
		return horSaida;
	}

	public void setHorSaida(String horSaida) {
		this.horSaida = horSaida;
	}

	public String getHorChegada() {
		return horChegada;
	}

	public void setHorChegada(String horChegada) {
		this.horChegada = horChegada;
	}

	public String getTransporte() {
		return transporte;
	}

	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

	

}