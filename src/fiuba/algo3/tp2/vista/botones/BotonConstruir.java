package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonConstruirHandler;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;
public class BotonConstruir extends BotonAlgoPoly {
	
	public BotonConstruir(VistaAcciones contenedorPadre){
		this.setText("Construir");
		this.setOnAction(new BotonConstruirHandler(contenedorPadre));
	}

}
