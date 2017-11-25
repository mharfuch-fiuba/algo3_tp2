package fiuba.algo3.tp2.vista.partida;

import fiuba.algo3.tp2.controlador.ControladorPartida;
import fiuba.algo3.tp2.vista.partida.tablero.ContenedorTablero;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ContenedorPartida extends HBox {
	
	public ContenedorPartida(Stage stage, ControladorPartida controladorPartida) {
		this.getStyleClass().add("ContenedorPartida");
		ContenedorDinamico contenedorDinamico=new ContenedorDinamico(controladorPartida);
		System.out.println("A1");
		ContenedorTablero vistaTablero = new ContenedorTablero();
		System.out.println("A2");
		this.getChildren().addAll(contenedorDinamico,vistaTablero);
	}	

}
