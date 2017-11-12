package fiuba.algo3.tp2.modelo;

public class DineroAlgoPoly extends Dinero {

	private int cantidad;
	
	public DineroAlgoPoly(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void aumentarCantidad(DineroAlgoPoly monto) {
		this.cantidad += monto.getCantidad();
	}

	public void disminuirCantidad(DineroAlgoPoly monto) throws DineroNegativoException {
		if(this.cantidad < monto.getCantidad()) throw new DineroNegativoException();
		this.cantidad -= monto.getCantidad();
	}
	
}
