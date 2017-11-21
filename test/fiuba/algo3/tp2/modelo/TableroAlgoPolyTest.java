package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.encasillables.*;
import fiuba.algo3.tp2.modelo.encasillables.comprables.*;
import fiuba.algo3.tp2.modelo.encasillables.comprables.servicios.Aysa;
import fiuba.algo3.tp2.modelo.encasillables.comprables.servicios.Edesur;
import fiuba.algo3.tp2.modelo.encasillables.comprables.servicios.Subte;
import fiuba.algo3.tp2.modelo.encasillables.comprables.servicios.Tren;

public class TableroAlgoPolyTest {

	@Test
	public void testCrearIteradorNoEsNulo() {
		Tablero tablero = new TableroAlgoPoly();
		IterTablero iterador = tablero.crearIterador();
		Assert.assertNotNull(iterador);
	}
	
	@Test
	public void testCrearIteradorTieneLaSecuenciaCorrectaDeCasilleros() {
		Tablero tablero = new TableroAlgoPoly();
		IterTablero iterador = tablero.crearIterador();
		ArrayList<Encasillable> casilleros = new ArrayList<Encasillable>();
		for(int i = 0; i < 20; i++) {
			casilleros.add(iterador.verActual());
			iterador.avanzar();
		}
		Assert.assertTrue(casilleros.get(0) instanceof Salida);
		Assert.assertTrue(casilleros.get(1) instanceof Quini6);
		Assert.assertTrue(casilleros.get(2) instanceof BuenosAiresSur);
		Assert.assertTrue(casilleros.get(3) instanceof Edesur);
		Assert.assertTrue(casilleros.get(4) instanceof BuenosAiresNorte);
		Assert.assertTrue(casilleros.get(5) instanceof Carcel);
		Assert.assertTrue(casilleros.get(6) instanceof CordobaSur);
		Assert.assertTrue(casilleros.get(7) instanceof AvanceDinamico);
		Assert.assertTrue(casilleros.get(8) instanceof Subte);
		Assert.assertTrue(casilleros.get(9) instanceof CordobaNorte);
		Assert.assertTrue(casilleros.get(10) instanceof ImpuestoDeLujo);
		Assert.assertTrue(casilleros.get(11) instanceof SantaFe);
		Assert.assertTrue(casilleros.get(12) instanceof Aysa);
		Assert.assertTrue(casilleros.get(13) instanceof SaltaNorte);
		Assert.assertTrue(casilleros.get(14) instanceof SaltaSur);
		Assert.assertTrue(casilleros.get(15) instanceof Policia);
		Assert.assertTrue(casilleros.get(16) instanceof Tren);
		Assert.assertTrue(casilleros.get(17) instanceof Neuquen);
		Assert.assertTrue(casilleros.get(18) instanceof RetrocesoDinamico);
		Assert.assertTrue(casilleros.get(19) instanceof Tucuman);
	}

	@Test
	public void testTableroAlgoPolyNoEsNuloAlCrear() {
		Tablero tablero = new TableroAlgoPoly();
		Assert.assertNotNull(tablero);
	}

}
