package fiuba.algo3.tp2.vista.partida;

import javafx.scene.layout.VBox;

public class ContenedorTableroLeft extends VBox{
	
	public ContenedorTableroLeft(){
		for(int i=0;i<4;i++){
			ContenedorCasillero c = new ContenedorCasillero();
			this.getChildren().add(c);
		}
	}

}
