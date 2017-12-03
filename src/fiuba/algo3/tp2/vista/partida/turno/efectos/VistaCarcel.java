package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonPagarFianza;
import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaCarcel extends VistaEfecto{

	public VistaCarcel(){
		LabelTurnoDinamica label = new LabelTurnoDinamica("ESTAS EN LA CARCEL");
		BotonPagarFianza boton = new BotonPagarFianza(null);
		this.getChildren().addAll(label,boton);
	}
	
	public VistaCarcel(ContenedorTurno contenedorPadre){
		LabelTurnoDinamica label = new LabelTurnoDinamica("ESTAS EN LA CARCEL");
		BotonPagarFianza boton = new BotonPagarFianza(contenedorPadre);
		BotonTerminarTurno botonTerminar = new BotonTerminarTurno(contenedorPadre);
		this.getChildren().addAll(label,boton,botonTerminar);
	}
}
