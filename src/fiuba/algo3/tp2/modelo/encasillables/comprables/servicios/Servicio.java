package fiuba.algo3.tp2.modelo.encasillables.comprables.servicios;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Propiedad;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class Servicio extends Propiedad implements Emparejable {

	private int penalidad_1;
	private int penalidad_2;
	private Propiedad pareja = null; // VER PATRON NULL
	
	public Servicio(Dinero precio_compra, int penalidad_1_servicio, int penalidad_2_servicios) {
		penalidad_1 = penalidad_1_servicio;
		penalidad_2 = penalidad_2_servicios;
		precioCompra = precio_compra;
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		//Si el propietario de este casillero es el mismo jugador no hago nada.
		if(propietario == jugador) return;
		//Si el propietario de este casillero es el mismo que el de la pareja entonces aplico la penalidad 2
		Jugador propietario_pareja = pareja.obtenerPropietario();
		if(propietario == propietario_pareja) {
			Dinero monto = new DineroAlgoPoly(penalidad_2 * dados.sumarValores());
			jugador.pagar(monto);
			propietario.cobrar(monto);
			return;
		}
		//Si el propietario de este casillero no es el mismo que el de la pareja entonces aplico la penalidad 1
		Dinero monto = new DineroAlgoPoly(penalidad_1 * dados.sumarValores());
		jugador.pagar(monto);
		propietario.cobrar(monto);
		return;
		//Si el propietario es nulo????
	}
	
	@Override
	public void agregarPareja(Propiedad casillero) {
		pareja = casillero;
	}
	
}
