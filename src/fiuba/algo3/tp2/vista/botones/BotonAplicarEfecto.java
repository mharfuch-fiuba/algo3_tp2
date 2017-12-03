package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.controlador.ControladorEncasillable;
import fiuba.algo3.tp2.controlador.ControladorJugador;
import fiuba.algo3.tp2.controlador.ControladorTablero;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoEfecto;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaAccion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAplicarEfecto extends BotonAlgoPoly {
	
	public BotonAplicarEfecto(VistaAcciones contenedorPadre){
		this.setText("Continuar");
		this.setOnAction(new BotonContinuarHandler(contenedorPadre));
	}
	
	private class BotonContinuarHandler implements EventHandler<ActionEvent>{
		
		VistaAcciones contenedorPadre;
		
		
		public BotonContinuarHandler(VistaAcciones contenedorPadre) {
			this.contenedorPadre=contenedorPadre;
		}

		@Override
		public void handle(ActionEvent event) {
					
		}
		
	}

}
