package fiuba.algo3.tp2.modelo;

public abstract class Jugador {

	//public abstract void avanzar(Cubilete cubilete) throws DineroInsuficienteException;	//no me cierra que el avanzar tire esta excepcion.
	public abstract int getCantidadDePropiedades();
	
	public abstract void avanzar(Cubilete cubilete);
	
	public abstract int getNombre();

	public abstract void agregarNombre(int nombre);
	
	public abstract Dinero obtenerDinero();

	public abstract void incrementarDinero(Dinero montoAIncrementar);
	
	public abstract void comprarCasilleroActual() throws DineroInsuficienteException;

	public abstract Encasillable obtenerCasilleroActual();

	public abstract void disminuirCapital(Dinero monto) throws DineroInsuficienteException;

	public abstract void aumentarCapital(Dinero monto);
	
	public abstract void pagarFianza() throws DineroInsuficienteException;
	
	public abstract void encarcelar();

	public abstract void avanzar(int cant_casilleros);

	public abstract void retroceder(Cubilete cubilete);
	
	//public abstract void interactuarConCasilleroActual();
	
}
