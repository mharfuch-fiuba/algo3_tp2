package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonIntercambiarHandler;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;

public class BotonIntercambiar extends BotonAlgoPoly {
	
	public BotonIntercambiar(VistaAcciones contenedorPadre){
		this.setText("Intercambiar");
		this.setOnAction(new BotonIntercambiarHandler(contenedorPadre));
	}

}
