package fiuba.algo3.tp2.modelo;

public class Dinero {

	private double cantidad;
	
	public Dinero(double cantidad) {
		this.cantidad = cantidad;
	}
	
	//MHHH!!!
	public boolean equals(Dinero otro) {
		return cantidad == otro.getCantidad();
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void aumentarCantidad(Dinero monto) {
		this.cantidad += monto.getCantidad();
	}

	public void disminuirCantidad(Dinero monto) {
		this.cantidad -= monto.getCantidad();
	}
	
}
