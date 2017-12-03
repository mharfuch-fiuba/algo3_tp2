package fiuba.algo3.tp2.controlador;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.encasillables.Carcel;
import fiuba.algo3.tp2.modelo.encasillables.ImpuestoDeLujo;
import fiuba.algo3.tp2.modelo.encasillables.Policia;
import fiuba.algo3.tp2.modelo.encasillables.Quini6;
import fiuba.algo3.tp2.modelo.encasillables.Salida;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.vista.partida.casillero.ContenedorCasillero;
import fiuba.algo3.tp2.vista.partida.casillero.VistaCasilleroJugador;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaCarcel;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaEfecto;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaImpuesto;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPolicia;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPropiedadAjena;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPropiedadPropia;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPropiedadVacia;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaQuini;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaSalida;
import javafx.scene.paint.Color;

public class ControladorEncasillable implements Observer {

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
		if (this.modelo instanceof Propiedad) {
			if (this.modelo.equals(jugador))
				return new VistaPropiedadPropia(contenedorPadre);
			Propiedad prop = (Propiedad) this.modelo;
			if (prop.getPropietario().esNull())
				return new VistaPropiedadVacia(contenedorPadre);
			return new VistaPropiedadAjena(contenedorPadre);
		}
		if(this.modelo instanceof Carcel){
			return new VistaCarcel(contenedorPadre);
		}
		if(this.modelo instanceof ImpuestoDeLujo){
			return new VistaImpuesto(contenedorPadre);
		}
		if(this.modelo instanceof Salida){
			return new VistaSalida(contenedorPadre);
		}
		if(this.modelo instanceof Quini6){
			return new VistaQuini(contenedorPadre);
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

	@Override
	public void update(Observable arg0, Object arg1) {
		Propiedad prop =(Propiedad) this.modelo;
		this.vistaCasillero.actualizarColor(prop.getPropietario().getColor());

	}

}
