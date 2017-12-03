package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonAvanceDinamicoHandler;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;

public class BotonAvanceDinamico extends BotonAlgoPoly{
	public BotonAvanceDinamico(VistaAcciones contenedorPadre){
		this.setText("Avanzar");
		this.setOnAction(new BotonAvanceDinamicoHandler(contenedorPadre));
	}
}
