package fiuba.algo3.tp2.vista.partida.casillero;

import javafx.scene.control.Label;

public class VistaCasilleroNombre extends Label{

	public VistaCasilleroNombre(String nombre){
		this.getStyleClass().add("VistaCasilleroNombre");

		this.setText(nombre);
	}
}
