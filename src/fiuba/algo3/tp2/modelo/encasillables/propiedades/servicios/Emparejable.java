package fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;

public interface Emparejable {
	void agregarPareja(Propiedad casillero);
	Emparejable getPareja();
}
