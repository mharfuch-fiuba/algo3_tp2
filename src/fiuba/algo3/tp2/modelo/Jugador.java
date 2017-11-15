package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class Jugador {

	public abstract int getCantidadDePropiedades();
	
	public abstract void avanzar(Cubilete cubilete);
		
	public abstract Dinero obtenerDinero();

	public abstract void cobrar(Dinero montoAIncrementar);
	
	public abstract void comprarCasilleroActual() throws DineroInsuficienteException;

	public abstract Encasillable obtenerCasilleroActual();

	public abstract void aumentarCapital(Dinero monto);
	
	public abstract void pagarFianza() throws DineroInsuficienteException;
	
	public abstract void encarcelar();

	public abstract void retroceder(Cubilete cubilete);
	
	public abstract void aplicarEfectoDeCasilleroActual(Cubilete cubilete) throws DineroInsuficienteException;

	public abstract void avanzarHasta(Encasillable casillero);
	
	public abstract Dinero pagar(Dinero monto) throws DineroInsuficienteException;
	
	public abstract void agregarPropiedad(Comprable propiedad);
}
