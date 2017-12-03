package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorJugador;
import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.vista.botones.BotonAlgoPoly;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaTurnoConstruir extends VBox{

	public VistaTurnoConstruir(ControladorJugador jugador) {
		this.getStyleClass().add("VistaTurnoDinamica");
		LabelTurnoDinamica mensaje = new LabelTurnoDinamica("Elija donde desea construir");
		ComboPropiedades comboPropiedades = new ComboPropiedades(jugador);
		//Botonera botones = new Botonera(contenedorPadre);
		ConstruccionPermitida construccionPermitida = new ConstruccionPermitida();
		//this.getChildren().addAll(mensaje,comboPropiedades,construccionPermitida,botones);
		}
	
	private class ComboPropiedades extends ComboBox<String>{	
		public ComboPropiedades(ControladorJugador jugador){
			//ObservableList<String> propiedades = jugador.getConstruibles();
			//this.setItems(propiedades);
		}
	}
	
	private class Botonera extends HBox{
		
		public Botonera(VistaAcciones contenedorPadre){
			this.getChildren().add(new BotonAlgoPoly("Construir"));
			//this.getChildren().add(contenedorPadre.getBotonVolver());
			this.setSpacing(20);
		}
		
	}
		
	private class ConstruccionPermitida extends HBox{
		
		public ConstruccionPermitida(){
			this.getChildren().add(new Label("Casa"));
			this.getChildren().add(new Label("$2000"));
			this.setSpacing(20);
		}
		
	}
	
	
}
