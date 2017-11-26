package fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.estrategias;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;

public class EstrategiaSinServicios implements EstrategiaServicios {

	@Override
	public Dinero totalServicio(Cubilete dados) {
		return new Dinero(0);
	}

}
