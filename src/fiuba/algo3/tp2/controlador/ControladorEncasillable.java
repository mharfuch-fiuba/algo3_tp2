package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.vista.partida.casillero.ContenedorCasillero;

public class ControladorEncasillable {
	
	private Encasillable modelo;
	private ContenedorCasillero vista;

	public ControladorEncasillable(Encasillable encasillable){
		this.modelo = encasillable;
	}
	
	// mostrar en sector superior
	public  String getNombre(){
		return this.modelo.getNombre();
	}

	// mostrar en sector medio
	public String getEstado(){
		return this.modelo.toString()+": ESTADO";
	}

	// mostrar en sector inferior
	public  Jugador[] getJugadores(){
		return null;
	}

	public void asociarVista(ContenedorCasillero c) {
		this.vista=c;
	}

}
