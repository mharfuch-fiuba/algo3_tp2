package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonComprar;
import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaComprar extends VistaEfecto{

	public VistaComprar(ContenedorTurno contenedorPadre){
		LabelTurnoDinamica label = new LabelTurnoDinamica("Esta propiedad cuesta ");
		BotonComprar botonComprar = new BotonComprar(contenedorPadre);
		BotonTerminarTurno botonTerminarTurno = new BotonTerminarTurno(contenedorPadre);
		this.getChildren().addAll(label,botonComprar,botonTerminarTurno);
	}
	
}
