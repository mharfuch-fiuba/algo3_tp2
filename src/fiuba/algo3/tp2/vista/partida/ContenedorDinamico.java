package fiuba.algo3.tp2.vista.partida;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;
import javafx.scene.layout.VBox;

public class ContenedorDinamico extends VBox{
	
	ControladorPrincipal controladorPartida;
	
	public ContenedorDinamico(ContenedorRonda contenedorRonda, VistaAcciones contenedorTurno){
		this.getChildren().addAll(contenedorRonda,contenedorTurno);
	}

}
