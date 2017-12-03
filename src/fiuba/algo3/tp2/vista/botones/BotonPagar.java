package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.eventos.BotonPagarHandler;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;

public class BotonPagar extends BotonAlgoPoly{
	
	public BotonPagar(ContenedorTurno contenedorPadre){
		this.setText("Pagar");
		this.setOnAction(new BotonPagarHandler(contenedorPadre));
	}
	
}
