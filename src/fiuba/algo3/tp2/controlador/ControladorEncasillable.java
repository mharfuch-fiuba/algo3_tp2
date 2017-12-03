package fiuba.algo3.tp2.controlador;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.vista.partida.casillero.ContenedorCasillero;
import fiuba.algo3.tp2.vista.partida.casillero.VistaCasilleroJugador;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaEfecto;
import javafx.scene.paint.Color;

public class ControladorEncasillable implements Observer {

	private Encasillable modelo;
	private ContenedorCasillero vistaCasillero;
	private VistaEfecto vista;

	public ControladorEncasillable(Encasillable encasillable, VistaEfecto vistaEfecto) {
		//refactor vistaefecto vistaencasillable
		this.modelo = encasillable;
		this.vista = vistaEfecto;
		vista.setDescrpcion(modelo.getNombre());
	}
/*
	// mostrar en sector superior
	public String getNombre() {
		return this.modelo.getNombre();
	}
	*/
	
/*
	public void asociarVistaCasillero(ContenedorCasillero c) {
		this.vistaCasillero = c;
	}
*/
	public void sacarJugador(ControladorJugador controlador_jugador) {
		VistaCasilleroJugador vista = controlador_jugador.getVista();
		vistaCasillero.getJugadores().sacarJugador(vista);
	}

//	private void actualizarVistaEfecto(ControladorJugador jugador) {
		/*
		 * Propiedad propiedad = (Propiedad) this.modelo; VistaPropiedad
		 * vistaPropiedad = (VistaPropiedad) this.vistaEfecto;
		 * if(propiedad.getPropietario().getControlador().equals(jugador))
		 * return; //es dueno, ver que hago. rompe
		 */
//	}

	public void ponerJugador(ControladorJugador jugador) {
		VistaCasilleroJugador puntito = jugador.getVista();
		vistaCasillero.getJugadores().ponerJugador(puntito);
		//if (this.modelo.esPropiedad())
		//	actualizarVistaEfecto(jugador);
	}
/*
	public Encasillable getEncasillable() {
		return this.modelo;
	}

	public VistaEfecto getVistaEfecto() {
		return this.vista;
	}

	public Color getColor() {
		if (!this.modelo.esPropiedad())
			return Color.ORANGE;
		Propiedad propiedad = (Propiedad) this.modelo;
		Color color = propiedad.getPropietario().getColor();
		return color;
	}


*/

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
