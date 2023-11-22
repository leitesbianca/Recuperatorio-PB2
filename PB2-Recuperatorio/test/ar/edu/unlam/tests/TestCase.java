package ar.edu.unlam.tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import ar.edu.unlam.pb2.dominio.*;

public class TestCase {

	@Test 
	public void queSePuedanAlmacenarLosDistintosTiposDePersonas() {
		Consumidor consumidor = new Consumidor ("Javier Montoya", 22099801, 30890438);
		Consumidor consumidor2 = new Consumidor ("Adrian Suar", 29888701, 30400981);
		Comercio comercio = new Comercio ("Monsters Inc", 227788996);
		Comercio comercio2 = new Comercio ("Dunder Mifflins", 227788995);
		Billetera mataGalan = new Billetera ("Mata Galan");
		
		mataGalan.agregarConsumidor(consumidor);
		mataGalan.agregarConsumidor(consumidor2);
		mataGalan.agregarComercio(comercio);
		mataGalan.agregarComercio(comercio2);
		
		assertEquals(mataGalan.obtenerCantidadDeComercios(), (Integer)2);
		assertEquals(mataGalan.obtenerCantidadDeConsumidores(), (Integer)2);
		
	}
	
	@Test
	public void queSePuedanRealizarCompras() {
		Consumidor titular = new Consumidor ("Javier Montoya", 22099801, 30890438);
		TarjetaDeDebito tarjetaDeDebito = new TarjetaDeDebito(titular, 3348967, 50000.00);
		Comercio comercio = new Comercio ("Compra Gamer", 2239005);
		Compra compra = new Compra (comercio, 10500.00);
		
		assertNotNull(compra);
	}

	@Test (expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaTarjetaEsInsuficienteParaHacerUnaCompra() throws SaldoInsuficienteException {
		Consumidor titular = new Consumidor ("Javier Montoya", 22099801, 30890438);
		TarjetaDeDebito tarjetaDeDebito = new TarjetaDeDebito(titular, 3348967, 20000.50);
		Comercio comercio = new Comercio ("Compra Gamer", 2239005);
		Compra compra = new Compra (comercio, 29000.00);
		Boolean fuePagada = tarjetaDeDebito.pagar(comercio, compra.getImporte());
		
		assertFalse(fuePagada);
	}
	
	@Test (expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaVirtualEsInsuficienteParaHacerUnaCompra() throws SaldoInsuficienteException{
		Consumidor titular = new Consumidor ("Javier Montoya", 22099801, 30890438);
		CuentaVirtual cuentaVirtual = new CuentaVirtual (titular, 3348967, 20000.50);
		Comercio comercio = new Comercio ("Compra Gamer", 2239005);
		Compra compra = new Compra (comercio, 29000.00);
		cuentaVirtual.pagar(comercio, compra.getImporte());
	}
	
	@Test (expected = ExcedeLimiteDeCompraException.class)
	public void queSeLanceUnaExcepcionSiElLimiteDeCompraDeLaTarjetaEsInsuficienteParaHacerUnaCompra() throws ExcedeLimiteDeCompraException{
		Consumidor titular = new Consumidor ("Javier Montoya", 22099801, 30890438);
		TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito(titular, 3348967, 50500.00);
		Comercio comercio = new Comercio ("Compra Gamer", 2239005);
		Compra compra = new Compra (comercio, 50501.00);
		Boolean fuePagada = tarjetaDeCredito.pagar(comercio, compra.getImporte());
		
		assertFalse(fuePagada);
	}
	
	@Test (expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaEsInsuficienteParaHacerUnaTransferencia() throws SaldoInsuficienteException {
		Persona titular = new Consumidor ("Abigail Hernandez", 22099789, 30786654);
		CuentaAhorro cuentaAhorro = new CuentaAhorro(titular, 22099789, 25000.00);
		Double importeATranferir = 25500.00;
		Persona aTransferir = new Consumidor ("Maria Menendez", 22099783, 30786655);
		CuentaVirtual cuentaVirtual = new CuentaVirtual (aTransferir, 22099783, 30000.00);
		
		if (cuentaAhorro.extraer(importeATranferir)) {
			cuentaVirtual.Depositar(importeATranferir);
		}		
		
	}
	
	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDeTransacciones() throws SaldoInsuficienteException {
	
	}
	
	@Test
	public void queSePuedanAsociarACadaPersonaSusMedios() {
		Consumidor titular = new Consumidor ("Abigail Hernandez", 22099801, 30786654);
		CuentaCorriente cuentaCorriente = new CuentaCorriente(titular, 220997892, 35000.00);
		CuentaVirtual cuentaVirtual = new CuentaVirtual (titular, 220997893, 35000.00);
		CuentaAhorro cuentaAhorro = new CuentaAhorro(titular, 220997894, 35000.00);
		TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito (titular, 220997892, 35000.00);
		TarjetaDeDebito tarjetaDeDebito = new TarjetaDeDebito (titular, 220997892, 35000.00);
		
		Billetera mataGalan = new Billetera ("Mata Galan");
		
		mataGalan.agregarConsumidor(titular);
		mataGalan.agregarMedioDePago(cuentaCorriente, titular.getDni());
		mataGalan.agregarMedioDePago(cuentaVirtual, titular.getDni());
		mataGalan.agregarMedioDePago(cuentaAhorro, titular.getDni());
		mataGalan.agregarMedioDePago(tarjetaDeCredito, titular.getDni());
		mataGalan.agregarMedioDePago(tarjetaDeDebito, titular.getDni());
		
		Integer valorEsperado = 5;
		Integer valorObtenido = mataGalan.obtenerCantidadDeMediosDePagoPorConsumidor(titular.getDni());
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void queSePuedanRealizarTransferencias() {
		Persona titular = new Consumidor ("Abigail Hernandez", 22099789, 30786654);
		CuentaCorriente cuentaCorriente = new CuentaCorriente(titular, 220997892, 35000.00);
		Persona aTransferir = new Consumidor ("Maria Menendez", 22099783, 30786655);
		CuentaVirtual cuentaVirtual = new CuentaVirtual (aTransferir, 22099783, 30000.00);
		Double importe = 5000.00;
		
		cuentaCorriente.pagar(aTransferir, importe);
		cuentaVirtual.Depositar(importe);
		
		assertEquals(cuentaCorriente.getSaldo(), 30000.00, 0.01);
		assertEquals(cuentaVirtual.getSaldo(), 35000.00, 0.01);
	}
	
	@Test
	public void queDesdeUnaCuentaCorrienteSePuedaRealizarUnaTransferenciaPorEncimaDeSuSaldo() {
		Persona titular = new Consumidor ("Abigail Hernandez", 22099789, 30786654);
		CuentaCorriente cuentaCorriente = new CuentaCorriente(titular, 220997892, 2500.00);
		Persona aTransferir = new Consumidor ("Maria Menendez", 22099783, 30786655);
		CuentaVirtual cuentaVirtual = new CuentaVirtual (aTransferir, 22099783, 30000.00);
		Double importe = 5000.00;
		
		cuentaCorriente.pagar(aTransferir, importe);
		cuentaVirtual.Depositar(importe);
		
		assertEquals(cuentaCorriente.getSobregiro(), -2500.00, 0.01);
		assertEquals(cuentaVirtual.getSaldo(), 35000.00, 0.01);
	}
	

}
