package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorNull;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;

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

	public Propiedad() {
		propietario = new JugadorNull();
	}
	
	@Override
	public Dinero getPrecioCompra(){
		return this.precioCompra;
	}
	
	@Override
	public void cambiarTitularidad(Jugador nuevo_propietario) {
		propietario = nuevo_propietario;
	}

}
