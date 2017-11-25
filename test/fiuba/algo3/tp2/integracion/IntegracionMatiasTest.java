package fiuba.algo3.tp2.integracion;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorHumano;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.cubilete.DadoCargado;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples.Edificable;
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
	
}
