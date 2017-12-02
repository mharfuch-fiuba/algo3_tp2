package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaImpuesto extends VistaEfecto{

	public VistaImpuesto(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("CAISTE EN IMPUESTO. PAGARÁS 10% DE TU EFECTIVO");
		BotonTerminarTurno boton = new BotonTerminarTurno(null);
		this.getChildren().addAll(label,boton);
	}
}
