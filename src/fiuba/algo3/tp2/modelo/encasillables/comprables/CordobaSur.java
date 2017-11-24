package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.inmobiliaria.InmobiliariaCordobaSur;

public class CordobaSur extends TerrenoAlgoPoly {

	public CordobaSur() {
		this.inmobiliaria=new InmobiliariaCordobaSur();
		this.precioCompra = new Dinero(18000);
		this.alquilerTerreno = new Dinero(1000);
	}

	
}
