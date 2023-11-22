package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Billetera {
	private String nombre;
	private Map <MedioDePago, Integer> mediosDePago;
	private Set <Comercio> comercios;
	private Set <Consumidor> consumidores;
	private List <Compra> compras;
	private List <String> codigosQR;
	
	public Billetera (String nombre) {
		this.nombre = nombre;
		this.mediosDePago = new HashMap<>();
		this.comercios = new HashSet<>();
		this.consumidores = new HashSet<>();
		this.compras = new ArrayList<>();
	}
	
	public void agregarMedioDePago (MedioDePago medioDePago, Integer dniConsumidor) {
		Consumidor cons = buscarConsumidorPorDni(dniConsumidor);
		if (cons != null) {
			this.mediosDePago.put(medioDePago, dniConsumidor);
		}
	}

	public Consumidor buscarConsumidorPorDni(Integer dniConsumidor) {
		for (Consumidor c : consumidores) {
			if (c.getDni().equals(dniConsumidor)) {
				return c;
			}
		} return null;
	}
	
	public Comercio buscarComercioPorCBU (Integer CBU) {
		for (Comercio c : comercios) {
			if (c.getCBU().equals(CBU)) {
				return c;
			}
		} return null;
		
	}
	
	public Compra buscarCompra(Compra compra) {
		for (Compra c : compras) {
			if (c.equals(compra)) {
				return c;
			}
		} return null;
	}

	public void agregarComercio (Comercio comercio) {
		comercios.add(comercio);
	}
	
	public void agregarConsumidor (Consumidor consumidor) {
		this.consumidores.add(consumidor);
	}
	
	public void agregarCompras(Compra compra) {
		this.compras.add(compra);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<MedioDePago, Integer> getMediosDePago() {
		return mediosDePago;
	}

	public void setMediosDePago(Map<MedioDePago, Integer> mediosDePago) {
		this.mediosDePago = mediosDePago;
	}
	
	public Integer obtenerCantidadDeMediosDePago() {
		return this.mediosDePago.size();
	}
	
	public Integer obtenerCantidadDeMediosDePagoPorConsumidor(Integer dniConsumidor) {
		Integer cantidadDeMediosDePago = 0;
		for (Map.Entry<MedioDePago, Integer> entry : this.mediosDePago.entrySet()) {
			if (entry.getValue().equals(dniConsumidor)) {
				cantidadDeMediosDePago ++;
			}
		} return cantidadDeMediosDePago;
	}
	
	public Set<MedioDePago> obtenerMediosDePagoPorConsumidor (Integer dniConsumidor) {
		Set <MedioDePago> mediosDePagoDelConsumidor = new HashSet<>();
		
		for (Map.Entry<MedioDePago, Integer> entry : this.mediosDePago.entrySet()) {
			if (entry.getValue().equals(dniConsumidor)) {
				mediosDePagoDelConsumidor.add(entry.getKey());
			}
		} return mediosDePagoDelConsumidor;
	}
	
	public Integer obtenerCantidadDeCompras() {
		return this.compras.size();
	}
	
	public Integer obtenerCantidadDeConsumidores() {
		return this.consumidores.size();
	}
	
	public Integer obtenerCantidadDeComercios() {
		return this.comercios.size();
	}

	public Set<Comercio> getComercios() {
		return comercios;
	}

	public void setComercios(Set<Comercio> comercios) {
		this.comercios = comercios;
	}

	public Set<Consumidor> getConsumidores() {
		return consumidores;
	}

	public void setConsumidores(Set<Consumidor> consumidores) {
		this.consumidores = consumidores;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	public void agregarCodigoQR(String codigoQR) {
		this.codigosQR.add(codigoQR);
	}
	
	public String generarCodigoQR(Compra compra) {
		String codigoQR = "";
		if (compra.getFuePagada()) {
			codigoQR = compra.getCodigoQR();
		} return codigoQR;
	}
	
	
	
}
