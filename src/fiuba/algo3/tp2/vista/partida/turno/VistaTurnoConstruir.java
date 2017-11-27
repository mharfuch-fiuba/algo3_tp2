package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorJugador;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class VistaTurnoConstruir extends VBox{

	public VistaTurnoConstruir(ContenedorTurno contenedorPadre) {
		this.getStyleClass().add("VistaTurnoDinamica");
		LabelTurnoDinamica mensaje = new LabelTurnoDinamica("Elija dónde desea construir");
		ControladorJugador jugador = contenedorPadre.getControladorRonda().getJugadorActual();
		ComboPropiedades comboPropiedades = new ComboPropiedades(jugador);
		this.getChildren().addAll(mensaje,comboPropiedades);
		}
	
	private class ComboPropiedades extends ComboBox<String>{	
		public ComboPropiedades(ControladorJugador jugador){
			ObservableList<String> propiedades = jugador.getConstruibles();
			this.setItems(propiedades);
		}
	}
	
	
	
}
