package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.controlador.ControladorCubilete;
import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaAccion;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaCarcel;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaDados;
import javafx.scene.layout.VBox;

public class VistaAcciones extends VBox {

	private VistaAccion vista_actual;
	private VistaTurnoTitulo vista_titulo;
	
	public VistaAcciones(){
		vista_titulo=new VistaTurnoTitulo("Sin Jugador");
		VistaTurnoInicial vista_actual = new VistaTurnoInicial(this);
		this.getChildren().addAll(vista_titulo, vista_actual);
	}
	
	public void setJugadorActual(String jugador_actual) {
		vista_titulo.setTitulo(jugador_actual);
	}
	
	public void colocarVistaCarcel() {
		this.cambiarVistaAccion(new VistaCarcel());
	}
	
	private void cambiarVistaAccion(VistaAccion nueva_vista){
		this.getChildren().remove(this.vista_actual);
		this.getChildren().add(nueva_vista);
		this.vista_actual = nueva_vista;
	}
	
	public void colocarVistaNormal() {
		//this.cambiarVistaAccion(new VistaTurnoInicial());
	}
	
	public void colocarVistaDados() {
		this.cambiarVistaAccion(new VistaDados());
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
