package fiuba.algo3.tp2.vista.partida;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ContenedorRonda extends HBox{
	
	public ContenedorRonda(){
		this.getStyleClass().add("VistaRonda");
		for(int i=0;i<3;i++){
			ContenedorJugador j=new ContenedorJugador();
			HBox.setHgrow(j,Priority.ALWAYS);
			this.getChildren().add(j);
		}

	}

}
