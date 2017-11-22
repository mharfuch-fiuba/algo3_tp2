package fiuba.algo3.tp2.modelo.encasillables.comprables.servicios;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class Aysa extends Servicio {
	
	private static final int MULT_PENALIDAD = 300;
	private static final int MULT_PENALIDAD_CON_EDESUR = 500;
	private static final Dinero PRECIO_DE_COMPRA = new DineroAlgoPoly(30000);
	
	public Aysa() {
		super(PRECIO_DE_COMPRA, MULT_PENALIDAD, MULT_PENALIDAD_CON_EDESUR);
	}
	
}
