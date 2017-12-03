package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonRetrocesoDinamicoHandler;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;

public class BotonRetrocesoDinamico extends BotonAlgoPoly{
	public BotonRetrocesoDinamico(VistaAcciones contenedorPadre){
		this.setText("Retroceder");
		this.setOnAction(new BotonRetrocesoDinamicoHandler(contenedorPadre));
	}
	
	
}
