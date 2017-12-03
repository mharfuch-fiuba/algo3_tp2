package fiuba.algo3.tp2.controlador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.Ronda;
import fiuba.algo3.tp2.modelo.RondaAlgoPoly;
import fiuba.algo3.tp2.modelo.excepciones.NoHayJugadoresException;
import fiuba.algo3.tp2.vista.partida.ContenedorRonda;
import fiuba.algo3.tp2.vista.partida.VistaJugador;
import fiuba.algo3.tp2.vista.partida.turno.LabelTituloTurno;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ControladorRonda implements Observer {

	private Ronda modelo_ronda;
	private LabelTituloTurno tituloTurno;
	//private ControladorCubilete cubilete;
	private ArrayList<ControladorJugador> jugadores;
	

	public ControladorRonda() {
		this.modelo_ronda = new RondaAlgoPoly();
		this.modelo_ronda.addObserver(this);
		//this.cubilete= new ControladorCubilete(ronda.getCubilete());
	}
/*
	public void vincularTitulo(LabelTituloTurno tituloTurno) {
		this.tituloTurno = tituloTurno;
	}

	public void agregarVistasJugadores() {

	}
*/
	/*
	public void agregarJugadores(ContenedorRonda contenedorRonda) {

		for (Jugador j : this.modelo_ronda) {
			ControladorJugador controladorJugador = new ControladorJugador(j);
			j.addObserver(controladorJugador);
			j.setControlador(controladorJugador);
			VistaJugador vista = new VistaJugador(controladorJugador);
			//controladorJugador.asociarVista(vista);
			HBox.setHgrow(vista, Priority.ALWAYS);
			contenedorRonda.getChildren().add(vista);
		}

	}

	public ArrayList<ControladorJugador> getJugadores(){
		ArrayList<ControladorJugador> jugadores = new ArrayList<ControladorJugador>();
		for (Jugador j : this.modelo_ronda){
			jugadores.add(j.getControlador());
		}
		return jugadores;		
	}
	
	public ControladorJugador getJugadorActual(){
		try {
			return modelo_ronda.obtenerJugadorActual().getControlador();
		} catch (NoHayJugadoresException e) {
			e.printStackTrace();
			System.out.println("NO HAY JUGADORES EN RONDA");
			return null;	//provisorio
		}
		
	}
	
	public String getNombreJugadorActual() {
		try {
			return this.modelo_ronda.obtenerJugadorActual().getNombre();
		} catch (NoHayJugadoresException e) {
			return "-";
		}
	}
	


	public void terminarTurno() {
		try {
			this.modelo_ronda.avanzarTurno();
		} catch (NoHayJugadoresException e) {
			e.printStackTrace();
		}
	}
*/
	@Override
	public void update(Observable o, Object arg) {
		try {
			this.tituloTurno.cambiarTexto(this.modelo_ronda.obtenerJugadorActual().getNombre());
		} catch (NoHayJugadoresException e) {
			e.printStackTrace();
		}
	}
	/*
	public void tirarDados(){
		//aca le digo a la ronda que tire los dados
		this.cubilete.lanzar();
	}
	/*
	public ControladorCubilete getDados(){
		
		return this.cubilete;
	}
	*/
	
	public ArrayList<ControladorJugador> getJugadores() {
		return jugadores;
	}
	
	public void agregarJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}
	public Jugador obtenerJugadorActual() {
		return modelo_ronda.obtenerJugadorActual();
	}
	public ArrayList<Jugador> obtenerJugadores() {
		return modelo_ronda.obtenerJugadores();
	}
	public void quitarJugador(Jugador jugador_actual) {
		modelo_ronda.quitarJugador(jugador_actual);
	}
	public int contarJugadores() {
		return modelo_ronda.contarJugadores();
	}
	public void avanzarTurno() {
		modelo_ronda.avanzarTurno();
	}

}
