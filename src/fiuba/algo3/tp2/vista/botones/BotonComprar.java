package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.eventos.BotonComprarHandler;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;

public class BotonComprar extends BotonAlgoPoly{
	public BotonComprar(ContenedorTurno contenedorPadre){
		this.setText("Comprar");
		this.setOnAction(new BotonComprarHandler(contenedorPadre));
	}
}
