package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.controlador.ControladorRonda;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoTirarDados;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
	
	ContenedorTurno contenedorPadre;
	
	public BotonTirarDadosHandler(ContenedorTurno contenedorPadre) {
		this.contenedorPadre=contenedorPadre;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		ControladorRonda ronda = this.contenedorPadre.getControladorRonda();
		ronda.tirarDados();
		VistaTurnoTirarDados vistaDados=new VistaTurnoTirarDados(this.contenedorPadre);
		this.contenedorPadre.cambiarVistaDinamica(vistaDados);
	}

}
