package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.encasillables.comprables.Tren;

public class RetrocesoDinamicoTest {

	int posicionEnTableroDeRetrocesoDinamico = 18;
	Tablero tablero = new TableroAlgoPoly();
	Dinero dinero = new Dinero(10000);
	Jugador jugador = new JugadorHumano(tablero, dinero);
	Cubilete cubilete = new Cubilete();

	// Tests grupo [2,3,4,5,6]
	@Test
	public void unJugadorSinPropiedadesQueSaca2Retrocede2Lugares() {
		cubilete.agregar(new DadoCargado(posicionEnTableroDeRetrocesoDinamico - 2));
		jugador.avanzar(cubilete);
		// Ahora está a 2 lugares de RetrocesoDinámico
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(2));
		jugador.avanzar(cubilete);
		Encasillable casillero = jugador.obtenerCasilleroActual();
		System.out.println(casillero);
		Assert.assertTrue(casillero instanceof Tren);
	}

	@Test
	public void unJugadorCon1PropiedadQueSaca2Retrocede1Lugar() {
		fail();
	}

	@Test
	public void unJugadorCon3PropiedadesQueSaca2NoRetrocede() {
		fail();
	}

	// Tests grupo [7,8,9,10]

	@Test
	public void unJugadorCon10000EfectivoQueSaca10NoRetrocede() {
		fail();

	}

	@Test
	public void unJugadorCon10001EfectivoQueSaca10Retrocede1Lugar() {
		fail();

	}

	@Test
	public void unJugadorCon10002EfectivoQueSaca10Retrocede2Lugares() {
		fail();

	}

	@Test
	public void unJugadorCon10009EfectivoQueSaca10Retrocede9Lugares() {
		fail();

	}

	// Tests grupo [11,12]

	@Test
	public void unJugadorQueSaca11Retrocede9Lugares() {
		fail();

	}

	@Test
	public void unJugadorQueSaca12Retrocede10Lugares() {
		fail();

	}
}
