package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorDados;
import fiuba.algo3.tp2.vista.botones.BotonContinuar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaTurnoTirarDados extends VBox{
	
	public VistaTurnoTirarDados(ContenedorTurno contenedorPadre){
		ControladorDados dados = contenedorPadre.getControladorRonda().getDados();
		this.getStyleClass().add("VistaTurnoDinamica");
		HijoHorizontal sectorDados = new HijoHorizontal(dados);
		BotonContinuar continuar = new BotonContinuar(contenedorPadre);
		this.getChildren().addAll(sectorDados,continuar);
	}
	
	private class HijoHorizontal extends HBox{
		public HijoHorizontal(ControladorDados dados){
			VistaDado dadoUno=dados.getDadoUno();
			VistaDado dadoDos=dados.getDadoDos();
			LabelTurnoDinamica textoSacaste = new LabelTurnoDinamica("Sacaste 6 y 6");
			this.getChildren().addAll(dadoUno,dadoDos,textoSacaste);
		}
	}

}

