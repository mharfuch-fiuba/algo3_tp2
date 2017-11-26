package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.vista.botones.BotonContinuar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaTurnoTirarDados extends VBox{
	
	public VistaTurnoTirarDados(){
		
		//ronda.tirarDados() o ronda.getJugadorActual().tirarDados()
		this.getStyleClass().add("VistaTurnoDinamica");
		HijoHorizontal sectorDados = new HijoHorizontal();
		BotonContinuar continuar = new BotonContinuar();
		this.getChildren().addAll(sectorDados,continuar);
	}
	
	private class HijoHorizontal extends HBox{
		public HijoHorizontal(){
			Image logo = new Image("file:assets/dados.png");
			ImageView vistaImagen = new ImageView(logo);
			vistaImagen.setFitHeight(100);
			vistaImagen.setFitWidth(100);
			LabelTurnoDinamica textoSacaste = new LabelTurnoDinamica("Sacaste 6");
			this.getChildren().addAll(vistaImagen,textoSacaste);
		}
	}

}

