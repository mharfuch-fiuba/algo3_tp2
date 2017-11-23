package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.inmobiliaria.InmobiliariaBuenosAiresSur;

public class BuenosAiresSur extends TerrenoAlgoPoly {

	public BuenosAiresSur() {
		this.inmobiliaria = new InmobiliariaBuenosAiresSur();
		this.precioCompra = new DineroAlgoPoly(20000);
		this.alquilerTerreno = new DineroAlgoPoly(2000);
	}

}
