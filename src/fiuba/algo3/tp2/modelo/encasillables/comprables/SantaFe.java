package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.inmobiliaria.InmobiliariaSantaFe;

public class SantaFe extends TerrenoAlgoPoly {

	public SantaFe() {
		this.inmobiliaria=new InmobiliariaSantaFe();
		precioCompra = new Dinero(15000);
		alquilerTerreno = new Dinero(1500);
	}

}
