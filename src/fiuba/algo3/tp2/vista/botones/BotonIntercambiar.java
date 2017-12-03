package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonIntercambiarHandler;

public class BotonIntercambiar extends BotonAlgoPoly {
	
	public BotonIntercambiar(){
		this.setText("Intercambiar");
		this.setOnAction(new BotonIntercambiarHandler());
	}

}
