package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.inmobiliaria.InmobiliariaBuenosAiresSur;

public class BuenosAiresSur extends TerrenoAlgoPoly {

	public BuenosAiresSur() {
		this.inmobiliaria = new InmobiliariaBuenosAiresSur();
		this.precioCompra = new Dinero(20000);
		this.alquilerTerreno = new Dinero(2000);
	}

}
