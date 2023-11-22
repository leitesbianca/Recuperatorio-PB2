package ar.edu.unlam.pb2.dominio;

public class CuentaAhorro extends CuentaBancaria implements Pagadora, Transferible {

	public CuentaAhorro(Persona titular, Integer CBU, Double saldo) {
		super(titular, CBU, saldo);
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) throws SaldoInsuficienteException{
		if (this.getSaldo() >= importe) {
			setSaldo(getSaldo() - importe);
			return true;
		} throw new SaldoInsuficienteException();
	}

	@Override
	public void Depositar(Double importe) {
		this.setSaldo(getSaldo()+importe);
	}

	@Override
	public Boolean extraer(Double importe) throws SaldoInsuficienteException {
		if (this.getSaldo() >= importe) {
			this.setSaldo(getSaldo() - importe);
			return true;
		} throw new SaldoInsuficienteException();
	}

}
