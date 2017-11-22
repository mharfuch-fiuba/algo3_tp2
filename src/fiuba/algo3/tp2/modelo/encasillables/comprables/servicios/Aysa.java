package fiuba.algo3.tp2.modelo.encasillables.comprables.servicios;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Propiedad;

public class Aysa extends Servicio {
	
	private Propiedad pareja; 
	
	public Aysa() {
		precioCompra = new DineroAlgoPoly(30000);
		PENALIDAD = 300;
		pareja = null; // VER PATRON NULL
	}

	@Override
	public void agregarPareja(Propiedad casillero) {
		pareja = casillero;
	}
	
}
