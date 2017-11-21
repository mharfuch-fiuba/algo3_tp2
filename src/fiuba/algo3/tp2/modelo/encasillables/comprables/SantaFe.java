package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class SantaFe extends TerrenoAlgoPoly {

	public SantaFe() {
		precioCompra = new DineroAlgoPoly(15000);
		alquilerTerreno = new DineroAlgoPoly(1500);
	}

	@Override
	public void construir() throws DineroInsuficienteException {
		// TODO Auto-generated method stub
		
	}

}
