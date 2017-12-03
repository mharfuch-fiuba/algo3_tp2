package fiuba.algo3.tp2.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.*;
import fiuba.algo3.tp2.modelo.encasillables.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.modelo.excepciones.BancaRotaException;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.NoPuedePagarFianzaException;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.vista.partida.*;
import fiuba.algo3.tp2.vista.partida.ContenedorRonda;
import fiuba.algo3.tp2.vista.partida.tablero.ContenedorTablero;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaAccion;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaCarcel;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaMensajeGenerico;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPropiedadLibre;
import javafx.scene.paint.Color;

public class ControladorPrincipal {
	
	private static final int CANTIDAD_DE_DADOS = 2;
	private static final int DINERO_INICIAL = 100000;
	
	//private Tablero modelo_tablero;
	//private Ronda modelo_ronda;
	//private Cubilete cubilete;
	private ControladorJugador jugador_actual;
	private ControladorTablero controlador_tablero;
	private ControladorCubilete controlador_cubilete;
	//TODO: VER COMO LLEGA LA REFERENCIA DEL CONTENEDOR TURNO QUE MUESTRA LAS VISTAS QUE ARMAMOS EN PAPEL
	private VistaAcciones contenedor_acciones;
	private ContenedorRonda contenedor_ronda;
	private ArrayList<ControladorJugador> controladores_jugadores;
	private ControladorRonda controlador_ronda;
	private ContenedorDinamico contenedorDinamico;
	
	private ControladorPrincipal() {
		System.out.println("CONTSTRUCTOR CONTROLADOR PRINCIPAL");
		controladores_jugadores = new ArrayList<ControladorJugador>(); 
		//modelo_ronda = new RondaAlgoPoly();
		Cubilete cubilete = Cubilete.getInstance();
		for(int i = 0;i<CANTIDAD_DE_DADOS;i++) {
			cubilete.agregar(new DadoCubico());
			cubilete.agregar(new DadoCubico());
		}
		controlador_cubilete = new ControladorCubilete(cubilete);
		//INICIALIZAR TABLERO:
		controlador_tablero = new ControladorTablero();
		//modelo_tablero = controlador_tablero.getModelo();
		//INICIALIZAR RONDA
		controlador_ronda = new ControladorRonda();
		//modelo_ronda = controlador_ronda.getModelo();
		contenedor_ronda = new ContenedorRonda(controlador_ronda);
		
		//contenedorDinamico = new ContenedorDinamico(contenedor_ronda,contenedor_acciones);
		//TAL VEZ INICIALIZAR LOS CONTROLADORES DE
		// - CUBILETE
		// - TABLERO
	}
	
	private static final ControladorPrincipal INSTANCE = new ControladorPrincipal();
	 
	public static ControladorPrincipal getInstance() {
		return INSTANCE;
	}
	
	public void agregarJugadores(ArrayList<String> nombres) {
		System.out.println("AGREGANDO JUGADORES...");
		System.out.println(nombres);
		Collections.shuffle(nombres);
		System.out.println(nombres);
		Stack<Color> colores = new Stack<Color>();
		colores.push(Color.GREEN);
		colores.push(Color.RED);
		colores.push(Color.BLUE);
		for(String nombre:nombres) {
			ControladorJugador controlador_jugador = new ControladorJugador(controlador_tablero.getModelo(), nombre, new Dinero(DINERO_INICIAL), (Color) colores.pop());
			controlador_ronda.agregarJugador(controlador_jugador);
			System.out.println("Agrego : " + controlador_jugador.getNombre());
			controladores_jugadores.add(controlador_jugador);
		}
	}
	
	public void iniciar_partida(ContenedorPrincipal contenedor_principal) {
		System.out.println("INICIANDO PARTIDA...");
		//ESTO DIBUJA LA PARTIDA
		contenedor_acciones = new VistaAcciones();
		contenedor_acciones.colocarVistaNormal();
		PantallaPartida vistaPartida = new PantallaPartida(contenedor_principal, controlador_tablero.getVista(), contenedor_acciones, contenedor_ronda);
		
		//DIBUJAR A LOS JUGADORES EN EL TALBERO:
	    controlador_tablero.dibujarJugadores(controladores_jugadores);
	    
		this.iniciar_ronda();
	}
	
	public void iniciar_ronda() {
		System.out.println("INICIA RONDA...");
		jugador_actual = controlador_ronda.obtenerJugadorActual();
		System.out.println("El jugador actual es: " + jugador_actual.getNombre());
		//MOSTRAR NOMBRE DEL JUGADOR ACTUAL
		contenedor_acciones.setJugadorActual(jugador_actual.getNombre());
	}
	
	public void lanzar_dado() {
		controlador_cubilete.lanzar();
		contenedor_acciones.colocarVistaDados();
		//DIBUJAR VISTA DADOS, VER SI SE DIBUJA SOLA O LA DIBUJAMOS DESDE ACA
		//contenedor_turno.cambiarVistaDinamica(controlador_cubilete.getVista());
	}
	
	private void jugador_fuera_de_juego() {
		controlador_ronda.quitarJugador(jugador_actual);
		if(controlador_ronda.contarJugadores() == 1){
			//Dibujar vista ganador
			//contenedor_acciones.cambiarVistaDinamica(new VistaGanador());
		}
		//Dibujar vista jugador eliminado
		//contenedor_acciones.cambiarVistaDinamica(new VistaJugadorEliminado(jugador_actual.getNombre()));	
	}
	
	private void cambiar_vista_efecto() {
		if(jugador_actual.obtenerCasilleroActual() instanceof Propiedad) {
			Propiedad propiedad = (Propiedad) jugador_actual.obtenerCasilleroActual();
			if(propiedad.getPropietario().esNull()) {
				contenedor_acciones.colocarVistaPropiedadLibre();
				return;
			}
			if(propiedad.getPropietario() == jugador_actual.getModelo()) {
				contenedor_acciones.colocarVistaPropiedadPropia();
			} else {
				contenedor_acciones.colocarVistaPropiedadAjena();
			}
		}
		
		if(jugador_actual.obtenerCasilleroActual() instanceof Carcel) {
			contenedor_acciones.colocarVistaCarcel();
		}
		
		if(jugador_actual.obtenerCasilleroActual() instanceof ImpuestoDeLujo) {
			contenedor_acciones.colocarVistaImpuesto();
		}
		
		if(jugador_actual.obtenerCasilleroActual() instanceof AvanceDinamico) {
			contenedor_acciones.colocarVistaAvance();
		}
		
		if(jugador_actual.obtenerCasilleroActual() instanceof Salida) {
			contenedor_acciones.colocarVistaSalida();
		}
		
		if(jugador_actual.obtenerCasilleroActual() instanceof Quini6) {
			contenedor_acciones.colocarVistaQuini();
		}
		
		if(jugador_actual.obtenerCasilleroActual() instanceof Policia) {
			contenedor_acciones.colocarVistaPolicia();
		}
		
	}
	
	public void avanzar_segun_dados() {
		for(int i = 0; i < controlador_cubilete.getModelo().sumarValores(); i++) {
			controlador_tablero.borrarJugador(jugador_actual);
			jugador_actual.avanzar(1);
			controlador_tablero.dibujarJugador(jugador_actual);
			//ACTUALIZAR VISTA DE TABLERO
		}
		try {
			jugador_actual.aplicarEfectoDeCasilleroActual(controlador_cubilete.getModelo());
		}catch(DineroInsuficienteException e) {
			//DIBUJAR VISTA DINERO INSUFICIENTE
			//contenedor_acciones.cambiarVistaDinamica(new VistaDineroInsuficiente());
		} catch (BancaRotaException e) {
			jugador_fuera_de_juego();
		}
		
		this.cambiar_vista_efecto();
		
	}
	
	public void terminar_turno() {
		controlador_tablero.borrarJugador(jugador_actual);
		try {jugador_actual.aplicarEfectoDeCasilleroActual(controlador_cubilete.getModelo());}
		catch (DineroInsuficienteException e) {
			controlador_tablero.dibujarJugador(jugador_actual);
			//DEBERIA IR A UNA VISTA QUE LE PERMITA DEMOLER O VENDER
			//contenedor_acciones.cambiarVistaDinamica(new VistaDineroInsuficiente());
		}
		catch (BancaRotaException e) {
			jugador_fuera_de_juego();
		}
		controlador_tablero.dibujarJugador(jugador_actual);
		
		controlador_ronda.avanzarTurno();
		jugador_actual = controlador_ronda.obtenerJugadorActual();
		//Agrega el nombre del siguiente
		contenedor_acciones.setJugadorActual(jugador_actual.getNombre());
		
		contenedor_acciones.colocarVistaNormal(); // <-- DEPENDE SI ESTA EN LA CARCEL
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
		try {
			jugador_actual.pagarFianza();
		}catch(NoPuedePagarFianzaException e) {
			contenedor_acciones.colocarVistaGenerica(new VistaMensajeGenerico("No se puede pagar la fianza en este turno.", new VistaCarcel()));
			return;
		}
		contenedor_acciones.colocarVistaNormal();
	}

	public ContenedorTablero getVistaTablero() {
		return controlador_tablero.getVista();
	}

	public ContenedorDinamico getContenedorDinamico() {
		// TODO Auto-generated method stub
		return this.contenedorDinamico;
	}

	public ControladorCubilete getControladorDados() {
		// TODO Auto-generated method stub
		return this.controlador_cubilete;
	}

	public void cambiarVistaAccion(VistaAccion vista_siguiente) {
		contenedor_acciones.colocarVistaGenerica(vista_siguiente);	
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
