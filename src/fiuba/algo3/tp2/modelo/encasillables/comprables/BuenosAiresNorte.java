package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.inmobiliaria.InmobiliariaBuenosAiresNorte;

public class BuenosAiresNorte extends TerrenoAlgoPoly{

	public BuenosAiresNorte() {
		this.inmobiliaria = new InmobiliariaBuenosAiresNorte();
		this.precioCompra = new Dinero(25000);
		this.alquilerTerreno = new Dinero(2500);
	}

}
