package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.vista.partida.casillero.ContenedorCasillero;
import fiuba.algo3.tp2.vista.partida.casillero.VistaCasilleroJugador;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaEfecto;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPropiedad;

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
		VistaCasilleroJugador vista = jugador.getVistaCasilleroJugador();
		vistaCasillero.getJugadores().sacarJugador(vista);
	}
	
	private void actualizarVistaEfecto(ControladorJugador jugador){
		Propiedad propiedad = (Propiedad) this.modelo;
		VistaPropiedad vistaPropiedad = (VistaPropiedad) this.vistaEfecto;
		//if(propiedad.getPropietario().getControlador().equals(jugador))return;	//es dueno, ver que hago. rompe		
	}
	
	public void ponerJugador(ControladorJugador jugador){
		VistaCasilleroJugador vista = jugador.getVistaCasilleroJugador();
		vistaCasillero.getJugadores().ponerJugador(vista);
		if(this.modelo.esPropiedad())actualizarVistaEfecto(jugador);
	}
	
	public Encasillable getEncasillable(){
		return this.modelo;
	}
	
	public VistaEfecto getVistaEfecto(){
		return this.vistaEfecto;
	}

}
