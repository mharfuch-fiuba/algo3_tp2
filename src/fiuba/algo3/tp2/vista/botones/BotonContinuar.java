package fiuba.algo3.tp2.vista.botones;

import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoEfecto;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoTirarDados;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonContinuar extends Button {
	
	public BotonContinuar(ContenedorTurno contenedorPadre){
		this.setText("Continuar");
		this.getStyleClass().add("BotonContinuar");
		this.setOnAction(new BotonContinuarHandler(contenedorPadre));
	}
	
	private class BotonContinuarHandler implements EventHandler<ActionEvent>{
		
		ContenedorTurno contenedorPadre;
		
		
		public BotonContinuarHandler(ContenedorTurno contenedorPadre) {
			this.contenedorPadre=contenedorPadre;
		}

		@Override
		public void handle(ActionEvent event) {
			VistaTurnoEfecto vistaEfecto=new VistaTurnoEfecto(this.contenedorPadre);
			this.contenedorPadre.cambiarVistaDinamica(vistaEfecto);		
		}
		
	}

}
