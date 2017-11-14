package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;

public class Policia implements Encasillable {

	private Carcel carcel;
	
	public Policia(Carcel casillero_carcel) {
		this.carcel = casillero_carcel;
	}

	@Override
	public void ejecutarEfecto(Jugador jugador, Cubilete dados) {
		jugador.avanzarHasta(carcel);
		jugador.interactuarConCasilleroActual(dados);
	}

}
