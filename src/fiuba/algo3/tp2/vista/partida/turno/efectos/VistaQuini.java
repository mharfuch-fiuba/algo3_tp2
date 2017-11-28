package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaQuini extends VistaEfecto{

	public VistaQuini(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("CAISTE EN EL QUINI!");
		this.getChildren().addAll(label);
	}
}
