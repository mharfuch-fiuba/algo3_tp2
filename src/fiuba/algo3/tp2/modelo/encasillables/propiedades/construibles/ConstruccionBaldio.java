package fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.modelo.excepciones.FaltanCasasException;
import fiuba.algo3.tp2.modelo.excepciones.NoHayConstruccionesParaDemoler;


public class ConstruccionBaldio implements Construible {
	
	private Construible proxima_mejora;
	private Dinero precio_alquiler;
	/*
	public ConstruccionBaldio(Dinero alquiler, Construible mejora) {
		proxima_mejora = mejora;
		precio_alquiler = alquiler;
	}
	*/
	public ConstruccionBaldio(Dinero alquiler) {
		proxima_mejora = new ConstruccionNull(this);
		//proxima_mejora = this;
		precio_alquiler = alquiler;
	}

	@Override
	public Dinero getAlquiler() {
		return precio_alquiler;
	}

	@Override
	public Dinero getPrecioMejora() {
		return this.construirMejora().getPrecioConstruccion();
	}
	
	@Override
	public Dinero getPrecioConstruccion() {
		return new Dinero(0);
	}

	@Override
	public Construible construirMejora(Terreno actual, Terreno pareja) {
		actual.quiereContruir(pareja); // <-- SALTA EXCEPCION SI EL DUEÑO NO ES EL MISMO
		return this.construirMejora(); // <-- SALTA EXCEPCION SI NO HAY MAS MEJORAS
	}
	
	@Override
	public Construible construirMejora() {
		return proxima_mejora;
	}

	@Override
	public void parejaQuiereConstruirHotel() {
		throw new FaltanCasasException();
	}
	
	@Override
	public Construible demoler() throws NoHayConstruccionesParaDemoler {
		throw new NoHayConstruccionesParaDemoler();
		//return this;
	}

	@Override
	public void setMejora(Construible prox) {
		proxima_mejora = prox;
	}

}
