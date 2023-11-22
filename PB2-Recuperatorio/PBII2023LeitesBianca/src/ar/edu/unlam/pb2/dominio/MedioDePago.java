package ar.edu.unlam.pb2.dominio;

public class MedioDePago {
	private Persona titular;

	public MedioDePago (Persona titular) {
		this.titular = titular;
	}

	public Persona getTitular() {
		return titular;
	}

	public void setTitular(Persona titular) {
		this.titular = titular;
	}
	
}
