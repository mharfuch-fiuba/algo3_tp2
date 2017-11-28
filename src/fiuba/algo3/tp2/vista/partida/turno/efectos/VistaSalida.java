package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaSalida extends VistaEfecto{

	public VistaSalida(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("PASASTE POR SALIDA");
		this.getChildren().addAll(label);
	}
	
}
