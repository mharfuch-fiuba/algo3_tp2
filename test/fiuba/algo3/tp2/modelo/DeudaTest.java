package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.tablero.Tablero;

public class DeudaTest {
	
	Tablero tablero = new Tablero();
	
	@Test
	public void testLaDeudaEs1000LuegoDeCrearlaCon1000() {
		Deuda deuda = new Deuda(new Dinero(1000));
		Assert.assertEquals(1000, deuda.getDeuda().obtenerMontoEntero());
	}
	
	@Test
	public void testLaDeudaEs500LuegoDeCrearlaCon500() {
		Deuda deuda = new Deuda(new Dinero(500));
		Assert.assertEquals(500, deuda.getDeuda().obtenerMontoEntero());
	}
	
	@Test
	public void testLaDeudaEs0LuegoDeSaldarla() throws DineroInsuficienteException {
		Deuda deuda = new Deuda(new Dinero(2000));
		Jugador jugador = new JugadorHumano(tablero, new Dinero(10000));
		deuda.pagarDeuda(jugador);
		Assert.assertEquals(0, deuda.getDeuda().obtenerMontoEntero());
	}
	
	@Test (expected = DineroInsuficienteException.class)
	public void testPagarDeudaLanzaDineroInsuficienteExceptionSiElJugadorNoTineSaldo() throws DineroInsuficienteException {
		Deuda deuda = new Deuda(new Dinero(10000));
		Jugador jugador = new JugadorHumano(tablero, new Dinero(2000));
		deuda.pagarDeuda(jugador);
	}
	
	public void testNoDisminuyeLaDeudaSiElJugadorNoTieneSaldo() throws DineroInsuficienteException {
		Deuda deuda = new Deuda(new Dinero(5000));
		Jugador jugador = new JugadorHumano(tablero, new Dinero(4000));
		try {
			deuda.pagarDeuda(jugador);
		}catch(DineroInsuficienteException e) {}
		Assert.assertEquals(5000, deuda.getDeuda().obtenerMontoEntero());
	}
	
}
