package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class CordobaNorte extends Terreno {
	
	public CordobaNorte() {
		
		precioCompra = new DineroAlgoPoly(20000);
		alquilerTerreno = new DineroAlgoPoly(1300);
	}

	@Override
	public void construir() throws DineroInsuficienteException {
		// TODO Auto-generated method stub
		
	}
	
}
