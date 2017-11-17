package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;

public class Movimiento {

	private IterTablero posicion;
	private int turnosPendientesEnCarcel;

	public Movimiento(Tablero tablero) {
		this.posicion = tablero.crearIterador();
		this.turnosPendientesEnCarcel = 0;
	}

	public void avanzar() {
		this.posicion.avanzar();
	}

	public void retroceder() {
		this.posicion.retroceder();
	}

	public Encasillable verActual() {
		return this.posicion.verActual();
	}

	public void avanzarHasta(Encasillable casillero) {
		this.posicion.avanzarHasta(casillero);
	}

	public void encarcelar() {
		this.turnosPendientesEnCarcel = 3;
	}

	public void disminuirDiasDeCarcel() {
		if (turnosPendientesEnCarcel <= 0)
			return;
		turnosPendientesEnCarcel--;
	}
	
	public int getTurnosPendientesDeCarcel(){
		return this.turnosPendientesEnCarcel;
	}
	
	public void desencarcelar(){
		this.turnosPendientesEnCarcel=0;
	}
	
	public void avanzar(int cantidadCasilleros) throws JugadorEnCarcelException{
		if (this.turnosPendientesEnCarcel > 0) throw new JugadorEnCarcelException();
		for (int i = 0; i < cantidadCasilleros; i++) this.avanzar();
	}

}
