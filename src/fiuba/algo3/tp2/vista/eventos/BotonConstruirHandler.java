package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoConstruir;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonConstruirHandler implements EventHandler<ActionEvent> {

	ContenedorTurno contenedorPadre;
	
	public BotonConstruirHandler(ContenedorTurno contenedorPadre) {
		this.contenedorPadre=contenedorPadre;
		}
	
	@Override
	public void handle(ActionEvent event) {
		VistaTurnoConstruir vistaDados=new VistaTurnoConstruir(this.contenedorPadre);
		//this.contenedorPadre.cambiarVistaDinamica(vistaDados);
	}
	
}
