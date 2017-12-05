package fiuba.algo3.tp2.controlador;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorHumano;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.modelo.tablero.Tablero;
import fiuba.algo3.tp2.vista.partida.casillero.VistaCasilleroJugador;
import javafx.scene.paint.Color;

public class ControladorJugador implements Observer {

	private Jugador modelo;
	//private VistaJugador vista;
	private VistaCasilleroJugador vistaCasillero;

	public ControladorJugador(Tablero tablero, String nombre, Dinero dinero_inicial, Color color) {
		modelo = new JugadorHumano(tablero, dinero_inicial);
		modelo.setNombre(nombre);
		modelo.setColor(color);
		vistaCasillero = new VistaCasilleroJugador(color);
	}

	/*
	public ControladorJugador(Jugador jugador) {
		this.modelo = jugador;
		this.vistaCasillero = new VistaCasilleroJugador(jugador.getColor());
	}

	public String getNombre() {
		return this.modelo.getNombre();
	}

	public Color getColor() {
		return this.modelo.getColor();
	}

	public String getDinero() {
		return "$" + String.valueOf(this.modelo.obtenerDinero().obtenerMontoEntero());
	}
*/
	@Override
	public void update(Observable o, Object arg) {
		//this.vista.actualizarDinero(jugador.obtenerDinero());
	}
/*
	public void asociarVista(VistaJugador vista) {
		this.vista = vista;
	}

	public ObservableList<String> getConstruibles() {
		// tengo que ver en jugador como hacerlo
		ObservableList<String> fruits = FXCollections.observableArrayList(jugador.getListaComprables());
		return fruits;
	}

	public Encasillable getCasillero() {
		return this.jugador.obtenerCasilleroActual();
	}

	public void avanzar(ControladorTablero tablero) {
		Cubilete cubilete = Cubilete.getInstance();
		// cubilete.lanzar();
		System.out.println("Jugador lanza: " + cubilete.sumarValores());
		// this.jugador.avanzar(cubilete.sumarValores());
		// ESTO ES PARA QUE NO SE TELETRANSPORTE

		for (int i = 0; i < cubilete.sumarValores(); i++) {
        
			System.out.println("Jugador avanza");
			ControladorEncasillable viejoCasillero = tablero.getEncasillableActual(this);
			viejoCasillero.sacarJugador(this);
			this.jugador.avanzar(1);
			ControladorEncasillable nuevoCasillero = tablero.getEncasillableActual(this);
			nuevoCasillero.ponerJugador(this);
		}

		System.out.println("Jugador cae en " + jugador.obtenerCasilleroActual().getNombre());

		try {
			ControladorEncasillable viejoCasillero = tablero.getEncasillableActual(this);
			viejoCasillero.sacarJugador(this);
			this.jugador.aplicarEfectoDeCasilleroActual(cubilete);
			ControladorEncasillable nuevoCasillero = tablero.getEncasillableActual(this);
			nuevoCasillero.ponerJugador(this);
			
			
			
		} catch (DineroInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
	public VistaCasilleroJugador getVista() {
		return this.vistaCasillero;
	}
	
	public Jugador getModelo() {
		return this.modelo;
	}
/*
	public boolean estaEncarcelado() {
		return this.jugador.estaEncarcelado();
	}

	public Encasillable obtenerModeloCasilleroActual() {
		return jugador.obtenerCasilleroActual();
	}
*/

	public String getNombre() {
		return this.modelo.getNombre();
	}

	public Color getColor() {
		return this.modelo.getColor();
	}

	public void avanzar(int i) {
		this.modelo.avanzar(i);
	}

	public void aplicarEfectoDeCasilleroActual(Cubilete cubilete) {
		this.modelo.aplicarEfectoDeCasilleroActual(cubilete);
	}

	public Encasillable obtenerCasilleroActual() {
		return this.modelo.obtenerCasilleroActual();
	}

	public void comprar(Propiedad propiedad) {
		this.modelo.comprar(propiedad);
	}

	public void pagarFianza() {
		this.modelo.pagarFianza();
	}

	public int getCantidadPropiedades() {
		return this.modelo.getCantidadDePropiedades();
	}

	public int getCantidadEfectivo() {
		return this.modelo.obtenerDinero().obtenerMontoEntero();
	}

	public boolean estaEnCarcel() {
		return this.modelo.estaEncarcelado();
	}

	public void retroceder(int cant_casilleros) {
		this.modelo.retroceder(cant_casilleros);
	}

	public Dinero getDinero() {
		return this.modelo.obtenerDinero();
	}
	
	public ArrayList<Propiedad> getPropiedades() {
		return this.modelo.getPropiedades();
	}

	public ArrayList<Terreno> getTerrenos() {
		ArrayList<Terreno> terrenos = new ArrayList<Terreno>();
		for(Propiedad propiedad:this.getPropiedades()) {
			if(propiedad instanceof Terreno) {
				terrenos.add((Terreno) propiedad);
			}
		}
		return terrenos;
	}

}
