package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaPagar extends VistaEfecto{

	public VistaPagar(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("Esta propiedad tiene due�o. Deberas pagarle X");
		BotonPagar botonPagar = new BotonPagar();
		this.getChildren().addAll(label,botonPagar);
	}
}
