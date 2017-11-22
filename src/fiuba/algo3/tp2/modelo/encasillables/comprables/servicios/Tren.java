package fiuba.algo3.tp2.modelo.encasillables.comprables.servicios;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Propiedad;

public class Tren extends Servicio {

	private Propiedad pareja;
	
	public Tren() {
		precioCompra = new DineroAlgoPoly(38000);
		PENALIDAD = 450;
	}
	
	@Override
	public void agregarPareja(Propiedad casillero) {
		pareja = casillero;
	}
	
}
