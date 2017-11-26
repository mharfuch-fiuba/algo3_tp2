package fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.PropiedadNull;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionBaldio;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionCasa;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.Construible;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class TerrenoSimple extends Propiedad implements Edificable {
	
	private Construible construccion;
	
	public TerrenoSimple(Dinero precioTerreno, Dinero alquiler, Dinero alquilerCon1Casa, Dinero costoConstruccionCasa) {
		super(precioTerreno);
		Construible casa = new ConstruccionCasa(costoConstruccionCasa, alquilerCon1Casa, null);
		construccion = new ConstruccionBaldio(alquiler, casa);
	}

	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		Dinero precio_alquiler = construccion.getAlquiler();
		jugador.pagar(precio_alquiler);
		this.getPropietario().cobrar(precio_alquiler);
	}
	
	@Override
	public void construir() throws DineroInsuficienteException {		
		Construible nueva_construccion = construccion.construirSiguiente(this, new PropiedadNull());
		this.getPropietario().pagar(nueva_construccion.getPrecioConstruccion());
		construccion = nueva_construccion;
	}
	
	@Override
	public boolean esNull() {
		return false;
	}

	@Override
	public Construible getConstruccion() {
		return construccion;
	}
	
}
