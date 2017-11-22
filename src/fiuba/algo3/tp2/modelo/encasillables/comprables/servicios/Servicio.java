package fiuba.algo3.tp2.modelo.encasillables.comprables.servicios;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Propiedad;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.DineroNegativoException;

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
		DineroAlgoPoly monto;
		try {
			monto = new DineroAlgoPoly(penalidad_1 * dados.sumarValores());
			jugador.pagar(monto);
			propietario.cobrar(monto);
		} catch (DineroNegativoException e) {
			//ESTO NUNCA PUEDE OCURRIR
		}
	}
	
	@Override
	public void agregarPareja(Propiedad casillero) {
		pareja = casillero;
	}
	
}
