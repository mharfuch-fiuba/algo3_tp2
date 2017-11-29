package fiuba.algo3.tp2.modelo.encasillables.propiedades;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.Construible;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public interface Edificable {

	void construir() throws DineroInsuficienteException;
	Construible getConstruccion();
	void setConstruccion(Construible construccion);
	boolean demoler();

}
