package ar.edu.unlam.pb2.dominio;

public class TarjetaDeCredito extends Tarjeta implements Pagadora {
	private final Double LIMITE_DE_COMPRA;

	public TarjetaDeCredito(Persona titular, Integer NRO, Double LIMITE_DE_COMPRA) {
		super(titular, NRO);
		this.LIMITE_DE_COMPRA = LIMITE_DE_COMPRA;
	}

	public Double getLIMITE_DE_COMPRA() {
		return LIMITE_DE_COMPRA;
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) throws ExcedeLimiteDeCompraException {
		if (vendedor instanceof Comercio && LIMITE_DE_COMPRA >= importe) {
			return true;
		}
		    throw new ExcedeLimiteDeCompraException();
	}

	
	
}
