package fiuba.algo3.tp2.modelo.encasillables.comprables;


public abstract class Inmobiliaria {
	/*
	 * aca pondria la logica de que se puede construir. hay que ver como hacer
	 * cuando uno vende casas (quizas un metodo demoler que agregue de nuevo esa
	 * construccion al stack)
	 * 
	 */

	protected Construcciones construcciones;
	/*
	 * No la saca de las pendientes. Llamar a este metodo para ver si el jugador
	 * puede pagarla.
	 */
	public Construccion verProximaConstruccion() {
		return construcciones.verPrimera();
	}

	/*
	 * La saca de las pendientes, por lo que antes de llamar a este el jugador
	 * tiene que comprarla.
	 */
	public Construccion construir() {
		return construcciones.sacarPrimera();
	}

	/*
	 * Agrega hotel como opcion de construccion
	 */
	public abstract void ofrecerHotel();

}
