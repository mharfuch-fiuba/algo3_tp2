package fiuba.algo3.tp2.vista.botones.eventos;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaVenderPropiedad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonVenderHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		ControladorPrincipal.getInstance().cambiarVistaAccion(new VistaVenderPropiedad());
	}

}
