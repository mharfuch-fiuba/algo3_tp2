package fiuba.algo3.tp2.vista.botones.eventos;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonConstruirHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		//VistaTurnoConstruir vistaDados=new VistaTurnoConstruir(this.contenedorPadre);
		//this.contenedorPadre.cambiarVistaDinamica(vistaDados);
		ControladorPrincipal.getInstance().construir(null);
	}
	
}
