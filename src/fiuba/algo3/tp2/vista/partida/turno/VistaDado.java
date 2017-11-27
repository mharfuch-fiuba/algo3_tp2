package fiuba.algo3.tp2.vista.partida.turno;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaDado extends ImageView {

	public VistaDado(){
		
		Image logo = new Image("file:assets/dados.png");
		this.setImage(logo);
		this.setFitHeight(50);
		this.setFitWidth(50);
	}
	

	
}
