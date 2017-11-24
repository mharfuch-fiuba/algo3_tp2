package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.inmobiliaria.InmobiliariaSaltaNorte;

public class SaltaNorte extends TerrenoAlgoPoly {
	
	public SaltaNorte() {
		this.inmobiliaria = new InmobiliariaSaltaNorte();
		this.precioCompra = new Dinero(23000);
		this.alquilerTerreno = new Dinero(2000);
	}


	
}
