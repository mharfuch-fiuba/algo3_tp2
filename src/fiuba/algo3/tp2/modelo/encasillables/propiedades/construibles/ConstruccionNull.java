package fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles;

import fiuba.algo3.tp2.modelo.Dinero;

public class ConstruccionNull implements Construible {
	
	private Dinero precio_alquiler;
	
	public ConstruccionNull(Dinero alquiler) {
		precio_alquiler = alquiler;
	}

	@Override
	public Dinero getAlquiler() {
		return precio_alquiler;
	}

	@Override
	public Construible getSiguienteConstruccion() {
		return this;
	}

	@Override
	public Dinero getPrecioMejora() {
		return new Dinero(0);
	}
	
}
