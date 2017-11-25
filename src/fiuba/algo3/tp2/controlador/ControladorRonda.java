package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.Ronda;
import fiuba.algo3.tp2.vista.partida.ContenedorRonda;
import fiuba.algo3.tp2.vista.partida.VistaJugador;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ControladorRonda {
	
	private Ronda ronda;
	
	
	public ControladorRonda(Ronda ronda){
		this.ronda=ronda;
	}
	
	 public void agregarJugadores(ContenedorRonda contenedorRonda){
			for(Jugador j:this.ronda){
				System.out.println("controRonda1");
				ControladorJugador controladorJugador = new ControladorJugador(j);
				System.out.println("controRonda2");
				VistaJugador vista=new VistaJugador(controladorJugador);
				HBox.setHgrow(vista,Priority.ALWAYS);
				contenedorRonda.getChildren().add(vista);
			}

	 }

}
