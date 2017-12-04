package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonRetrocesoDinamico;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaRetroceso extends VistaAccion {

	public VistaRetroceso(int cant_casilleros) {
		
		LabelTurnoDinamica label = new LabelTurnoDinamica("Caiste en Retroceso Dinamico. Retrocederas " + cant_casilleros + " casilleros");
		BotonRetrocesoDinamico boton = new BotonRetrocesoDinamico(null);
		this.getChildren().addAll(label,boton);
	}
}
