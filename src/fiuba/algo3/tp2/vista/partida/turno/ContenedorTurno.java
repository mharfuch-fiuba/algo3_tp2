package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorJugador;
import fiuba.algo3.tp2.controlador.ControladorRonda;
import fiuba.algo3.tp2.controlador.ControladorTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ContenedorTurno extends VBox {

	private VistaTurnoInicial vistaTurnoInicial;
	private Pane vistaActual;
	private ControladorRonda ronda;
	private ControladorTablero tablero;
	
	public ContenedorTurno(ControladorRonda ronda,ControladorTablero tablero){
		this.ronda=ronda;
		this.tablero=tablero;
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
		VistaTurnoInicial vistaInicial=this.vistaTurnoInicial;
		ControladorJugador jugador = this.ronda.getJugadorActual();
		if(jugador.estaEncarcelado()){
			vistaInicial= new VistaJugadorEnCarcel(this,jugador);
		}
		return vistaInicial;
	}
	
	public void terminarTurno(){
		this.ronda.terminarTurno();
	}
	
	public ControladorRonda getControladorRonda(){
		return this.ronda;
	}

	public ControladorTablero getControladorTablero(){
		return this.tablero;
	}
	
	public Button getBotonVolver(){
		return new BotonVolver(this);
	}
	
	private class BotonVolver extends Button{
		
		public BotonVolver(ContenedorTurno contenedorPadre){
			this.getStyleClass().add("Boton");
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
