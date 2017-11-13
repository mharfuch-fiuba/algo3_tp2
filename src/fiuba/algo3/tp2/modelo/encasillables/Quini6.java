package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;
import java.util.HashMap; 

public class Quini6 implements Encasillable{

	static final DineroAlgoPoly MONTO_A_INCREMENTAR_PRIMERA_VEZ = new DineroAlgoPoly(50000);
	static final DineroAlgoPoly MONTO_A_INCREMENTAR_SEGUNDA_VEZ = new DineroAlgoPoly(30000);
	//protected HashMap<Integer, Integer> jugadoresGanadores = new HashMap<Integer, Integer> ();
	private HashMap<Jugador, Integer> jugadoresGanadores = new HashMap<Jugador, Integer> ();
/*
 * HARCODEO A FULL, SI JUGAS CON 7 JUGADORES QUE PASA ACA?	
	public Quini6(){
		jugadoresGanadores.put(1,0);
		jugadoresGanadores.put(2,0);
		jugadoresGanadores.put(3,0);
		
	}
*/	
	@Override
	public void ejecutarEfecto(Jugador jugador, Cubilete dados) {
		/*
		int nombreJugador=jugador.getNombre();
		
		if(jugadoresGanadores.get(nombreJugador) == 0){
			jugador.incrementarDinero(MONTO_A_INCREMENTAR_PRIMERA_VEZ);
			jugadoresGanadores.put(nombreJugador,1); 
		} else if(jugadoresGanadores.get(nombreJugador) == 1){
			jugador.incrementarDinero(MONTO_A_INCREMENTAR_SEGUNDA_VEZ);
			jugadoresGanadores.put(nombreJugador, 2);
		}
		*/
		
		if(!jugadoresGanadores.containsKey(jugador)) {
			jugadoresGanadores.put(jugador, 0);
		}
		
		int cant_veces_que_gano = jugadoresGanadores.get(jugador);
		
		if(cant_veces_que_gano == 0) {
			jugador.cobrar(MONTO_A_INCREMENTAR_PRIMERA_VEZ);
			jugadoresGanadores.put(jugador, 1);
		}
		
		if(cant_veces_que_gano == 1) {
			jugador.cobrar(MONTO_A_INCREMENTAR_SEGUNDA_VEZ);
			jugadoresGanadores.put(jugador, 2);
		}
		
	}

	
}