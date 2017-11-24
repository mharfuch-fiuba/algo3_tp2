package fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles;

import fiuba.algo3.tp2.modelo.Dinero;

public class Construccion implements Construible {
	
	private Construible proxima_mejora;
	private Dinero precio_alquiler;
	private Dinero precio_mejora;
	
	public Construccion(Dinero alquilerConstruccion, Dinero costoConstruccionMejora, Construible mejora) {
		proxima_mejora = mejora;
		precio_alquiler = alquilerConstruccion;
		precio_mejora = costoConstruccionMejora;
	}

	@Override
	public Dinero getAlquiler() {
		return precio_alquiler;
	}

	@Override
	public Construible getSiguienteConstruccion() {
		return proxima_mejora;
	}

	@Override
	public Dinero getPrecioMejora() {
		return precio_mejora;
	}

}
