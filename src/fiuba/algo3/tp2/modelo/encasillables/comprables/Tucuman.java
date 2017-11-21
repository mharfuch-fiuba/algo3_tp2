package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class Tucuman extends Terreno {

	public Tucuman() {
		precioCompra = new DineroAlgoPoly(25000);
		alquilerTerreno = new DineroAlgoPoly(2500);
	}

	@Override
	public void construir() throws DineroInsuficienteException {
		// TODO Auto-generated method stub
		
	}

}
