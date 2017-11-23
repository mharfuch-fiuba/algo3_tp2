package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.premios.Premio;

import java.util.HashMap; 

public class Quini6 implements Encasillable{
	
	/*** PARA ESTA SOLUCION SE UTILIZO EL PATRON STATE ***/
	
	private HashMap<Jugador, Premio> jugadoresGanadores;

	public Quini6(){
		jugadoresGanadores = new HashMap<Jugador, Premio> ();
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) {
		
		if(!jugadoresGanadores.containsKey(jugador)) {
			jugadoresGanadores.put(jugador, new Premio());
		}
		
		Premio premio_actual = jugadoresGanadores.get(jugador);
		Dinero monto_premio = premio_actual.obtenerMonto();
		jugador.cobrar(monto_premio);
		premio_actual.siguientePremio();
		
	}

}