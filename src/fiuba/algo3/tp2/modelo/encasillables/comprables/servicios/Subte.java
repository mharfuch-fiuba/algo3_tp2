package fiuba.algo3.tp2.modelo.encasillables.comprables.servicios;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Propiedad;

public class Subte extends Servicio {

	private Propiedad pareja;
	
	public Subte() {
		precioCompra = new DineroAlgoPoly(40000);
		PENALIDAD = 600;
	}
	
	@Override
	public void agregarPareja(Propiedad casillero) {
		pareja = casillero;
	}
	
}
