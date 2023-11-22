package ar.edu.unlam.pb2.dominio;

public interface Pagadora {
	
	Boolean pagar (Persona vendedor, Double importe) throws SaldoInsuficienteException, ExcedeLimiteDeCompraException;
}
