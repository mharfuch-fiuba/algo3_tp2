package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorCubilete;
import fiuba.algo3.tp2.vista.botones.BotonContinuar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaTurnoTirarDados extends VBox{
	
	public VistaTurnoTirarDados(ContenedorTurno contenedorPadre){
		ControladorCubilete dados = contenedorPadre.getControladorRonda().getDados();
		this.getStyleClass().add("VistaTurnoDinamica");
		HijoHorizontal sectorDados = new HijoHorizontal(dados);
		BotonContinuar continuar = new BotonContinuar(contenedorPadre);
		this.getChildren().addAll(sectorDados,continuar);
	}
	
	private class HijoHorizontal extends HBox{
		public HijoHorizontal(ControladorCubilete dados){
			VistaDado dadoUno=dados.getVistaDadoUno();
			VistaDado dadoDos=dados.getVistaDadoDos();
			LabelTurnoDinamica textoSacaste = new LabelTurnoDinamica("Sacaste "+dados.getValor1()+" y "+dados.getValor2());
			this.getChildren().addAll(dadoUno,dadoDos,textoSacaste);
		}
	}

}

