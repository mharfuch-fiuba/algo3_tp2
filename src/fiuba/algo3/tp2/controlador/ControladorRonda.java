package fiuba.algo3.tp2.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.Ronda;
import fiuba.algo3.tp2.modelo.excepciones.NoHayJugadoresException;
import fiuba.algo3.tp2.vista.partida.ContenedorRonda;

public class ControladorRonda implements Observer {

	private Ronda modelo_ronda;
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
			//this.tituloTurno.(this.modelo_ronda.obtenerJugadorActual().getNombre());
		} catch (NoHayJugadoresException e) {
			e.printStackTrace();
		}
	}	
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


}
