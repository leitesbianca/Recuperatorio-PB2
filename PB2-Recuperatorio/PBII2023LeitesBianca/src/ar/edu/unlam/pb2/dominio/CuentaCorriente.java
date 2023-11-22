package ar.edu.unlam.pb2.dominio;

public class CuentaCorriente extends CuentaBancaria implements Pagadora, Transferible{
	private Double sobregiro = 0.0;

	public CuentaCorriente(Persona titular, Integer CBU, Double saldo) {
		super(titular, CBU, saldo);
		
	}

	public Double getSobregiro() {
		return sobregiro;
	}

	public void setSobregiro(Double sobregiro) {
		this.sobregiro = sobregiro;
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) {
		Double diferencia = 0.0;
		
		if (this.getSaldo() < importe) {
			
			diferencia += this.getSaldo() - importe;
			this.sobregiro += diferencia;
			
		} this.setSaldo(getSaldo() - importe);
		
		return true;
	}

	@Override
	public void Depositar(Double importe) {
		this.setSaldo(getSaldo() + importe);
	}

	@Override
	public Boolean extraer(Double importe) throws SaldoInsuficienteException {
		if (this.getSaldo() >= importe) {
			this.setSaldo(getSaldo() - importe);
			return true;
		} throw new SaldoInsuficienteException();
	}
	
	

}
