package fiuba.algo3.tp2.controlador;

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
			for(int i=0;i<3;i++){
				ControladorJugador controladorJugador = new ControladorJugador();
				VistaJugador j=new VistaJugador(controladorJugador);
				HBox.setHgrow(j,Priority.ALWAYS);
				contenedorRonda.getChildren().add(j);
			}

	 }

}
