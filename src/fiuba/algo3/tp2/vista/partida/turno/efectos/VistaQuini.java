package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaQuini extends VistaAccion{

	public VistaQuini(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("Caiste en el Quini6. Ganaste X");
		BotonTerminarTurno boton = new BotonTerminarTurno(null);
		this.getChildren().addAll(label);
	}
}
