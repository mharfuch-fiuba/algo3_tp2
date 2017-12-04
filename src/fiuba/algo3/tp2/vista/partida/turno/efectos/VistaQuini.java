package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaQuini extends VistaAccion{

	public VistaQuini(int monto_ganado){
		LabelTurnoDinamica label = new LabelTurnoDinamica("Caiste en el Quini6. Ganaste $" + monto_ganado);
		BotonTerminarTurno boton = new BotonTerminarTurno();
		this.getChildren().addAll(label,boton);
	}
}
