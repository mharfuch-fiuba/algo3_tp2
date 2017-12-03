package fiuba.algo3.tp2.vista.botones.eventos;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
	
	public BotonTirarDadosHandler() {
	}
	
	@Override
	public void handle(ActionEvent event) {
		System.out.println("LANZO DADOS");
		ControladorPrincipal.getInstance().lanzar_dado();
		//ControladorRonda ronda = this.contenedorPadre.getControladorRonda();
		//ronda.tirarDados();
		//VistaTurnoTirarDados vistaDados=new VistaTurnoTirarDados(this.contenedorPadre);
		//this.contenedorPadre.cambiarVistaDinamica(vistaDados);
	}

}
