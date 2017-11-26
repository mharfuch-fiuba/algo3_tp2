package fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.PropiedadNull;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.estrategias.EstrategiaDosServicios;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.estrategias.EstrategiaNula;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.estrategias.EstrategiaServicios;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.estrategias.EstrategiaUnServicio;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.YaTieneParejaException;

public abstract class Servicio extends Propiedad implements Emparejable {

	private EstrategiaServicios estrategia;
	private Propiedad pareja;
	
	public Servicio(Dinero precio_compra, int penalidad_1_servicio, int penalidad_2_servicios) {
		super(precio_compra);
		EstrategiaServicios estrategia_0 = new EstrategiaNula();
		EstrategiaServicios estrategia_1 = new EstrategiaUnServicio(this, penalidad_1_servicio, estrategia_0);
		EstrategiaServicios estrategia_2 = new EstrategiaDosServicios(this, penalidad_2_servicios, estrategia_1);
		estrategia = estrategia_2;
		pareja = new PropiedadNull();
	}
	
	private void realizarCobros(Jugador inquilino, Jugador propietario, int penalidad, Cubilete dados) throws DineroInsuficienteException {
		Dinero monto = new Dinero(penalidad * dados.sumarValores());
		inquilino.pagar(monto);
		propietario.cobrar(monto);
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		if(this.getPropietario() == jugador || this.getPropietario().esNull()) return;
		int penalidad = estrategia.getPenalidad();
		realizarCobros(jugador, this.getPropietario(), penalidad, dados);
		return;
	}
	
	@Override
	public void agregarPareja(Propiedad casillero) {
		if(!pareja.esNull()) throw new YaTieneParejaException();
		pareja = casillero;
	}
	
	@Override
	public Servicio getPareja() {
		return (Servicio) pareja;
	}
	
	@Override
	public boolean esNull() {
		return false;
	}
	
}
