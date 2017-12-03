package fiuba.algo3.tp2.vista.partida;

import fiuba.algo3.tp2.controlador.ControladorPartida;
import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import javafx.scene.layout.VBox;

public class ContenedorDinamico extends VBox{
	
	ControladorPrincipal controladorPartida;
	
	public ContenedorDinamico(ControladorPrincipal controladorPartida){
		this.controladorPartida=controladorPartida;
		ContenedorRonda contenedorRonda =new ContenedorRonda(controladorPartida.getControladorRonda());
		ContenedorTurno contenedorTurno = new ContenedorTurno(controladorPartida.getControladorRonda(),controladorPartida.getControladorTablero());
		this.getChildren().addAll(contenedorRonda,contenedorTurno);
	}

}
