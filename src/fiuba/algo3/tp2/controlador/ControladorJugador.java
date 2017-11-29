package fiuba.algo3.tp2.controlador;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.vista.partida.VistaJugador;
import fiuba.algo3.tp2.vista.partida.casillero.VistaCasilleroJugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class ControladorJugador implements Observer {

	private Jugador jugador;
	private VistaJugador vista;
	private VistaCasilleroJugador vistaCasillero;

	public ControladorJugador(Jugador jugador) {
		this.jugador = jugador;
		this.vistaCasillero = new VistaCasilleroJugador(jugador.getColor());
	}

	public String getNombre() {
		return this.jugador.getNombre();
	}

	public Color getColor() {
		return this.jugador.getColor();
	}

	public String getDinero() {
		return "$" + String.valueOf(this.jugador.obtenerDinero().obtenerMontoEntero());
	}

	@Override
	public void update(Observable o, Object arg) {
		this.vista.actualizarDinero(this.getDinero());
	}

	public void asociarVista(VistaJugador vista) {
		this.vista = vista;
	}

	public ObservableList<String> getConstruibles() {
		//tengo que ver en jugador como hacerlo
		ObservableList<String> fruits = FXCollections.observableArrayList( 
				 jugador.getListaComprables());
		return fruits;
	}

	public Encasillable getCasillero() {
		return this.jugador.obtenerCasilleroActual();
	}
	
	public void avanzar(){
		Cubilete cubilete = Cubilete.getInstance();
		
		this.jugador.avanzar(cubilete.sumarValores());
		
		try {
			this.jugador.aplicarEfectoDeCasilleroActual(cubilete);
		} catch (DineroInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public VistaCasilleroJugador getVistaCasilleroJugador() {
		return this.vistaCasillero;
	}
	
}
