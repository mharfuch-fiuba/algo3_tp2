package fiuba.algo3.tp2.modelo;

public abstract class Jugador {

	public abstract void avanzar(Cubilete cubilete);

	public abstract Dinero obtenerDinero();

	public abstract void incrementarDinero(Dinero montoAIncrementar);
	
	public abstract void comprarCasilleroActual();

	public abstract Encasillable obtenerCasilleroActual();

	public abstract void disminuirCapital(Dinero monto);

	public abstract void aumentarCapital(Dinero monto);
	
	public abstract void pagarFianza();
	
	public abstract void encarcelar();
	
}
