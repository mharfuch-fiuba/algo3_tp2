package fiuba.algo3.tp2.vista;

import java.util.ArrayList;

import javafx.scene.Node;

@SuppressWarnings("serial")
public class TextFieldNombres extends ArrayList<Node> {

	private TextFieldNombreJugador nombreJugador1;
	private TextFieldNombreJugador nombreJugador2;
	private TextFieldNombreJugador nombreJugador3;

	public TextFieldNombres() {
		nombreJugador1 = new TextFieldNombreJugador("Jugador1");
		nombreJugador2 = new TextFieldNombreJugador("Jugador2");
		nombreJugador3 = new TextFieldNombreJugador("Jugador3");
		this.add(nombreJugador1);
		this.add(nombreJugador2);
		this.add(nombreJugador3);
	}

	public String[] getNombres(){
		String[] nombres = {nombreJugador1.getText(),nombreJugador2.getText(),nombreJugador3.getText()};
		return nombres;
	}
	
}
