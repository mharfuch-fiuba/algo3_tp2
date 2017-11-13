package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;

public class Policia implements Encasillable {

	@Override
	public void ejecutarEfecto(Jugador jugador, Cubilete dados) {
		jugador.avanzarHastaCarcel();
		jugador.interactuarConCasilleroActual(dados);
	}

}
