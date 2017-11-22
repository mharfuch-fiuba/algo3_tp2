package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class BuenosAiresNorte extends TerrenoAlgoPoly{

	public BuenosAiresNorte() {
		this.inmobiliaria = new InmobiliariaBuenosAiresNorte();
		this.precioCompra = new DineroAlgoPoly(25000);
		this.alquilerTerreno = new DineroAlgoPoly(2500);
	}

}
