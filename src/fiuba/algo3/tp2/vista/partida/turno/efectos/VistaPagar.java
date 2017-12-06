package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonPagar;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaPagar extends VistaAccion{

	public VistaPagar(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("Esta propiedad tiene dueno. Deberas pagarle ");
		BotonPagar botonPagar = new BotonPagar(null);
		this.getChildren().addAll(label,botonPagar);
	}
}
