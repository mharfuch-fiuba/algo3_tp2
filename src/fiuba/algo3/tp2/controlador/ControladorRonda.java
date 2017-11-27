package fiuba.algo3.tp2.controlador;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.Ronda;
import fiuba.algo3.tp2.modelo.excepciones.NoHayJugadoresException;
import fiuba.algo3.tp2.vista.partida.ContenedorRonda;
import fiuba.algo3.tp2.vista.partida.VistaJugador;
import fiuba.algo3.tp2.vista.partida.turno.LabelTituloTurno;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ControladorRonda implements Observer {

	private Ronda ronda;
	private LabelTituloTurno tituloTurno;

	public ControladorRonda(Ronda ronda) {
		this.ronda = ronda;
		this.ronda.addObserver(this);
	}

	public void vincularTitulo(LabelTituloTurno tituloTurno) {
		this.tituloTurno = tituloTurno;
	}

	public void agregarVistasJugadores() {

	}

	public void agregarJugadores(ContenedorRonda contenedorRonda) {

		for (Jugador j : this.ronda) {
			ControladorJugador controladorJugador = new ControladorJugador(j);
			VistaJugador vista = new VistaJugador(controladorJugador);
			HBox.setHgrow(vista, Priority.ALWAYS);
			contenedorRonda.getChildren().add(vista);
		}

	}

	public String getJugadorActual() {
		try {
			return this.ronda.obtenerJugadorActual().getNombre();
		} catch (NoHayJugadoresException e) {
			return "-";
		}
	}

	public void terminarTurno() {
		try {
			this.ronda.avanzarTurno();
		} catch (NoHayJugadoresException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			this.tituloTurno.cambiarTexto(this.ronda.obtenerJugadorActual().getNombre());
		} catch (NoHayJugadoresException e) {
			e.printStackTrace();
		}
	}

}
