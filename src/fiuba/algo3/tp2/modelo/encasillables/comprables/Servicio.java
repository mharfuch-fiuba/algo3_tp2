package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;

public abstract class Servicio extends Propiedad {

	protected int PENALIDAD;
	
	@Override
	public void ejecutarEfecto(Jugador jugador, Cubilete dados) {
		DineroAlgoPoly monto = new DineroAlgoPoly(PENALIDAD * dados.sumarValores());
		jugador.pagar(monto);
		PROPIETARIO.aumentarCapital(monto);
	}
	
}
