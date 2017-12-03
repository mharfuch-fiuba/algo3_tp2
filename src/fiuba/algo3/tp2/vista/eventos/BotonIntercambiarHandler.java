package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoIntercambiar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonIntercambiarHandler implements EventHandler<ActionEvent> {

	ContenedorTurno contenedorPadre;
	
	public BotonIntercambiarHandler(ContenedorTurno contenedorPadre) {
		this.contenedorPadre=contenedorPadre;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		VistaTurnoIntercambiar vistaIntercambiar=new VistaTurnoIntercambiar(this.contenedorPadre);
		//this.contenedorPadre.cambiarVistaDinamica(vistaIntercambiar);
	}

}
