package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonAvanceDinamico;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaAvance extends VistaEfecto {
	
	public VistaAvance() {
	
		LabelTurnoDinamica label = new LabelTurnoDinamica("Caiste en Avance Dinamico. Avanzaras x casilleros");
		BotonAvanceDinamico boton = new BotonAvanceDinamico();
		this.getChildren().addAll(label,boton);
		
	}
}
