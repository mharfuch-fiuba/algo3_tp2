package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Comprable;
import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorNull;

public abstract class Propiedad implements Comprable, Encasillable {
	
	protected Jugador PROPIETARIO;
	protected Dinero PRECIO_COMPRA;
	
	@Override
	public Jugador obtenerPropietario() {
		return PROPIETARIO;
	}
	
	@Override
	public void comprar(Jugador jugador) throws DineroInsuficienteException {
		jugador.disminuirCapital(PRECIO_COMPRA);
		PROPIETARIO = jugador;
	}
	
	@Override
	public abstract void ejecutarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException;
	
	public Propiedad() {
		PROPIETARIO = new JugadorNull();
	}
	
}
