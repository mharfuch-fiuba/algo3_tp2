package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class ImpuestoDeLujo implements Encasillable {

	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		Dinero dineroJugador = jugador.obtenerDinero();
		Dinero montoAPagar = dineroJugador.obtenerPorcentaje(10);
		jugador.pagar(montoAPagar);
	}

}
