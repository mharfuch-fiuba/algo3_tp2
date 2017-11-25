package fiuba.algo3.tp2.controlador;

import java.util.Random;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorHumano;
import fiuba.algo3.tp2.modelo.Partida;
import fiuba.algo3.tp2.vista.partida.ContenedorPartida;
import javafx.scene.paint.Color;

public class ControladorPartida {

	private Partida partida;
	private ControladorRonda controladorRonda;
	private ControladorTablero controladorTablero;

	public ControladorPartida() {
	}

	public void nuevaPartida(String[] jugadores){
		this.partida=new Partida();
		agregarJugadores(jugadores);
		this.controladorRonda=new ControladorRonda(this.partida.getRonda());
		this.controladorRonda.agregarVistasJugadores();
		this.controladorTablero=new ControladorTablero(this.partida.getTablero());	
	}
	
	private void agregarJugadores(String[] jugadores) {
		for (String nombre : jugadores) {
			Jugador jugador = new JugadorHumano(this.partida.getTablero(), this.partida.dineroInicial);
			jugador.setNombre(nombre);
			jugador.setColor(colorAleatorio());
			this.partida.getRonda().agregarJugador(jugador);
		}
	}

	private Color colorAleatorio() {
		Random rand = new Random();
		return new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 1.0);
	}
	
	public ControladorRonda getControladorRonda(){
		return this.controladorRonda;
	}
	
	public ControladorTablero getControladorTablero(){
		return this.controladorTablero;
	}

}
