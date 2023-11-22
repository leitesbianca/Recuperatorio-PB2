package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public class Comercio extends Persona{
	private final Integer CBU;
	
	public Comercio(String nombre, Integer CBU) {
		super(nombre);
		this.CBU = CBU;
	}
	
	

	public Integer getCBU() {
		return CBU;
	}



	@Override
	public int hashCode() {
		return Objects.hash(CBU);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comercio other = (Comercio) obj;
		return Objects.equals(CBU, other.CBU);
	}
	
	

}
