package fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.Construccion;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionNull;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.Construible;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class TerrenoSimple extends Propiedad implements Edificable {
	
	private Construible construccion;
	
	public TerrenoSimple(Dinero precioTerreno, Dinero alquiler, Dinero alquilerCon1Casa, Dinero costoConstruccionCasa) {
		super(precioTerreno);
		Construible casa = new Construccion(alquilerCon1Casa, new Dinero(0),  new ConstruccionNull(alquilerCon1Casa));
		construccion = new Construccion(alquiler, costoConstruccionCasa, casa);
	}

	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		Dinero precio_alquiler = construccion.getAlquiler();
		jugador.pagar(precio_alquiler);
		this.getPropietario().cobrar(precio_alquiler);
	}
	
	@Override
	public void construir() throws DineroInsuficienteException {
		this.getPropietario().pagar(construccion.getPrecioMejora());
		construccion = construccion.getSiguienteConstruccion();
	}
	
	@Override
	public boolean esNull() {
		return false;
	}

}
