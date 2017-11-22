package fiuba.algo3.tp2.modelo.encasillables.comprables.servicios;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class Subte extends Servicio {
	
	private static final int MULT_PENALIDAD = 600;
	private static final int MULT_PENALIDAD_CON_TREN = 1100;
	private static final Dinero PRECIO_DE_COMPRA = new DineroAlgoPoly(40000);
	
	public Subte() {
		super(PRECIO_DE_COMPRA, MULT_PENALIDAD, MULT_PENALIDAD_CON_TREN);
	}
	
}
