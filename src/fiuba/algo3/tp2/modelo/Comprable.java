package fiuba.algo3.tp2.modelo;

public interface Comprable {

	public Jugador obtenerPropietario();
	public abstract void comprar(Jugador jugador) throws DineroInsuficienteException;
	
}
