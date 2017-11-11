package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

public class AlgoPolyTest {
	
	@Test
	public void Test01elCapitalSeIncrementaEnQuini6() {
		Recorrible tablero = new TableroAlgoPoly();
		IterTablero iterador = tablero.crearIterador();
		Jugador jugador = new JugadorHumano(iterador);
		Lanzable dado1 = new DadoCargado(7);
		Lanzable dado2 = new DadoCargado(14);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		Dinero monto_final = jugador.obtenerDinero();
		Assert.assertEquals(150000, monto_final);
	}
	
}
