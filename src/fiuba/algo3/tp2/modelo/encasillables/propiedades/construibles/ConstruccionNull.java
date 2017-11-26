package fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.excepciones.NoHayMasMejorasException;

public class ConstruccionNull implements Construible {

	Construible construccion;
	
	public ConstruccionNull(Construible construccion_actual) {
		construccion = construccion_actual;
	}

	@Override
	public Dinero getAlquiler() {
		return construccion.getAlquiler();
	}

	@Override
	public Dinero getPrecioMejora() {
		return new Dinero(0);
	}

	@Override
	public Dinero getPrecioConstruccion() {
		return new Dinero(0);
	}

	@Override
	public Construible construirSiguiente(Propiedad actual, Propiedad pareja) {
		throw new NoHayMasMejorasException();
	}

	@Override
	public Construible construirSiguiente() {
		throw new NoHayMasMejorasException();
	}

	@Override
	public boolean esDuplex() {
		return construccion.esDuplex();
	}

	@Override
	public boolean esHotel() {
		return construccion.esHotel();
	}

}
