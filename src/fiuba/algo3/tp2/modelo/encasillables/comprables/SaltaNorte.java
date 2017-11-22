package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class SaltaNorte extends TerrenoAlgoPoly {
	
	public SaltaNorte() {
		this.inmobiliaria = new InmobiliariaSaltaNorte();
		this.precioCompra = new DineroAlgoPoly(23000);
		this.alquilerTerreno = new DineroAlgoPoly(2000);
	}


	
}
