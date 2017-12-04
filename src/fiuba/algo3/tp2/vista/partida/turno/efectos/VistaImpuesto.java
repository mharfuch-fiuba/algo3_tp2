package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaImpuesto extends VistaAccion{

	public VistaImpuesto(){
		LabelTurnoDinamica label1 = new LabelTurnoDinamica("CAISTE EN IMPUESTO.");
		LabelTurnoDinamica label2 = new LabelTurnoDinamica("PAGARÁS 10% DE TU EFECTIVO.");
		BotonTerminarTurno boton = new BotonTerminarTurno();
		this.getChildren().addAll(label1,label2,boton);
	}
}
