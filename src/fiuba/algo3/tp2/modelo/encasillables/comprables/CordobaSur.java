package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class CordobaSur extends TerrenoAlgoPoly {

	public CordobaSur() {
		precioCompra = new DineroAlgoPoly(18000);
		alquilerTerreno = new DineroAlgoPoly(1000);
	}

	@Override
	public void construir() throws DineroInsuficienteException {
		// TODO Auto-generated method stub
		
	}
	
}
