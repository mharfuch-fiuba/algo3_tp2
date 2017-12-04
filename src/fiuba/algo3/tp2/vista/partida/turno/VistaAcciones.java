package fiuba.algo3.tp2.vista.partida.turno;

import fiuba.algo3.tp2.vista.partida.turno.efectos.*;
import javafx.scene.layout.VBox;

public class VistaAcciones extends VBox {

	private VistaAccion vista_actual;
	private VistaTurnoTitulo vista_titulo;
	
	public VistaAcciones(){
		vista_titulo=new VistaTurnoTitulo("Sin Jugador");
		this.colocarVistaNormal();
		//VistaTurnoInicial vista_actual = new VistaTurnoInicial(this);
		//this.getChildren().addAll(vista_titulo, vista_actual);
	}
	
	public void setJugadorActual(String jugador_actual) {
		vista_titulo.setTitulo(jugador_actual);
	}
	
	public void colocarVistaCarcel() {
		this.cambiarVistaAccion(new VistaCarcel());
	}
	
	private void cambiarVistaAccion(VistaAccion nueva_vista){
		System.out.println("Saco" + this.vista_actual);
		this.getChildren().remove(this.vista_actual);
		System.out.println("pongo" + nueva_vista);
		this.getChildren().add(nueva_vista);
		this.vista_actual = nueva_vista;
	}
	
	public void colocarVistaNormal() {
		this.cambiarVistaAccion(new VistaTurnoInicial());
	}
	
	public void colocarVistaDados() {
		this.cambiarVistaAccion(new VistaDados());
	}

	public void colocarVistaImpuesto() {
		this.cambiarVistaAccion(new VistaImpuesto());
	}

	public void colocarVistaAvance(int cant_casilleros) {
		this.cambiarVistaAccion(new VistaAvance(cant_casilleros));
	}
	
	public void colocarVistaRetroceso(int cant_casilleros) {
		this.cambiarVistaAccion(new VistaRetroceso(cant_casilleros));
	}

	public void colocarVistaSalida() {
		this.cambiarVistaAccion(new VistaSalida());
	}

	public void colocarVistaQuini(int monto_ganado) {
		this.cambiarVistaAccion(new VistaQuini(monto_ganado));
	}

	public void colocarVistaPolicia() {
		this.cambiarVistaAccion(new VistaPolicia());
	}

	public void colocarVistaPropiedadPropia() {
		this.cambiarVistaAccion(new VistaPropiedadPropia());
	}
	
	public void colocarVistaPropiedadAjena() {
		this.cambiarVistaAccion(new VistaPropiedadAjena());
	}
	
	public void colocarVistaPropiedadLibre() {
		this.cambiarVistaAccion(new VistaPropiedadLibre());
	}

	public void colocarVistaGenerica(VistaAccion vista_siguiente) {
		this.cambiarVistaAccion(vista_siguiente);
	}

	public void colocarVistaDineroInsuficiente() {
		this.cambiarVistaAccion(new VistaDineroInsuficiente());
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
