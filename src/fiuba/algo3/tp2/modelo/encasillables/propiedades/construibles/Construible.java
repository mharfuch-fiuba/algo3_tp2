package fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles;

import fiuba.algo3.tp2.modelo.Dinero;

public interface Construible {

	Dinero getAlquiler();
	Construible getSiguienteConstruccion();
	Dinero getPrecioMejora();

}
