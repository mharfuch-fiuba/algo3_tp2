package fiuba.algo3.tp2.controlador;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.modelo.tablero.FactoryEncasillables;
import fiuba.algo3.tp2.modelo.tablero.Tablero;
import fiuba.algo3.tp2.vista.partida.turno.efectos.*;

public class ControladorTablero {

	private Tablero tablero;

	private ArrayList<ControladorEncasillable> controladoresAbajo;
	private ArrayList<ControladorEncasillable> controladoresIzquierda;
	private ArrayList<ControladorEncasillable> controladoresArriba;
	private ArrayList<ControladorEncasillable> controladoresDerecha;

	public ControladorTablero(Tablero tablero) {
		this.tablero = tablero;
		this.controladoresAbajo = crearControladoresAbajo();
		this.controladoresIzquierda = crearControladoresIzquierda();
		this.controladoresArriba = crearControladoresArriba();
		this.controladoresDerecha = crearControladoresDerecha();
	}

	public ArrayList<ControladorEncasillable> getControladoresAbajo() {
		return this.controladoresAbajo;
	}

	public ArrayList<ControladorEncasillable> getControladoresIzquierda() {
		return this.controladoresIzquierda;
	}

	public ArrayList<ControladorEncasillable> getControladoresArriba() {
		return this.controladoresArriba;
	}

	public ArrayList<ControladorEncasillable> getControladoresDerecha() {
		return this.controladoresDerecha;
	}

	private ArrayList<ControladorEncasillable> crearControladoresAbajo() {
		ArrayList<ControladorEncasillable> controladores = new ArrayList<ControladorEncasillable>();
		FactoryEncasillables factory = this.tablero.getFactory();

		ControladorEncasillable salida = new ControladorEncasillable(factory.getSalida(), new VistaSalida());
		controladores.add(0, salida);
		

		ControladorEncasillable quini6 = new ControladorEncasillable(factory.getQuini6(), new VistaQuini());
		controladores.add(0, quini6);

		ControladorEncasillable bsAsSur = new ControladorEncasillable(factory.getBuenosAiresSur(),
				new VistaPropiedad());
		controladores.add(0, bsAsSur);

		ControladorEncasillable edesur = new ControladorEncasillable(factory.getEdesur(), new VistaPropiedad());
		controladores.add(0, edesur);

		ControladorEncasillable bsAsNorte = new ControladorEncasillable(factory.getBuenosAiresNorte(),
				new VistaPropiedad());
		controladores.add(0, bsAsNorte);

		ControladorEncasillable carcel = new ControladorEncasillable(factory.getCarcel(), new VistaCarcel());
		controladores.add(0, carcel);

		return controladores;
	}

	private ArrayList<ControladorEncasillable> crearControladoresIzquierda() {
		ArrayList<ControladorEncasillable> controladores = new ArrayList<ControladorEncasillable>();

		FactoryEncasillables factory = this.tablero.getFactory();

		ControladorEncasillable cordobaSur = new ControladorEncasillable(factory.getCordobaSur(), new VistaPropiedad());
		controladores.add(0, cordobaSur);

		ControladorEncasillable avance = new ControladorEncasillable(factory.getAvanceDinamico(), new VistaAvance());
		controladores.add(0, avance);

		ControladorEncasillable subte = new ControladorEncasillable(factory.getSubte(), new VistaPropiedad());
		controladores.add(0, subte);

		ControladorEncasillable cordobaNorte = new ControladorEncasillable(factory.getCordobaNorte(),
				new VistaPropiedad());
		controladores.add(0, cordobaNorte);

		return controladores;
	}

	private ArrayList<ControladorEncasillable> crearControladoresArriba() {
		ArrayList<ControladorEncasillable> controladores = new ArrayList<ControladorEncasillable>();

		FactoryEncasillables factory = this.tablero.getFactory();

		ControladorEncasillable impuesto = new ControladorEncasillable(factory.getImpuestoDeLujo(),
				new VistaImpuesto());
		controladores.add(impuesto);

		ControladorEncasillable santaFe = new ControladorEncasillable(factory.getSantaFe(), new VistaPropiedad());
		controladores.add(santaFe);

		ControladorEncasillable aysa = new ControladorEncasillable(factory.getAysa(), new VistaPropiedad());
		controladores.add(aysa);

		ControladorEncasillable saltaNorte = new ControladorEncasillable(factory.getSaltaNorte(), new VistaPropiedad());
		controladores.add(saltaNorte);

		ControladorEncasillable saltaSur = new ControladorEncasillable(factory.getSaltaSur(), new VistaPropiedad());
		controladores.add(saltaSur);

		ControladorEncasillable policia = new ControladorEncasillable(factory.getPolicia(), new VistaPolicia());
		controladores.add(policia);

		return controladores;
	}

	private ArrayList<ControladorEncasillable> crearControladoresDerecha() {
		ArrayList<ControladorEncasillable> controladores = new ArrayList<ControladorEncasillable>();

		FactoryEncasillables factory = this.tablero.getFactory();

		ControladorEncasillable tren = new ControladorEncasillable(factory.getTren(), new VistaPropiedad());
		controladores.add(tren);

		ControladorEncasillable neuquen = new ControladorEncasillable(factory.getNeuquen(), new VistaPropiedad());
		controladores.add(neuquen);

		ControladorEncasillable retroceso = new ControladorEncasillable(factory.getRestrocesoDinamico(),
				new VistaRetroceso());
		controladores.add(retroceso);

		ControladorEncasillable tucuman = new ControladorEncasillable(factory.getTucuman(), new VistaPropiedad());
		controladores.add(tucuman);

		return controladores;
	}
	
	
	
	public ControladorEncasillable getEncasillableActual(ControladorJugador jugador){
		Encasillable encasillable = jugador.getCasillero();
		for(ControladorEncasillable controlador:controladoresAbajo)if(controlador.getEncasillable().equals(encasillable))return controlador;
		for(ControladorEncasillable controlador:controladoresIzquierda)if(controlador.getEncasillable().equals(encasillable))return controlador;
		for(ControladorEncasillable controlador:controladoresArriba)if(controlador.getEncasillable().equals(encasillable))return controlador;
		for(ControladorEncasillable controlador:controladoresDerecha)if(controlador.getEncasillable().equals(encasillable))return controlador;
		return null; //no lo encontro
		
	}
	
	public void ubicarJugadoresInicial(ControladorRonda ronda){
	ControladorEncasillable salida = this.getEncasillableActual(ronda.getJugadorActual());
	for (ControladorJugador j:ronda.getJugadores()){
		salida.ponerJugador(j);
	}
	}

}
