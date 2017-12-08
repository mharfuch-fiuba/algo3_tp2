package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles.BuenosAiresNorte;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles.BuenosAiresSur;
import fiuba.algo3.tp2.modelo.tablero.Tablero;

public class IntercambioTest {
	private Tablero tablero = new Tablero();
	private Jugador jugador1 = new JugadorHumano(tablero, new Dinero(100000));
	private Jugador jugador2 = new JugadorHumano(tablero, new Dinero(100000));
	private BuenosAiresSur bsassur;
	private BuenosAiresNorte bsasnorte;

	public IntercambioTest() {
		jugador1.avanzar(2);
		bsassur = (BuenosAiresSur) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();
		jugador2.avanzar(4);
		bsasnorte = (BuenosAiresNorte) jugador2.obtenerCasilleroActual();
		jugador2.comprarCasilleroActual();
	}
	
	@Test
	public void testJugador1IntercambiaBsAsSurPorBsAsNorteJugador2EsPropietarioDeBsAsSur() {
		Intercambio intercambio = new Intercambio(bsasnorte, bsassur);
		intercambio.aceptarIntercambio();
		Assert.assertEquals(jugador2, bsassur.getPropietario());
	}
	
	@Test
	public void testJugador1IntercambiaBsAsSurPorBsAsNorteJugador1EsPropietarioDeBsAsNorte() {
		Intercambio intercambio = new Intercambio(bsasnorte, bsassur);
		intercambio.aceptarIntercambio();
		Assert.assertEquals(jugador1, bsasnorte.getPropietario());
	}
	
	@Test
	public void testJugador1NoIntercambiaBsAsSurPorBsAsNorteJugador1EsPropietarioDeBsAsSur() {
		new Intercambio(bsasnorte, bsassur);
		Assert.assertEquals(jugador1, bsassur.getPropietario());
	}
	
	@Test
	public void testJugador1NoIntercambiaBsAsSurPorBsAsNorteJugador2EsPropietarioDeBsAsNorte() {
		new Intercambio(bsasnorte, bsassur);
		Assert.assertEquals(jugador2, bsasnorte.getPropietario());
	}
	
}
