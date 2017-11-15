package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.DineroNegativoException;

public abstract class Servicio extends Propiedad {

	protected int PENALIDAD;
	
	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		DineroAlgoPoly monto;
		try {
			monto = new DineroAlgoPoly(PENALIDAD * dados.sumarValores());
			jugador.pagar(monto);
			PROPIETARIO.aumentarCapital(monto);
		} catch (DineroNegativoException e) {
			//ESTO NUNCA PUEDE OCURRIR
		}
	}
	
}
