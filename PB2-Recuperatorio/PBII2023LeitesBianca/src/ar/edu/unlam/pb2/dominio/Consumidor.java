package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public class Consumidor extends Persona {

	private final Integer CUIL;
	private Integer dni;
	
	public Consumidor(String nombre, Integer dni, Integer CUIL) {
		super(nombre);
		this.dni = dni;
		this.CUIL = CUIL;
	}
	
	

	public Integer getDni() {
		return dni;
	}



	public void setDni(Integer dni) {
		this.dni = dni;
	}



	public Integer getCUIL() {
		return CUIL;
	}



	@Override
	public int hashCode() {
		return Objects.hash(CUIL);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumidor other = (Consumidor) obj;
		return Objects.equals(CUIL, other.CUIL);
	}

	
}
