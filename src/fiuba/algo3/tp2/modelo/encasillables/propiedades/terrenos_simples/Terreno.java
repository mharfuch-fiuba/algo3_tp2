package fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples;

import fiuba.algo3.tp2.modelo.Dinero;

public abstract class Terreno extends Propiedad {

	public Terreno(Dinero precio_compra) {
		super(precio_compra);
	}
	
	public abstract void construir();

}
