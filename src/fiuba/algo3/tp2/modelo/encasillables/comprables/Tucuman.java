package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.inmobiliaria.InmobiliariaTucuman;

public class Tucuman extends TerrenoAlgoPoly {

	public Tucuman() {
		this.inmobiliaria=new InmobiliariaTucuman();
		this.precioCompra = new Dinero(25000);
		this.alquilerTerreno = new Dinero(2500);
	}


}
