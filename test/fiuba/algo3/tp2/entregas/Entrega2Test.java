package fiuba.algo3.tp2.entregas;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.DadoCargado;
import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorHumano;
import fiuba.algo3.tp2.modelo.Lanzable;
import fiuba.algo3.tp2.modelo.Tablero;
import fiuba.algo3.tp2.modelo.TableroAlgoPoly;
import fiuba.algo3.tp2.modelo.encasillables.comprables.*;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;

public class Entrega2Test {
	
	private Tablero tablero = new TableroAlgoPoly();
	private Dinero dinero100k = new DineroAlgoPoly(100000);
	private Dinero dinero200k = new DineroAlgoPoly(200000);
	private Jugador jugador100k = new JugadorHumano(tablero, dinero100k);
	private Jugador jugador200k = new JugadorHumano(tablero,dinero200k);
	private Terreno bsAsSur = new BuenosAiresSur();
	private Terreno bsAsNorte = new BuenosAiresNorte();
	private Terreno cordobaSur = new CordobaSur();
	private Terreno cordobaNorte = new CordobaNorte();
	private Terreno santaFe = new SantaFe();
	private Terreno saltaSur = new SaltaSur();
	private Terreno saltaNorte = new SaltaNorte();
	private Terreno neuquen = new Neuquen();
	private Terreno tucuman = new Tucuman();
	
	@Test
	public void test01_comprarBsAsSurDisminuye20kElDineroDelJugador() throws DineroInsuficienteException{
		bsAsSur.comprar(jugador100k);	
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(),80000);
	}
	
	@Test
	public void test01_comprarBsAsNorteDisminuye25kElDineroDelJugador() throws DineroInsuficienteException{
		bsAsNorte.comprar(jugador100k);	
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(),75000);
	}
	
	@Test
	public void test01_comprarCordobaSurDisminuye18kElDineroDelJugador() throws DineroInsuficienteException{
		cordobaSur.comprar(jugador100k);	
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(),82000);
	}
	
	@Test
	public void test01_comprarCordobaNorteDisminuye20kElDineroDelJugador() throws DineroInsuficienteException{
		cordobaNorte.comprar(jugador100k);	
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(),80000);
	}
	
	@Test
	public void test01_comprarSantaFeDisminuye15kElDineroDelJugador() throws DineroInsuficienteException{
		santaFe.comprar(jugador100k);	
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(),85000);
	}
	
	@Test
	public void test01_comprarSaltaSurDisminuye23kElDineroDelJugador() throws DineroInsuficienteException{
		saltaSur.comprar(jugador100k);	
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(),77000);
	}
	
	@Test
	public void test01_comprarSaltaNorteDisminuye23kElDineroDelJugador() throws DineroInsuficienteException{
		saltaNorte.comprar(jugador100k);	
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(),77000);
	}
	
	@Test
	public void test01_comprarNeuquenDisminuye17kElDineroDelJugador() throws DineroInsuficienteException{
		neuquen.comprar(jugador100k);	
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(),83000);
	}
	
	@Test
	public void test01_comprarTucumanDisminuye25kElDineroDelJugador() throws DineroInsuficienteException{
		tucuman.comprar(jugador100k);	
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(),75000);
	}
	
	@Test
	public void test02_jugadorTieneAmbosBuenosAiresConstruyeUnaCasaYSuDineroDisminuye5k() throws DineroInsuficienteException{
		bsAsSur.comprar(jugador100k);
		bsAsNorte.comprar(jugador100k);
		int dineroAntesDeConstruir = jugador100k.obtenerDinero().obtenerMontoEntero();
		bsAsSur.construir();
		int dineroDespuesDeConstruir = jugador100k.obtenerDinero().obtenerMontoEntero();
		Assert.assertEquals(dineroAntesDeConstruir,dineroDespuesDeConstruir+5000);
	}
	
	@Test
	public void test03_jugadorQueCaeEnBuenosAiresSurConUnaCasaPaga3k() throws DineroInsuficienteException, JugadorEnCarcelException{
		// El requerimiento de este test era otro. Revisar con corrector.
		Cubilete cubilete = new Cubilete();
		Lanzable dadoSiempre2=new DadoCargado(2);
		cubilete.agregar(dadoSiempre2);
		jugador100k.avanzar(2);
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete);
		//jugador100k.obtenerCasilleroActual().
		jugador200k.avanzar(2);
		jugador200k.aplicarEfectoDeCasilleroActual(cubilete);
		int dineroDespues = jugador200k.obtenerDinero().obtenerMontoEntero();
		Assert.assertEquals(197000, dineroDespues);
	}
	
	@Test
	public void test04_(){
		fail();
	}
	
	@Test
	public void test05_(){
		fail();
	}
	
	@Test
	public void test06_(){
		fail();
	}
	
	@Test
	public void test07_(){
		fail();
	}
	@Test
	public void test08_(){
		fail();
	}
	
	@Test
	public void test09_(){
		fail();
	}
	
	@Test
	public void test10_(){
		fail();
	}
	
	@Test
	public void test11_(){
		fail();
	}
	
	@Test
	public void test12_(){
		fail();
	}
	
	@Test
	public void test13_(){
		fail();
	}
	
	@Test
	public void test14_(){
		fail();
	}
	
	@Test
	public void test15_JugadorCaeEnImpuestoAlLujoYSuDineroDisminuye10Porciento() throws JugadorEnCarcelException, DineroInsuficienteException{
		Cubilete cubilete = new Cubilete();
		Lanzable dadoSiempre10=new DadoCargado(10);
		cubilete.agregar(dadoSiempre10);
		jugador100k.avanzar(10);
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete);
		Assert.assertEquals(90000, jugador100k.obtenerDinero().obtenerMontoEntero());
	}
	
	@Test
	public void test16_(){
		fail();
	}
	
	@Test
	public void test17_(){
		fail();
	}

}
