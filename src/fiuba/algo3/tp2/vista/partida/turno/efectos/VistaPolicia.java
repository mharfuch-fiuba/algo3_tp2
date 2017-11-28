package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaPolicia extends VistaEfecto{

	public VistaPolicia(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("CAISTE EN LA POLICIA. A LA CARCEL!");
		this.getChildren().addAll(label);
	}
}
