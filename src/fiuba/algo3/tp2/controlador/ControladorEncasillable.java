package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.vista.partida.casillero.ContenedorCasillero;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaEfecto;

public class ControladorEncasillable {
	
	private Encasillable modelo;
	private ContenedorCasillero vistaCasillero;
	private VistaEfecto vistaEfecto;

	public ControladorEncasillable(Encasillable encasillable,VistaEfecto vistaEfecto){
		this.modelo = encasillable;
		this.vistaEfecto=vistaEfecto;
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
		Jugador[] jugadores={};
		return jugadores;
	}

	public void asociarVistaCasillero(ContenedorCasillero c) {
		this.vistaCasillero=c;
	}

	public void sacarJugador(ControladorJugador jugador){
		
	}
	
	public void ponerJugador(ControladorJugador jugador){
		
	}
	
	public Encasillable getEncasillable(){
		return this.modelo;
	}
	
	public VistaEfecto getVistaEfecto(){
		return this.vistaEfecto;
	}

}
