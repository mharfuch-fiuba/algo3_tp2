package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.DadoCargado;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;

public class AvanceDinamico implements Encasillable{


	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) {
		int valor_obtenido = dados.sumarValores();
		Cubilete cubilete = new Cubilete();
		switch(valor_obtenido){
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				cubilete.agregar(new DadoCargado(valor_obtenido - 2));				
				break;
			case 7:
			case 8:
			case 9:
			case 10:
				cubilete.agregar(new DadoCargado(jugador.obtenerDinero().obtenerMontoEntero() % valor_obtenido));
				break;
			case 11:
			case 12:
				cubilete.agregar(new DadoCargado(valor_obtenido - jugador.getCantidadDePropiedades()));
				break;
		}
		jugador.avanzar(cubilete);
	}

}
