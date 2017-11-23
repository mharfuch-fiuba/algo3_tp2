package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;

public class Carcel implements Encasillable {

	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) {
		jugador.encarcelar();
	}

}
