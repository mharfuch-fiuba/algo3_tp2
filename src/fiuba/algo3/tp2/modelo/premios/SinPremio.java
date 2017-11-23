package fiuba.algo3.tp2.modelo.premios;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class SinPremio implements EstadoPremio {

	private static final Dinero monto = new DineroAlgoPoly(0);
	
	@Override
	public Dinero obtenerMonto() {
		return monto;
	}

	@Override
	public EstadoPremio siguientePremio() {
		return this;
	}
	
}
