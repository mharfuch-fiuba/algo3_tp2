package fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;


public interface Construible {

	Dinero getAlquiler();
	Dinero getPrecioMejora();
	Dinero getPrecioConstruccion();
	Construible construirSiguiente(Terreno actual, Terreno pareja);
	Construible construirSiguiente();
	void parejaQuiereConstruirHotel();
	
}
