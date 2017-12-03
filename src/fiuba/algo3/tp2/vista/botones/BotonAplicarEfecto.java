package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.controlador.ControladorEncasillable;
import fiuba.algo3.tp2.controlador.ControladorJugador;
import fiuba.algo3.tp2.controlador.ControladorTablero;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoEfecto;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaEfecto;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAplicarEfecto extends BotonAlgoPoly {
	
	public BotonAplicarEfecto(ContenedorTurno contenedorPadre){
		this.setText("Continuar");
		this.setOnAction(new BotonContinuarHandler(contenedorPadre));
	}
	
	private class BotonContinuarHandler implements EventHandler<ActionEvent>{
		
		ContenedorTurno contenedorPadre;
		
		
		public BotonContinuarHandler(ContenedorTurno contenedorPadre) {
			this.contenedorPadre=contenedorPadre;
		}

		@Override
		public void handle(ActionEvent event) {
					
		}
		
	}

}
