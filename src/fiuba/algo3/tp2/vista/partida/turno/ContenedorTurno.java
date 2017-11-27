package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorRonda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ContenedorTurno extends VBox {

	private VistaTurnoInicial vistaTurnoInicial;
	private Pane vistaActual;
	private ControladorRonda ronda;
	
	public ContenedorTurno(ControladorRonda ronda){
		this.ronda=ronda;
		VistaTurnoTitulo vistaTurnoTitulo=new VistaTurnoTitulo(ronda);
		this.ronda.vincularTitulo(vistaTurnoTitulo.getLabelJugador());
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
	
	public void terminarTurno(){
		this.ronda.terminarTurno();
	}
	
	public ControladorRonda getControladorRonda(){
		return this.ronda;
	}
	
	public Button getBotonVolver(){
		return new BotonVolver(this);
	}
	
	private class BotonVolver extends Button{
		
		public BotonVolver(ContenedorTurno contenedorPadre){
			this.setText("Volver");
			this.setOnAction(new BotonVolverHandler(contenedorPadre));
		}
	}
	
	public class BotonVolverHandler implements EventHandler<ActionEvent> {
		
		ContenedorTurno contenedorPadre;
		
		public BotonVolverHandler(ContenedorTurno contenedorPadre) {
			this.contenedorPadre=contenedorPadre;
		}
		@Override
		public void handle(ActionEvent event) {
			this.contenedorPadre.cambiarVistaDinamica(this.contenedorPadre.getVistaInicial());
		}
		
	}
	
	
	
}
