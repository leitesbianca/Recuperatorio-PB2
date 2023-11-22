package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public class Tarjeta extends MedioDePago {
	private final Integer NRO;
	
	public Tarjeta(Persona titular, Integer NRO) {
		super(titular);
		this.NRO = NRO;
	}

	public Integer getNRO() {
		return NRO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(NRO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		return Objects.equals(NRO, other.NRO);
	} 
	
	

}
