package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaPagar extends VistaEfecto{

	public VistaPagar(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("ESTA PROPIEDAD TIENE DUEÑO. PAGA.");
		this.getChildren().addAll(label);
	}
}
