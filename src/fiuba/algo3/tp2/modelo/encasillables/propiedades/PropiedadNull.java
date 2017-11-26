package fiuba.algo3.tp2.modelo.encasillables.propiedades;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorNull;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class PropiedadNull extends Propiedad {

	public PropiedadNull() {
		super(new Dinero(0));
		this.setPropietario(new JugadorNull());
	}

	@Override
	public String getNombre() {
		return "Propiedad Null";
	}

	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		return;
	}

	@Override
	public boolean esNull() {
		return true;
	}

}
