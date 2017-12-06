package fiuba.algo3.tp2.vista.botones.eventos;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaConstruir;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonConstruirHandler implements EventHandler<ActionEvent> {
	
	@Override
	public void handle(ActionEvent event) {
		ControladorPrincipal.getInstance().cambiarVistaAccion(new VistaConstruir());
	}
	
}
