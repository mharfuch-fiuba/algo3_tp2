package fiuba.algo3.tp2.vista.partida.turno;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaAccion;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaAvance;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaCarcel;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaConfirmarIntercambio;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaDados;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaDineroInsuficiente;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaJugadorGanador;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaImpuesto;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaIntercambiarPropiedad;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaJugadorExpulsado;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaMensajeGenerico;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPolicia;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPropiedadAjena;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPropiedadLibre;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPropiedadPropia;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaQuini;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaRetroceso;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaSalida;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaDeEspera;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VistaAcciones extends VBox {

	private String jugador_actual;
	private Color color_jugador;
	
	public VistaAcciones(){
		jugador_actual = "Sin Jugador";
		this.colocarVistaNormal();
	}
	
	public void setJugadorActual(String jugador_actual, Color color_jugador) {
		this.jugador_actual = jugador_actual;
		this.color_jugador = color_jugador;
	}

	private void cambiarVistaAccion(VistaAccion nueva_vista){
		nueva_vista.setColorFondo(color_jugador);
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
	
	public void colocarVistaNormal() {
		this.cambiarVistaAccion(new VistaTurnoInicial());
	}
	
	public void colocarVistaDados(ArrayList<VistaDado> vistas_dados) {
		this.cambiarVistaAccion(new VistaDados(vistas_dados));
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

	public void colocarVistaGenerica(String texto, VistaAccion vista_siguiente) {
		this.cambiarVistaAccion(new VistaMensajeGenerico(texto, vista_siguiente));
	}

	public void colocarVistaDineroInsuficiente() {
		this.cambiarVistaAccion(new VistaDineroInsuficiente());
	}

	public void colocarVistaDeEspera() {
		this.cambiarVistaAccion(new VistaDeEspera());
	}

	public void colocarVista(VistaAccion vista_siguiente) {
		this.cambiarVistaAccion(vista_siguiente);
	}

	public void colocarVistaJugadorGanador(String jugador) {
		this.cambiarVistaAccion(new VistaJugadorGanador(jugador));
	}

	public void colocarVistaJugadorExpulsado(String jugador) {
		this.cambiarVistaAccion(new VistaJugadorExpulsado(jugador));
	}

	public void colocarVistaIntercambiarPropiedad() {
		this.cambiarVistaAccion(new VistaIntercambiarPropiedad());
	}

	public void colocarVistaConfirmarIntercambio(Propiedad propiedad, Jugador jugador) {
		this.cambiarVistaAccion(new VistaConfirmarIntercambio(propiedad,jugador));
	}
	
}
