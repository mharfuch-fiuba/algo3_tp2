package fiuba.algo3.tp2.controlador;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.cubilete.DadoCargado;
import fiuba.algo3.tp2.modelo.cubilete.Lanzable;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.controlador.ControladorEncasillable;
import fiuba.algo3.tp2.vista.partida.VistaJugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class ControladorJugador implements Observer {

	private Jugador jugador;
	private VistaJugador vista;

	public ControladorJugador(Jugador jugador) {
		this.jugador = jugador;
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
		Cubilete cubilete = new Cubilete();
		Random r = new Random();
		Lanzable dado1 = new DadoCargado(r.nextInt(6)+1);
		Lanzable dado2 = new DadoCargado(r.nextInt(6)+1);
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		this.jugador.avanzar(cubilete.sumarValores());
		try {
			this.jugador.aplicarEfectoDeCasilleroActual(cubilete);
		} catch (DineroInsuficienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
