package fiuba.algo3.tp2.vista.botones.eventos;

import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoConstruir;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonConstruirHandler implements EventHandler<ActionEvent> {

	VistaAcciones contenedorPadre;
	
	public BotonConstruirHandler(VistaAcciones contenedorPadre) {
		this.contenedorPadre=contenedorPadre;
		}
	
	@Override
	public void handle(ActionEvent event) {
		//VistaTurnoConstruir vistaDados=new VistaTurnoConstruir(this.contenedorPadre);
		//this.contenedorPadre.cambiarVistaDinamica(vistaDados);
	}
	
}
