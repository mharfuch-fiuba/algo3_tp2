package fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionBaldio;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionCasa;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.Construible;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class TerrenoSimple extends Terreno {
	
	public TerrenoSimple(Dinero precioTerreno, Dinero alquiler, Dinero alquilerCon1Casa, Dinero costoConstruccionCasa) {
		super(precioTerreno);
		Construible casa = new ConstruccionCasa(costoConstruccionCasa, alquilerCon1Casa, null);
		Construible baldio = new ConstruccionBaldio(alquiler, casa);
		this.setConstruccion(baldio);
	}
	
	@Override
	public void construir() throws DineroInsuficienteException {		
		Construible nueva_construccion = this.getConstruccion().construirSiguiente();
		this.getPropietario().pagar(nueva_construccion.getPrecioConstruccion());
		this.setConstruccion(nueva_construccion);
	}
	
}
