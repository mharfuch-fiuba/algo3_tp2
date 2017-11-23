package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Comprable;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;

public abstract class Jugador {

	public abstract int getCantidadDePropiedades();
			
	public abstract Dinero obtenerDinero();
	
	public abstract void comprar(Comprable comprable) throws DineroInsuficienteException;
	
	public abstract void comprarCasilleroActual() throws DineroInsuficienteException;

	public abstract Encasillable obtenerCasilleroActual();

	public abstract void pagarFianza() throws DineroInsuficienteException;
	
	public abstract void encarcelar();
	
	public abstract void aplicarEfectoDeCasilleroActual(Cubilete cubilete) throws DineroInsuficienteException;

	public abstract void avanzarHasta(Encasillable casillero);
	
	public abstract Dinero pagar(Dinero monto) throws DineroInsuficienteException;
	
	public abstract void cobrar(Dinero monto);

	public abstract void disminuirDiasDeCarcel();

	public abstract void avanzar(int cant_casilleros)throws JugadorEnCarcelException;

	public abstract void retroceder(int cant_casilleros);
	
	public abstract boolean isNull();

	public abstract void entregarPropiedad(Jugador destinatario, Comprable propiedad);

	public abstract void agregarPropiedad(Comprable propiedad);
	
}
