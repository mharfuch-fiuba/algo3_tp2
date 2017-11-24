package fiuba.algo3.tp2.vista.partida;

import javafx.scene.layout.VBox;

public class ContenedorDinamico extends VBox{
	
	public ContenedorDinamico(){
		ContenedorRonda contenedorRonda =new ContenedorRonda();
		ContenedorTurno contenedorTurno = new ContenedorTurno();
		this.getChildren().addAll(contenedorRonda,contenedorTurno);
	}

}
