package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaAccion;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaCarcel;
import javafx.scene.layout.VBox;

public class VistaAcciones extends VBox {

	private VistaAccion vista_actual;
	
	public VistaAcciones(Jugador jugador_actual){
		VistaTurnoTitulo vistaTurnoTitulo=new VistaTurnoTitulo(jugador_actual);
		VistaTurnoInicial vista_actual = new VistaTurnoInicial(this);
		this.getChildren().addAll(vistaTurnoTitulo, vista_actual);
	}
	
	public void colocarVistaCarcel() {
		this.cambiarVistaAccion(new VistaCarcel());
	}
	
	private void cambiarVistaAccion(VistaAccion nueva_vista){
		this.getChildren().remove(this.vista_actual);
		this.getChildren().add(nueva_vista);
		this.vista_actual = nueva_vista;
	}
	/*
	public VistaTurnoInicial getVistaInicial(){
		VistaTurnoInicial vistaInicial=this.vistaTurnoInicial;
		//ControladorJugador jugador = this.ronda.getJugadorActual();
		/*
		if(jugador.estaEncarcelado()){
			vistaInicial= new VistaJugadorEnCarcel(this,jugador);
		}
		
		return vistaInicial;
	}
*/
	/*
	public Button getBotonVolver(){
		return new BotonVolver(this);
	}
	
	private class BotonVolver extends Button{
		
		public BotonVolver(ContenedorAcciones contenedorPadre){
			this.getStyleClass().add("Boton");
			this.setText("Volver");
			this.setOnAction(new BotonVolverHandler(contenedorPadre));
		}
	}
	
	public class BotonVolverHandler implements EventHandler<ActionEvent> {
		
		ContenedorAcciones contenedorPadre;
		
		public BotonVolverHandler(ContenedorAcciones contenedorPadre) {
			this.contenedorPadre=contenedorPadre;
		}
		@Override
		public void handle(ActionEvent event) {
			this.contenedorPadre.cambiarVistaDinamica(this.contenedorPadre.getVistaInicial());
		}
		
	}
	*/
	
	
}
