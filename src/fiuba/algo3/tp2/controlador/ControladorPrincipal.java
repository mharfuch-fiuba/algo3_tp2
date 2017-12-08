package fiuba.algo3.tp2.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Intercambio;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.cubilete.DadoCubico;
import fiuba.algo3.tp2.modelo.encasillables.AvanceDinamico;
import fiuba.algo3.tp2.modelo.encasillables.Carcel;
import fiuba.algo3.tp2.modelo.encasillables.ImpuestoDeLujo;
import fiuba.algo3.tp2.modelo.encasillables.Policia;
import fiuba.algo3.tp2.modelo.encasillables.Quini6;
import fiuba.algo3.tp2.modelo.encasillables.RetrocesoDinamico;
import fiuba.algo3.tp2.modelo.encasillables.Salida;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles.TerrenoDoble;
import fiuba.algo3.tp2.modelo.excepciones.BancaRotaException;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.FaltaAdquirirParejaException;
import fiuba.algo3.tp2.modelo.excepciones.FaltanCasasException;
import fiuba.algo3.tp2.modelo.excepciones.NoHayMasMejorasException;
import fiuba.algo3.tp2.modelo.excepciones.NoPuedePagarFianzaException;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.vista.ContenedorPrincipal;
import fiuba.algo3.tp2.vista.animaciones.AnimacionAvanzar;
import fiuba.algo3.tp2.vista.animaciones.AnimacionRetroceder;
import fiuba.algo3.tp2.vista.pantallas.PantallaPartida;
import fiuba.algo3.tp2.vista.partida.turno.VistaAcciones;
import fiuba.algo3.tp2.vista.partida.turno.VistaTurnoInicial;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaAccion;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaCarcel;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaConstruir;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaPropiedadLibre;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaVenderObligatoriamente;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaVenderPropiedad;
import javafx.scene.paint.Color;

public class ControladorPrincipal {

	private static final int CANTIDAD_DE_DADOS = 2;
	private static final int DINERO_INICIAL = 30000;
	private static final int VELOCIDAD_ANIMACION = 200;

	private ControladorJugador jugador_actual;
	private ControladorTablero controlador_tablero;
	private ControladorCubilete controlador_cubilete;
	private VistaAcciones contenedor_acciones;
	private ArrayList<ControladorJugador> controladores_jugadores;
	private ControladorRonda controlador_ronda;

	private ControladorPrincipal() {
		System.out.println("CONSTRUCTOR CONTROLADOR PRINCIPAL");
		controladores_jugadores = new ArrayList<ControladorJugador>();
		Cubilete cubilete = new Cubilete();
		for (int i = 0; i < CANTIDAD_DE_DADOS; i++) {
			cubilete.agregar(new DadoCubico());
		}
		controlador_cubilete = new ControladorCubilete(cubilete);
		// INICIALIZAR TABLERO:
		controlador_tablero = new ControladorTablero();
		// INICIALIZAR RONDA
		controlador_ronda = new ControladorRonda(cubilete);
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

	private void iniciar_ronda() {
		System.out.println("INICIA RONDA...");
		jugador_actual = controlador_ronda.obtenerJugadorActual();
		contenedor_acciones.setJugadorActual(jugador_actual.getNombre(), jugador_actual.getColor());
		if (jugador_actual.estaEnCarcel())
			contenedor_acciones.colocarVistaCarcel();
		else
			contenedor_acciones.colocarVistaNormal();
	}

	public void intercambiar(Jugador destinatario, Propiedad entregada, Propiedad pedida) {
		// ESTO ES MEDIO LIO DEJEMOSLO PARA EL FINAL !!!
	}

	public void cambiarVistaAccion(VistaAccion vista_siguiente) {
		contenedor_acciones.colocarVista(vista_siguiente);
	}

	public ArrayList<Terreno> getTerrenos() {
		return this.jugador_actual.getTerrenos();
	}

	public void mostrarVistaDeEspera() {
		contenedor_acciones.colocarVistaDeEspera();
	}

	public ArrayList<Propiedad> getPropiedadesPropias() {
		return jugador_actual.getPropiedades();
	}
	
	public ArrayList<Propiedad> getPropiedadesAjenas() {
		ArrayList<Propiedad> propiedades = new ArrayList<Propiedad>();
		ArrayList<Jugador> jugadores = controlador_ronda.obtenerJugadores();
		for(Jugador jugador:jugadores) {
			if(jugador != this.jugador_actual.getModelo()) {
				for(Propiedad propiedad:jugador.getPropiedades()) {
					propiedades.add(propiedad);
				}
			}
		}
		return propiedades;
	}
/*
	public ArrayList<Jugador> getOtrosJugadores() {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		for (Jugador jugador : controlador_ronda.obtenerJugadores()) {
			if (jugador != this.jugador_actual.getModelo())
				jugadores.add(jugador);
		}
		return jugadores;
	}
*/
	public void reiniciarPartida() {

	}

	/* ACCIONES DE CADA BOTON */

	public void accionConstruir() {
		this.cambiarVistaAccion(new VistaConstruir());
	}

	public void accionConfirmarConstruir(Terreno terreno) {
		if (terreno == null)
			return;
		try {
			terreno.construir();
			contenedor_acciones.colocarVistaGenerica("Se ha construido en: " + terreno + ".", new VistaConstruir());
			return;
		} catch (DineroInsuficienteException e) {
			contenedor_acciones.colocarVistaGenerica("Dinero insuficiente.", new VistaConstruir());
			return;
		} catch (FaltaAdquirirParejaException e) {
			TerrenoDoble terreno_doble = (TerrenoDoble) terreno;
			contenedor_acciones.colocarVistaGenerica("Falta adquirir " + terreno_doble.getPareja() + ".",
					new VistaConstruir());
			return;
		} catch (FaltanCasasException e) {
			TerrenoDoble terreno_doble = (TerrenoDoble) terreno;
			contenedor_acciones.colocarVistaGenerica("Faltan casas en " + terreno_doble.getPareja() + ".",
					new VistaConstruir());
			return;
		} catch (NoHayMasMejorasException e) {
			contenedor_acciones.colocarVistaGenerica("No hay mas mejoras para " + terreno + ".", new VistaConstruir());
			return;
		}
	}

	public void accionVender() {
		this.cambiarVistaAccion(new VistaVenderPropiedad());
	}

	public void accionConfirmarVender(Propiedad propiedad) {
		if (propiedad == null)
			return;
		propiedad.vender();
		contenedor_acciones.colocarVistaGenerica("Vendiste " + propiedad + ".", new VistaVenderPropiedad());
		return;
	}

	public void accionConfirmarVenderObligatoriamente(Propiedad propiedad) {
		if (propiedad == null)
			return;
		propiedad.vender();
		this.accionAplicarEfecto();
		return;
	}

	public void accionLanzarDados() {
		controlador_cubilete.lanzar();
		contenedor_acciones.colocarVistaDados(controlador_cubilete.getVistasDados());
	}

	public void accionAvanzarSegunDados() {
		// this.avanzar(controlador_cubilete.sumarValores());
		int cant_casilleros = controlador_cubilete.sumarValores();
		new AnimacionAvanzar(cant_casilleros, VELOCIDAD_ANIMACION, jugador_actual, controlador_tablero);
	}

	public void accionMostrarEfecto() {

		Encasillable casillero_actual = jugador_actual.obtenerCasilleroActual();

		if (casillero_actual instanceof Propiedad) {
			Propiedad propiedad = (Propiedad) jugador_actual.obtenerCasilleroActual();
			if (propiedad.getPropietario().esNull()) {
				contenedor_acciones.colocarVistaPropiedadLibre(propiedad.toString(),
						propiedad.getPrecio().obtenerMontoEntero());
				return;
			}
			if (propiedad.getPropietario() == jugador_actual.getModelo()) {
				contenedor_acciones.colocarVistaPropiedadPropia();
				return;
			} else {
				contenedor_acciones.colocarVistaPropiedadAjena(propiedad.getPropietario().getNombre(),
						propiedad.getAlquiler(controlador_cubilete.getModelo()).obtenerMontoEntero());
				return;
			}
		}

		if (casillero_actual instanceof Carcel) {
			this.accionAplicarEfecto();
			// contenedor_acciones.colocarVistaCarcel();
			return;
		}

		if (casillero_actual instanceof ImpuestoDeLujo) {
			contenedor_acciones.colocarVistaImpuesto();
			return;
		}

		if (casillero_actual instanceof AvanceDinamico) {
			AvanceDinamico casillero = (AvanceDinamico) jugador_actual.obtenerCasilleroActual();
			int cant_casilleros = casillero.obtenerCantCasilleros(jugador_actual.getModelo(),
					controlador_cubilete.getModelo());
			contenedor_acciones.colocarVistaAvance(cant_casilleros);
			return;
		}

		if (casillero_actual instanceof RetrocesoDinamico) {
			RetrocesoDinamico casillero = (RetrocesoDinamico) jugador_actual.obtenerCasilleroActual();
			int cant_casilleros = casillero.obtenerCantCasilleros(jugador_actual.getModelo(),
					controlador_cubilete.getModelo());
			contenedor_acciones.colocarVistaRetroceso(cant_casilleros);
			return;
		}

		if (casillero_actual instanceof Salida) {
			contenedor_acciones.colocarVistaSalida();
			return;
		}

		if (casillero_actual instanceof Quini6) {
			Quini6 casillero = (Quini6) this.controlador_tablero.getModelo().getFactory().getQuini6();
			Dinero monto_ganado = casillero.obtenerPremio(jugador_actual.getModelo());
			contenedor_acciones.colocarVistaQuini(monto_ganado.obtenerMontoEntero());
			return;
		}

		if (casillero_actual instanceof Policia) {
			contenedor_acciones.colocarVistaPolicia();
			return;
		}

	}

	public void accionAplicarEfecto() {
		controlador_tablero.borrarJugador(jugador_actual);
		try {
			jugador_actual.aplicarEfectoDeCasilleroActual(controlador_cubilete.getModelo());
			controlador_tablero.dibujarJugador(jugador_actual);
			this.accionTerminarTurno();
			return;
		} catch (DineroInsuficienteException e) {
			System.out.println("DINERO INSUFICIENTE");
			contenedor_acciones.colocarVistaGenerica("Dinero insuficiente.", new VistaVenderObligatoriamente());
			controlador_tablero.dibujarJugador(jugador_actual);
			return;
		} catch (BancaRotaException e) {
			System.out.println("BANCA ROTA");
			this.expulsarJugador();
			return;
		}
	}

	public void accionComprar() {
		Propiedad propiedad = (Propiedad) jugador_actual.obtenerCasilleroActual();
		try {
			jugador_actual.comprar(propiedad);
		} catch (DineroInsuficienteException | BancaRotaException e) {
			contenedor_acciones.colocarVistaGenerica("Dinero Insuficiente!",
					new VistaPropiedadLibre(propiedad.toString(), propiedad.getPrecio().obtenerMontoEntero()));
			return;
		}
		this.accionTerminarTurno();
	}

	public void accionTerminarTurno() {
		controlador_ronda.avanzarTurno();
		jugador_actual = controlador_ronda.obtenerJugadorActual();
		this.iniciar_ronda();
	}

	public void accionPagarFianza() {
		try {
			jugador_actual.pagarFianza();
			contenedor_acciones.colocarVistaNormal();
			return;
		} catch (NoPuedePagarFianzaException e) {
			contenedor_acciones.colocarVistaGenerica("No se puede pagar la fianza\nen este turno.", new VistaCarcel());
			return;
		} catch (DineroInsuficienteException | BancaRotaException e) {
			contenedor_acciones.colocarVistaGenerica("Dinero insuficiente.", new VistaCarcel());
			return;
		}
	}

	public void accionRetrocesoDinamico(int cant_casilleros) {
		if (cant_casilleros == 0) {
			this.accionTerminarTurno();
			return;
		}
		new AnimacionRetroceder(cant_casilleros, VELOCIDAD_ANIMACION, jugador_actual, controlador_tablero);
	}

	public void accionAvanceDinamico(int cant_casilleros) {
		if (cant_casilleros == 0) {
			this.accionTerminarTurno();
			return;
		}
		new AnimacionAvanzar(cant_casilleros, VELOCIDAD_ANIMACION, jugador_actual, controlador_tablero);
	}

	public void accionIniciarTurno() {
		this.iniciar_ronda();
	}

	private void venderPropiedades(ArrayList<Propiedad> propiedades) {
		for (Propiedad propiedad : propiedades) {
			propiedad.vender();
		}
	}

	private void expulsarJugador() {
		this.venderPropiedades(jugador_actual.getPropiedades());
		Propiedad propiedad = (Propiedad) jugador_actual.obtenerCasilleroActual();
		Jugador propietario = propiedad.getPropietario();
		jugador_actual.getModelo().pagar(jugador_actual.getDinero());
		propietario.cobrar(jugador_actual.getDinero());
		controlador_ronda.quitarJugadorActual();
		if (controlador_ronda.contarJugadores() == 1) {
			contenedor_acciones.colocarVistaJugadorGanador(jugador_actual.getNombre());
			return;
		}
		contenedor_acciones.colocarVistaJugadorExpulsado(jugador_actual.getNombre());
		controlador_tablero.borrarJugador(jugador_actual);
		return;
	}

	public void accionProponerIntercambio() {
		contenedor_acciones.colocarVistaProponerIntercambio();
	}
/*
	public void accionProponerIntercambio(Propiedad propiedad, Jugador jugador) {
		contenedor_acciones.colocarVistaConfirmarIntercambio(propiedad, jugador);
	}
*/
/*
	public void accionIntercambiar(Propiedad propiedad_origen, Jugador jugador) {
		Intercambio intercambio = new Intercambio();
		intercambio.agregarPropiedadOrigen(propiedad);
		intercambio.agregarJugadorDestino(jugador);
		intercambio.agregarJugadorOrigen(jugador_actual.getModelo());
		contenedor_acciones.colocarVistaIntercambio(intercambio);
	}
*/

	public void accionConfirmarPropuesta(Propiedad propiedad_propia, Propiedad propiedad_ajena) {
		contenedor_acciones.colocarVistaConfirmarIntercambio(propiedad_propia, propiedad_ajena);
		
	}

	public void accionIntercambiar(Propiedad propiedad_propia, Propiedad propiedad_ajena) {
		Intercambio intercambio = new Intercambio(propiedad_propia, propiedad_ajena);
		intercambio.aceptarIntercambio();
		this.cambiarVistaAccion(new VistaTurnoInicial());
	}
	
}
