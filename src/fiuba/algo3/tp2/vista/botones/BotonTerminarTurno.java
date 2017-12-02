package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonTerminarTurno extends BotonAlgoPoly {
	
	public BotonTerminarTurno(ContenedorTurno contenedorPadre){
		this.setText("Terminar Turno");
		this.setOnAction(new BotonTerminarTurnoHandler(contenedorPadre));
	}
	
	private class BotonTerminarTurnoHandler implements EventHandler<ActionEvent>{
		
		ContenedorTurno contenedorPadre;
		
		
		public BotonTerminarTurnoHandler(ContenedorTurno contenedorPadre) {
			this.contenedorPadre=contenedorPadre;
		}

		@Override
		public void handle(ActionEvent event) {
			this.contenedorPadre.terminarTurno();
			this.contenedorPadre.cambiarVistaDinamica(this.contenedorPadre.getVistaInicial());		
		}
		
	}

}
