package fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.modelo.excepciones.FaltanCasasException;


public class ConstruccionCasa implements Construible {
	
	private Construible proxima_mejora;
	private Dinero precio_alquiler;
	private Dinero precio_construccion;
	
	public ConstruccionCasa(Dinero costo_construccion, Dinero costo_alquiler, Construible mejora) {
		proxima_mejora = mejora;
		precio_alquiler = costo_alquiler;
		precio_construccion = costo_construccion;
	}

	public ConstruccionCasa(Dinero costo_construccion, Dinero costo_alquiler) {
		proxima_mejora = new ConstruccionNull(this);
		precio_alquiler = costo_alquiler;
		precio_construccion = costo_construccion;
	}

	@Override
	public Dinero getAlquiler() {
		return precio_alquiler;
	}

	@Override
	public Construible construirMejora() {
		return proxima_mejora;
	}

	@Override
	public Dinero getPrecioMejora() {
		return this.construirMejora().getPrecioConstruccion();
	}
	
	@Override
	public Dinero getPrecioConstruccion() {
		return precio_construccion;
	}

	@Override
	public Construible construirMejora(Terreno actual, Terreno pareja) {
		actual.quiereContruir(pareja); // <-- SALTA EXCEPCION SI EL DUEÑO NO ES EL MISMO
		return this.construirMejora(); // <-- SALTA EXCEPCION SI NO HAY MAS MEJORAS
	}

	@Override
	public void parejaQuiereConstruirHotel() {
		throw new FaltanCasasException();
	}
	
}
