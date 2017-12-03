package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.botones.eventos.BotonTirarDadosHandler;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;

public class BotonTirarDados extends BotonAlgoPoly {
	
	public BotonTirarDados(VistaAcciones contenedorPadre){
		this.setText("Tirar Dados");
		this.setOnAction(new BotonTirarDadosHandler(contenedorPadre));
	}

}
