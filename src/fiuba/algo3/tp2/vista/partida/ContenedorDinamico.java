package fiuba.algo3.tp2.vista.partida;

import fiuba.algo3.tp2.controlador.ControladorPartida;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import javafx.scene.layout.VBox;

public class ContenedorDinamico extends VBox{
	
	ControladorPartida controladorPartida;
	
	public ContenedorDinamico(ControladorPartida controladorPartida){
		this.controladorPartida=controladorPartida;
		ContenedorRonda contenedorRonda =new ContenedorRonda(controladorPartida.getControladorRonda());
		ContenedorTurno contenedorTurno = new ContenedorTurno(controladorPartida.getControladorRonda(),controladorPartida.getControladorTablero());
		this.getChildren().addAll(contenedorRonda,contenedorTurno);
	}

}
