package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.movimiento.Movimiento;
import fiuba.algo3.tp2.modelo.movimiento.MovimientoEnCarcelPrimerDia;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;

public class Carcel implements Encasillable {

	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) {
		Movimiento movimiento_normal = jugador.getMovimiento();
		Movimiento movimiento_carcel = new MovimientoEnCarcelPrimerDia(movimiento_normal);
		jugador.setMovimiento(movimiento_carcel);
	}
	
	public void pagarFianza(Jugador jugador) throws DineroInsuficienteException {
		Movimiento movimiento = jugador.getMovimiento();
		movimiento.desencarcelar(jugador);
	}

	@Override
	public String getNombre() {
		return "Carcel";
	}
}
