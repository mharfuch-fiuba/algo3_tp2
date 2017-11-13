package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.DineroNegativoException;

public class DineroAlgoPoly extends Dinero {

	private int cantidad;

	public DineroAlgoPoly(int cantidad) throws DineroNegativoException {
		if (cantidad < 0)
			throw new DineroNegativoException();
		this.cantidad = cantidad;
	}

	public int obtenerMontoEntero() {
		return this.cantidad;
	}

	public void aumentarCantidad(Dinero monto) {
		this.cantidad += monto.obtenerMontoEntero();
	}

	public void disminuirCantidad(Dinero monto) throws DineroInsuficienteException {
		if (this.cantidad < monto.obtenerMontoEntero())
			throw new DineroInsuficienteException();
		this.cantidad -= monto.obtenerMontoEntero();
	}

}
