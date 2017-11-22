package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class SaltaSur extends TerrenoAlgoPoly {

	public SaltaSur() {
		this.inmobiliaria=new InmobiliariaSaltaSur();
		this.precioCompra = new DineroAlgoPoly(23000);
		this.alquilerTerreno = new DineroAlgoPoly(2000);
	}



}
