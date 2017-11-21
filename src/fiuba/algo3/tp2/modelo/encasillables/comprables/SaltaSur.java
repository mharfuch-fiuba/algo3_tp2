package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class SaltaSur extends TerrenoAlgoPoly {

	public SaltaSur() {
		precioCompra = new DineroAlgoPoly(23000);
		alquilerTerreno = new DineroAlgoPoly(2000);
	}

	@Override
	public void construir() throws DineroInsuficienteException {
		// TODO Auto-generated method stub
		
	}

}
