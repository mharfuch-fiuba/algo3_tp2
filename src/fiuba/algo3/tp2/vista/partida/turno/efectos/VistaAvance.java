package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.vista.botones.BotonAvanceDinamico;
import fiuba.algo3.tp2.vista.partida.turno.LabelTurnoDinamica;

public class VistaAvance extends VistaAccion {
	
	public VistaAvance(int cant_casilleros) {
		//"LA VISTA NO CONOCE AL MODELO"
		//int cant_propiedades = ControladorPrincipal.getInstance().getCantidadPropiedadesJugadorActual();
		//int cant_efectivo = ControladorPrincipal.getInstance().getCantidadEfectivoJugadorActual();
		//int cant_casilleros =ControladorPrincipal.getInstance().getCubilete();
		//if(cant_casilleros <= 6) cant_casilleros = cant_casilleros -2;
		//if(cant_casilleros > 6 && cant_casilleros < 11) cant_casilleros = cant_casilleros % cant_efectivo;
		//if(cant_casilleros >= 11) cant_casilleros = cant_casilleros - cant_propiedades;
		LabelTurnoDinamica label = new LabelTurnoDinamica("Caiste en Avance Dinamico. Avanzaras " + cant_casilleros + " casilleros");
		BotonAvanceDinamico boton = new BotonAvanceDinamico();
		this.getChildren().addAll(label,boton);
		
	}
}
