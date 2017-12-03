package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaEfecto;

public class VistaTurnoIntercambiar extends VistaEfecto{

	public VistaTurnoIntercambiar(ContenedorTurno contenedorPadre) {
		LabelTurnoDinamica intercambiar = new LabelTurnoDinamica("Elija qu� desea intercambiar");
		this.getChildren().addAll(intercambiar,contenedorPadre.getBotonVolver());
		}

}
