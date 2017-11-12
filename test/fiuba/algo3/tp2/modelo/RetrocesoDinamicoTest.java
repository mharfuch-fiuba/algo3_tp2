package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.encasillables.RetrocesoDinamico;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Neuquen;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Tren;

public class RetrocesoDinamicoTest {

	int posicionEnTableroDeRetrocesoDinamico = 18;
	Tablero tablero = new TableroAlgoPoly();
	Dinero dinero = new Dinero(100000);
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
		//System.out.println(casillero);
		Assert.assertTrue(casillero instanceof Tren);
	}

	@Test
	public void unJugadorCon1PropiedadQueSaca2Retrocede1Lugar() {
		cubilete.agregar(new DadoCargado(2));
		jugador.avanzar(cubilete);
		jugador.comprarCasilleroActual(); // Compra Bs As Sur
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(posicionEnTableroDeRetrocesoDinamico - 4));
		jugador.avanzar(cubilete); // Ahora está a 2 lugares de RetrocesoDinámico
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(2));
		jugador.avanzar(cubilete);
		Encasillable casillero = jugador.obtenerCasilleroActual();
		//System.out.println(casillero);
		Assert.assertTrue(casillero instanceof Neuquen);	
		
	}

	@Test
	public void unJugadorCon3PropiedadesQueSaca2NoRetrocede() {
		cubilete.agregar(new DadoCargado(2));
		jugador.avanzar(cubilete);
		Encasillable casillero = jugador.obtenerCasilleroActual();
		System.out.println(casillero);
		jugador.comprarCasilleroActual(); // Compra Bs As Sur
		jugador.avanzar(cubilete);
		casillero = jugador.obtenerCasilleroActual();
		System.out.println(casillero);
		jugador.comprarCasilleroActual(); // Compra Bs As Norte
		jugador.avanzar(cubilete);
		casillero = jugador.obtenerCasilleroActual();
		System.out.println(casillero);
		jugador.comprarCasilleroActual(); // Compra Cordoba Sur
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(10));
		jugador.avanzar(cubilete); // Ahora está a 2 lugares de RetrocesoDinámico
		casillero = jugador.obtenerCasilleroActual();
		System.out.println(casillero);
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(2));
		jugador.avanzar(cubilete);
		casillero = jugador.obtenerCasilleroActual();
		System.out.println(casillero);
		Assert.assertTrue(casillero instanceof RetrocesoDinamico);	
	}

	// Tests grupo [7,8,9,10]

	@Test
	public void unJugadorCon100000EfectivoQueSaca10NoRetrocede() {
		fail();

	}

	@Test
	public void unJugadorCon100001EfectivoQueSaca10Retrocede1Lugar() {
		fail();

	}

	@Test
	public void unJugadorCon100002EfectivoQueSaca10Retrocede2Lugares() {
		fail();

	}

	@Test
	public void unJugadorCon100009EfectivoQueSaca10Retrocede9Lugares() {
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
