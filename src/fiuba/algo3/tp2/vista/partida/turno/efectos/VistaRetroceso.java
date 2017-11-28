package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaRetroceso extends VistaEfecto {

	public VistaRetroceso() {
		LabelTurnoDinamica label = new LabelTurnoDinamica("VOLVE PARA ATRAS!");
		this.getChildren().addAll(label);
	}
}
