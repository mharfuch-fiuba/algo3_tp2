package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.vista.TextFieldNombres;
import fiuba.algo3.tp2.vista.botones.eventos.BotonIniciarPartidaHandler;

public class BotonIniciarPartida extends BotonAlgoPoly {

	public BotonIniciarPartida(ContenedorPrincipal contenedorPadre,TextFieldNombres textFieldNombres,ControladorPrincipal controlador_principal){
		this.setText("Iniciar Partida");
		this.setOnAction(new BotonIniciarPartidaHandler(contenedorPadre,textFieldNombres));
	}
	
}
