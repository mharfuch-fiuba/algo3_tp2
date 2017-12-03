package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.eventos.BotonVenderHandler;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;

public class BotonVender extends BotonAlgoPoly {
	
	public BotonVender(ContenedorTurno contenedorPadre){
		this.setText("Vender");
		this.setOnAction(new BotonVenderHandler(contenedorPadre));
	}

}
