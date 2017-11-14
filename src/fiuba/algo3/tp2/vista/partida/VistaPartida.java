package fiuba.algo3.tp2.vista.partida;

import fiuba.algo3.tp2.controlador.ControladorPartida;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaPartida extends VBox {
	
	private ControladorPartida controladorPartida;

	public VistaPartida(Stage stage, ControladorPartida controladorPartida) {
		VistaTablero vistaTablero = new VistaTablero();
		ContenedorPartidaInferior contenedorPartidaInferior= new ContenedorPartidaInferior();
		this.controladorPartida = controladorPartida;
		this.getChildren().addAll(vistaTablero,contenedorPartidaInferior);
		this.getStyleClass().add("VistaPartida");	
	}	

}
