package fiuba.algo3.tp2.modelo.encasillables.comprables.servicios;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Propiedad;

public class Subte extends Servicio {

	private static final int PENALIDAD = 600;
	private static final Dinero PRECIO_DE_COMPRA = new DineroAlgoPoly(40000);
	
	private Propiedad pareja;
	
	public Subte() {
		super(PENALIDAD, PRECIO_DE_COMPRA);
		pareja = null;
	}
	
	@Override
	public void agregarPareja(Propiedad casillero) {
		pareja = casillero;
	}
	
}
