package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonComprar;
import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaComprar extends VistaEfecto{

	public VistaComprar(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("Esta propiedad cuesta ");
		BotonComprar botonComprar = new BotonComprar(null);
		BotonTerminarTurno botonTerminarTurno = new BotonTerminarTurno(null);
		this.getChildren().addAll(label,botonComprar,botonTerminarTurno);
	}
}
