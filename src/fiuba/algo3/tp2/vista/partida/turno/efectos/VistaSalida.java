package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaSalida extends VistaEfecto{

	public VistaSalida(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("Caiste en Salida. Descansa que no pasa nada.");
		BotonTerminarTurno boton = new BotonTerminarTurno(null);
		this.getChildren().addAll(label);
	}
	
	public VistaSalida(ContenedorTurno controladorPadre){
		LabelTurnoDinamica label = new LabelTurnoDinamica("Caiste en Salida. Descansa que no pasa nada.");
		BotonTerminarTurno boton = new BotonTerminarTurno(controladorPadre);
		this.getChildren().addAll(label,boton);
	}
}
