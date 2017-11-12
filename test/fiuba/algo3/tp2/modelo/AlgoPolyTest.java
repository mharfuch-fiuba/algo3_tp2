package fiuba.algo3.tp2.modelo;

import org.junit.Assert;
import org.junit.Test;

public class AlgoPolyTest {
	
	@Test
	public void Test01_ElCapitalSeIncrementaEn50000AlCaerEnQuini6PorPrimeraVez() throws DineroInsuficienteException {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		ronda.agregarJugador(new JugadorHumano(tablero, new Dinero(100000)));
		Lanzable dado1 = new DadoCargado(7);
		Lanzable dado2 = new DadoCargado(14);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		double monto_final = jugador.obtenerDinero().getCantidad();
		double monto_esperado = new Dinero(150000).getCantidad();
		Assert.assertEquals(monto_esperado, monto_final, 0.001);//NO SE BIEN COMO SE HACE ESTO CON EQUALS
	}
	
	@Test
	public void Test02_ElCapitalSeIncrementaEn30000AlCaerEnQuini6PorSegundaVez() {
		
	}
	
	@Test
	public void Test03_ElCapitalNoSeIncrementaAlCaerEnQuini6PorTerceraVez() {
		
	}
	
	@Test
	public void Test04_ElJugadorCompraUnBarrio() throws DineroInsuficienteException {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		ronda.agregarJugador(new JugadorHumano(tablero, new Dinero(100000)));
		ronda.agregarJugador(new JugadorHumano(tablero, new Dinero(100000)));
		Lanzable dado1 = new DadoCargado(2);
		Lanzable dado2 = new DadoCargado(2);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		
		Jugador jugador1 = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador1.avanzar(cubilete);
		jugador1.comprarCasilleroActual();
		ronda.avanzarTurno();
		Jugador jugador2 = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador2.avanzar(cubilete);
		Comprable casillero = (Comprable) jugador2.obtenerCasilleroActual();
		Jugador propietario = casillero.obtenerPropietario();
		
		Assert.assertEquals(jugador1, propietario);
	}
	
	@Test
	public void Test05_ElJugadorQueCaeEnLaCarcelNoPuedeMoverse() throws DineroInsuficienteException {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		Dinero dinero_inicial = new Dinero(100000);
		ronda.agregarJugador(new JugadorHumano(tablero, dinero_inicial));
		Lanzable dado1 = new DadoCargado(1);
		Lanzable dado2 = new DadoCargado(4);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		
		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		Encasillable casillero_carcel = jugador.obtenerCasilleroActual();
		ronda.avanzarTurno();
		jugador = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();
		
		Assert.assertEquals(casillero_carcel, casillero_actual);
	}
	
	@Test
	public void Test06_ElJugadorQuePagaLaFianzaPuedeMoverse() throws DineroInsuficienteException {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		Dinero dinero_inicial = new Dinero(100000);
		ronda.agregarJugador(new JugadorHumano(tablero, dinero_inicial));
		Lanzable dado1 = new DadoCargado(1);
		Lanzable dado2 = new DadoCargado(4);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		
		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		Encasillable casillero_carcel = jugador.obtenerCasilleroActual();
		ronda.avanzarTurno();
		jugador.avanzar(cubilete);
		ronda.avanzarTurno();
		jugador = ronda.obtenerJugadorActual();
		jugador.pagarFianza();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();
		
		Assert.assertNotEquals(casillero_carcel, casillero_actual);
	}
	
	@Test
	public void Test07_ElJugadorQueNoPuedePagarLaFianzaPorFaltaDeFondosNoPuedeMoverse() throws DineroInsuficienteException {
		Tablero tablero = new TableroAlgoPoly();
		Ronda ronda = new RondaAlgoPoly();
		Dinero dinero_inicial = new Dinero(40000);
		ronda.agregarJugador(new JugadorHumano(tablero, dinero_inicial));
		Lanzable dado1 = new DadoCargado(2);
		Lanzable dado2 = new DadoCargado(3);
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		
		Jugador jugador = ronda.obtenerJugadorActual();
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		Encasillable casillero_carcel = jugador.obtenerCasilleroActual();
		ronda.avanzarTurno();
		jugador.avanzar(cubilete);
		ronda.avanzarTurno();
		jugador = ronda.obtenerJugadorActual();
		try {jugador.pagarFianza();} catch (DineroInsuficienteException e) {}
		cubilete.lanzar();
		jugador.avanzar(cubilete);
		Encasillable casillero_actual = jugador.obtenerCasilleroActual();
			
		Assert.assertEquals(casillero_carcel, casillero_actual);
	}
	
	@Test
	public void Test08_ElJugadorQueCaeEnAvanceDinamicoHabiendoSacado6Avanza4Casilleros() {
		
	}
	
	@Test
	public void Test09_ElJugadorQueCaeEnAvanceDinamicoHabiendoSacado7Avanza5CasillerosSiSuCapitalEsDe100000() {
		
	}
	
	@Test
	public void Test10_ElJugadorQueCaeEnAvanceDinamicoHabiendoSacado12Avanza10CasillerosSiTiene2Propiedades() {
		
	}
	
	@Test
	public void Test11() {
		
	}
	
	@Test
	public void Test12_ElJugadorQueCaeEnPoliciaVaALaCarcel() {
		
	}
	
}
