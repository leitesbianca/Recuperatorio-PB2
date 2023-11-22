package ar.edu.unlam.pb2.dominio;

public class TarjetaDeDebito extends Tarjeta implements Pagadora {
	private Double saldo; 

	public TarjetaDeDebito(Persona titular, Integer NRO, Double saldo) {
		super(titular, NRO);
		this.saldo = saldo;
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) throws SaldoInsuficienteException {

		if (vendedor instanceof Comercio && saldo >= importe) {
			saldo -= importe;
			return true;
		}
		    throw new SaldoInsuficienteException();
	}

}
