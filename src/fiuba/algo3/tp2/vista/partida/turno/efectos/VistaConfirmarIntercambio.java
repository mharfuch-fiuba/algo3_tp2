package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.vista.botones.BotonCambiarVista;
import fiuba.algo3.tp2.vista.botones.BotonConfirmarIntercambio;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoInicial;

public class VistaConfirmarIntercambio extends VistaAccion {

	public VistaConfirmarIntercambio(Propiedad propiedad_propia, Propiedad propiedad_ajena) {
		this.getStyleClass().add("VistaTurnoDinamica");
		
		LabelTurnoDinamica mensaje1 = new LabelTurnoDinamica(propiedad_propia.getPropietario() + " quiere intercambiar");
		LabelTurnoDinamica mensaje2 = new LabelTurnoDinamica(propiedad_propia + " por " + propiedad_ajena);
		
		BotonConfirmarIntercambio boton_confirmar = new BotonConfirmarIntercambio(propiedad_propia, propiedad_ajena);
		BotonCambiarVista boton_cancelar = new BotonCambiarVista("Cancelar", new VistaTurnoInicial());
		
		this.getChildren().addAll(mensaje1, mensaje2, boton_confirmar, boton_cancelar);
	}
	
}
