package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;

public abstract class Servicio extends Propiedad {

	protected int PENALIDAD;
	
	@Override
	public void ejecutarEfecto(Jugador jugador, Cubilete dados) {
		Dinero monto = new Dinero(PENALIDAD * dados.sumarValores());
		jugador.disminuirCapital(monto);
		PROPIETARIO.aumentarCapital(monto);
	}
	
}
