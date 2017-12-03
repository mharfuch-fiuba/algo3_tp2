package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTerminarTurno extends BotonAlgoPoly {
	
	public BotonTerminarTurno(VistaAcciones contenedorPadre){
		this.setText("Terminar Turno");
		this.setOnAction(new BotonTerminarTurnoHandler(contenedorPadre));
	}
	
	private class BotonTerminarTurnoHandler implements EventHandler<ActionEvent>{
		
		VistaAcciones contenedorPadre;
		
		
		public BotonTerminarTurnoHandler(VistaAcciones contenedorPadre) {
			this.contenedorPadre=contenedorPadre;
		}

		@Override
		public void handle(ActionEvent event) {
			//this.contenedorPadre.terminarTurno();
			//this.contenedorPadre.cambiarVistaDinamica(this.contenedorPadre.getVistaInicial());		
		}
		
	}

}
