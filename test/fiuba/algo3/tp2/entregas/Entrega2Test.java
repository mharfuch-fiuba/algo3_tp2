package fiuba.algo3.tp2.entregas;


import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorHumano;
import fiuba.algo3.tp2.modelo.construible.ConstructorBuenosAires;
import fiuba.algo3.tp2.modelo.construible.ConstructorCordoba;
import fiuba.algo3.tp2.modelo.construible.ConstructorSalta;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.cubilete.DadoCargado;
import fiuba.algo3.tp2.modelo.cubilete.Lanzable;
import fiuba.algo3.tp2.modelo.encasillables.comprables.*;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;
import fiuba.algo3.tp2.modelo.tablero.Tablero;
import fiuba.algo3.tp2.modelo.tablero.TableroAlgoPoly;

public class Entrega2Test {

	private Tablero tablero = new TableroAlgoPoly();
	private Dinero dinero100k = new DineroAlgoPoly(100000);
	private Dinero dinero200k = new DineroAlgoPoly(200000);
	private Jugador jugador100k = new JugadorHumano(tablero, dinero100k);
	private Jugador jugador200k = new JugadorHumano(tablero, dinero200k);
	private ConstructorBuenosAires cBuenosAires = new ConstructorBuenosAires();
	private ConstructorSalta cSalta = new ConstructorSalta();
	private ConstructorCordoba cCordoba = new ConstructorCordoba();
	
	private TerrenoAlgoPoly bsAsSur = cBuenosAires.getSur();
	private TerrenoAlgoPoly bsAsNorte = cBuenosAires.getNorte();
	private TerrenoAlgoPoly cordobaSur = cCordoba.getSur();
	private TerrenoAlgoPoly cordobaNorte = cCordoba.getNorte();
	private TerrenoAlgoPoly santaFe = new SantaFe();
	private TerrenoAlgoPoly saltaSur = cSalta.getSur();
	private TerrenoAlgoPoly saltaNorte = cSalta.getNorte();
	private TerrenoAlgoPoly neuquen = new Neuquen();
	private TerrenoAlgoPoly tucuman = new Tucuman();

	@Test
	public void test01_comprarBsAsSurDisminuye20kElDineroDelJugador() throws DineroInsuficienteException {
		bsAsSur.comprar(jugador100k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), 80000);
	}

	@Test
	public void test01_comprarBsAsNorteDisminuye25kElDineroDelJugador() throws DineroInsuficienteException {
		bsAsNorte.comprar(jugador100k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), 75000);
	}

	@Test
	public void test01_comprarCordobaSurDisminuye18kElDineroDelJugador() throws DineroInsuficienteException {
		cordobaSur.comprar(jugador100k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), 82000);
	}

	@Test
	public void test01_comprarCordobaNorteDisminuye20kElDineroDelJugador() throws DineroInsuficienteException {
		cordobaNorte.comprar(jugador100k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), 80000);
	}

	@Test
	public void test01_comprarSantaFeDisminuye15kElDineroDelJugador() throws DineroInsuficienteException {
		santaFe.comprar(jugador100k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), 85000);
	}

	@Test
	public void test01_comprarSaltaSurDisminuye23kElDineroDelJugador() throws DineroInsuficienteException {
		saltaSur.comprar(jugador100k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), 77000);
	}

	@Test
	public void test01_comprarSaltaNorteDisminuye23kElDineroDelJugador() throws DineroInsuficienteException {
		saltaNorte.comprar(jugador100k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), 77000);
	}

	@Test
	public void test01_comprarNeuquenDisminuye17kElDineroDelJugador() throws DineroInsuficienteException {
		neuquen.comprar(jugador100k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), 83000);
	}

	@Test
	public void test01_comprarTucumanDisminuye25kElDineroDelJugador() throws DineroInsuficienteException {
		tucuman.comprar(jugador100k);
		Assert.assertEquals(jugador100k.obtenerDinero().obtenerMontoEntero(), 75000);
	}

	@Test
	public void test02_jugadorTieneAmbosBuenosAiresConstruyeUnaCasaYSuDineroDisminuye5k()
			throws DineroInsuficienteException {
		bsAsSur.comprar(jugador100k);
		bsAsNorte.comprar(jugador100k);
		int dineroAntesDeConstruir = jugador100k.obtenerDinero().obtenerMontoEntero();
		bsAsSur.construir();
		int dineroDespuesDeConstruir = jugador100k.obtenerDinero().obtenerMontoEntero();
		Assert.assertEquals(dineroAntesDeConstruir, dineroDespuesDeConstruir + 5000);
	}

	@Test
	public void test03_jugadorQueCaeEnBuenosAiresSurConUnaCasaPaga3k()
			throws DineroInsuficienteException, JugadorEnCarcelException {
		
		Cubilete cubilete = new Cubilete();
		Lanzable dadoSiempre2 = new DadoCargado(2);
		cubilete.agregar(dadoSiempre2);
		jugador100k.avanzar(2);
		jugador100k.aplicarEfectoDeCasilleroActual(cubilete);

		// no se me ocurre otra forma de hacerlo ahora sin casteo
		TerrenoAlgoPoly terreno = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		jugador100k.comprar(terreno);
		terreno.construir();

		jugador200k.avanzar(2);
		jugador200k.aplicarEfectoDeCasilleroActual(cubilete);
		int dineroDespues = jugador200k.obtenerDinero().obtenerMontoEntero();
		Assert.assertEquals(197000, dineroDespues);
		
		/*
		// DE OTRA FORMA ... <PRUEBA DE INTEGRACION>
		final int monto_inicial = 200000;
		
		Cubilete cubilete_que_saca_2 = new Cubilete();
		cubilete_que_saca_2.agregar(new DadoCargado(2));
		
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador1.avanzar(cubilete_que_saca_2.sumarValores());
		Construible bsas_sur = (Construible) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();//Compra BsAs Sur $20000
		int monto_esperado_jugador_1 = monto_inicial - 20000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//SI INTENTO CONSTRUIR NO ME DEBERIA DEJAR PORQUE ME FALTA BSAS NORTE, NO?
		jugador1.avanzar(cubilete_que_saca_2.sumarValores());
		jugador1.comprarCasilleroActual();//Compra BsAs Norte $25000
		monto_esperado_jugador_1 = monto_esperado_jugador_1 - 25000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		Construible bsas_nor = (Construible) jugador1.obtenerCasilleroActual();
		bsas_sur.construir();
		monto_esperado_jugador_1 = monto_esperado_jugador_1 - 5000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		bsas_nor.construir();
		monto_esperado_jugador_1 = monto_esperado_jugador_1 - 5500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		
		Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
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
		*/
	}

	@Test
	public void test04_jugadorQueCaeEnBuenosAiresDeOtroCon1CasaEnNorteYDosEnSurPaga3500EnCadaUna() throws JugadorEnCarcelException, DineroInsuficienteException {
		Cubilete cubilete = new Cubilete();
		Lanzable dadoSiempre2 = new DadoCargado(2);
		cubilete.agregar(dadoSiempre2);
		
		jugador100k.avanzar(2);

		// no se me ocurre otra forma de hacerlo ahora sin casteo
		TerrenoAlgoPoly bsAsSur = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		jugador100k.comprar(bsAsSur);
		bsAsSur.construir();
		bsAsSur.construir();
		//hasta aca hay dos casas en BsAsSur
		jugador100k.avanzar(2);
		TerrenoAlgoPoly bsAsNorte = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		jugador100k.comprar(bsAsNorte);
		bsAsNorte.construir();
		//ahora hay dos casas en BsAsSur y una en BsAsNorte

		//otro jugador cae en BsAsSur
		jugador200k.avanzar(2);
		jugador200k.aplicarEfectoDeCasilleroActual(cubilete);
		Dinero despuesDeCaerEnSur = jugador200k.obtenerDinero();
		Assert.assertEquals(196500, despuesDeCaerEnSur.obtenerMontoEntero());
		//el mismo jugador cae en BsAsNorte
		jugador200k.avanzar(2);
		jugador200k.aplicarEfectoDeCasilleroActual(cubilete);
		Dinero despuesDeCaerEnNorte = jugador200k.obtenerDinero();
		Assert.assertEquals(193000, despuesDeCaerEnNorte.obtenerMontoEntero());
		
	}

	@Test
	public void test05_SiJugadorTieneAmbosBuenosAiresPeroNoLaMaximaCantidadDeCasasYConstruyeHotelSuDineroNoBaja() throws JugadorEnCarcelException, DineroInsuficienteException {
		// por como lo tenemos implementado, el jugador no puede elegir qu� construir. La inmobiliaria decide esto.
		
		//Si decidimos cambiarlo, aca una posible implementacion del test:
		
		/*
		final int monto_inicial = 200000;
		int monto_esperado_jugador_1 = monto_inicial;

		Cubilete cubilete_que_saca_2 = new Cubilete();
		cubilete_que_saca_2.agregar(new DadoCargado(2));
		
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador1.avanzar(cubilete_que_saca_2.sumarValores());
		Construible bsas_sur = (Construible) jugador1.obtenerCasilleroActual();
		jugador1.comprarCasilleroActual();//Compra BsAs Sur $20000
		monto_esperado_jugador_1 -= 20000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		jugador1.avanzar(cubilete_que_saca_2.sumarValores());
		jugador1.comprarCasilleroActual();//Compra BsAs Norte $25000
		monto_esperado_jugador_1 -= 25000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		Construible bsas_nor = (Construible) jugador1.obtenerCasilleroActual();
		//bsas_sur.construirHotel(); // <-- Tiene que tirar excepcion CasasInsuficientesException
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//bsas_nor.construirHotel(); // <-- Tiene que tirar excepcion CasasInsuficientesException
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//bsas_sur.construirCasa();
		monto_esperado_jugador_1 -= 5000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//bsas_sur.construirHotel(); // <-- Tiene que tirar excepcion CasasInsuficientesException
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//bsas_sur.construirCasa();
		monto_esperado_jugador_1 -= 5000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//bsas_sur.construirHotel(); // <-- Tiene que tirar excepcion CasasInsuficientesException
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//bsas_sur.construirCasa(); // <-- Tiene que tirar excepcion MaximoDeCasasException
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//bsas_nor.construirCasa();
		monto_esperado_jugador_1 -= 5500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//bsas_sur.construirHotel(); // <-- Tiene que tirar excepcion CasasInsuficientesException
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//bsas_nor.construirCasa();
		monto_esperado_jugador_1 -= 5500;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//bsas_sur.construirHotel();
		monto_esperado_jugador_1 -= 8000;
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		//bsas_nor.construirCasa(); // <-- Tiene que tirar excepcion MaximoDeCasasException
		Assert.assertEquals(monto_esperado_jugador_1, jugador1.obtenerDinero().obtenerMontoEntero());
		*/
	}

	@Test
	public void test06_SiJugadorTieneAmbosBuenosAiresConMaximaCantidadDeCasasYConstruyeHotelEnBuenosAiresSurSuDineroBaja8k() throws DineroInsuficienteException {
		jugador100k.comprar(bsAsNorte);
		jugador100k.comprar(bsAsSur);
		bsAsSur.construir();
		bsAsSur.construir();
		bsAsNorte.construir();
		bsAsNorte.construir();
		//en este punto tiene dos casas en cada terreno.
		//el dinero del jugador deberia ser ahora 34k (gasto 45k por los terrenos + 10k casas BsAsSur + 11k casas BsAsNorte)
		Dinero antesDelHotel = jugador100k.obtenerDinero();
		Assert.assertEquals(34000,antesDelHotel.obtenerMontoEntero());
		bsAsSur.construir();
		Dinero despuesDelHotel = jugador100k.obtenerDinero();
		Assert.assertEquals(26000, despuesDelHotel.obtenerMontoEntero());
	}

	@Test
	public void test07_SiUnJugadorCaeEnBuenosAiresSurDeOtroConHotelPaga5k() throws JugadorEnCarcelException, DineroInsuficienteException {
		
		Cubilete cubilete = new Cubilete();
		Lanzable dadoSiempre2 = new DadoCargado(2);
		cubilete.agregar(dadoSiempre2);
		
		jugador100k.avanzar(2);

		// no se me ocurre otra forma de hacerlo ahora sin casteo
		TerrenoAlgoPoly bsAsSur = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		jugador100k.comprar(bsAsSur);
		bsAsSur.construir();
		bsAsSur.construir();
		//hasta aca hay dos casas en BsAsSur
		jugador100k.avanzar(2);
		TerrenoAlgoPoly bsAsNorte = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		jugador100k.comprar(bsAsNorte);
		bsAsNorte.construir();
		bsAsNorte.construir();		
		//hasta aca hay dos casas en BsAsSur y dos en BsAsNorte
		bsAsSur.construir();
		//ahora deberia haber un hotel en BsAsSur
		
		//otro jugador cae en BsAsSur
		jugador200k.avanzar(2);
		jugador200k.aplicarEfectoDeCasilleroActual(cubilete);
		int dineroDespues = jugador200k.obtenerDinero().obtenerMontoEntero();
		Assert.assertEquals(195000, dineroDespues);
	}
	
	@Test
	public void test08_JugadorCaeEnCordobaSurDeOtroPropietarioYPagaAlquilerDeHotel() throws JugadorEnCarcelException, DineroInsuficienteException{
		Cubilete cubilete = new Cubilete();
		Lanzable dado_siempre_6 = new DadoCargado(6);
		Lanzable dado_siempre_3 = new DadoCargado(3);
		Cubilete cubilete2 = new Cubilete();
		cubilete.agregar(dado_siempre_6);
		cubilete2.agregar(dado_siempre_3);
		
		jugador100k.avanzar(cubilete.sumarValores());
		TerrenoAlgoPoly cbaSur = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		jugador100k.comprar(cbaSur);
		cbaSur.construir();
		cbaSur.construir();
		jugador100k.avanzar(cubilete2.sumarValores());
		TerrenoAlgoPoly cbaNor = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		jugador100k.comprar(cbaNor);
		cbaNor.construir();
		cbaNor.construir();
		cbaSur.construir();
		
		jugador200k.avanzar(cubilete.sumarValores());
		int dineroInicial = jugador200k.obtenerDinero().obtenerMontoEntero();
		jugador200k.aplicarEfectoDeCasilleroActual(cubilete);
		
		Assert.assertEquals(3000, dineroInicial - jugador200k.obtenerDinero().obtenerMontoEntero());
	}

	@Test
	public void test08_JugadorCaeEnSaltaNorteDeOtroPropietarioYPagaAlquilerDeHotel() throws JugadorEnCarcelException, DineroInsuficienteException{
		Cubilete cubilete = new Cubilete();
		Lanzable dado_siempre_13 = new DadoCargado(13);
		cubilete.agregar(dado_siempre_13);
		
		jugador100k.avanzar(cubilete.sumarValores());
		TerrenoAlgoPoly saltaNorte = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		jugador100k.comprar(saltaNorte);
		saltaNorte.construir();
		saltaNorte.construir();
		jugador100k.avanzar(1);
		TerrenoAlgoPoly saltaSur = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		jugador100k.comprar(saltaSur);
		saltaSur.construir();
		saltaSur.construir();
		saltaNorte.construir();
		
		jugador200k.avanzar(cubilete.sumarValores());
		int dineroInicial = jugador200k.obtenerDinero().obtenerMontoEntero();
		jugador200k.aplicarEfectoDeCasilleroActual(cubilete);
		
		Assert.assertEquals(5500, dineroInicial - jugador200k.obtenerDinero().obtenerMontoEntero());
	}
	
	@Test
	public void test09_SiJugadorTieneSantaFeYConstruyeUnaCasaSuDineroBaja4k() throws DineroInsuficienteException {
		jugador100k.comprar(santaFe);
		santaFe.construir();
		Dinero despuesDeConstruir= jugador100k.obtenerDinero();
		Assert.assertEquals(81000, despuesDeConstruir.obtenerMontoEntero());
	}

	@Test
	public void test10_SiJugadorCaeEnCualquierTerrenoConConstruccionesPagaLoQueCorresponde() throws JugadorEnCarcelException, DineroInsuficienteException{
		//Tests realizados en clase aparte porque hay que verificar todos los casos.
	}
	
	@Test
	public void test10_SiJugadorCaeEnBuenosAiresSurConUnaConstruccionSuDineroSeReduce3000() throws DineroInsuficienteException, JugadorEnCarcelException {
		jugador100k.avanzar(2);
		jugador100k.comprarCasilleroActual();
		TerrenoAlgoPoly bsAsSur = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		bsAsSur.construir();
		jugador200k.avanzar(2);
		jugador200k.aplicarEfectoDeCasilleroActual(new Cubilete());
		Dinero dineroDespuesDeInteractuar = jugador200k.obtenerDinero();
		
		Assert.assertEquals(3000, 200000 - dineroDespuesDeInteractuar.obtenerMontoEntero());
	}
	
	@Test
	public void test10_SiJugadorCaeEnBuenosAiresNorteConUnaConstruccionSuDineroSeReduce3500() throws DineroInsuficienteException, JugadorEnCarcelException {
		jugador100k.avanzar(4);
		jugador100k.comprarCasilleroActual();
		TerrenoAlgoPoly bsAsNorte = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		bsAsNorte.construir();
		jugador200k.avanzar(4);
		jugador200k.aplicarEfectoDeCasilleroActual(new Cubilete());
		Dinero dineroDespuesDeInteractuar = jugador200k.obtenerDinero();
		
		Assert.assertEquals(3500, 200000 - dineroDespuesDeInteractuar.obtenerMontoEntero());
	}
	
	@Test
	public void test10_SiJugadorCaeEnCordobaSurConUnaConstruccionSuDineroSeReduce1500() throws DineroInsuficienteException, JugadorEnCarcelException {
		jugador100k.avanzar(6);
		jugador100k.comprarCasilleroActual();
		TerrenoAlgoPoly cordobaSur = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		cordobaSur.construir();
		jugador200k.avanzar(6);
		jugador200k.aplicarEfectoDeCasilleroActual(new Cubilete());
		Dinero dineroDespuesDeInteractuar = jugador200k.obtenerDinero();
		
		Assert.assertEquals(1500, 200000 - dineroDespuesDeInteractuar.obtenerMontoEntero());
	}
	
	@Test
	public void test10_SiJugadorCaeEnCordobaNorteConUnaConstruccionSuDineroSeReduce1800() throws DineroInsuficienteException, JugadorEnCarcelException {
		jugador100k.avanzar(9);
		jugador100k.comprarCasilleroActual();
		TerrenoAlgoPoly cordobaNorte = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		cordobaNorte.construir();
		jugador200k.avanzar(9);
		jugador200k.aplicarEfectoDeCasilleroActual(new Cubilete());
		Dinero dineroDespuesDeInteractuar = jugador200k.obtenerDinero();
		
		Assert.assertEquals(1800, 200000 - dineroDespuesDeInteractuar.obtenerMontoEntero());
	}
	
	@Test
	public void test10_SiJugadorCaeEnSantaFeConUnaConstruccionSuDineroSeReduce3500() throws DineroInsuficienteException, JugadorEnCarcelException {
		jugador100k.avanzar(11);
		jugador100k.comprarCasilleroActual();
		TerrenoAlgoPoly santaFe = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		santaFe.construir();
		jugador200k.avanzar(11);
		jugador200k.aplicarEfectoDeCasilleroActual(new Cubilete());
		Dinero dineroDespuesDeInteractuar = jugador200k.obtenerDinero();
		
		Assert.assertEquals(3500, 200000 - dineroDespuesDeInteractuar.obtenerMontoEntero());
	}
	
	@Test
	public void test10_SiJugadorCaeEnSaltaNorteConUnaConstruccionSuDineroSeReduce3250() throws DineroInsuficienteException, JugadorEnCarcelException {
		jugador100k.avanzar(13);
		jugador100k.comprarCasilleroActual();
		TerrenoAlgoPoly saltaNorte = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		saltaNorte.construir();
		jugador200k.avanzar(13);
		jugador200k.aplicarEfectoDeCasilleroActual(new Cubilete());
		Dinero dineroDespuesDeInteractuar = jugador200k.obtenerDinero();
		
		Assert.assertEquals(3250, 200000 - dineroDespuesDeInteractuar.obtenerMontoEntero());
	}
	
	@Test
	public void test10_SiJugadorCaeEnSalaSurConUnaConstruccionSuDineroSeReduce3250() throws DineroInsuficienteException, JugadorEnCarcelException {
		jugador100k.avanzar(13);
		jugador100k.comprarCasilleroActual();
		TerrenoAlgoPoly saltaSur = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		saltaSur.construir();
		jugador200k.avanzar(13);
		jugador200k.aplicarEfectoDeCasilleroActual(new Cubilete());
		Dinero dineroDespuesDeInteractuar = jugador200k.obtenerDinero();
		
		Assert.assertEquals(3250, 200000 - dineroDespuesDeInteractuar.obtenerMontoEntero());
	}
	
	@Test
	public void test10_SiJugadorCaeEnNeuquenConUnaConstruccionSuDineroSeReduce3800() throws DineroInsuficienteException, JugadorEnCarcelException {
		jugador100k.avanzar(17);
		jugador100k.comprarCasilleroActual();
		TerrenoAlgoPoly neuquen = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		neuquen.construir();
		jugador200k.avanzar(17);
		jugador200k.aplicarEfectoDeCasilleroActual(new Cubilete());
		Dinero dineroDespuesDeInteractuar = jugador200k.obtenerDinero();
		
		Assert.assertEquals(3800, 200000 - dineroDespuesDeInteractuar.obtenerMontoEntero());
	}
	
	@Test
	public void test10_SiJugadorCaeEnTucumanConUnaConstruccionSuDineroSeReduce4500() throws DineroInsuficienteException, JugadorEnCarcelException {
		jugador100k.avanzar(19);
		jugador100k.comprarCasilleroActual();
		TerrenoAlgoPoly tucuman = (TerrenoAlgoPoly) jugador100k.obtenerCasilleroActual();
		tucuman.construir();
		jugador200k.avanzar(19);
		jugador200k.aplicarEfectoDeCasilleroActual(new Cubilete());
		Dinero dineroDespuesDeInteractuar = jugador200k.obtenerDinero();
		
		Assert.assertEquals(4500, 200000 - dineroDespuesDeInteractuar.obtenerMontoEntero());
	}

	@Test
	public void test11_jugadorSacaDoceCaeEnTrenYaAdquiridoSuPropietarioNoTieneSubteSuDineroSeReduce5400() throws JugadorEnCarcelException, DineroInsuficienteException {
		final int monto_inicial = 20000;
		final int monto_esperado = monto_inicial - 5400;
		Cubilete cubilete_que_saca_12 = new Cubilete();
		cubilete_que_saca_12.agregar(new DadoCargado(12));
		Cubilete cubilete_que_saca_16 = new Cubilete();
		cubilete_que_saca_16.agregar(new DadoCargado(16));
		/* CREO AL JUGADOR 1, LO AVANZO HASTA EL TREN Y LO COMPRO */
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
		jugador1.avanzar(cubilete_que_saca_16.sumarValores());
		jugador1.comprarCasilleroActual();
		/* CREO AL JUGADOR 2 Y LO AVANZO HASTA EL TREN */
		Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador2.avanzar(cubilete_que_saca_16.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(cubilete_que_saca_12); // EMULA HABER SACADO 12
		Assert.assertEquals(monto_esperado, jugador2.obtenerDinero().obtenerMontoEntero());
	}

	@Test
	public void test12_jugadorSacaDoceCaeEnTrenYaAdquiridoSuPropietarioTieneSubteSuDineroSeReduce9600() throws JugadorEnCarcelException, DineroInsuficienteException {
		final int monto_inicial = 20000;
		final int monto_esperado = monto_inicial - 9600;
		
		Cubilete cubilete_que_saca_12 = new Cubilete();
		cubilete_que_saca_12.agregar(new DadoCargado(12));
		/* CREO AL JUGADOR 1, LO AVANZO HASTA EL SUBTE Y LO COMPRO LUEGO HASTA EL TREN Y LO COMPRO */
		Cubilete cubilete_que_saca_8 = new Cubilete();
		cubilete_que_saca_8.agregar(new DadoCargado(8));
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
		jugador1.avanzar(cubilete_que_saca_8.sumarValores());
		//POR QUE NO UN METODO: COMPRAR CASILLERO ACTUAL?
		jugador1.comprarCasilleroActual(); // Compra el subte
		jugador1.avanzar(cubilete_que_saca_8.sumarValores());
		jugador1.comprarCasilleroActual(); // Compra el tren
		/* CREO AL JUGADOR 2 Y LO AVANZO HASTA EL TREN */
		Cubilete cubilete_que_saca_16 = new Cubilete();
		cubilete_que_saca_16.agregar(new DadoCargado(16));
		Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador2.avanzar(cubilete_que_saca_16.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(cubilete_que_saca_12); // EMULA HABER SACADO 12
		Assert.assertEquals(monto_esperado, jugador2.obtenerDinero().obtenerMontoEntero());
	}

	@Test
	public void test13_JugadoresIntercambianPropiedadesElTercerJugadorLePagaAlNuevoPropietario() throws JugadorEnCarcelException, DineroInsuficienteException {
		final int monto_inicial = 100000;
		final int monto_esperado = monto_inicial - 20000 + 1500;
		
		//JUGADOR 1 COMPRA SANTA FE
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		Cubilete cubilete_que_saca_11 = new Cubilete();
		cubilete_que_saca_11.agregar(new DadoCargado(11));
		jugador1.avanzar(cubilete_que_saca_11.sumarValores());
		jugador1.comprarCasilleroActual();
		//JUGADOR 2 COMPRA CORDOBA NORTE
		Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		Cubilete cubilete_que_saca_9 = new Cubilete();
		cubilete_que_saca_9.agregar(new DadoCargado(9));
		jugador2.avanzar(cubilete_que_saca_9.sumarValores());
		jugador2.comprarCasilleroActual();
		//JUGADOR 1 INTERCAMBIA PROPIEDADES CON JUGADOR 2
		// MAS ADELTANTE TAL VEZ SE PUEDA ARMAR UNA CLASE TRUEQUE, PERO ESTO ESTA MUY ARRAIGADO CON LA INTERFAZ
		Propiedad propiedad1 = (Propiedad) jugador1.obtenerCasilleroActual();
		jugador1.entregarPropiedad(jugador2, propiedad1);
		Propiedad propiedad2 = (Propiedad) jugador2.obtenerCasilleroActual();
		jugador2.entregarPropiedad(jugador1, propiedad2);
		// -----------------------------------------------------------------------------------------------------
		//JUGADOR 3 CAE EN SANTA FE Y LE PAGA AL JUGADOR 2
		Jugador jugador3 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador3.avanzar(cubilete_que_saca_11.sumarValores());
		jugador3.aplicarEfectoDeCasilleroActual(cubilete_que_saca_11);
		Assert.assertEquals(monto_esperado, jugador2.obtenerDinero().obtenerMontoEntero());
	}

	@Test
	public void test14_() {
		//duplicado test13
	}

	@Test
	public void test15_JugadorCaeEnImpuestoAlLujoYSuDineroDisminuye10Porciento() throws JugadorEnCarcelException, DineroInsuficienteException {
		final int monto_inicial = 10000;
		final int monto_esperado = monto_inicial - (int) (monto_inicial * 0.1);
		
		Cubilete cubilete_que_saca_10 = new Cubilete();
		cubilete_que_saca_10.agregar(new DadoCargado(10));
		/* CREO AL JUGADOR 1, LO AVANZO HASTA EDESUR Y LO COMPRO */
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador1.avanzar(cubilete_que_saca_10.sumarValores());
		jugador1.aplicarEfectoDeCasilleroActual(cubilete_que_saca_10);
		Assert.assertEquals(monto_esperado, jugador1.obtenerDinero().obtenerMontoEntero());
	}

	@Test
	public void test16_jugadorSacaDoceCaeEnEdesurYaAdquiridoSuPropietarioNoTieneAyseSuDineroSeReduce6000() throws JugadorEnCarcelException, DineroInsuficienteException {
		final int monto_inicial = 20000;
		final int monto_esperado = monto_inicial - 6000;
		
		Cubilete cubilete_que_saca_12 = new Cubilete();
		cubilete_que_saca_12.agregar(new DadoCargado(12));
		Cubilete cubilete_que_saca_3 = new Cubilete();
		cubilete_que_saca_3.agregar(new DadoCargado(3));
		/* CREO AL JUGADOR 1, LO AVANZO HASTA EDESUR Y LO COMPRO */
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
		jugador1.avanzar(cubilete_que_saca_3.sumarValores());
		jugador1.comprarCasilleroActual();
		/* CREO AL JUGADOR 2 Y LO AVANZO HASTA EDESUR */
		Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador2.avanzar(cubilete_que_saca_3.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(cubilete_que_saca_12); // EMULA HABER SACADO 12
		Assert.assertEquals(monto_esperado, jugador2.obtenerDinero().obtenerMontoEntero());
	}

	@Test
	public void test17_jugadorSacaDoceCaeEnEdesurYaAdquiridoSuPropietarioTieneAysaSuDineroSeReduce12000() throws JugadorEnCarcelException, DineroInsuficienteException {
		final int monto_inicial = 20000;
		final int monto_esperado = monto_inicial - 12000;
		
		Cubilete cubilete_que_saca_12 = new Cubilete();
		cubilete_que_saca_12.agregar(new DadoCargado(12));
		/* CREO AL JUGADOR 1, LO AVANZO HASTA EDESUR Y LO COMPRO LUEGO HASTA AYSA Y LO COMPRO */
		Cubilete cubilete_que_saca_3 = new Cubilete();
		cubilete_que_saca_3.agregar(new DadoCargado(3));
		Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
		jugador1.avanzar(cubilete_que_saca_3.sumarValores());
		jugador1.comprarCasilleroActual(); // Compra edesur
		Cubilete cubilete_que_saca_9 = new Cubilete();
		cubilete_que_saca_9.agregar(new DadoCargado(9));
		jugador1.avanzar(cubilete_que_saca_9.sumarValores());
		jugador1.comprarCasilleroActual(); // Compra aysa
		/* CREO AL JUGADOR 2 Y LO AVANZO HASTA EDESUR */
		Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(monto_inicial));
		jugador2.avanzar(cubilete_que_saca_3.sumarValores());
		jugador2.aplicarEfectoDeCasilleroActual(cubilete_que_saca_12); // EMULA HABER SACADO 12
		Assert.assertEquals(monto_esperado, jugador2.obtenerDinero().obtenerMontoEntero());
	}

}
