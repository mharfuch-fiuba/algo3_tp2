package fiuba.algo3.tp2.vista.partida.turno.efectos;


import fiuba.algo3.tp2.vista.botones.BotonTerminarTurno;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;
import javafx.scene.control.Label;

public class VistaPropiedadAjena extends VistaEfecto {

	public VistaPropiedadAjena(ContenedorTurno contenedorPadre){
		Label label = new Label("soy propiedad ajena");
		BotonTerminarTurno boton = new BotonTerminarTurno(contenedorPadre);
		this.getChildren().addAll(label,boton);
	}
}
