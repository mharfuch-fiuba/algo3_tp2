package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;
import java.util.HashMap; 

public class Quini6 implements Encasillable{

	static final Dinero MONTO_A_INCREMENTAR_PRIMERA_VEZ = new Dinero(50000);
	static final Dinero MONTO_A_INCREMENTAR_SEGUNDA_VEZ = new Dinero(30000);
	protected HashMap<Integer, Integer> jugadoresGanadores = new HashMap<Integer, Integer> ();
	
	public Quini6(){
		jugadoresGanadores.put(1,0);
		jugadoresGanadores.put(2,0);
		jugadoresGanadores.put(3,0);
		
	}
	
	@Override
	public void ejecutarEfecto(Jugador jugador, Cubilete dados) {
		int nombreJugador=jugador.getNombre();
		
		if(jugadoresGanadores.get(nombreJugador) == 0){
			jugador.incrementarDinero(MONTO_A_INCREMENTAR_PRIMERA_VEZ);
			jugadoresGanadores.put(nombreJugador,1); 
		} else if(jugadoresGanadores.get(nombreJugador) == 1){
			jugador.incrementarDinero(MONTO_A_INCREMENTAR_SEGUNDA_VEZ);
			jugadoresGanadores.put(nombreJugador, 2);
		}
	}

	
}