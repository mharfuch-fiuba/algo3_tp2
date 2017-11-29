package fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.modelo.excepciones.NoHayConstruccionesParaDemoler;
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
	public Construible construirMejora(Terreno actual, Terreno pareja) {
		throw new NoHayMasMejorasException();
	}

	@Override
	public Construible construirMejora() {
		throw new NoHayMasMejorasException();
	}

	@Override
	public void parejaQuiereConstruirHotel() {
		construccion.parejaQuiereConstruirHotel();
	}

	@Override
	public Construible demoler() throws NoHayConstruccionesParaDemoler {
		return construccion.demoler();
	}

	@Override
	public void setMejora(Construible prox) {
	}

	@Override
	public Dinero getPrecioDemolicion() {
		// TODO Auto-generated method stub
		return construccion.getPrecioDemolicion();
	}

}
