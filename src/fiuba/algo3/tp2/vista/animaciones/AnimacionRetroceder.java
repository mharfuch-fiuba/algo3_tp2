package fiuba.algo3.tp2.vista.animaciones;

import fiuba.algo3.tp2.controlador.ControladorJugador;
import fiuba.algo3.tp2.controlador.ControladorPrincipal;
import fiuba.algo3.tp2.controlador.ControladorTablero;
import javafx.animation.AnimationTimer;

public class AnimacionRetroceder extends AnimationTimer {

	private ControladorJugador jugador_actual;
	private ControladorTablero controlador_tablero;
	private int iteraciones_restantes;
	private int tiempo_espera;
	
	public AnimacionRetroceder(int iteraciones_restantes, int tiempo_espera, ControladorJugador jugador_actual, ControladorTablero controlador_tablero) {
		this.iteraciones_restantes = iteraciones_restantes;
		this.tiempo_espera = tiempo_espera;
		this.jugador_actual = jugador_actual;
		this.controlador_tablero = controlador_tablero;
		ControladorPrincipal.getInstance().cambiar_vista_vacia();
		this.start();
	}
	
	private void finalizar() {
		this.stop();
		//ControladorPrincipal.getInstance().aplicar_efecto();
		ControladorPrincipal.getInstance().cambiar_vista_efecto();
	}
	
	private void delay() {
		try {
			Thread.sleep(tiempo_espera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handle(long arg0) {
		if(iteraciones_restantes <= 0) {
			this.finalizar();
			return;
		}
		controlador_tablero.borrarJugador(jugador_actual);
		jugador_actual.retroceder(1);
		controlador_tablero.dibujarJugador(jugador_actual);
		this.delay();
		this.iteraciones_restantes--;
	}
	
}
