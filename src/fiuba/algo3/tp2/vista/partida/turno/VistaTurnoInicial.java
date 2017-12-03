package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.vista.botones.BotonAlgoPoly;
import fiuba.algo3.tp2.vista.botones.eventos.BotonConstruirHandler;
import fiuba.algo3.tp2.vista.botones.eventos.BotonIntercambiarHandler;
import fiuba.algo3.tp2.vista.botones.eventos.BotonTirarDadosHandler;
import fiuba.algo3.tp2.vista.botones.eventos.BotonVenderHandler;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaEfecto;
import javafx.scene.layout.VBox;

public class VistaTurnoInicial extends VistaEfecto {
	
	private ContenedorTurno contenedorPadre;

	public VistaTurnoInicial(ContenedorTurno contenedorPadre){
		this.contenedorPadre = contenedorPadre;
		this.getStyleClass().add("VistaTurnoDinamica");
		this.getChildren().addAll(construirBotones());
	}
	
	private BotonAlgoPoly[] construirBotones(){
		BotonAlgoPoly construir = new BotonAlgoPoly("Construir");
		construir.setOnAction(new BotonConstruirHandler(this.contenedorPadre));
		
		BotonAlgoPoly vender = new BotonAlgoPoly("Vender");
		vender.setOnAction(new BotonVenderHandler(this.contenedorPadre));
		
		BotonAlgoPoly intercambiar = new BotonAlgoPoly("Intercambiar");
		intercambiar.setOnAction(new BotonIntercambiarHandler(this.contenedorPadre));
		
		BotonAlgoPoly tirarDados = new BotonAlgoPoly("Tirar Dados");
		tirarDados.setOnAction(new BotonTirarDadosHandler(contenedorPadre));
		
		BotonAlgoPoly[] botones = {construir,vender,intercambiar,tirarDados};
		return botones;
	}
}
