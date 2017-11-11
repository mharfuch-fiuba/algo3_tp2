package fiuba.algo3.tp2.modelo;

public abstract class Jugador {

	public abstract void avanzar(Cubilete cubilete);

	public abstract Dinero obtenerDinero();

	public abstract void incrementarDinero(Dinero montoAIncrementar);
	
}
