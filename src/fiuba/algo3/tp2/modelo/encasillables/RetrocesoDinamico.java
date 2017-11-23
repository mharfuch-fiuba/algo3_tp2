package fiuba.algo3.tp2.modelo.encasillables;

import java.util.ArrayList;
import java.util.Arrays;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;

public class RetrocesoDinamico implements Encasillable{
	private ArrayList<Integer> dadosEfecto1 = new ArrayList<>(Arrays.asList(2,3,4,5,6));
	private ArrayList<Integer> dadosEfecto2 = new ArrayList<>(Arrays.asList(6,7,8,9,10));
	private ArrayList<Integer> dadosEfecto3 = new ArrayList<>(Arrays.asList(11,12));
	
	private void efectoRetrocedeSumaDadosMenosCantidadPropiedades(Jugador jugador, int sumaDados){
		int cantidadPropiedades = jugador.getCantidadDePropiedades();
		int casillerosPorRetroceder = sumaDados-cantidadPropiedades;
		casillerosPorRetroceder = (casillerosPorRetroceder<0)?0:casillerosPorRetroceder;
		jugador.retroceder(casillerosPorRetroceder);
	}
	
	private void efectoRetrocedeCantidadEfectivoRestoSumaDados(Jugador jugador, int sumaDados){
		Dinero dineroJugador =jugador.obtenerDinero();
		jugador.retroceder(dineroJugador.obtenerMontoEntero() % sumaDados);
	}
	
	private void efectoRetrocedeSumaDadosMenosDos(Jugador jugador, int sumaDados){
		jugador.retroceder(sumaDados-2);
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) {
		int sumaDados = dados.sumarValores();
		if(dadosEfecto1.contains(sumaDados)){
			efectoRetrocedeSumaDadosMenosCantidadPropiedades(jugador, sumaDados);
		}
		else if(dadosEfecto2.contains(sumaDados)){
			efectoRetrocedeCantidadEfectivoRestoSumaDados(jugador, sumaDados);
		}
		else if(dadosEfecto3.contains(sumaDados)){
			efectoRetrocedeSumaDadosMenosDos(jugador, sumaDados);
		}
	}

}
