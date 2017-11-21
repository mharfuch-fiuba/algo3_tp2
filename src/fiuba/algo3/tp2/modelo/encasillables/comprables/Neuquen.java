package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class Neuquen extends Terreno{
	
	public Neuquen() {
		precioCompra = new DineroAlgoPoly(17000);
		alquilerTerreno = new DineroAlgoPoly(1800);
	}

	@Override
	public void construir() throws DineroInsuficienteException {
		// TODO Auto-generated method stub
		
	}
	
}
