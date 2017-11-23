package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.inmobiliaria.InmobiliariaTucuman;

public class Tucuman extends TerrenoAlgoPoly {

	public Tucuman() {
		this.inmobiliaria=new InmobiliariaTucuman();
		this.precioCompra = new DineroAlgoPoly(25000);
		this.alquilerTerreno = new DineroAlgoPoly(2500);
	}


}
