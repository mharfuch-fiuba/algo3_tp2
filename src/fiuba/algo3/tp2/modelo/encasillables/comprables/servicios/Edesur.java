package fiuba.algo3.tp2.modelo.encasillables.comprables.servicios;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Propiedad;

public class Edesur extends Servicio {

	private Propiedad pareja;
	
	public Edesur() {
		precioCompra = new DineroAlgoPoly(35000);
		PENALIDAD = 500;
		pareja = null;
	}
	
	@Override
	public void agregarPareja(Propiedad casillero) {
		pareja = casillero;
	}
	
}
