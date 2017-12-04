package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonAvanceDinamicoHandler;

public class BotonAvanceDinamico extends BotonAlgoPoly{
	public BotonAvanceDinamico(){
		this.setText("Avanzar");
		this.setOnAction(new BotonAvanceDinamicoHandler());
	}
}
