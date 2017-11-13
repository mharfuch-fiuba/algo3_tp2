package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class CasilleroAlgoPoly extends Casillero {
	ArrayList<Jugador> jugadores;
	Encasillable encasillable;

	public CasilleroAlgoPoly(Encasillable encasillable) {
		this.encasillable = encasillable;
		this.jugadores=new ArrayList<Jugador>();
	}

}


