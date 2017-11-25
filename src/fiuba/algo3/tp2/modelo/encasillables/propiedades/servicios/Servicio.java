package fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples.Propiedad;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class Servicio extends Propiedad implements Emparejable {

	private int penalidad_1;
	private int penalidad_2;
	private Propiedad pareja = null; // VER PATRON NULL
	
	public Servicio(Dinero precio_compra, int penalidad_1_servicio, int penalidad_2_servicios) {
		super(precio_compra);
		penalidad_1 = penalidad_1_servicio;
		penalidad_2 = penalidad_2_servicios;
		/*
		EstrategiaServicios estrategia_0 = new EstrategiaNula();
		EstrategiaServicios estrategia_1 = new EstrategiaUnservicio(this, pareja, penalidad_1_servicio, estrategia_0);
		EstrategiaServicios estrategia_2 = new EstrategiaUnservicio(this, pareja, penalidad_2_servicios, estrategia_1);
		new EstrategiaDosServicios(penalidad_2_servicios, )
		*/
		
	}
	
	private void realizarCobros(Jugador inquilino, Jugador propietario, int penalidad, Cubilete dados) throws DineroInsuficienteException {
		Dinero monto = new Dinero(penalidad * dados.sumarValores());
		inquilino.pagar(monto);
		propietario.cobrar(monto);
	}
	
	private int seleccionarPenalidad() {
		Jugador propietario_pareja = pareja.getPropietario();
		if(this.getPropietario() == propietario_pareja) {
			return penalidad_2;
		}
		return penalidad_1;
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		//Si el propietario de este casillero es el mismo jugador o null no hago nada.
		if(this.getPropietario() == jugador || this.getPropietario().esNull()) return;
		int penalidad = seleccionarPenalidad();
		realizarCobros(jugador, this.getPropietario(), penalidad, dados);
		return;
	}
	
	@Override
	public void agregarPareja(Propiedad casillero) {
		pareja = casillero;
	}
	
}
