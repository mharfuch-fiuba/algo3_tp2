package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.vista.partida.casillero.ContenedorCasillero;
import fiuba.algo3.tp2.vista.partida.casillero.VistaCasilleroJugador;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaEfecto;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPropiedadPropia;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPropiedadVacia;
import javafx.scene.paint.Color;

public class ControladorEncasillable {

	private Encasillable modelo;
	private ContenedorCasillero vistaCasillero;
	private VistaEfecto vistaEfecto;

	public ControladorEncasillable(Encasillable encasillable, VistaEfecto vistaEfecto) {
		this.modelo = encasillable;
		this.vistaEfecto = vistaEfecto;

	}

	// mostrar en sector superior
	public String getNombre() {
		return this.modelo.getNombre();
	}

	public void asociarVistaCasillero(ContenedorCasillero c) {
		this.vistaCasillero = c;
	}

	public void sacarJugador(ControladorJugador jugador) {
		VistaCasilleroJugador vista = jugador.getVistaCasilleroJugador();
		vistaCasillero.getJugadores().sacarJugador(vista);
	}

	private void actualizarVistaEfecto(ControladorJugador jugador) {
		/*
		 * Propiedad propiedad = (Propiedad) this.modelo; VistaPropiedad
		 * vistaPropiedad = (VistaPropiedad) this.vistaEfecto;
		 * if(propiedad.getPropietario().getControlador().equals(jugador))
		 * return; //es dueno, ver que hago. rompe
		 */
	}

	public void ponerJugador(ControladorJugador jugador) {
		VistaCasilleroJugador vista = jugador.getVistaCasilleroJugador();
		vistaCasillero.getJugadores().ponerJugador(vista);
		if (this.modelo.esPropiedad())
			actualizarVistaEfecto(jugador);
	}

	public Encasillable getEncasillable() {
		return this.modelo;
	}

	public VistaEfecto getVistaEfecto(ControladorJugador jugador, ContenedorTurno contenedorPadre) {
		if(this.modelo.esPropiedad()) {
			if(this.modelo.equals(jugador))
				return new VistaPropiedadPropia(contenedorPadre);
			//FALTA SI ES PROPIEDAD DE OTRO
			return new VistaPropiedadVacia(contenedorPadre);
		}
		return this.vistaEfecto;
	}

	public Color getColor() {
		if (!this.modelo.esPropiedad())
			return Color.ORANGE;
		Propiedad propiedad = (Propiedad) this.modelo;
		Color color = propiedad.getPropietario().getColor();
		return color;
	}

}
