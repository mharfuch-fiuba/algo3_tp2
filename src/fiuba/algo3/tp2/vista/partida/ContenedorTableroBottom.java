package fiuba.algo3.tp2.vista.partida;

import javafx.scene.layout.HBox;

public class ContenedorTableroBottom extends HBox {

	public ContenedorTableroBottom(){
		for(int i=0;i<6;i++){
			ContenedorCasillero c = new ContenedorCasillero();
			this.getChildren().add(c);
		}
	}
}
