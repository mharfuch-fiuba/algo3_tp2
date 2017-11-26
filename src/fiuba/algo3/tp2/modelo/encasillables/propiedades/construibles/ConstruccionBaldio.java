package fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.modelo.excepciones.FaltanCasasException;


public class ConstruccionBaldio implements Construible {
	
	private Construible proxima_mejora;
	private Dinero precio_alquiler;
	
	public ConstruccionBaldio(Dinero alquiler, Construible mejora) {
		proxima_mejora = mejora;
		precio_alquiler = alquiler;
	}
	
	public ConstruccionBaldio(Dinero alquiler) {
		proxima_mejora = new ConstruccionNull(this);
		precio_alquiler = alquiler;
	}

	@Override
	public Dinero getAlquiler() {
		return precio_alquiler;
	}

	@Override
	public Dinero getPrecioMejora() {
		return this.construirSiguiente().getPrecioConstruccion();
	}
	
	@Override
	public Dinero getPrecioConstruccion() {
		return new Dinero(0);
	}

	@Override
	public Construible construirSiguiente(Terreno actual, Terreno pareja) {
		actual.quiereContruir(pareja); // <-- SALTA EXCEPCION SI EL DUEÑO NO ES EL MISMO
		return this.construirSiguiente(); // <-- SALTA EXCEPCION SI NO HAY MAS MEJORAS
	}
	
	@Override
	public Construible construirSiguiente() {
		return proxima_mejora;
	}

	@Override
	public void parejaQuiereConstruirHotel() {
		throw new FaltanCasasException();
	}

}
