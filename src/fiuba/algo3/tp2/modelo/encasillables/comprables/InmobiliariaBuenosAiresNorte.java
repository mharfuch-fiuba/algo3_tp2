package fiuba.algo3.tp2.modelo.encasillables.comprables;

import java.util.Stack;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class InmobiliariaBuenosAiresNorte extends Inmobiliaria {
	/*
	 * aca pondria la logica de que se puede construir. hay que ver como hacer
	 * cuando uno vende casas (quizas un metodo demoler que agregue de nuevo esa
	 * construccion al stack)
	 * 
	 */

	public InmobiliariaBuenosAiresNorte() {
		this.construcciones = new Stack<Construccion>();
		Construccion primerCasa = new Construccion(new DineroAlgoPoly(5000), new DineroAlgoPoly(1000));
		Construccion segundaCasa = new Construccion(new DineroAlgoPoly(5000), new DineroAlgoPoly(500));
		construcciones.push(segundaCasa);
		construcciones.push(primerCasa);
	}

	@Override
	public void ofrecerHotel() {
		Construccion hotel = new Construccion(new DineroAlgoPoly(5000), new DineroAlgoPoly(500));
		construcciones.add(hotel);
	}

}
