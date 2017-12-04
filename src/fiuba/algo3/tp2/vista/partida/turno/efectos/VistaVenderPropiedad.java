package fiuba.algo3.tp2.vista.partida.turno.efectos;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.vista.botones.BotonCambiarVista;
import fiuba.algo3.tp2.vista.botones.BotonConfirmarVenderPropiedad;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoInicial;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class VistaVenderPropiedad extends VistaAccion {

	public VistaVenderPropiedad(ArrayList<Propiedad> propiedades) {
		this.getStyleClass().add("VistaTurnoDinamica");
		LabelTurnoDinamica mensaje = new LabelTurnoDinamica("Elija qué desea vender:");
		
		System.out.println(propiedades);
		
		ObservableList<Propiedad> opciones = FXCollections.observableArrayList(propiedades);
		ComboBox<Propiedad> combo_propiedades = new ComboBox<Propiedad>(opciones);
		
		BotonConfirmarVenderPropiedad boton_confirmar = new BotonConfirmarVenderPropiedad(combo_propiedades);
		BotonCambiarVista boton_cancelar = new BotonCambiarVista("Cancelar", new VistaTurnoInicial(propiedades));
		
		this.getChildren().addAll(mensaje, combo_propiedades, boton_confirmar, boton_cancelar);
	}
	
}
