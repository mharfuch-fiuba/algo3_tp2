package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;
import fiuba.algo3.tp2.modelo.excepciones.NoPuedePagarFianzaException;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.modelo.tablero.Tablero;

public class CarcelTest {
	
	private Tablero tablero = new Tablero();
	private Jugador jugador = new JugadorHumano(tablero, new Dinero(100000));
	
	public CarcelTest() throws DineroInsuficienteException {
		jugador.avanzar(5);
		jugador.aplicarEfectoDeCasilleroActual(null);
	}
	
	@Test
	public void testElJugadorQueCaeEnCarcelNoPuedeAvanzar() {
		Encasillable casillero_esperado = jugador.obtenerCasilleroActual();
		try{jugador.avanzar(10);}
		catch(JugadorEnCarcelException e) {};
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();
		Assert.assertEquals(casillero_esperado, casillero_actual);
	}
	
	@Test
	public void testElJugadorQueCaeEnCarcelNoPuedeAvanzarDuranteElPrimerTurno() {
		Encasillable casillero_esperado = jugador.obtenerCasilleroActual();
		jugador.avanzarTurno();
		try{jugador.avanzar(10);}
		catch(JugadorEnCarcelException e) {};
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();
		Assert.assertEquals(casillero_esperado, casillero_actual);
	}
	
	@Test
	public void testElJugadorQueCaeEnCarcelNoPuedeAvanzarDuranteElSegundoTurno() {
		Encasillable casillero_esperado = jugador.obtenerCasilleroActual();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		try{jugador.avanzar(10);}
		catch(JugadorEnCarcelException e) {};
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();
		Assert.assertEquals(casillero_esperado, casillero_actual);
	}
	
	@Test
	public void testElJugadorQueCaeEnCarcelNoPuedeAvanzarDuranteElTercerTurno() {
		Encasillable casillero_esperado = jugador.obtenerCasilleroActual();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		try{jugador.avanzar(10);}
		catch(JugadorEnCarcelException e) {};
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();
		Assert.assertEquals(casillero_esperado, casillero_actual);
	}
	
	@Test
	public void testElJugadorQueCaeEnCarcelPuedeAvanzarDuranteElCuartoTurno() {
		Encasillable casillero_esperado = jugador.obtenerCasilleroActual();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.avanzar(10);
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();
		Assert.assertNotEquals(casillero_esperado, casillero_actual);
	}
	
	@Test(expected=NoPuedePagarFianzaException.class)
	public void testElJugadorQueCaeEnCarcelNoPuedePagarFianza() throws DineroInsuficienteException {
		jugador.pagarFianza();
	}
	
	@Test(expected=NoPuedePagarFianzaException.class)
	public void testElJugadorQueCaeEnCarcelNoPuedePagarFianzaDuranteElPrimerTurno() throws DineroInsuficienteException {
		jugador.avanzarTurno();
		jugador.pagarFianza();
	}
	
	@Test
	public void testElJugadorQueCaeEnCarcelPuedePagarFianzaDuranteElSegundoTurno() throws DineroInsuficienteException {
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.pagarFianza();
	}
	
	@Test
	public void testElJugadorQuePagaFianzaPuedeAvanzar() throws DineroInsuficienteException {
		Encasillable casillero_esperado = jugador.obtenerCasilleroActual();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.pagarFianza();
		jugador.avanzar(10);
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();
		Assert.assertNotEquals(casillero_esperado, casillero_actual);
	}
	
	@Test
	public void testElJugadorQueNoPuedePagarFianzaNoPuedeAvanzar() throws DineroInsuficienteException {
		Encasillable casillero_esperado = jugador.obtenerCasilleroActual();
		jugador.pagar(jugador.obtenerDinero());
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		try{jugador.pagarFianza();}
		catch(DineroInsuficienteException e) {};
		try{jugador.avanzar(10);}
		catch(JugadorEnCarcelException e) {};
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();
		Assert.assertEquals(casillero_esperado, casillero_actual);
	}
	
	@Test
	public void testElJugadorQuePagaFianzaPierde45000() throws DineroInsuficienteException {
		Dinero monto_antes = jugador.obtenerDinero();
		jugador.avanzarTurno();
		jugador.avanzarTurno();
		jugador.pagarFianza();
		Dinero monto_despues = jugador.obtenerDinero();
		Assert.assertEquals(monto_antes.obtenerMontoEntero() - 45000, monto_despues.obtenerMontoEntero());
	}
	
	@Test(expected=NoPuedePagarFianzaException.class)
	public void testElJugadorQueCaeEnCarcelNoPuedePagarFianzaNoSeRestaDinero() throws DineroInsuficienteException {
		Dinero monto_antes = jugador.obtenerDinero();
		jugador.pagarFianza();
		Dinero monto_despues = jugador.obtenerDinero();
		Assert.assertEquals(monto_antes.obtenerMontoEntero(), monto_despues.obtenerMontoEntero());
	}
	
}
