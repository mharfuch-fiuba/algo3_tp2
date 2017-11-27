package fiuba.algo3.tp2.modelo;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.movimiento.Movimiento;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import javafx.scene.paint.Color;

public abstract class Jugador extends Observable{

	public abstract String getNombre();
	
	public abstract Color getColor();
	
	//esto lo haria en constructor
	public abstract void setNombre(String nombre);
	
	//esto lo haria en constructor
	public abstract void setColor(Color color);
	
	public abstract int getCantidadDePropiedades();
			
	public abstract Dinero obtenerDinero();
	
	public abstract void comprar(Propiedad propiedad) throws DineroInsuficienteException;
	
	public abstract void comprarCasilleroActual() throws DineroInsuficienteException;

	public abstract Encasillable obtenerCasilleroActual();

	public abstract void pagarFianza() throws DineroInsuficienteException;
	
	public abstract void aplicarEfectoDeCasilleroActual(Cubilete cubilete) throws DineroInsuficienteException;

	public abstract void avanzarHasta(Encasillable casillero) throws JugadorEnCarcelException;
	
	public abstract void pagar(Dinero monto) throws DineroInsuficienteException;
	
	public abstract void cobrar(Dinero monto);

	public abstract void avanzar(int cant_casilleros)throws JugadorEnCarcelException;

	public abstract void retroceder(int cant_casilleros) throws JugadorEnCarcelException;
	
	public abstract boolean isNull();

	public abstract void entregarPropiedad(Jugador destinatario, Propiedad propiedad);

	public abstract void agregarPropiedad(Propiedad propiedad);

	public abstract boolean esNull();

	public abstract Movimiento getMovimiento();

	public abstract void setMovimiento(Movimiento movimiento);

	public abstract void avisarCambioDeTurno();
	
}
