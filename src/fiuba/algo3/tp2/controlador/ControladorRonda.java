package fiuba.algo3.tp2.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.Ronda;
import fiuba.algo3.tp2.modelo.Ronda;
import fiuba.algo3.tp2.modelo.excepciones.NoHayJugadoresException;
import fiuba.algo3.tp2.vista.partida.ContenedorRonda;
import fiuba.algo3.tp2.vista.partida.turno.LabelTituloTurno;

public class ControladorRonda implements Observer {

	private Ronda modelo_ronda;
	private LabelTituloTurno tituloTurno;
	//private ControladorCubilete cubilete;
	private HashMap<Jugador, ControladorJugador> jugadores;
	private ContenedorRonda vistaRonda;
	

	public ControladorRonda() {
		this.jugadores = new HashMap<Jugador, ControladorJugador>();
		this.modelo_ronda = new Ronda();
		this.modelo_ronda.addObserver(this);
		this.vistaRonda=new ContenedorRonda();
		//this.cubilete= new ControladorCubilete(ronda.getCubilete());
	}
	
	
	public ContenedorRonda getVistaRonda(){
		return this.vistaRonda;
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			//this.tituloTurno.cambiarTexto(this.modelo_ronda.obtenerJugadorActual().getNombre());
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
		return new ArrayList<ControladorJugador>(jugadores.values());
	}
	
	public void agregarJugador(ControladorJugador controlador_jugador) {
		Jugador jugador = controlador_jugador.getModelo();
		modelo_ronda.agregarJugador(jugador);
		jugadores.put(jugador, controlador_jugador);
		this.vistaRonda.ponerJugador(controlador_jugador.getVista());
	}
	public ControladorJugador obtenerJugadorActual() {
		return jugadores.get(modelo_ronda.obtenerJugadorActual());
	}
	public ArrayList<Jugador> obtenerJugadores() {
		return modelo_ronda.obtenerJugadores();
	}
	public void quitarJugador(ControladorJugador jugador_actual) {
		modelo_ronda.quitarJugador(jugador_actual.getModelo());
		jugadores.remove(jugador_actual);
	}
	public int contarJugadores() {
		return modelo_ronda.contarJugadores();
	}
	public void avanzarTurno() {
		modelo_ronda.avanzarTurno();
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

}
