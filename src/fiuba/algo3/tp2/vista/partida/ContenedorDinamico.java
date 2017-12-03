package fiuba.algo3.tp2.vista.partida;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import javafx.scene.layout.VBox;

public class ContenedorDinamico extends VBox{
	
	ControladorPrincipal controladorPartida;
	
	public ContenedorDinamico(ContenedorRonda contenedorRonda, ContenedorTurno contenedorTurno){
		this.getChildren().addAll(contenedorRonda,contenedorTurno);
	}

}
