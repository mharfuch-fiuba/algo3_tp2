package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonRetrocesoDinamicoHandler;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;

public class BotonRetrocesoDinamico extends BotonAlgoPoly{
	public BotonRetrocesoDinamico(ContenedorTurno contenedorPadre){
		this.setText("Retroceder");
		this.setOnAction(new BotonRetrocesoDinamicoHandler(contenedorPadre));
	}
	
	
}
