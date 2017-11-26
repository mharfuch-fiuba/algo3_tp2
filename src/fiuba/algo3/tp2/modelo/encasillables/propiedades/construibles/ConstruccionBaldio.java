package fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.excepciones.NoHayMasMejorasException;
import fiuba.algo3.tp2.modelo.excepciones.FaltaAdquirirParejaException;

public class ConstruccionBaldio implements Construible {
	
	private Construible proxima_mejora;
	private Dinero precio_alquiler;
	
	public ConstruccionBaldio(Dinero alquiler, Construible mejora) {
		proxima_mejora = mejora;
		precio_alquiler = alquiler;
	}

	@Override
	public Dinero getAlquiler() {
		return precio_alquiler;
	}

	@Override
	public Construible getSiguienteConstruccion() {
		if(proxima_mejora == null) throw new NoHayMasMejorasException();
		return proxima_mejora;
	}

	@Override
	public Dinero getPrecioMejora() {
		return this.getSiguienteConstruccion().getPrecioConstruccion();
	}
	
	@Override
	public Dinero getPrecioConstruccion() {
		return new Dinero(0);
	}

	@Override
	public Construible construirSiguiente(Propiedad actual, Propiedad pareja) {
		if(actual.getPropietario() == pareja.getPropietario()) return this.getSiguienteConstruccion();
		if(pareja.esNull()) return this.getSiguienteConstruccion();
		throw new FaltaAdquirirParejaException();
	}

	@Override
	public boolean esDuplex() {
		return false;
	}

	@Override
	public boolean esHotel() {
		return false;
	}

}
