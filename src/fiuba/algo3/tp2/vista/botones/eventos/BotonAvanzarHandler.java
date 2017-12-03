package fiuba.algo3.tp2.vista.botones.eventos;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAvanzarHandler implements EventHandler<ActionEvent> {
	
	ControladorPrincipal controlador_principal = ControladorPrincipal.getInstance();
	
	public BotonAvanzarHandler() {
		//this.controlador_principal = controlador_principal;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		controlador_principal.avanzar_segun_dados();
	}

}
