package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class Dinero {
	
	public abstract int obtenerMontoEntero();

	public abstract void aumentarCantidad(Dinero dinero);

	public abstract void disminuirCantidad(Dinero dinero) throws DineroInsuficienteException;

}
