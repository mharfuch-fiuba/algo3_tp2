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
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles.TerrenoDoble;
import fiuba.algo3.tp2.modelo.excepciones.BancaRotaException;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.FaltaAdquirirParejaException;
import fiuba.algo3.tp2.modelo.excepciones.FaltanCasasException;
import fiuba.algo3.tp2.modelo.excepciones.NoPuedePagarFianzaException;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.vista.animaciones.AnimacionAvanzar;
import fiuba.algo3.tp2.vista.animaciones.AnimacionRetroceder;
import fiuba.algo3.tp2.vista.pantallas.PantallaPartida;
import fiuba.algo3.tp2.vista.partida.*;
import fiuba.algo3.tp2.vista.partida.tablero.ContenedorTablero;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaAccion;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaCarcel;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaConstruir;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPropiedadLibre;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaVenderObligatoriamente;
import javafx.scene.paint.Color;

public class ControladorPrincipal {

	private static final int CANTIDAD_DE_DADOS = 2;
	private static final int DINERO_INICIAL = 100000;
	private static final int VELOCIDAD_ANIMACION = 200;

	private ControladorJugador jugador_actual;
	private ControladorTablero controlador_tablero;
	private ControladorCubilete controlador_cubilete;
	private VistaAcciones contenedor_acciones;
	private ArrayList<ControladorJugador> controladores_jugadores;
	private ControladorRonda controlador_ronda;
	private ContenedorDinamico contenedorDinamico;

	private ControladorPrincipal() {
		System.out.println("CONSTRUCTOR CONTROLADOR PRINCIPAL");
		controladores_jugadores = new ArrayList<ControladorJugador>();
		Cubilete cubilete = Cubilete.getInstance();
		for (int i = 0; i < CANTIDAD_DE_DADOS; i++) {
			cubilete.agregar(new DadoCubico());
			cubilete.agregar(new DadoCubico());
		}
		controlador_cubilete = new ControladorCubilete(cubilete);
		// INICIALIZAR TABLERO:
		controlador_tablero = new ControladorTablero();
		// INICIALIZAR RONDA
		controlador_ronda = new ControladorRonda();
		contenedor_acciones = new VistaAcciones();
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
		colores.push(Color.SEAGREEN);
		colores.push(Color.STEELBLUE);
		colores.push(Color.TOMATO);
		for (String nombre : nombres) {
			ControladorJugador controlador_jugador = new ControladorJugador(controlador_tablero.getModelo(), nombre,
					new Dinero(DINERO_INICIAL), colores.pop());
			controlador_jugador.asociarVista();
			controlador_ronda.agregarJugador(controlador_jugador);
			System.out.println("Agrego : " + controlador_jugador.getNombre());
			controladores_jugadores.add(controlador_jugador);
		}
	}

	public void iniciar_partida(ContenedorPrincipal contenedor_principal) {
		System.out.println("INICIANDO PARTIDA...");
		new PantallaPartida(contenedor_principal, controlador_tablero.getVista(), contenedor_acciones,
				controlador_ronda.getVistaRonda());
		controlador_tablero.dibujarJugadores(controladores_jugadores);
		this.controlador_tablero.asociarCasilleros();
		this.iniciar_ronda();
	}

	public void iniciar_ronda() {
		System.out.println("INICIA RONDA...");
		jugador_actual = controlador_ronda.obtenerJugadorActual();
		contenedor_acciones.setJugadorActual(jugador_actual.getNombre(), jugador_actual.getColor());
		if (jugador_actual.estaEnCarcel())
			contenedor_acciones.colocarVistaCarcel();
		else
			contenedor_acciones.colocarVistaNormal();
	}

	public void lanzar_dado() {
		controlador_cubilete.lanzar();
		contenedor_acciones.colocarVistaDados();
	}

	private void jugador_fuera_de_juego() {
		controlador_ronda.quitarJugador(jugador_actual);
		if (controlador_ronda.contarJugadores() == 1) {
			// Dibujar vista ganador
			// contenedor_acciones.cambiarVistaDinamica(new VistaGanador());
		}
		// Dibujar vista jugador eliminado
		// contenedor_acciones.cambiarVistaDinamica(new
		// VistaJugadorEliminado(jugador_actual.getNombre()));
	}

	public void cambiar_vista_efecto() {
		
		if (jugador_actual.obtenerCasilleroActual() instanceof Propiedad) {
			Propiedad propiedad = (Propiedad) jugador_actual.obtenerCasilleroActual();
			if (propiedad.getPropietario().esNull()) {
				contenedor_acciones.colocarVistaPropiedadLibre(propiedad.toString(), propiedad.getPrecio().obtenerMontoEntero());
				return;
			}
			if (propiedad.getPropietario() == jugador_actual.getModelo()) {
				contenedor_acciones.colocarVistaPropiedadPropia();
			} else {
				contenedor_acciones.colocarVistaPropiedadAjena(propiedad.getPropietario().getNombre(), propiedad.getAlquiler(controlador_cubilete.getModelo()).obtenerMontoEntero());
			}
		}

		if (jugador_actual.obtenerCasilleroActual() instanceof Carcel) {
			this.aplicar_efecto();
			contenedor_acciones.colocarVistaCarcel();
		}

		if (jugador_actual.obtenerCasilleroActual() instanceof ImpuestoDeLujo) {
			contenedor_acciones.colocarVistaImpuesto();
		}

		if (jugador_actual.obtenerCasilleroActual() instanceof AvanceDinamico) {	
			AvanceDinamico casillero = (AvanceDinamico) jugador_actual.obtenerCasilleroActual();
			int cant_casilleros = casillero.obtenerCantCasilleros(jugador_actual.getModelo(), controlador_cubilete.getModelo());
			//if(cant_casilleros == 0){this.terminar_turno();return;}
			contenedor_acciones.colocarVistaAvance(cant_casilleros);
		}

		if (jugador_actual.obtenerCasilleroActual() instanceof RetrocesoDinamico) {
			RetrocesoDinamico casillero = (RetrocesoDinamico) jugador_actual.obtenerCasilleroActual();
			int cant_casilleros = casillero.obtenerCantCasilleros(jugador_actual.getModelo(), controlador_cubilete.getModelo());
			//if(cant_casilleros == 0) {this.terminar_turno();return;}
			contenedor_acciones.colocarVistaRetroceso(cant_casilleros);
		}

		if (jugador_actual.obtenerCasilleroActual() instanceof Salida) {
			contenedor_acciones.colocarVistaSalida();
		}

		if (jugador_actual.obtenerCasilleroActual() instanceof Quini6) {
			Quini6 casillero = (Quini6) this.controlador_tablero.getModelo().getFactory().getQuini6();
			Dinero monto_ganado = casillero.obtenerPremio(jugador_actual.getModelo());
			contenedor_acciones.colocarVistaQuini(monto_ganado.obtenerMontoEntero());
		}

		if (jugador_actual.obtenerCasilleroActual() instanceof Policia) {
			contenedor_acciones.colocarVistaPolicia();
		}

	}

	public void aplicar_efecto() {
		if(jugador_actual.estaEnCarcel()) {this.terminar_turno(); return;}
		System.out.println("APLICA EFECTIO!");
		controlador_tablero.borrarJugador(jugador_actual);
		try {
			jugador_actual.aplicarEfectoDeCasilleroActual(controlador_cubilete.getModelo());
		} catch (DineroInsuficienteException e) {
			contenedor_acciones.colocarVistaGenerica("Dinero insuficiente.", new VistaVenderObligatoriamente());
			return;
		} catch (BancaRotaException e) {
			jugador_fuera_de_juego();
		}
		controlador_tablero.dibujarJugador(jugador_actual);
		this.terminar_turno();
	}

	public void terminar_turno() {
		controlador_ronda.avanzarTurno();
		jugador_actual = controlador_ronda.obtenerJugadorActual();
		this.iniciar_ronda();
	}

	public void construir(Terreno terreno) {
		try {
			terreno.construir();
			
		} catch (DineroInsuficienteException e) {
			contenedor_acciones.colocarVistaDineroInsuficiente();
		} catch (FaltaAdquirirParejaException e) {
			TerrenoDoble terreno_doble = (TerrenoDoble) terreno;
			contenedor_acciones.colocarVistaGenerica("Falta adquirir " + terreno_doble.getPareja(),
					new VistaConstruir());
			return;
		} catch (FaltanCasasException e) {
			TerrenoDoble terreno_doble = (TerrenoDoble) terreno;
			contenedor_acciones.colocarVistaGenerica("Faltan casas en " + terreno_doble.getPareja(),
					new VistaConstruir());
			return;
		}
		contenedor_acciones.colocarVistaNormal();
	}

	public void comprar() {
		Propiedad propiedad = (Propiedad) jugador_actual.obtenerCasilleroActual();
		try {
			jugador_actual.comprar(propiedad);
		} catch (DineroInsuficienteException e) {
			contenedor_acciones.colocarVistaGenerica("Dinero Insuficiente!", new VistaPropiedadLibre(propiedad.toString(), propiedad.getPrecio().obtenerMontoEntero()));
			return;
		} catch (BancaRotaException e) {
			contenedor_acciones.colocarVistaGenerica("Dinero Insuficiente!", new VistaPropiedadLibre(propiedad.toString(), propiedad.getPrecio().obtenerMontoEntero()));
			return;
		}
		terminar_turno();
		// ACTUALIZAR VISTA DINERO JUGADORES (PUEDE CAMBIAR LA PLATA)
	}

	public void vender(Propiedad propiedad) {
		System.out.println(propiedad.toString());
		propiedad.vender();
		contenedor_acciones.colocarVistaNormal();
		// ACTUALIZAR VISTA TABLERO (PODRIA LLEGAR A CAMBIAR LA CANTIDAD DE
		// CONSTRUCCIONES)
		// ACTUALIZAR VISTA JUGADORES (PUEDE CAMBIAR LA PLATA) no hace falta

	}

	public void intercambiar(Jugador destinatario, Propiedad entregada, Propiedad pedida) {
		// ESTO ES MEDIO LIO DEJEMOSLO PARA EL FINAL !!!
	}

	public void pagar_fianza() {
		try {
			jugador_actual.pagarFianza();
		} catch (NoPuedePagarFianzaException e) {
			contenedor_acciones.colocarVistaGenerica("No se puede pagar la fianza en este turno.", new VistaCarcel());
			return;
		} catch (DineroInsuficienteException e) {
			contenedor_acciones.colocarVistaGenerica("Dinero insuficiente.", new VistaCarcel());
			return;
		} catch (BancaRotaException e) {
			contenedor_acciones.colocarVistaGenerica("Dinero insuficiente.", new VistaCarcel());
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
		contenedor_acciones.colocarVista(vista_siguiente);
	}

	public int getCubilete() {
		return this.controlador_cubilete.getModelo().sumarValores();
	}

	public int getCantidadPropiedadesJugadorActual() {
		return this.controlador_ronda.obtenerJugadorActual().getCantidadPropiedades();
	}

	public int getCantidadEfectivoJugadorActual() {
		return this.controlador_ronda.obtenerJugadorActual().getCantidadEfectivo();
	}

	public ArrayList<Terreno> getTerrenos() {
		return this.jugador_actual.getTerrenos();
	}

	/*
	 * 
	 * ### VISTAS PRE DADOS:
	 * 
	 * NORMAL: - BOTON: CONSTRUIR - BOTON: VENDER - BOTON: INTERCAMBIAR - BOTON:
	 * DEMOLER - BOTON: TIRAR DADOS
	 * 
	 * CARCEL: - PASA A VISTA POSTDADOS CARCEL
	 * 
	 * ### VISTAS POST DADOS:
	 * 
	 * CARCEL: - MENSAJE: ENCARCELADO! - PAGAR FIANZA - TERMINAR TURNO
	 * 
	 * PROPIEDADES OCUPADAS (POR OTRO JUGADOR!!!): - MENSAJE: PAGA ALQUILER $$ -
	 * BOTON: PAGAR Y TERMINAR TURNO
	 * 
	 * PROPIEDADES LIBRES: - MENSAJE: PRECIO DE COMPRA $$ - BOTON: COMPRAR -
	 * BOTON: TERMINAR TURNO
	 * 
	 * IMPUESTO DE LUJO: - MENSAJE: IMPUESTO $$ - BOTON: PAGAR Y TERMINAR TURNO
	 * 
	 * AVANCE DINAMICO: - MENSAJE AVANZASTE N CASILLEROS - BOTON: TERMINAR TURNO
	 * 
	 * RETROCESO DINAMICO - MENSAJE: RETROCEDISTE N CASILLEROS - BOTON: TERMINAR
	 * TURNO
	 * 
	 * SALIDA - MENSAJE: EL CIRCULO DE LA VIDA - BOTON: TERMINAR TURNO
	 * 
	 * QUINI6 - MENSAJE: GANASTE $$!!! - BOTON: TERMINAR TURNO
	 * 
	 * POLICIA: - MENSAJE: A LA CARCEL!!! - BOTON: TERMINAR TURNO
	 * 
	 * DOBLE POR SEGUNDA VEZ: - MENSAJE: TRAMPOSO - BOTON: TERMINAR TURNO
	 * 
	 * ### VISTAS ESPECIALES ###
	 * 
	 * SALDO INSUFICIENTE: - MENSAJE DEBE VENDER ALGO PARA CONTINUAR EN JUEGO -
	 * BOTON: DEMOLER - BOTON: VENDER
	 * 
	 * JUGADOR ELIMINADO: - MENSAJE: JUGADOR HA SIDO ELIMINADO - BOTON:
	 * CONTINUAR
	 * 
	 * ESTARIA LINDO QUE CUANDO JUEGA UN JUGADOR LAS PROPIEDADES DE ESE JUGADOR
	 * APAREZCAN DE UN COLOR DISTINTO EN EL TABLERO
	 */

	public void avanzar(int cant_casilleros) {
		if(cant_casilleros == 0){this.terminar_turno();return;}
		new AnimacionAvanzar(cant_casilleros, VELOCIDAD_ANIMACION, jugador_actual, controlador_tablero);
	}

	public void avanzar_segun_dados() {
		this.avanzar(controlador_cubilete.sumarValores());
	}

	public void retroceder(int cant_casilleros) {
		if(cant_casilleros == 0){this.terminar_turno();return;}
		new AnimacionRetroceder(cant_casilleros, VELOCIDAD_ANIMACION, jugador_actual, controlador_tablero);
	}

	public void cambiar_vista_vacia() {
		contenedor_acciones.colocarVistaVacia();
	}

	public ArrayList<Propiedad> getPropiedades() {
		return jugador_actual.getPropiedades();
	}

}
