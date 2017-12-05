package fiuba.algo3.tp2.controlador;

import java.util.ArrayList;
import java.util.HashMap;

import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.modelo.tablero.FactoryEncasillables;
import fiuba.algo3.tp2.modelo.tablero.Tablero;
import fiuba.algo3.tp2.vista.partida.casillero.ContenedorCasillero;
import fiuba.algo3.tp2.vista.partida.casillero.VistaCasilleroJugador;
import fiuba.algo3.tp2.vista.partida.tablero.ContenedorTablero;
import fiuba.algo3.tp2.vista.partida.tablero.FactoryCasilleros;

public class ControladorTablero {

	private Tablero modelo_tablero;
	private ContenedorTablero vista_tablero;

	HashMap<Encasillable, ContenedorCasillero> casilleros;
	
	public ControladorTablero() {
		modelo_tablero = new Tablero();
		vista_tablero = new ContenedorTablero();
		casilleros = new HashMap<Encasillable, ContenedorCasillero>();
		FactoryEncasillables fmodelos = modelo_tablero.getFactory();
		FactoryCasilleros fvistas = vista_tablero.getFactory();
		//SE VINCULAN LOS MODELOS DE LOS CASILLEROS CON SUS RESPECTIVAS VISTAS
		casilleros.put(fmodelos.getBuenosAiresNorte(), fvistas.getBuenosAiresNorte());
		casilleros.put(fmodelos.getAvanceDinamico(), fvistas.getAvanceDinamico());
		casilleros.put(fmodelos.getAysa(), fvistas.getAysa());
		casilleros.put(fmodelos.getBuenosAiresSur(), fvistas.getBuenosAiresSur());
		casilleros.put(fmodelos.getCarcel(), fvistas.getCarcel());
		casilleros.put(fmodelos.getCordobaNorte(), fvistas.getCordobaNorte());
		casilleros.put(fmodelos.getCordobaSur(), fvistas.getCordobaSur());
		casilleros.put(fmodelos.getEdesur(), fvistas.getEdesur());
		casilleros.put(fmodelos.getImpuestoDeLujo(), fvistas.getImpuestoDeLujo());
		casilleros.put(fmodelos.getNeuquen(), fvistas.getNeuquen());
		casilleros.put(fmodelos.getPolicia(), fvistas.getPolicia());
		casilleros.put(fmodelos.getQuini6(), fvistas.getQuini6());
		casilleros.put(fmodelos.getRestrocesoDinamico(), fvistas.getRestrocesoDinamico());
		casilleros.put(fmodelos.getSalida(), fvistas.getSalida());
		casilleros.put(fmodelos.getSaltaNorte(), fvistas.getSaltaNorte());
		casilleros.put(fmodelos.getSaltaSur(), fvistas.getSaltaSur());
		casilleros.put(fmodelos.getSantaFe(), fvistas.getSantaFe());
		casilleros.put(fmodelos.getSubte(), fvistas.getSubte());
		casilleros.put(fmodelos.getTren(), fvistas.getTren());
		casilleros.put(fmodelos.getTucuman(), fvistas.getTucuman());
	}

	public void dibujarJugadores(ArrayList<ControladorJugador> jugadores) {
		for(ControladorJugador jugador: jugadores){
			dibujarJugador(jugador);
		}
	}
	
	public void borrarJugador(ControladorJugador controlador_jugador){
		Encasillable modelo_casillero_actual = controlador_jugador.getModelo().obtenerCasilleroActual();
		ContenedorCasillero vista_casillero_actual = casilleros.get(modelo_casillero_actual);
		VistaCasilleroJugador puntito = controlador_jugador.getVista();
		vista_casillero_actual.borrarJugador(puntito);
	}
	
	public void dibujarJugador(ControladorJugador controlador_jugador){
		Encasillable modelo_casillero_actual = controlador_jugador.getModelo().obtenerCasilleroActual();
		ContenedorCasillero vista_casillero_actual = casilleros.get(modelo_casillero_actual);
		VistaCasilleroJugador puntito = controlador_jugador.getVista();
		vista_casillero_actual.dibujarJugador(puntito);
		System.out.println(modelo_casillero_actual.toString());
		
		
		//ESTO DIBUJA OTRA COSA:
		//Encasillable modelo_casillero_actual = controlador_jugador.getModelo().obtenerCasilleroActual();
		//ContenedorCasillero vista_casillero_actual = casilleros.get(modelo_casillero_actual);
		//vista_casillero_actual.dibujarJugador(controlador_jugador.getVista());
	}

	//public Tablero getModelo() {
		//return modelo_tablero;
	//}

	public ContenedorTablero getVista() {
		return vista_tablero;
	}

	public Tablero getModelo() {
		return modelo_tablero;
	}
}
