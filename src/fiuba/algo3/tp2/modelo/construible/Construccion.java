package fiuba.algo3.tp2.modelo.construible;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorNull;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Comprable;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class Construccion implements Comprable{

	Jugador propietario;
	private Dinero precioCompra;
	private Dinero alquiler;

	public Construccion(Dinero costo, Dinero alquiler) {
		this.precioCompra = costo;
		this.alquiler = alquiler;
		this.propietario=new JugadorNull();
	}

	@Override
	public Dinero getPrecioCompra() {
		return this.precioCompra;
	}

	public Dinero getAlquiler() {
		return this.alquiler;
	}

	@Override
	public Jugador obtenerPropietario() {
		return this.propietario;
	}

	@Override
	public void comprar(Jugador jugador) throws DineroInsuficienteException {
		jugador.pagar(this.precioCompra);
		this.propietario=jugador;
	}

	@Override
	public void cambiarTitularidad(Jugador nuevo_propietario) {
		propietario = nuevo_propietario;
	}


}
