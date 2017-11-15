package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.excepciones.DineroNegativoException;

import java.util.HashMap; 

public class Quini6 implements Encasillable{

	private DineroAlgoPoly MONTO_A_INCREMENTAR_PRIMERA_VEZ;
	private DineroAlgoPoly MONTO_A_INCREMENTAR_SEGUNDA_VEZ;
	
	private HashMap<Jugador, Integer> jugadoresGanadores = new HashMap<Jugador, Integer> ();

	public Quini6(){
		try {
			MONTO_A_INCREMENTAR_PRIMERA_VEZ = new DineroAlgoPoly(50000);
			MONTO_A_INCREMENTAR_SEGUNDA_VEZ = new DineroAlgoPoly(30000);
		} catch (DineroNegativoException e) {
			//ESTO NUNCA PUEDE OCURRIR
		}
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) {
		
		if(!jugadoresGanadores.containsKey(jugador)) {
			jugadoresGanadores.put(jugador, 0);
		}
		
		int cant_veces_que_gano = jugadoresGanadores.get(jugador);
		
		if(cant_veces_que_gano == 0) {
			jugador.agregarDinero(MONTO_A_INCREMENTAR_PRIMERA_VEZ);
			jugadoresGanadores.put(jugador, 1);
		}
		
		if(cant_veces_que_gano == 1) {
			jugador.agregarDinero(MONTO_A_INCREMENTAR_SEGUNDA_VEZ);
			jugadoresGanadores.put(jugador, 2);
		}
		
	}

}