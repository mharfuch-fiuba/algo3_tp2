package fiuba.algo3.tp2.vista.partida.turno;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.vista.partida.turno.efectos.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VistaAcciones extends VBox {

	private String jugador_actual;
	private Color color_jugador;
	
	public VistaAcciones(){
		jugador_actual = "Sin Jugador";
		this.colocarVistaNormal(new ArrayList<Propiedad>());
	}
	
	public void setJugadorActual(String jugador_actual, Color color_jugador) {
		this.jugador_actual = jugador_actual;
		this.color_jugador = color_jugador;
	}

	private void cambiarVistaAccion(VistaAccion nueva_vista){
		this.getChildren().clear();
		this.getChildren().add(new VistaTurnoTitulo(jugador_actual, color_jugador));
		this.getChildren().add(nueva_vista);
		/*
		System.out.println("Saco" + this.vista_actual);
		this.getChildren().remove(this.vista_actual);
		System.out.println("pongo" + nueva_vista);
		this.getChildren().add(nueva_vista);
		this.vista_actual = nueva_vista;
		*/
	}
	
	public void colocarVistaCarcel() {
		this.cambiarVistaAccion(new VistaCarcel());
	}
	
	public void colocarVistaNormal(ArrayList<Propiedad> propiedades) {
		this.cambiarVistaAccion(new VistaTurnoInicial(propiedades));
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
	
	public void colocarVistaPropiedadAjena(String nombre_propietario, int monto) {
		this.cambiarVistaAccion(new VistaPropiedadAjena(nombre_propietario, monto));
	}
	
	public void colocarVistaPropiedadLibre(String nombre, int precio) {
		this.cambiarVistaAccion(new VistaPropiedadLibre(nombre, precio));
	}

	public void colocarVistaGenerica(VistaAccion vista_siguiente) {
		this.cambiarVistaAccion(vista_siguiente);
	}

	public void colocarVistaDineroInsuficiente(ArrayList<Propiedad> propiedades) {
		this.cambiarVistaAccion(new VistaDineroInsuficiente(propiedades));
	}

	public void colocarVistaVacia() {
		this.cambiarVistaAccion(new VistaVacia());
	}
	
}
