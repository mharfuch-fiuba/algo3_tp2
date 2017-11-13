package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Comprable;
import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorNull;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class Propiedad implements Comprable, Encasillable {
	
	protected Jugador PROPIETARIO;
	protected DineroAlgoPoly PRECIO_COMPRA;
	
	@Override
	public Jugador obtenerPropietario() {
		return PROPIETARIO;
	}
	
	@Override
	public void comprar(Jugador jugador) throws DineroInsuficienteException {
		jugador.pagar(PRECIO_COMPRA);
		PROPIETARIO = jugador;
	}
	
	@Override
	public abstract void ejecutarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException;
	
	public Propiedad() {
		PROPIETARIO = new JugadorNull();
	}
	
}
