package fiuba.algo3.tp2.vista.partida.turno.efectos;

import java.util.ArrayList;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.vista.botones.BotonCambiarVista;
import fiuba.algo3.tp2.vista.botones.BotonConfirmarVenderPropiedad;
import fiuba.algo3.tp2.vista.botones.BotonProponerIntercambio;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoInicial;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class VistaIntercambiarPropiedad extends VistaAccion {

	public VistaIntercambiarPropiedad() {
		this.getStyleClass().add("VistaTurnoDinamica");
		
		LabelTurnoDinamica mensaje1 = new LabelTurnoDinamica("Elija que desea vender:");
		
		ArrayList<Propiedad> propiedades = ControladorPrincipal.getInstance().getPropiedades();
		ObservableList<Propiedad> opciones1 = FXCollections.observableArrayList(propiedades);
		ComboBox<Propiedad> combo_propiedades = new ComboBox<Propiedad>(opciones1);
		
		LabelTurnoDinamica mensaje2 = new LabelTurnoDinamica("Elija el destinatario:");
		
		ArrayList<Jugador> jugadores = ControladorPrincipal.getInstance().getOtrosJugadores();
		ObservableList<Jugador> opciones2 = FXCollections.observableArrayList(jugadores);
		ComboBox<Jugador> combo_jugadores = new ComboBox<Jugador>(opciones2);
		
		BotonProponerIntercambio boton_confirmar = new BotonProponerIntercambio(combo_propiedades, combo_jugadores);
		BotonCambiarVista boton_cancelar = new BotonCambiarVista("Cancelar", new VistaTurnoInicial());
		
		this.getChildren().addAll(mensaje1, combo_propiedades, mensaje2, combo_jugadores, boton_confirmar, boton_cancelar);
	}
	
}
