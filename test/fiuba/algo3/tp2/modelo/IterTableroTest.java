package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.encasillables.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples.*;
import fiuba.algo3.tp2.modelo.tablero.IterTablero;
import fiuba.algo3.tp2.modelo.tablero.Tablero;

import junit.framework.TestCase;

import org.junit.Assert;

public class IterTableroTest extends TestCase {
	
	Tablero tablero = new Tablero();
	
	public void testSecuenciaDeIteracionAvanzar() {
		IterTablero iterador = tablero.crearIterador();
		Assert.assertTrue(iterador.verActual() instanceof Salida);
		Assert.assertTrue(iterador.avanzar() instanceof Quini6);
		Assert.assertTrue(iterador.avanzar() instanceof BuenosAiresSur);
		Assert.assertTrue(iterador.avanzar() instanceof Edesur);
		Assert.assertTrue(iterador.avanzar() instanceof BuenosAiresNorte);
		Assert.assertTrue(iterador.avanzar() instanceof Carcel);
		Assert.assertTrue(iterador.avanzar() instanceof CordobaSur);
		Assert.assertTrue(iterador.avanzar() instanceof AvanceDinamico);
		Assert.assertTrue(iterador.avanzar() instanceof Subte);
		Assert.assertTrue(iterador.avanzar() instanceof CordobaNorte);
		Assert.assertTrue(iterador.avanzar() instanceof ImpuestoDeLujo);
		Assert.assertTrue(iterador.avanzar() instanceof SantaFe);
		Assert.assertTrue(iterador.avanzar() instanceof Aysa);
		Assert.assertTrue(iterador.avanzar() instanceof SaltaNorte);
		Assert.assertTrue(iterador.avanzar() instanceof SaltaSur);
		Assert.assertTrue(iterador.avanzar() instanceof Policia);
		Assert.assertTrue(iterador.avanzar() instanceof Tren);
		Assert.assertTrue(iterador.avanzar() instanceof Neuquen);
		Assert.assertTrue(iterador.avanzar() instanceof RetrocesoDinamico);
		Assert.assertTrue(iterador.avanzar() instanceof Tucuman);
		Assert.assertTrue(iterador.avanzar() instanceof Salida);
	}
	
}
