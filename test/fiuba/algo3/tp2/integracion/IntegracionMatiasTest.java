package fiuba.algo3.tp2.integracion;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorHumano;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.cubilete.DadoCargado;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples.*;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;
import fiuba.algo3.tp2.modelo.excepciones.PropietarioDeParejaNoEsElMismoException;
import fiuba.algo3.tp2.modelo.tablero.Tablero;
import junit.framework.TestCase;

import org.junit.Assert;

public class IntegracionMatiasTest extends TestCase {
	
	private Tablero tablero = new Tablero();
	
	public void testConstruirEnBuenosAires() throws JugadorEnCarcelException, DineroInsuficienteException {
		final int monto_inicial = 200000;
		
		Cubilete cubilete_que_saca_2 = new Cubilete();
		cubilete_que_saca_2.agregar(new DadoCargado(2));
		
		Jugador jugador1 = new JugadorHumano(tablero, new Dinero(monto_inicial));
		jugador1.avanzar(cubilete_que_saca_2.sumarValores());
		Edificable bsas_sur = (Edificable) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();//Compra BsAs Sur $20000
		int monto_esperado_jugador_1 = monto_inicial - 20000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//SI INTENTO CONSTRUIR NO ME DEBERIA DEJAR PORQUE ME FALTA BSAS NORTE, NO?
		jugador1.avanzar(cubilete_que_saca_2.sumarValores());
		jugador1.comprarCasilleroActual();//Compra BsAs Norte $25000
		monto_esperado_jugador_1 = monto_esperado_jugador_1 - 25000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		Edificable bsas_nor = (Edificable) jugador1.obtenerCasilleroActual();
		bsas_sur.construir();
		monto_esperado_jugador_1 = monto_esperado_jugador_1 - 5000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		bsas_nor.construir();
		monto_esperado_jugador_1 = monto_esperado_jugador_1 - 5500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		Jugador jugador2 = new JugadorHumano(tablero, new Dinero(monto_inicial));
		int monto_esperado_jugador_2 = monto_inicial;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		jugador2.avanzar(cubilete_que_saca_2.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(cubilete_que_saca_2);
		monto_esperado_jugador_2 = monto_inicial - 3000;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		jugador2.avanzar(cubilete_que_saca_2.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(cubilete_que_saca_2);
		monto_esperado_jugador_2 = monto_esperado_jugador_2 - 3500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
	}
	
	public void testConstruirEnBuenosAires2() throws JugadorEnCarcelException, DineroInsuficienteException {
		
		final int monto_inicial = 200000;
		int monto_esperado_jugador_1 = monto_inicial;

		Cubilete cubilete_que_saca_2 = new Cubilete();
		cubilete_que_saca_2.agregar(new DadoCargado(2));
		
		Jugador jugador1 = new JugadorHumano(tablero, new Dinero(monto_inicial));
		jugador1.avanzar(cubilete_que_saca_2.sumarValores());
		Edificable bsas_sur = (Edificable) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();//Compra BsAs Sur $20000
		monto_esperado_jugador_1 -= 20000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		try {
			bsas_sur.construir(); // <-- No deberia hacer nada
		}catch(PropietarioDeParejaNoEsElMismoException e) {}
		
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		jugador1.avanzar(cubilete_que_saca_2.sumarValores());
		jugador1.comprarCasilleroActual();//Compra BsAs Norte $25000
		monto_esperado_jugador_1 -= 25000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		Edificable bsas_nor = (Edificable) jugador1.obtenerCasilleroActual();
		
		bsas_sur.construir();
		monto_esperado_jugador_1 -= 5000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		bsas_sur.construir();
		monto_esperado_jugador_1 -= 5000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//bsas_sur.construir(); // <-- No deberia hacer nada
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		bsas_nor.construir();
		monto_esperado_jugador_1 -= 5500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		bsas_nor.construir();
		monto_esperado_jugador_1 -= 5500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		bsas_nor.construir();
		monto_esperado_jugador_1 -= 9000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		bsas_nor.construir(); // <-- No deberia hacer nada
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		bsas_sur.construir();
		monto_esperado_jugador_1 -= 8000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		bsas_sur.construir(); // <-- No deberia hacer nada
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
	}
	
	public void testJugador1CompraTodosLosCasillerosJugador2AlquilaTodosLosCasilleros() throws JugadorEnCarcelException, DineroInsuficienteException {
		int dinero_inicial = 10000000;
		//SE CREA UN CUBILETE QUE RECORRE TODAS LAS PROPIEDADES DEL TABLERO Y REGRESA A SALIDA
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(new int[] {2,2,2,3,2,2,1,3,2,1}));
		
		Jugador jugador1 = new JugadorHumano(tablero, new Dinero(dinero_inicial));
		int monto_esperado_jugador_1 = dinero_inicial;
		
		jugador1.avanzar(cubilete.sumarValores());
		BuenosAiresSur bsassur = (BuenosAiresSur) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();
		monto_esperado_jugador_1 -= 20000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador1.avanzar(cubilete.sumarValores());
		BuenosAiresNorte bsasnorte = (BuenosAiresNorte) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();
		monto_esperado_jugador_1 -= 25000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador1.avanzar(cubilete.sumarValores());
		CordobaSur cbasur = (CordobaSur) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();
		monto_esperado_jugador_1 -= 18000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador1.avanzar(cubilete.sumarValores());
		CordobaNorte cbanorte = (CordobaNorte) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();
		monto_esperado_jugador_1 -= 20000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador1.avanzar(cubilete.sumarValores());
		SantaFe stafe = (SantaFe) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();
		monto_esperado_jugador_1 -= 15000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador1.avanzar(cubilete.sumarValores());
		SaltaNorte saltanorte = (SaltaNorte) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();
		monto_esperado_jugador_1 -= 23000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador1.avanzar(cubilete.sumarValores());
		SaltaSur saltasur = (SaltaSur) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();
		monto_esperado_jugador_1 -= 23000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador1.avanzar(cubilete.sumarValores());
		Neuquen neuquen = (Neuquen) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();
		monto_esperado_jugador_1 -= 17000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador1.avanzar(cubilete.sumarValores());
		Tucuman tucuman = (Tucuman) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();
		monto_esperado_jugador_1 -= 25000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		//JUGADOR 2 ALQUILA EN TODOS LOS TERRENOS SIN CASAS
		Jugador jugador2 = new JugadorHumano(tablero, new Dinero(dinero_inicial));
		int monto_esperado_jugador_2 = dinero_inicial;
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 2000;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 2500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 1000;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 1300;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 1500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 2000;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 2000;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 1800;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 2500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		//JUGADOR 1 CONSTRUYE EN TODOS LOS TERRENOS
		monto_esperado_jugador_1 = jugador1.obtenerDinero().obtenerMontoEntero();
		
		bsassur.construir();
		monto_esperado_jugador_1 -= 5000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		bsasnorte.construir();
		monto_esperado_jugador_1 -= 5500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		cbasur.construir();
		monto_esperado_jugador_1 -= 2000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		cbanorte.construir();
		monto_esperado_jugador_1 -= 2200;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		stafe.construir();
		monto_esperado_jugador_1 -= 4000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		saltanorte.construir();
		monto_esperado_jugador_1 -= 4500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		saltasur.construir();
		monto_esperado_jugador_1 -= 4500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		neuquen.construir();
		monto_esperado_jugador_1 -= 4800;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		tucuman.construir();
		monto_esperado_jugador_1 -= 7000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());

		//JUGADOR 2 ALQUILA EN TODOS LOS TERRENOS CON 1 CASA
		monto_esperado_jugador_2 = jugador2.obtenerDinero().obtenerMontoEntero();
		jugador2.avanzar(cubilete.sumarValores());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3000;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 1500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 1800;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3250;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3250;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3800;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 4500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();

		//JUGADOR 1 CONSTRUYE EN TODOS LOS TERRENOS
		monto_esperado_jugador_1 = jugador1.obtenerDinero().obtenerMontoEntero();
		
		bsassur.construir();
		monto_esperado_jugador_1 -= 5000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		bsasnorte.construir();
		monto_esperado_jugador_1 -= 5500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		cbasur.construir();
		monto_esperado_jugador_1 -= 2000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		cbanorte.construir();
		monto_esperado_jugador_1 -= 2200;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		//try {
		//stafe.construir();
		//monto_esperado_jugador_1 -= 4000;
		//Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//}catch(MaximoDeConstruccionesAlcanzadoException e) {}
		
		saltanorte.construir();
		monto_esperado_jugador_1 -= 4500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		saltasur.construir();
		monto_esperado_jugador_1 -= 4500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		//neuquen.construir();
		//monto_esperado_jugador_1 -= 4800;
		//Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		//tucuman.construir();
		//monto_esperado_jugador_1 -= 7000;
		//Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());

		//JUGADOR 2 ALQUILA EN TODOS LOS TERRENOS DOS CASAS
		monto_esperado_jugador_2 = jugador2.obtenerDinero().obtenerMontoEntero();
		jugador2.avanzar(cubilete.sumarValores());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 4000;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 2500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 2900;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3850;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3850;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3800;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 4500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();

		//JUGADOR 1 CONSTRUYE 1 HOTEL EN TODOS LOS TERRENOS
		monto_esperado_jugador_1 = jugador1.obtenerDinero().obtenerMontoEntero();
		
		bsassur.construir();
		monto_esperado_jugador_1 -= 8000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		bsasnorte.construir();
		monto_esperado_jugador_1 -= 9000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		cbasur.construir();
		monto_esperado_jugador_1 -= 3000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		cbanorte.construir();
		monto_esperado_jugador_1 -= 3500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		//try {
		//stafe.construir();
		//monto_esperado_jugador_1 -= 4000;
		//Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//}catch(MaximoDeConstruccionesAlcanzadoException e) {}
		
		saltanorte.construir();
		monto_esperado_jugador_1 -= 7500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		saltasur.construir();
		monto_esperado_jugador_1 -= 7500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		//neuquen.construir();
		//monto_esperado_jugador_1 -= 4800;
		//Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		//tucuman.construir();
		//monto_esperado_jugador_1 -= 7000;
		//Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());

		//JUGADOR 2 ALQUILA EN TODOS LOS TERRENOS UN HOTEL
		monto_esperado_jugador_2 = jugador2.obtenerDinero().obtenerMontoEntero();
		jugador2.avanzar(cubilete.sumarValores());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 5000;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 6000;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3000;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 5500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 5500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 3800;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();
		
		jugador2.avanzar(cubilete.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(null);
		monto_esperado_jugador_2 -= 4500;
		Assert.assertEquals(monto_esperado_jugador_2, jugador2.obtenerDinero().obtenerMontoEntero());
		cubilete.lanzar();

	}
	
}
