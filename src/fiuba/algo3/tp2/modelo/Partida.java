package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.tablero.Tablero;

public class Partida {

	private Ronda ronda;
	private Tablero tablero;
	public final Dinero dineroInicial = new Dinero(100000);

	public Partida() {
		this.ronda = new Ronda();
		this.tablero = new Tablero();
	}

	public Ronda getRonda() {
		return this.ronda;
	}

	public Tablero getTablero() {
		return this.tablero;
	}
	
}
