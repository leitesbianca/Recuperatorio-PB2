package ar.edu.unlam.pb2.dominio;

import java.util.Objects;
import java.util.Set;

public class Compra {
	
	private Comercio comercio;
	private Double importe;
	private Boolean fuePagada;
	private String codigoQR;
	
	public Compra (Comercio comercio, Double importe) {
		this.comercio = comercio;
		this.importe = importe;
		this.fuePagada = false;
	}

	public Comercio getComercio() {
		return comercio;
	}

	public void setComercio(Comercio comercio) {
		this.comercio = comercio;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Boolean getFuePagada() {
		return fuePagada;
	}

	public void setFuePagada(Boolean fuePagada) {
		this.fuePagada = fuePagada;
	}
	
	public String getCodigoQR() {
		return "Compra [comercio=" + comercio + ", importe=" + importe + ", fuePagada=" + fuePagada + "]";
	}

	@Override
	public String toString() {
		return "Compra [comercio=" + comercio + ", importe=" + importe + ", fuePagada=" + fuePagada + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoQR);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(codigoQR, other.codigoQR);
	}
	
	
	
	

}
