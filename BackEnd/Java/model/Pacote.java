package model;

public class Pacote {
	private int id_pacote;
	private String tipo;
	private String partida;
	private String destino;
	private String horSaida;
	private String horChegada;
	private String transporte;
	

	public Pacote() {
	}

	public Pacote(int id_pacote, String tipo, String partida, String destino, String horSaida, String horChegada,
			String transporte) {
		this.id_pacote = id_pacote;
		this.tipo = tipo;
		this.partida = partida;
		this.destino = destino;
		this.horSaida = horSaida;
		this.horChegada = horChegada;
		this.transporte = transporte;
	}

	public void mostrarPacote(){
	System.out.println("==========");;
	System.out.println("ID Pacote: " + this.id_pacote + " Tipo: " + this.tipo);
	System.out.println("Partida: " + this.partida);
	System.out.println("Destino: " + this.destino);
	System.out.println("Horário de Saída: " + this.horSaida);
	System.out.println("Horário de Chegada: " + this.horChegada);
	System.out.println("Meio de Transporte: " + this.transporte	+ "\n");
	}

	public int getId_Pacote() {
		return id_pacote;
	}

	public void setId_Pacote(int id) {
		this.id_pacote = id;
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