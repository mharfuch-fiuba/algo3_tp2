package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tp2.modelo.encasillables.comprables.Neuquen;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class AvanceDinamicoTest {
/*
	Tablero tablero = new TableroAlgoPoly();
	Encasillable avance_dinamico = tablero.getCasilleroDestino(tablero.getSalida(), 7);
	Cubilete cubilete_para_llegar = new Cubilete();
	
	@Before
	public void crearCubileteParaLlegarAAvanceDinamico(){
		cubilete_para_llegar.agregar(new DadoCargado(7));
	}
*/
	Tablero tablero = new TableroAlgoPoly();
	Jugador jugador = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
	Cubilete cubilete_para_llegar_hasta_avance_dinamico = new Cubilete();
	private static final int cant_propiedades = 3;
	private static final int distancia_hasta_avance_dinamico = 7;
	
	@Before
	public void crearCubileteParaLlegarAAvanceDinamico(){
		cubilete_para_llegar_hasta_avance_dinamico.agregar(new DadoCargado(7));
	}
/*	
	@Test
	public void test01sacandoDe2A6SeAvanzaDosMenos(){
		for(int i = 2; i<= 6; i++){
			Cubilete cubilete = new Cubilete();		
			Jugador jugador = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
			cubilete.agregar(new DadoCargado(i));
			jugador.avanzar(cubilete_para_llegar);
			jugador.interactuarConCasilleroActual(cubilete);
			Encasillable casilleroEsperado = tablero.getCasilleroDestino(avance_dinamico, cubilete.sumarValores() - 2);
			Encasillable casilleroActual = jugador.obtenerCasilleroActual();
			Assert.assertEquals(casilleroEsperado, casilleroActual);			
		}
		
	}
*/
	@Test
	public void test01sacandoDe2A6SeAvanzaDosMenos() throws DineroInsuficienteException{
		for(int i = 2; i<= 6; i++){
			//LLEVO AL JUGADOR HASTA AVANCE DINAMICO
			Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
			jugador1.avanzar(cubilete_para_llegar_hasta_avance_dinamico);
			Cubilete cubilete1 = new Cubilete();
			cubilete1.agregar(new DadoCargado(i));
			jugador1.aplicarEfectoDeCasilleroActual(cubilete1);
			//LLEVO AL JUGADOR 2 HASTA AVANCE DINAMICO + I
			Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
			Cubilete cubilete2 = new Cubilete();
			int distancia_esperada = distancia_hasta_avance_dinamico  + i - 2;
			cubilete2.agregar(new DadoCargado(distancia_esperada));
			cubilete2.lanzar();
			jugador2.avanzar(cubilete2);
			//VERIFICO QUE AMBOS ESTAN EN EL MISMO LUGAR
			Assert.assertEquals(jugador2.obtenerCasilleroActual(), jugador1.obtenerCasilleroActual());			
		}
		
	}
/*
	@Test
	public void test02sacandoDe7A10SeAvanzaLaCantidadDineroDelJugadorDivididoLosDados(){
		int cantidad_random = (int)Math.random() * 1000000;
		for(int i = 7; i<=10; i++){
			Cubilete cubilete = new Cubilete();
			Jugador jugador = new JugadorHumano(tablero, new DineroAlgoPoly(cantidad_random));
			cubilete.agregar(new DadoCargado(i));
			jugador.avanzar(cubilete_para_llegar);
			jugador.interactuarConCasilleroActual(cubilete);
			Encasillable casilleroEsperado = tablero.getCasilleroDestino(avance_dinamico, jugador.obtenerDinero().obtenerMontoEntero() % cubilete.sumarValores());
			Encasillable casilleroActual = jugador.obtenerCasilleroActual();
			Assert.assertEquals(casilleroEsperado, casilleroActual);
		}
		Assert.assertTrue(true);
	}
*/
	@Test
	public void test02sacandoDe7A10SeAvanzaLaCantidadDineroDelJugadorDivididoLosDados() throws DineroInsuficienteException{
		for(int i = 7; i<= 10; i++){
			//LLEVO AL JUGADOR HASTA AVANCE DINAMICO
			Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
			jugador1.avanzar(cubilete_para_llegar_hasta_avance_dinamico);
			Cubilete cubilete1 = new Cubilete();
			cubilete1.agregar(new DadoCargado(i));
			jugador1.aplicarEfectoDeCasilleroActual(cubilete1);
			//LLEVO AL JUGADOR 2 HASTA AVANCE DINAMICO + PLATA % I
			Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
			Cubilete cubilete2 = new Cubilete();
			int distancia_esperada = distancia_hasta_avance_dinamico + jugador1.obtenerDinero().obtenerMontoEntero() % i;
			cubilete2.agregar(new DadoCargado(distancia_esperada));
			cubilete2.lanzar();
			jugador2.avanzar(cubilete2);
			//VERIFICO QUE AMBOS ESTAN EN EL MISMO LUGAR
			Assert.assertEquals(jugador2.obtenerCasilleroActual(), jugador1.obtenerCasilleroActual());			
		}
		
	}
/*
	@Test
	public void test03sacandoDe11A12SeAvanzaElNumeroMenosCantidadDePropiedades(){
		int propiedades_random = (int)Math.random() * 10;
		ArrayList<Comprable> propiedades = new ArrayList<Comprable>();
		for(int i=1; i<=propiedades_random; i++){
			propiedades.add(new Neuquen());
		}
		for(int i=11; i<=12;i++){
			Cubilete cubilete = new Cubilete();
			Jugador jugador = new JugadorHumano(tablero, new DineroAlgoPoly(100000),new ArrayList<Comprable>());
			cubilete.agregar(new DadoCargado(i));
			jugador.avanzar(cubilete_para_llegar);
			jugador.interactuarConCasilleroActual(cubilete);
			Encasillable casilleroEsperado = tablero.getCasilleroDestino(avance_dinamico, cubilete.sumarValores() - jugador.getCantidadDePropiedades());
			Encasillable casilleroActual = jugador.obtenerCasilleroActual();
			Assert.assertEquals(casilleroEsperado, casilleroActual);
		}
	}
*/
	@Test
	public void test03sacandoDe11A12SeAvanzaElNumeroMenosCantidadDePropiedades() throws DineroInsuficienteException{

		for(int i = 11; i <= 12; i++){
			//LLEVO AL JUGADOR HASTA AVANCE DINAMICO
			Jugador jugador1 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
			for(int j = 1; j <= cant_propiedades; j++){
				jugador1.agregarPropiedad(new Neuquen());
			}
			jugador1.avanzar(cubilete_para_llegar_hasta_avance_dinamico);
			Cubilete cubilete1 = new Cubilete();
			cubilete1.agregar(new DadoCargado(i));
			jugador1.aplicarEfectoDeCasilleroActual(cubilete1);
			//LLEVO AL JUGADOR 2 HASTA AVANCE DINAMICO + I - CANT_PROP
			Jugador jugador2 = new JugadorHumano(tablero, new DineroAlgoPoly(100000));
			Cubilete cubilete2 = new Cubilete();
			int distancia_esperada = distancia_hasta_avance_dinamico + i - jugador1.getCantidadDePropiedades();
			cubilete2.agregar(new DadoCargado(distancia_esperada));
			cubilete2.lanzar();
			jugador2.avanzar(cubilete2);
			//VERIFICO QUE AMBOS ESTAN EN EL MISMO LUGAR
			Assert.assertEquals(jugador2.obtenerCasilleroActual(), jugador1.obtenerCasilleroActual());			
		}
		
	}
}
