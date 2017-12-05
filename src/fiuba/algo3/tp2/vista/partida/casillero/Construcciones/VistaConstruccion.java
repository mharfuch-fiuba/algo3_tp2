package fiuba.algo3.tp2.vista.partida.casillero.Construcciones;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VistaConstruccion extends Pane {

	public VistaConstruccion(String nombreImagen){
		System.out.println("Creo la construccion: "+nombreImagen);
		Image imagen = new Image(nombreImagen);
		ImageView vistaImagen = new ImageView(imagen);
		this.setWidth(128);
		this.setHeight(42);
		this.getChildren().add(vistaImagen);
	}
	
}
