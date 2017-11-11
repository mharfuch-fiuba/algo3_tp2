package fiuba.algo3.tp2.modelo;

public class Dinero implements Comparable<Dinero> {

	private Double cantidad = (double) 0;
	
	@Override
	public int compareTo(Dinero otro) {
		return this.cantidad.compareTo(otro.getCantidad());
	}

	private Double getCantidad() {
		return this.cantidad;
	}
	
}
