package fiuba.algo3.tp2.controlador;

import java.util.Stack;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorHumano;
import fiuba.algo3.tp2.modelo.Partida;
import javafx.scene.paint.Color;

public class ControladorPartida {

	private Color color1 = Color.AZURE;
	private Color color2 = Color.BLUEVIOLET;
	private Color color3 = Color.CORNSILK;
	private Stack<Color> colores = new Stack<Color>();
	
	
	private Partida partida;
	private ControladorRonda controladorRonda;
	private ControladorTablero controladorTablero;

	public ControladorPartida() {
	}

	public void nuevaPartida(String[] jugadores){
		colores.add(color1);
		colores.add(color2);
		colores.add(color3);
		this.partida=new Partida();
		this.controladorRonda=new ControladorRonda(this.partida.getRonda());
		agregarJugadores(jugadores);
		this.controladorRonda.agregarVistasJugadores();
		this.controladorTablero=new ControladorTablero(this.partida.getTablero());	
		//this.controladorTablero.ubicarJugadoresInicial(controladorRonda);
	}
	
	private void agregarJugadores(String[] jugadores) {
		for (String nombre : jugadores) {
			Jugador jugador = new JugadorHumano(this.partida.getTablero(), this.partida.dineroInicial);	
			jugador.setNombre(nombre);
			jugador.setColor(colores.pop());
			this.partida.getRonda().agregarJugador(jugador);
			jugador.addObserver(this.controladorRonda);
		}
	}
	
	public ControladorRonda getControladorRonda(){
		return this.controladorRonda;
	}
	
	public ControladorTablero getControladorTablero(){
		return this.controladorTablero;
	}

}
