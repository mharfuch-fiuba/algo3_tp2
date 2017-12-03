package fiuba.algo3.tp2.vista.partida.turno.efectos;


import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import javafx.scene.control.Label;

public class VistaPropiedadAjena extends VistaEfecto {

	public VistaPropiedadAjena(ContenedorTurno contenedorPadre){
		this.getChildren().add(new Label("soy propiedad ajena"));
	}
}
