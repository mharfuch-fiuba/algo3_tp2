package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;

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
			jugador.avanzar(valor_obtenido - 2);
			break;
			case 7:
			case 8:
			case 9:
			case 10:
			jugador.avanzar(jugador.obtenerDinero().obtenerMontoEntero() % valor_obtenido);
			break;
			case 11:
			case 12:
			jugador.avanzar(valor_obtenido - jugador.getCantidadDePropiedades());
			break;
		}
	}

	@Override
	public String getNombre() {
		return "Avance Dinamico";
	}
	
	@Override
	public boolean esPropiedad(){
		return false;
	}

}
