package fiuba.algo3.tp2.modelo.encasillables.comprables.servicios;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Propiedad;

public class Aysa extends Servicio {
	
	private static final int PENALIDAD = 300;
	private static final Dinero PRECIO_DE_COMPRA = new DineroAlgoPoly(30000);
	
	private Propiedad pareja;
	
	public Aysa() {
		super(PENALIDAD, PRECIO_DE_COMPRA);
		pareja = null; // VER PATRON NULL
	}

	@Override
	public void agregarPareja(Propiedad casillero) {
		pareja = casillero;
	}
	
}
