package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.eventos.BotonPagarFianzaHandler;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;

public class BotonPagarFianza extends BotonAlgoPoly{
	public BotonPagarFianza(ContenedorTurno contenedorPadre){
		this.setText("Pagar Fianza");
		this.setOnAction(new BotonPagarFianzaHandler(contenedorPadre));
	}
}
