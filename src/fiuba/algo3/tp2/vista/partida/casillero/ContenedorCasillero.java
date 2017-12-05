package fiuba.algo3.tp2.vista.partida.casillero;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.Construccion;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionBaldio;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionCasa;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionDuplex;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionHotel;
import fiuba.algo3.tp2.vista.partida.casillero.Construcciones.VistaConstruccion;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ContenedorCasillero extends VBox implements Observer{
	
	private VistaCasilleroNombre nombre;
	private VistaCasilleroDetalle detalle ;
	private VistaCasilleroJugadores jugadores ;	
	
	public ContenedorCasillero(String nombreCasillero,Color color){
		this.getStyleClass().add("VistaCasillero");
		nombre = new VistaCasilleroNombre(nombreCasillero,color);
		detalle = new VistaCasilleroDetalle();
		jugadores = new VistaCasilleroJugadores();
		
		//nombre.setPrefHeight(this.getPrefHeight()/3);
		detalle.setPrefHeight(this.getPrefHeight()/3);
		jugadores.setPrefHeight(this.getPrefHeight()/3);
		//nombre.setPrefWidth(this.getPrefWidth());
		detalle.setPrefWidth(this.getPrefWidth());
		jugadores.setPrefWidth(this.getPrefWidth());
		this.getChildren().addAll(nombre,detalle,jugadores);

	}
	
	public VistaCasilleroJugadores getJugadores(){
		return this.jugadores;
	}
	
	public void actualizarDetalle(VistaCasilleroDetalle vistaDetalle){
		this.detalle=vistaDetalle;
		//remplazar la vista detalle
		//this.getChildren().replaceAll(operator);
	}
	
	public void borrarJugador(VistaCasilleroJugador vista) {
		jugadores.sacarJugador(vista);
	}

	public void dibujarJugador(VistaCasilleroJugador vista) {
		jugadores.ponerJugador(vista);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("entro al update de ContenedorCasillero");
		Construccion construccion = (Construccion) arg;
		if(construccion instanceof ConstruccionBaldio) this.detalle.cambiarVista(new VistaConstruccion("file:assets/construcciones/baldio.png")) ;
		if(construccion instanceof ConstruccionCasa) this.detalle.cambiarVista(new VistaConstruccion("file:assets/construcciones/casa.png"));
		if(construccion instanceof ConstruccionDuplex) this.detalle.cambiarVista(new VistaConstruccion("file:assets/construcciones/duplex.png"));
		if(construccion instanceof ConstruccionHotel) this.detalle.cambiarVista(new VistaConstruccion("file:assets/construcciones/hotel.png"));	
	}
	
}
