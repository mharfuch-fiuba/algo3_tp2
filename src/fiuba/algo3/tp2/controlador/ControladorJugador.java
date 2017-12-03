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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		// tengo que ver en jugador como hacerlo
		ObservableList<String> fruits = FXCollections.observableArrayList(jugador.getListaComprables());
		return fruits;
	}

	public Encasillable getCasillero() {
		return this.jugador.obtenerCasilleroActual();
	}

	public void avanzar(ControladorTablero tablero) {
		if(jugador.estaEncarcelado()){
			return;
		}
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

	public VistaCasilleroJugador getVistaCasilleroJugador() {
		return this.vistaCasillero;
	}

	public boolean estaEncarcelado() {
		return this.jugador.estaEncarcelado();
	}
	
	public void comprarCasilleroActual(){
		this.jugador.comprarCasilleroActual();
	}

	public void pagarFianza() {
		try{
			this.jugador.pagarFianza();
		}catch (Exception e){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Acerca de...");
			alert.setHeaderText("Programa Algopoly");
			String mensaje = "Recien entras a la carcel campeon";
			alert.setContentText(mensaje);
			alert.show();
		}
	}

}
