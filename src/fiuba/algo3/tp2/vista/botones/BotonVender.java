package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonVenderHandler;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;

public class BotonVender extends BotonAlgoPoly {
	
	public BotonVender(VistaAcciones contenedorPadre){
		this.setText("Vender");
		this.setOnAction(new BotonVenderHandler(contenedorPadre));
	}

}
