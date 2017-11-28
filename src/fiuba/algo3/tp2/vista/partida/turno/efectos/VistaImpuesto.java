package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaImpuesto extends VistaEfecto{

	public VistaImpuesto(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("CAISTE EN IMPUESTO. PAGA.");
		this.getChildren().addAll(label);
	}
}
