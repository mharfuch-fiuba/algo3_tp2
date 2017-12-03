package fiuba.algo3.tp2.vista.partida;

import fiuba.algo3.tp2.controlador.ControladorPartida;
import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.controlador.ControladorTablero;
import fiuba.algo3.tp2.vista.BarraDeMenu;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.vista.partida.tablero.ContenedorTablero;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaPartida extends BorderPane {

	public PantallaPartida(ContenedorPrincipal stage, ControladorPrincipal controladorPartida) {
		this.getStyleClass().add("ContenedorPartida");
		Hijo hijo = new Hijo(controladorPartida);
		//this.setTop(new BarraDeMenu(stage));
		this.setCenter(hijo);
	}
	
	private class Hijo extends HBox{
		
		public Hijo(ControladorPrincipal controladorPartida){
			this.getChildren().addAll(controladorPartida.getContenedorDinamico(), controladorPartida.getVistaTablero());
		}
		
	}
	
	

}
