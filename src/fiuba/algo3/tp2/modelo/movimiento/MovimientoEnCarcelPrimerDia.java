package fiuba.algo3.tp2.modelo.movimiento;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;
import fiuba.algo3.tp2.modelo.excepciones.NoPuedeSalirDeCarcel;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;

public class MovimientoEnCarcelPrimerDia implements Movimiento {

	private Movimiento movimiento_original;
	
	public MovimientoEnCarcelPrimerDia(Movimiento movimiento_normal) {
		movimiento_original = movimiento_normal;
	}

	@Override
	public Encasillable verActual() {
		return movimiento_original.verActual();
	}

	@Override
	public void avanzarHasta(Encasillable casillero) throws JugadorEnCarcelException {
		throw new JugadorEnCarcelException();
	}

	@Override
	public void avanzar(int cantidadCasilleros) throws JugadorEnCarcelException {
		throw new JugadorEnCarcelException();
	}
	
	@Override
	public void retroceder(int cant_casilleros) throws JugadorEnCarcelException {
		throw new JugadorEnCarcelException();
	}

	@Override
	public void desencarcelar(Jugador jugador) throws DineroInsuficienteException {
		throw new NoPuedeSalirDeCarcel();
	}

	@Override
	public void avanzarDia(Jugador jugador) {
		jugador.setMovimiento(new MovimientoEnCarcelSegundoDia(movimiento_original));
	}
	
}
