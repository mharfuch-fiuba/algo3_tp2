package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.eventos.BotonIntercambiarHandler;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;

public class BotonIntercambiar extends BotonAlgoPoly {
	
	public BotonIntercambiar(ContenedorTurno contenedorPadre){
		this.setText("Intercambiar");
		this.setOnAction(new BotonIntercambiarHandler(contenedorPadre));
	}

}
