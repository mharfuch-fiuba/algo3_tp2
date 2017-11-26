package fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.Construible;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public interface Edificable {

	public abstract void construir() throws DineroInsuficienteException;
	public abstract Construible getConstruccion();

}
