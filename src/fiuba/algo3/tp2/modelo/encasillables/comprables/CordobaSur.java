package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class CordobaSur extends TerrenoAlgoPoly {

	public CordobaSur() {
		this.inmobiliaria=new InmobiliariaCordobaSur();
		this.precioCompra = new DineroAlgoPoly(18000);
		this.alquilerTerreno = new DineroAlgoPoly(1000);
	}

	
}
