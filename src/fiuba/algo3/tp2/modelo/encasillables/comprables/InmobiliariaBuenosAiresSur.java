package fiuba.algo3.tp2.modelo.encasillables.comprables;

import java.util.Stack;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class InmobiliariaBuenosAiresSur extends Inmobiliaria {
	/*
	 * aca pondria la logica de que se puede construir.
	 * hay que ver como hacer cuando uno vende casas
	 * (quizas un metodo demoler que agregue de nuevo esa construccion al stack)
	 * 
	 */

	private Stack<Construccion> construcciones;

	
	public InmobiliariaBuenosAiresSur(){
		this.construcciones=new Stack<Construccion>();
		Construccion primerCasa=new Construccion(new DineroAlgoPoly(5000),new DineroAlgoPoly(1000));
		Construccion segundaCasa=new Construccion(new DineroAlgoPoly(5000),new DineroAlgoPoly(500));
		construcciones.push(segundaCasa);
		construcciones.push(primerCasa);
	}
	
	@Override
	public Construccion verProximaConstruccion() {
		return construcciones.peek();
	}

	@Override
	public Construccion construir() {
		return construcciones.pop();
	}
	
	@Override
	public void ofrecerHotel(){
		Construccion hotel=new Construccion(new DineroAlgoPoly(5000),new DineroAlgoPoly(500));
		construcciones.add(hotel);
	}

}
