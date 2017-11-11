package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

public class AlgoPolyTest {
	
	@Test
	public void Test01elCapitalSeIncrementaEnQuini6() {
		Tablero tablero = new TableroAlgoPoly();
		Jugador jugador = new JugadorHumano(tablero);
		Lanzable dado1 = new DadoCargado(7);
		Lanzable dado2 = new DadoCargado(14);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		double monto_final = jugador.obtenerDinero().getCantidad();
		double monto_esperado = new Dinero(150000).getCantidad();
		Assert.assertEquals(monto_esperado, monto_final, 0.001);//NO SE BIEN COMO SE HACE ESTO CON EQUALS
	}
	
}
