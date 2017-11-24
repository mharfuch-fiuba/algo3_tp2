package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples.Tucuman;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.tablero.Tablero;

public class JugadorHumanoTest {

	Tablero tablero = new Tablero();

	Dinero dinero100k = new Dinero(100000);
	Dinero dinero50k = new Dinero(50000);
	
	Propiedad comprable = new Tucuman();

	Jugador jugador100k = new JugadorHumano(tablero, dinero100k);

	@Test
	public void alCrearCon100kObtenerDineroDevuelve100k() {
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), dinero100k.obtenerMontoEntero());
	}

	@Test
	public void obtenerDineroDevuelveUnaCopia() throws DineroInsuficienteException {
		Dinero dinero = jugador100k.obtenerDinero();
		dinero.disminuirCantidad(dinero50k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), dinero100k.obtenerMontoEntero());
	}

	@Test
	public void inicialmenteGetCantidadDePropiedadesDevuelve0() {
		Assert.assertEquals(jugador100k.getCantidadDePropiedades(), 0);
	}

	@Test
	public void alComprarLaPrimerPropiedadGetCantidadDePropiedadesDevuelve1() throws DineroInsuficienteException {
		jugador100k.comprar(comprable);
		Assert.assertEquals(jugador100k.getCantidadDePropiedades(), 1);
	}

	@Test
	public void siAumentoCapitalGetDineroDevuelveLaSuma(){
		jugador100k.cobrar(dinero50k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(),150000);
	}	
}