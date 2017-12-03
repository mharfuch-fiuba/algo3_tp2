package fiuba.algo3.tp2.vista.botones.eventos;

import fiuba.algo3.tp2.controlador.ControladorRonda;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoTirarDados;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
	
	VistaAcciones contenedorPadre;
	
	public BotonTirarDadosHandler(VistaAcciones contenedorPadre) {
		this.contenedorPadre=contenedorPadre;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		//ControladorRonda ronda = this.contenedorPadre.getControladorRonda();
		//ronda.tirarDados();
		//VistaTurnoTirarDados vistaDados=new VistaTurnoTirarDados(this.contenedorPadre);
		//this.contenedorPadre.cambiarVistaDinamica(vistaDados);
	}

}
