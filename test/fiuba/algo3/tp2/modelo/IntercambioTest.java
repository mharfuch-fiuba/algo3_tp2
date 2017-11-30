package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles.BuenosAiresSur;
import fiuba.algo3.tp2.modelo.tablero.Tablero;

public class IntercambioTest {
	private Tablero tablero = new Tablero();
	private Jugador jugador1 = new JugadorHumano(tablero, new Dinero(100000));
	private Jugador jugador2 = new JugadorHumano(tablero, new Dinero(100000));
	private BuenosAiresSur bsassur;
	
	public IntercambioTest() {
		jugador1.avanzar(2);
		bsassur = (BuenosAiresSur) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();
	}
	
	@Test
	public void testElJugador1IntercambiaUnaPropiedadPor30000ConElJugador2ElJugador2EsElNuevoPropietario() {
		Intercambio intercambio = jugador1.generarIntercambio(bsassur, new Dinero(30000));
		intercambio.aceptarIntercambio(jugador2);
		Assert.assertEquals(jugador2, bsassur.getPropietario());
		Assert.assertTrue(jugador2.getPropiedades().contains(bsassur));
	}
	
	@Test
	public void testElJugador1IntercambiaUnaPropiedadPor20000ConElJugador2ElJugador1YaNoEsPropietario() {
		Intercambio intercambio = jugador1.generarIntercambio(bsassur, new Dinero(20000));
		intercambio.aceptarIntercambio(jugador2);
		Assert.assertNotEquals(jugador1, bsassur.getPropietario());
		Assert.assertFalse(jugador1.getPropiedades().contains(bsassur));
	}
	
	@Test
	public void testElJugador1IntercambiaUnaPropiedadPor30000ConElJugador2ElJugador2Pierde30000() {
		Intercambio intercambio = jugador1.generarIntercambio(bsassur, new Dinero(30000));
		intercambio.aceptarIntercambio(jugador2);
		Assert.assertEquals(jugador2, bsassur.getPropietario());
	}
	
	@Test
	public void testElJugador1IntercambiaUnaPropiedadPor20000ConElJugador2ElJugador1Gana20000() {
		Intercambio intercambio = jugador1.generarIntercambio(bsassur, new Dinero(20000));
		intercambio.aceptarIntercambio(jugador2);
		Assert.assertEquals(jugador2, bsassur.getPropietario());
	}
	
}
