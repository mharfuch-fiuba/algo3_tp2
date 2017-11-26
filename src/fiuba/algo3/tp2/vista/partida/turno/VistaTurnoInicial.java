package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.vista.botones.BotonTurnoInicial;
import fiuba.algo3.tp2.vista.eventos.BotonConstruirHandler;
import fiuba.algo3.tp2.vista.eventos.BotonIntercambiarHandler;
import fiuba.algo3.tp2.vista.eventos.BotonTirarDadosHandler;
import fiuba.algo3.tp2.vista.eventos.BotonVenderHandler;
import javafx.scene.layout.VBox;

public class VistaTurnoInicial extends VBox {
	
	private ContenedorTurno contenedorPadre;

	public VistaTurnoInicial(ContenedorTurno contenedorPadre){
		this.contenedorPadre = contenedorPadre;
		this.getStyleClass().add("VistaTurnoDinamica");
		this.getChildren().addAll(construirBotones());
	}
	
	private BotonTurnoInicial[] construirBotones(){
		BotonTurnoInicial construir = new BotonTurnoInicial("Construir");
		construir.setOnAction(new BotonConstruirHandler());
		
		BotonTurnoInicial vender = new BotonTurnoInicial("Vender");
		vender.setOnAction(new BotonVenderHandler());
		
		BotonTurnoInicial intercambiar = new BotonTurnoInicial("Intercambiar");
		intercambiar.setOnAction(new BotonIntercambiarHandler());
		
		BotonTurnoInicial tirarDados = new BotonTurnoInicial("Tirar Dados");
		tirarDados.setOnAction(new BotonTirarDadosHandler(contenedorPadre));
		
		BotonTurnoInicial[] botones = {construir,vender,intercambiar,tirarDados};
		return botones;
	}
}
