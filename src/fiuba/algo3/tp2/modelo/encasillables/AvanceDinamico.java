package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;

public class AvanceDinamico implements Encasillable{


	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) {
		int valor_obtenido = dados.sumarValores();
		switch(valor_obtenido){
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			try {
				jugador.avanzar(valor_obtenido - 2);
			} catch (JugadorEnCarcelException e) {
				e.printStackTrace();
			}
				break;
			case 7:
			case 8:
			case 9:
			case 10:
			try {
				jugador.avanzar(jugador.obtenerDinero().obtenerMontoEntero() % valor_obtenido);
			} catch (JugadorEnCarcelException e) {
				e.printStackTrace();
			}
				break;
			case 11:
			case 12:
			try {
				jugador.avanzar(valor_obtenido - jugador.getCantidadDePropiedades());
			} catch (JugadorEnCarcelException e) {
				e.printStackTrace();
			}
				break;
		}
	}

}
