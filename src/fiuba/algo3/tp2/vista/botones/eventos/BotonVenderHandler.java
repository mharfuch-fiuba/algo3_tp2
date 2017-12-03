package fiuba.algo3.tp2.vista.botones.eventos;

import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoVender;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonVenderHandler implements EventHandler<ActionEvent> {

	VistaAcciones contenedorPadre;
	
	public BotonVenderHandler(VistaAcciones contenedorPadre) {
		this.contenedorPadre=contenedorPadre;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		VistaTurnoVender vistaVender=new VistaTurnoVender(this.contenedorPadre);
		//this.contenedorPadre.cambiarVistaDinamica(vistaVender);
	}

}
