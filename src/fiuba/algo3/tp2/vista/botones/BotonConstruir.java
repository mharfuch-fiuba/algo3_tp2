package fiuba.algo3.tp2.vista.botones;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.vista.botones.eventos.BotonConstruirHandler;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaAccion;

public class BotonConstruir extends BotonAlgoPoly {
	
	public BotonConstruir(){
		this.setText("Construir");
		this.setOnAction(new BotonConstruirHandler());
	}

}
