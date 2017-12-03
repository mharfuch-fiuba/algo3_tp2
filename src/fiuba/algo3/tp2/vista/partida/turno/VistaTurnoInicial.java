package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.vista.botones.BotonAlgoPoly;
import fiuba.algo3.tp2.vista.botones.eventos.BotonConstruirHandler;
import fiuba.algo3.tp2.vista.botones.eventos.BotonIntercambiarHandler;
import fiuba.algo3.tp2.vista.botones.eventos.BotonTirarDadosHandler;
import fiuba.algo3.tp2.vista.botones.eventos.BotonVenderHandler;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaAccion;

public class VistaTurnoInicial extends VistaAccion {

	public VistaTurnoInicial(){
		this.getStyleClass().add("VistaTurnoDinamica");
		this.getChildren().addAll(construirBotones());
	}

	private BotonAlgoPoly[] construirBotones(){
		BotonAlgoPoly construir = new BotonAlgoPoly("Construir");
		construir.setOnAction(new BotonConstruirHandler());
		
		BotonAlgoPoly vender = new BotonAlgoPoly("Vender");
		vender.setOnAction(new BotonVenderHandler());
		
		BotonAlgoPoly intercambiar = new BotonAlgoPoly("Intercambiar");
		intercambiar.setOnAction(new BotonIntercambiarHandler());
		
		BotonAlgoPoly tirarDados = new BotonAlgoPoly("Tirar Dados");
		tirarDados.setOnAction(new BotonTirarDadosHandler());
		
		BotonAlgoPoly[] botones = {construir,vender,intercambiar,tirarDados};
		return botones;
	}
}
