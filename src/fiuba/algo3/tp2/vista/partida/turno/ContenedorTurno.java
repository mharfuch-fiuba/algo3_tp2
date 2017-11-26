package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorRonda;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ContenedorTurno extends VBox {

	VistaTurnoInicial vistaTurnoInicial;
	Pane vistaActual;
	
	public ContenedorTurno(ControladorRonda ronda){
		VistaTurnoTitulo vistaTurnoTitulo=new VistaTurnoTitulo(ronda);
		this.vistaTurnoInicial = new VistaTurnoInicial(this);
		this.getChildren().addAll(vistaTurnoTitulo,vistaTurnoInicial);
		this.vistaActual=vistaTurnoInicial;
	}
	
	public void cambiarVistaDinamica(Pane nuevaVista){
		this.getChildren().remove(this.vistaActual);
		this.getChildren().add(nuevaVista);
		this.vistaActual=nuevaVista;
	}
	
	public VistaTurnoInicial getVistaInicial(){
		return this.vistaTurnoInicial;
	}
	
}
