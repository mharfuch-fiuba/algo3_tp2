package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.controlador.ControladorEncasillable;
import fiuba.algo3.tp2.controlador.ControladorJugador;
import fiuba.algo3.tp2.controlador.ControladorTablero;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
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
			//PARA MI TODO ESTO TENDRIA QUE DELEGARSE EN OTRO METODO DE OTRA CLASE MAS OBVIA
			ControladorTablero tablero = contenedorPadre.getControladorTablero();
			ControladorJugador jugador = contenedorPadre.getControladorRonda().getJugadorActual();
			//ControladorEncasillable viejoCasillero = tablero.getEncasillableActual(jugador);
			//viejoCasillero.sacarJugador(jugador);
			jugador.avanzar(tablero); // <-- FALTA HACER TRY CATCH PARA QUE NO SALTE LA EXCEPCION DE MOVER
			//ControladorEncasillable nuevoCasillero = tablero.getEncasillableActual(jugador);
			//nuevoCasillero.ponerJugador(jugador);
			ControladorEncasillable nuevoCasillero = tablero.getEncasillableActual(jugador);
			VistaEfecto vistaEfecto = nuevoCasillero.getVistaEfecto(jugador,this.contenedorPadre);
			this.contenedorPadre.cambiarVistaDinamica(vistaEfecto);		
		}
		
	}

}
