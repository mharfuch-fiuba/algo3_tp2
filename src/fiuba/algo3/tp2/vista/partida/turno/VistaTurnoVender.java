package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorJugador;
import fiuba.algo3.tp2.vista.botones.BotonAlgoPoly;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaEfecto;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaTurnoVender extends VistaEfecto{

	public VistaTurnoVender(ContenedorTurno contenedorPadre) {
		LabelTurnoDinamica mensaje = new LabelTurnoDinamica("Elija qu� desea vender");
		ControladorJugador jugador = contenedorPadre.getControladorRonda().getJugadorActual();
		ComboPropiedades comboPropiedades = new ComboPropiedades(jugador);
		Botonera botones = new Botonera(contenedorPadre);
		ConstruccionPermitida construccionPermitida = new ConstruccionPermitida();
		this.getChildren().addAll(mensaje,comboPropiedades,construccionPermitida,botones);
		}
	
	private class ComboPropiedades extends ComboBox<String>{	
		public ComboPropiedades(ControladorJugador jugador){
			ObservableList<String> propiedades = jugador.getConstruibles();
			this.setItems(propiedades);
		}
	}
	
	private class Botonera extends HBox{
		
		public Botonera(ContenedorTurno contenedorPadre){
			this.getChildren().add(new BotonAlgoPoly("Vender"));
			this.getChildren().add(contenedorPadre.getBotonVolver());
			this.setSpacing(20);
		}
		
	}
	
	private class ConstruccionPermitida extends HBox{
		
		public ConstruccionPermitida(){
			this.getChildren().add(new Label("Precio de Venta"));
			this.getChildren().add(new Label("$2000"));
			this.setSpacing(20);
		}
		
	}
	
	
}
