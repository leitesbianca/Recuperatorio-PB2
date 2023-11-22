package ar.edu.unlam.pb2.dominio;

public interface Transferible {

	Double getSaldo();
	void Depositar (Double importe);
	Boolean extraer (Double importe) throws SaldoInsuficienteException;
}
