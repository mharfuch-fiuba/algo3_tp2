package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.inmobiliaria.InmobiliariaCordobaNorte;

public class CordobaNorte extends TerrenoAlgoPoly {
	
	public CordobaNorte() {
		this.inmobiliaria=new InmobiliariaCordobaNorte();
		this.precioCompra = new Dinero(20000);
		this.alquilerTerreno = new Dinero(1300);
	}

	
}
