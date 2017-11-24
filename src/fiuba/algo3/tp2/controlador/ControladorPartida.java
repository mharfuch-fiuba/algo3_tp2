package fiuba.algo3.tp2.controlador;

import java.util.Random;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorHumano;
import fiuba.algo3.tp2.modelo.Partida;
import javafx.scene.paint.Color;

public class ControladorPartida {

	private Partida partida;

	public ControladorPartida() {
		this.partida = new Partida();
	}

	public void agregarJugadores(String[] jugadores) {
		for (String nombre : jugadores) {
			Jugador jugador = new JugadorHumano(this.partida.getTablero(), this.partida.dineroInicial);
			jugador.setNombre(nombre);
			jugador.setColor(colorAleatorio());
			this.partida.getRonda().agregarJugador(jugador);
		}
	}

	private Color colorAleatorio() {
		Random rand = new Random();
		return new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 100);
	}

}
