package fiuba.algo3.tp2.modelo;

public class Dinero {

	private double cantidad;
	
	public Dinero(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void aumentarCantidad(Dinero monto) {
		this.cantidad += monto.getCantidad();
	}

	public void disminuirCantidad(Dinero monto) throws DineroNegativoException {
		if(this.cantidad < monto.getCantidad()) throw new DineroNegativoException();
		this.cantidad -= monto.getCantidad();
	}
	
}
