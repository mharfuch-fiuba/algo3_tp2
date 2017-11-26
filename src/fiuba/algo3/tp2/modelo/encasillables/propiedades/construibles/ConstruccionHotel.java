package fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.excepciones.FaltaAdquirirParejaException;

public class ConstruccionHotel implements Construible {
	
	private Construible proxima_mejora;
	private Dinero precio_alquiler;
	private Dinero precio_construccion;
	
	public ConstruccionHotel(Dinero costo_construccion, Dinero costo_alquiler, Construible mejora) {
		proxima_mejora = mejora;
		precio_alquiler = costo_alquiler;
		precio_construccion = costo_construccion;
	}

	public ConstruccionHotel(Dinero costo_construccion, Dinero costo_alquiler) {
		proxima_mejora = new ConstruccionNull(this);;
		precio_alquiler = costo_alquiler;
		precio_construccion = costo_construccion;
	}

	@Override
	public Dinero getAlquiler() {
		return precio_alquiler;
	}

	@Override
	public Construible construirSiguiente() {
		return proxima_mejora;
	}

	@Override
	public Dinero getPrecioMejora() {
		return this.construirSiguiente().getPrecioConstruccion();
	}
	
	@Override
	public Dinero getPrecioConstruccion() {
		return precio_construccion;
	}
	
	@Override
	public Construible construirSiguiente(Propiedad actual, Propiedad pareja) {
		if(actual.getPropietario() == pareja.getPropietario()) return this.construirSiguiente();
		if(pareja.esNull()) return this.construirSiguiente();
		throw new FaltaAdquirirParejaException();
	}

	@Override
	public boolean esDuplex() {
		return false;
	}

	@Override
	public boolean esHotel() {
		return true;
	}

}
