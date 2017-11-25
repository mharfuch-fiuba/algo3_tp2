package fiuba.algo3.tp2.vista.partida;

import fiuba.algo3.tp2.controlador.ControladorPartida;
import javafx.scene.layout.VBox;

public class ContenedorDinamico extends VBox{
	
	ControladorPartida controladorPartida;
	
	public ContenedorDinamico(ControladorPartida controladorPartida){
		this.controladorPartida=controladorPartida;
		
		ContenedorRonda contenedorRonda =new ContenedorRonda(controladorPartida.getControladorRonda());
		System.out.println("AA");
		System.out.println("AA1");
		ContenedorTurno contenedorTurno = new ContenedorTurno();
		System.out.println("AA2");
		this.getChildren().addAll(contenedorRonda,contenedorTurno);
	}

}
