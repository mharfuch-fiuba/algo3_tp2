package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.encasillables.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples.*;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.tablero.Tablero;

public class JugadorHumanoTest {

	Tablero tablero = new Tablero();

	Dinero dinero100k = new Dinero(100000);
	Dinero dinero50k = new Dinero(50000);
	
	Propiedad comprable = new Tucuman();

	Jugador jugador100k = new JugadorHumano(tablero, dinero100k);

	@Test
	public void testAlCrearCon100kObtenerDineroDevuelve100k() {
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), dinero100k.obtenerMontoEntero());
	}

	@Test
	public void testObtenerDineroDevuelveUnaCopia() throws DineroInsuficienteException {
		Dinero dinero = jugador100k.obtenerDinero();
		dinero.disminuirCantidad(dinero50k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), dinero100k.obtenerMontoEntero());
	}

	@Test
	public void testInicialmenteGetCantidadDePropiedadesDevuelve0() {
		Assert.assertEquals(jugador100k.getCantidadDePropiedades(), 0);
	}

	@Test
	public void testAlComprarLaPrimerPropiedadGetCantidadDePropiedadesDevuelve1() throws DineroInsuficienteException {
		jugador100k.comprar(comprable);
		Assert.assertEquals(jugador100k.getCantidadDePropiedades(), 1);
	}

	@Test
	public void testSiAumentoCapitalGetDineroDevuelveLaSuma(){
		jugador100k.cobrar(dinero50k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(),150000);
	}
	
	@Test
	public void testRecorrerTablero() {
		Jugador jugador = new JugadorHumano(tablero, new Dinero(10000));
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof Salida);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof Quini6);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof BuenosAiresSur);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof Edesur);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof BuenosAiresNorte);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof Carcel);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof CordobaSur);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof AvanceDinamico);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof Subte);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof CordobaNorte);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof ImpuestoDeLujo);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof SantaFe);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof Aysa);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof SaltaNorte);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof SaltaSur);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof Policia);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof Tren);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof Neuquen);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof RetrocesoDinamico);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof Tucuman);
		jugador.avanzar(1);
		Assert.assertTrue(jugador.obtenerCasilleroActual() instanceof Salida);
		
	}
	
}