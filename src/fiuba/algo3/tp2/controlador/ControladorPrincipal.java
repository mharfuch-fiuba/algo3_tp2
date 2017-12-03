package fiuba.algo3.tp2.controlador;

import java.util.ArrayList;
import java.util.Collections;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorHumano;
import fiuba.algo3.tp2.modelo.Ronda;
import fiuba.algo3.tp2.modelo.RondaAlgoPoly;
import fiuba.algo3.tp2.modelo.cubilete.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.modelo.excepciones.BancaRotaException;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.tablero.Tablero;
import fiuba.algo3.tp2.vista.partida.turno.ContenedorTurno;

public class ControladorPrincipal {
	
	private static final int CANTIDAD_DE_DADOS = 2;
	private static final int DINERO_INICIAL = 100000;
	
	private Ronda ronda;
	private Tablero tablero;
	private Cubilete cubilete;
	private Jugador jugador_actual;
	private ControladorTablero controlador_tablero;
	private ControladorCubilete controlador_cubilete;
	//TODO: VER COMO LLEGA LA REFERENCIA DEL CONTENEDOR TURNO QUE MUESTRA LAS VISTAS QUE ARMAMOS EN PAPEL
	private ContenedorTurno contenedor_acciones;
	
	public ControladorPrincipal() {
		ronda = new RondaAlgoPoly();
		tablero = new Tablero();
		cubilete = Cubilete.getInstance();
		for(int i = 0;i<CANTIDAD_DE_DADOS;i++) {
			cubilete.agregar(new DadoCubico());
			cubilete.agregar(new DadoCubico());
		}
		//TAL VEZ INICIALIZAR LOS CONTROLADORES DE
		// - CUBILETE
		// - TABLERO
	}
	
	public void agregarJugadores(ArrayList<String> nombres) {
		Collections.shuffle(nombres);
		for(String nombre:nombres) {
			Jugador jugador = new JugadorHumano(this.tablero, new Dinero(DINERO_INICIAL));
			ronda.agregarJugador(jugador);
			//FALTA ASOCIAR NOMBRE CON JUGADOR
		}
		
	}
	
	public void iniciar_partida() {
		jugador_actual = ronda.obtenerJugadorActual();
	    
		//DIBUJAR A LOS JUGADORES EN EL TALBERO ControladorTablero().update()
	}
	
	public void lanzar_dado() {
		cubilete.lanzar();
		//DIBUJAR VISTA DADOS, VER SI SE DIBUJA SOLA O LA DIBUJAMOS DESDE ACA
		//contenedor_turno.cambiarVistaDinamica(controlador_cubilete.getVista());
	}
	
	private void jugador_fuera_de_juego() {
		ronda.quitarJugador(jugador_actual);
		switch(ronda.contarJugadores()){
			case 1:
				//Dibujar vista ganador
				contenedor_acciones.cambiarVistaDinamica(new VistaGanador());
			break;
			default:
				//Dibujar vista jugador eliminado
				contenedor_acciones.cambiarVistaDinamica(new VistaJugadorEliminado(jugador_actual));
			break;
		}		
	}
	
	public void avanzar_segun_dados() {
		for(int i = 0; i < cubilete.sumarValores(); i++) {
			jugador_actual.avanzar(1);
			//ACTUALIZAR VISTA DE TABLERO
		}
		try {
			jugador_actual.aplicarEfectoDeCasilleroActual(cubilete);
		}catch(DineroInsuficienteException e) {
			//DIBUJAR VISTA DINERO INSUFICIENTE
			contenedor_acciones.cambiarVistaDinamica(new VistaDineroInsuficiente());
		} catch (BancaRotaException e) {
			jugador_fuera_de_juego();
		}
	}
	
	public void terminar_turno() {
		
			try {jugador_actual.aplicarEfectoDeCasilleroActual(cubilete);}
			catch (DineroInsuficienteException e) {
				//DEBERIA IR A UNA VISTA QUE LE PERMITA DEMOLER O VENDER
				contenedor_acciones.cambiarVistaDinamica(new VistaDineroInsuficiente());
			}
			catch (BancaRotaException e) {
				jugador_fuera_de_juego();
			}
		
		ronda.avanzarTurno();
		jugador_actual = ronda.obtenerJugadorActual();
		//ACTUALIZAR VISTA QUE MUESTRA AL JUGADOR ACTUAL
		//DEBERIA VOLVER A LA VISTA PREDADOS
	}
	
	public void construir(Terreno terreno) {
		try {terreno.construir();} catch(DineroInsuficienteException e) {
			//MOSTRAR MENSAJE DE ERROR, TAMBIEN PUEDE SALIR ALGUN MENSAJE RELACIONADO CON LAS PROPIEDADES PAREJA
		}
		//ACTUALIZAR VISTA TABLERO (CAMBIA LA CANTIDAD DE CONSTRUCCIONES)
		//ACTUALIZAR VISTA JUGADORES (PUEDE CAMBIAR LA PLATA)
	}
	
	public void demoler(Terreno terreno) {
		terreno.demoler();//ACA PUEDE SALTAR EXCEPCION
		//ACTUALIZAR VISTA TABLERO (CAMBIA LA CANTIDAD DE CONSTRUCCIONES)
		//ACTUALIZAR VISTA JUGADORES (PUEDE CAMBIAR LA PLATA)
	}
	
	public void comprar() {
		Propiedad propiedad = (Propiedad) jugador_actual.obtenerCasilleroActual();
		jugador_actual.comprar(propiedad);
		//ACTUALIZAR VISTA JUGADORES (PUEDE CAMBIAR LA PLATA)
	}
	
	public void vender(Terreno terreno) {
		terreno.vender();
		//ACTUALIZAR VISTA TABLERO (PODRIA LLEGAR A CAMBIAR LA CANTIDAD DE CONSTRUCCIONES)
		//ACTUALIZAR VISTA JUGADORES (PUEDE CAMBIAR LA PLATA) no hace falta
		
	}
	
	public void intercambiar(Jugador destinatario, Propiedad entregada, Propiedad pedida) {
		//ESTO ES MEDIO LIO DEJEMOSLO PARA EL FINAL !!!
	}
	
	public void pagar_fianza() {
		jugador_actual.pagarFianza();
		//LLEVA A VISTA PRE DADO NORMAL
	}
	
	/*
	  
	 	### VISTAS PRE DADOS:
	 
	 	NORMAL:
	 	- BOTON: CONSTRUIR
	 	- BOTON: VENDER
	 	- BOTON: INTERCAMBIAR
	 	- BOTON: DEMOLER
	 	- BOTON: TIRAR DADOS
	 	
	 	CARCEL:
	 	- PASA A VISTA POSTDADOS CARCEL
	 
		### VISTAS POST DADOS:
		
		CARCEL:
		- MENSAJE: ENCARCELADO!
		- PAGAR FIANZA
		- TERMINAR TURNO
		
		PROPIEDADES OCUPADAS (POR OTRO JUGADOR!!!):
		- MENSAJE: PAGA ALQUILER $$
		- BOTON: PAGAR Y TERMINAR TURNO
		
		PROPIEDADES LIBRES:
		- MENSAJE: PRECIO DE COMPRA $$
		- BOTON: COMPRAR
		- BOTON: TERMINAR TURNO
		
		IMPUESTO DE LUJO:
		- MENSAJE: IMPUESTO $$
		- BOTON: PAGAR Y TERMINAR TURNO
		
		AVANCE DINAMICO:
		- MENSAJE AVANZASTE N CASILLEROS
		- BOTON: TERMINAR TURNO
		
		RETROCESO DINAMICO
		- MENSAJE: RETROCEDISTE N CASILLEROS
		- BOTON: TERMINAR TURNO
		
		SALIDA
		- MENSAJE: EL CIRCULO DE LA VIDA
		- BOTON: TERMINAR TURNO
		
		QUINI6
		- MENSAJE: GANASTE $$!!!
		- BOTON: TERMINAR TURNO
		
		POLICIA:
		- MENSAJE: A LA CARCEL!!!
		- BOTON: TERMINAR TURNO
		
		DOBLE POR SEGUNDA VEZ:
		- MENSAJE: TRAMPOSO
		- BOTON: TERMINAR TURNO
		
		### VISTAS ESPECIALES ###
		
		SALDO INSUFICIENTE:
		- MENSAJE DEBE VENDER ALGO PARA CONTINUAR EN JUEGO
		- BOTON: DEMOLER
		- BOTON: VENDER
		
		JUGADOR ELIMINADO:
		- MENSAJE: JUGADOR HA SIDO ELIMINADO
		- BOTON: CONTINUAR
		
		ESTARIA LINDO QUE CUANDO JUEGA UN JUGADOR LAS PROPIEDADES DE ESE JUGADOR APAREZCAN DE UN COLOR DISTINTO EN EL TABLERO
	*/
	
}
