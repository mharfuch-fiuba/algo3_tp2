package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.Ronda;
import fiuba.algo3.tp2.modelo.excepciones.NoHayJugadoresException;
import fiuba.algo3.tp2.vista.partida.ContenedorRonda;
import fiuba.algo3.tp2.vista.partida.VistaJugador;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ControladorRonda {

	private Ronda ronda;
	

	public ControladorRonda(Ronda ronda) {
		this.ronda = ronda;
	}

	public void agregarVistasJugadores(){
		
	}
	
	public void agregarJugadores(ContenedorRonda contenedorRonda){

		/*
		 * esto es una truchada, hay que arreglar el iterador
		 *  y que se pueda hacer for(Jugador j:this.ronda)
		 */
		try{
		for (int i=0;i<3;i++) {
			Jugador j = this.ronda.obtenerJugadorActual();
			this.ronda.avanzarTurno();
			ControladorJugador controladorJugador = new ControladorJugador(j);
			VistaJugador vista = new VistaJugador(controladorJugador);
			HBox.setHgrow(vista, Priority.ALWAYS);
			contenedorRonda.getChildren().add(vista);		
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
