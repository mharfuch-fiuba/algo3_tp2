package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonPoliciaHandler;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;

public class BotonPolicia extends BotonAlgoPoly {
	public BotonPolicia(VistaAcciones contenedorPadre){
		this.setText("Ir a carcel");
		this.setOnAction(new BotonPoliciaHandler(contenedorPadre));
	}
}
