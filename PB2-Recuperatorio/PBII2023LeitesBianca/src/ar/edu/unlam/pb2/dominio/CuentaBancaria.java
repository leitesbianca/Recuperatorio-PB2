package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public abstract class CuentaBancaria extends MedioDePago{
	private final Integer CBU;
	private Double saldo;
	
	public CuentaBancaria (Persona titular, Integer CBU, Double saldo ) {
		super(titular);
		this.CBU = CBU;
		this.saldo = saldo;
	}
	
	

	public Double getSaldo() {
		return saldo;
	}



	public void setSaldo(Double saldo) {
		this.saldo = saldo;
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
		CuentaBancaria other = (CuentaBancaria) obj;
		return Objects.equals(CBU, other.CBU);
	}

	
}
