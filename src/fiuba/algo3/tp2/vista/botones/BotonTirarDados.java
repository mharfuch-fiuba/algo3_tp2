package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.eventos.BotonTirarDadosHandler;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;

public class BotonTirarDados extends BotonAlgoPoly {
	
	public BotonTirarDados(ContenedorTurno contenedorPadre){
		this.setText("Tirar Dados");
		this.setOnAction(new BotonTirarDadosHandler(contenedorPadre));
	}

}
