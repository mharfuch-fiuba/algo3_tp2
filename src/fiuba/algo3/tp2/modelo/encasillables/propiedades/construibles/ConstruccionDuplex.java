package fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Edificable;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.excepciones.FaltanCasasException;
import fiuba.algo3.tp2.modelo.excepciones.NoHayMasMejorasException;
import fiuba.algo3.tp2.modelo.excepciones.FaltaAdquirirParejaException;

public class ConstruccionDuplex implements Construible {
	
	private Construible proxima_mejora;
	private Dinero precio_alquiler;
	private Dinero precio_construccion;
	
	public ConstruccionDuplex(Dinero costo_construccion, Dinero costo_alquiler, Construible mejora) {
		proxima_mejora = mejora;
		precio_alquiler = costo_alquiler;
		precio_construccion = costo_construccion;
	}

	@Override
	public Dinero getAlquiler() {
		return precio_alquiler;
	}

	@Override
	public Construible construirSiguiente() {
		if(proxima_mejora == null) throw new NoHayMasMejorasException();
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
	
	private Construible verificarDuplex(Edificable pareja) {
		Construible construccion = pareja.getConstruccion();
		if(construccion.esDuplex()) return this.construirSiguiente();
		if(construccion.esHotel()) return this.construirSiguiente();
		throw new FaltanCasasException();
	}
	
	@Override
	public Construible construirSiguiente(Propiedad actual, Propiedad pareja) {
		if(actual.getPropietario() == pareja.getPropietario()) return verificarDuplex((Edificable)pareja);
		if(pareja.esNull()) return this.construirSiguiente();
		throw new FaltaAdquirirParejaException();
	}

	@Override
	public boolean esDuplex() {
		return true;
	}

	@Override
	public boolean esHotel() {
		return false;
	}

}
