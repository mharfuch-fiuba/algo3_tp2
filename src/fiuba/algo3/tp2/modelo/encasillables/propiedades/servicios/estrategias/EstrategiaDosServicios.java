package fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.estrategias;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.Servicio;

public class EstrategiaDosServicios implements EstrategiaServicios {

	private Servicio propiedad_actual;
	private int penalidad;
	private EstrategiaServicios siguiente_estrategia;
	
	public EstrategiaDosServicios(Servicio actual, int penalidad_2_servicios, EstrategiaServicios estrategia_siguiente) {
		propiedad_actual = actual;
		penalidad = penalidad_2_servicios;
		siguiente_estrategia = estrategia_siguiente;
		
	}

	@Override
	public Dinero totalServicio(Cubilete dados) {
		Servicio propiedad_pareja = propiedad_actual.getPareja();
		if(propiedad_actual.getPropietario() == propiedad_pareja.getPropietario()) return new Dinero(penalidad * dados.sumarValores());
		return siguiente_estrategia.totalServicio(dados);
	}

}
