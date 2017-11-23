package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public interface Comprable {

	public Jugador obtenerPropietario();
	public abstract void comprar(Jugador jugador) throws DineroInsuficienteException;
	public void cambiarTitularidad(Jugador jugador);
	public Dinero getPrecioCompra();
	
}
