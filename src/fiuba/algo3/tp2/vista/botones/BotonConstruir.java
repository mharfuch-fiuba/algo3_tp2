package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonConstruirHandler;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
public class BotonConstruir extends BotonAlgoPoly {
	
	public BotonConstruir(ContenedorTurno contenedorPadre){
		this.setText("Construir");
		this.setOnAction(new BotonConstruirHandler(contenedorPadre));
	}

}
