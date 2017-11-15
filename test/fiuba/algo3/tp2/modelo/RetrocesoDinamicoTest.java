package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.encasillables.RetrocesoDinamico;
import fiuba.algo3.tp2.modelo.encasillables.comprables.CordobaNorte;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Neuquen;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Subte;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Tren;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class RetrocesoDinamicoTest{

	int posicionEnTableroDeRetrocesoDinamico = 18;
	Tablero tablero = new TableroAlgoPoly();
	DineroAlgoPoly dinero = new DineroAlgoPoly(100000);
	Jugador jugador = new JugadorHumano(tablero, dinero);
	Cubilete cubilete = new Cubilete();

	// Tests grupo [2,3,4,5,6]
	@Test
	public void test01unJugadorSinPropiedadesQueSaca2Retrocede2Lugares() throws DineroInsuficienteException {
		cubilete.agregar(new DadoCargado(posicionEnTableroDeRetrocesoDinamico - 2));
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		// Ahora est� a 2 lugares de RetrocesoDin�mico
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(2));
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		Encasillable casillero = jugador.obtenerCasilleroActual();
		Assert.assertTrue(casillero instanceof Tren);
	}

	@Test
	public void test02unJugadorCon1PropiedadQueSaca2Retrocede1Lugar() throws DineroInsuficienteException {
		cubilete.agregar(new DadoCargado(2));
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		jugador.comprarCasilleroActual(); // Compra Bs As Sur
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(posicionEnTableroDeRetrocesoDinamico - 4));
		jugador.avanzar(cubilete); // Ahora est� a 2 lugares de
									// RetrocesoDin�mico
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(2));
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		Encasillable casillero = jugador.obtenerCasilleroActual();
		Assert.assertTrue(casillero instanceof Neuquen);

	}

	@Test
	public void test03unJugadorCon3PropiedadesQueSaca2NoRetrocede() throws DineroInsuficienteException {
		cubilete.agregar(new DadoCargado(2));
		jugador.avanzar(cubilete);
		Encasillable casillero = jugador.obtenerCasilleroActual();
		jugador.comprarCasilleroActual(); // Compra Bs As Sur
		jugador.avanzar(cubilete);
		casillero = jugador.obtenerCasilleroActual();
		jugador.comprarCasilleroActual(); // Compra Bs As Norte
		jugador.avanzar(cubilete);
		casillero = jugador.obtenerCasilleroActual();
		jugador.comprarCasilleroActual(); // Compra Cordoba Sur
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(10));
		jugador.avanzar(cubilete); // Ahora est� a 2 lugares de
									// RetrocesoDin�mico
		casillero = jugador.obtenerCasilleroActual();
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(2));
		jugador.avanzar(cubilete);
		casillero = jugador.obtenerCasilleroActual();
		Assert.assertTrue(casillero instanceof RetrocesoDinamico);
	}

	// Tests grupo [7,8,9,10]

	@Test
	public void test05unJugadorCon100000EfectivoQueSaca10NoRetrocede() {
		cubilete.agregar(new DadoCargado(posicionEnTableroDeRetrocesoDinamico - 10));
		jugador.avanzar(cubilete); // Ahora est� a 10 lugares de
									// RetrocesoDin�mico
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(10));
		jugador.avanzar(cubilete);
		Encasillable casillero = jugador.obtenerCasilleroActual();
		Assert.assertTrue(casillero instanceof RetrocesoDinamico);
	}

	@Test
	public void test06unJugadorCon100001EfectivoQueSaca10Retrocede1Lugar() throws DineroInsuficienteException {
		jugador.agregarDinero(new DineroAlgoPoly(1));
		cubilete.agregar(new DadoCargado(posicionEnTableroDeRetrocesoDinamico - 10));
		jugador.avanzar(cubilete); // Ahora est� a 10 lugares de
									// RetrocesoDin�mico
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(10));
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		Encasillable casillero = jugador.obtenerCasilleroActual();
		Assert.assertTrue(casillero instanceof Neuquen);
	}

	@Test
	public void test07unJugadorCon100002EfectivoQueSaca10Retrocede2Lugares() throws DineroInsuficienteException {
		jugador.agregarDinero(new DineroAlgoPoly(2));
		cubilete.agregar(new DadoCargado(posicionEnTableroDeRetrocesoDinamico - 10));
		jugador.avanzar(cubilete); // Ahora est� a 10 lugares de
									// RetrocesoDin�mico
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(10));
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		Encasillable casillero = jugador.obtenerCasilleroActual();
		Assert.assertTrue(casillero instanceof Tren);
	}

	@Test
	public void test08unJugadorCon100009EfectivoQueSaca10Retrocede9Lugares() throws DineroInsuficienteException {
		jugador.agregarDinero(new DineroAlgoPoly(9));
		cubilete.agregar(new DadoCargado(posicionEnTableroDeRetrocesoDinamico - 10));
		jugador.avanzar(cubilete); // Ahora est� a 10 lugares de
									// RetrocesoDin�mico
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(10));
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		Encasillable casillero = jugador.obtenerCasilleroActual();
		Assert.assertTrue(casillero instanceof CordobaNorte);

	}

	// Tests grupo [11,12]

	@Test
	public void test09unJugadorQueSaca11Retrocede9Lugares() throws DineroInsuficienteException {
		/*
		 * VER!!! falla porque parte de avance din�mico. hay que lograr
		 * pararlo en avance dinamico sin que se mueva
		 */
		cubilete.agregar(new DadoCargado(posicionEnTableroDeRetrocesoDinamico - 11));
		jugador.avanzar(cubilete);
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(11));
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		Encasillable casillero = jugador.obtenerCasilleroActual();

		Assert.assertTrue(casillero instanceof CordobaNorte);
	}

	@Test
	public void test10unJugadorQueSaca12Retrocede10Lugares() throws DineroInsuficienteException {
		cubilete.agregar(new DadoCargado(posicionEnTableroDeRetrocesoDinamico - 12));
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(12));
		jugador.avanzar(cubilete);
		jugador.aplicarEfectoDeCasilleroActual(cubilete);
		Encasillable casillero = jugador.obtenerCasilleroActual();
		Assert.assertTrue(casillero instanceof Subte);

	}
}
