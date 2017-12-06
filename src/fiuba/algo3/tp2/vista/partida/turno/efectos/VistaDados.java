package fiuba.algo3.tp2.vista.partida.turno.efectos;

import fiuba.algo3.tp2.controlador.ControladorCubilete;
import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.vista.botones.BotonAvanzar;
import javafx.scene.layout.HBox;

public class VistaDados extends VistaAccion{
/*
	public VistaDados(Cubilete cubilete){
		LabelTurnoDinamica label = new LabelTurnoDinamica("LANZASTE DADOS");
		BotonPagarFianza boton = new BotonPagarFianza(null);
		this.getChildren().addAll(label);
	}
	*/
	
	public VistaDados(){
		ControladorCubilete dados = ControladorPrincipal.getInstance().getControladorDados();
		this.getStyleClass().add("VistaTurnoDinamica");
		HijoHorizontal sectorDados = new HijoHorizontal(dados);
		BotonAvanzar continuar = new BotonAvanzar();
		this.getChildren().addAll(sectorDados,continuar);
	}
	
	private class HijoHorizontal extends HBox{
		public HijoHorizontal(ControladorCubilete dados){
			this.setSpacing(10);			
			this.getChildren().addAll(dados.getVistasDados());
		}
	}
	
}
