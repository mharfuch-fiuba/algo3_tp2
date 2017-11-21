package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Comprable;
import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorNull;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class Construccion implements Comprable{

	Jugador propietario;
	private Dinero costo;
	private Dinero alquiler;

	public Construccion(Dinero costo, Dinero alquiler) {
		this.costo = costo;
		this.alquiler = alquiler;
		this.propietario=new JugadorNull();
	}

	public Dinero getCosto() {
		return this.costo;
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
		jugador.pagar(this.costo);
		this.propietario=jugador;
	}

}
