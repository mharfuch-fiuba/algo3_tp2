package fiuba.algo3.tp2.vista.botones;

import javafx.scene.control.Button;

public class BotonTurnoInicial extends Button{

	public BotonTurnoInicial(String texto){
		this.getStyleClass().add("BotonTurnoInicial");
		this.setText(texto);
	}

}
