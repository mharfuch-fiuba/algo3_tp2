package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;

public class Quini6 implements Encasillable{

	static final Dinero monto_a_incrementar = new Dinero(50000);
	
	@Override
	public void ejecutarEfecto(Jugador jugador) {
		jugador.incrementarDinero(monto_a_incrementar);
	}

}
