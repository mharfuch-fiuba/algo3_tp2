package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Comprable;
import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorNull;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class Propiedad implements Comprable, Encasillable {

	protected Jugador propietario;
	protected Dinero precioCompra;

	@Override
	public Jugador obtenerPropietario() {
		return propietario;
	}

	@Override
	public void comprar(Jugador jugador) throws DineroInsuficienteException {
		jugador.pagar(precioCompra);
		propietario = jugador;
	}

	@Override
	public abstract void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException;

	public Propiedad() {
		propietario = new JugadorNull();
	}
	
	public Dinero getPrecioCompra(){
		return this.precioCompra;
	}

}
