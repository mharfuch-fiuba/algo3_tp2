package fiuba.algo3.tp2.modelo;

public class Dinero implements Comparable<Dinero> {

	private Double cantidad;
	
	public Dinero(Double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int compareTo(Dinero otro) {
		return this.cantidad.compareTo(otro.getCantidad());
	}

	private Double getCantidad() {
		return this.cantidad;
	}

	public void agregarCantidad(Dinero monto) {
		this.cantidad += monto.getCantidad();
	}
	
}
