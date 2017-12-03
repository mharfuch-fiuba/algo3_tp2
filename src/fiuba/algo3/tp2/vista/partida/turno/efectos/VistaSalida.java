package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaSalida extends VistaAccion{

	public VistaSalida(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("Caiste en Salida. Descansa que no pasa nada.");
		BotonTerminarTurno boton = new BotonTerminarTurno(null);
		this.getChildren().addAll(label);
	}
	
}
