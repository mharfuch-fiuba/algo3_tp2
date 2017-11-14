package fiuba.algo3.tp2.vista;

import javafx.scene.control.TextField;

public class TextFieldNombreJugador extends TextField {

	public TextFieldNombreJugador(String textoDefault){
		this.setText(textoDefault);
		this.getStyleClass().add("TextFieldNombreJugador");
	}
	
}
