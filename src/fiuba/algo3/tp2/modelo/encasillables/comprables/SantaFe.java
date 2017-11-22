package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class SantaFe extends TerrenoAlgoPoly {

	public SantaFe() {
		this.inmobiliaria=new InmobiliariaSantaFe();
		precioCompra = new DineroAlgoPoly(15000);
		alquilerTerreno = new DineroAlgoPoly(1500);
	}

}
