package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorCubilete;
import fiuba.algo3.tp2.vista.botones.BotonAplicarEfecto;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaEfecto;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaTurnoTirarDados extends VistaEfecto{
	
	public VistaTurnoTirarDados(ContenedorTurno contenedorPadre){
		ControladorCubilete dados = contenedorPadre.getControladorRonda().getDados();
		
		HijoHorizontal sectorDados = new HijoHorizontal(dados);
		BotonAplicarEfecto continuar = new BotonAplicarEfecto(contenedorPadre);
		this.getChildren().addAll(sectorDados,continuar);
	}
	
	private class HijoHorizontal extends HBox{
		public HijoHorizontal(ControladorCubilete dados){
			this.setSpacing(10);			
			this.getChildren().addAll(dados.getVistasDados());
		}
	}

}

