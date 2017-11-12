package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.Jugador;

public abstract class Terreno extends Propiedad {
	
	protected DineroAlgoPoly PRECIO_ALQUILER;
	
	@Override
	public void ejecutarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		jugador.disminuirCapital(PRECIO_ALQUILER);
		PROPIETARIO.aumentarCapital(PRECIO_ALQUILER);
	}
	
}
