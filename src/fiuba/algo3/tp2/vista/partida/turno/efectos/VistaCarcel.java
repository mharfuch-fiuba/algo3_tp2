package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaCarcel extends VistaEfecto{

	public VistaCarcel(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("CAISTE EN LA CARCEL");
		this.getChildren().addAll(label);
	}
	
}
