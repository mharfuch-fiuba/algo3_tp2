package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonPoliciaHandler;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;

public class BotonPolicia extends BotonAlgoPoly {
	public BotonPolicia(ContenedorTurno contenedorPadre){
		this.setText("Ir a carcel");
		this.setOnAction(new BotonPoliciaHandler(contenedorPadre));
	}
}
