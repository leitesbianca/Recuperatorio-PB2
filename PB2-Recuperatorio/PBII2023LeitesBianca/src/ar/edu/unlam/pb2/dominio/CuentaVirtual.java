package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public class CuentaVirtual extends MedioDePago implements Pagadora, Transferible {
	private final Integer CVU;
	private Double saldo;

	public CuentaVirtual(Persona titular, Integer CVU, Double saldo) {
		super(titular);
		this.CVU = CVU;
		this.saldo = saldo;
	}

	public Integer getCVU() {
		return CVU;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CVU);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaVirtual other = (CuentaVirtual) obj;
		return Objects.equals(CVU, other.CVU);
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) throws SaldoInsuficienteException{
		if (vendedor instanceof Comercio && saldo >= importe) {
			saldo -= importe;
			return true;
		} throw new SaldoInsuficienteException();
	}

	@Override
	public Double getSaldo() {
		return this.saldo;
	}

	@Override
	public void Depositar(Double importe) {
		this.saldo += importe;
	}

	@Override
	public Boolean extraer(Double importe) {
		if (saldo >= importe) {
			this.saldo -= importe;
			return true;
		} return false;
	}
	
	

}
