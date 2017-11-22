package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class CordobaNorte extends TerrenoAlgoPoly {
	
	public CordobaNorte() {
		this.inmobiliaria=new InmobiliariaCordobaNorte();
		this.precioCompra = new DineroAlgoPoly(20000);
		this.alquilerTerreno = new DineroAlgoPoly(1300);
	}

	
}
