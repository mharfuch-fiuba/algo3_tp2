package fiuba.algo3.tp2.controlador;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.tablero.IterTablero;
import fiuba.algo3.tp2.modelo.tablero.Tablero;

public class ControladorTablero {
	
	private Tablero tablero;
	private IterTablero iterador;

	public ControladorTablero(Tablero tablero) {
		this.tablero=tablero;
		this.iterador= tablero.crearIterador();
	}

	public ArrayList<ControladorEncasillable> getControladoresAbajo(){
		ArrayList<ControladorEncasillable> controladores = new ArrayList<ControladorEncasillable>();
		for(int i=0;i<6;i++){
			ControladorEncasillable controlador = new ControladorEncasillable(iterador.verActual());
			iterador.avanzar();
			controladores.add(0,controlador);
		}
		return controladores;
	}
	
	public ArrayList<ControladorEncasillable> getControladoresIzquierda(){
		ArrayList<ControladorEncasillable> controladores = new ArrayList<ControladorEncasillable>();
		for(int i=0;i<4;i++){
			ControladorEncasillable controlador = new ControladorEncasillable(iterador.verActual());
			iterador.avanzar();
			controladores.add(0,controlador);
		}
		return controladores;
	}
	
	public ArrayList<ControladorEncasillable> getControladoresArriba(){
		ArrayList<ControladorEncasillable> controladores = new ArrayList<ControladorEncasillable>();
		for(int i=0;i<6;i++){
			ControladorEncasillable controlador = new ControladorEncasillable(iterador.verActual());
			iterador.avanzar();
			controladores.add(controlador);
		}
		return controladores;
	}
	
	public ArrayList<ControladorEncasillable> getControladoresDerecha(){
		ArrayList<ControladorEncasillable> controladores = new ArrayList<ControladorEncasillable>();
		for(int i=0;i<4;i++){
			ControladorEncasillable controlador = new ControladorEncasillable(iterador.verActual());
			iterador.avanzar();
			controladores.add(controlador);
		}
		return controladores;
	}
	
	
}
