package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.inmobiliaria.InmobiliariaSaltaSur;

public class SaltaSur extends TerrenoAlgoPoly {

	public SaltaSur() {
		this.inmobiliaria=new InmobiliariaSaltaSur();
		this.precioCompra = new Dinero(23000);
		this.alquilerTerreno = new Dinero(2000);
	}



}
