package fiuba.algo3.tp2.modelo.encasillables.comprables;

public abstract class Inmobiliaria {

	/*
	 * No la saca de las pendientes. Llamar a este metodo 
	 * para ver si el jugador puede pagarla.
	 */
	public abstract Construccion verProximaConstruccion();
	
	/*
	 * La saca de las pendientes, por lo que antes de llamar a este
	 * el jugador tiene que comprarla.
	 */
	public abstract Construccion construir();
	
	/*
	 * Agrega hotel como opcion de construccion
	 */
	public abstract void ofrecerHotel();
	
}
