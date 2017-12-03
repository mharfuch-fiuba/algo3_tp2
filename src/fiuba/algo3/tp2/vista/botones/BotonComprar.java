package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonComprarHandler;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;

public class BotonComprar extends BotonAlgoPoly{
	public BotonComprar(VistaAcciones contenedorPadre){
		this.setText("Comprar");
		this.setOnAction(new BotonComprarHandler(contenedorPadre));
	}
}
