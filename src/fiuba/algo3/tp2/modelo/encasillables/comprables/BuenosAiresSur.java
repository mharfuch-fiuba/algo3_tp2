package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class BuenosAiresSur extends Terreno implements Barrio {
	
	private BuenosAiresNorte hermana;
	private Inmobiliaria inmobiliaria;
	
	public BuenosAiresSur() {
		this.inmobiliaria=new InmobiliariaBuenosAiresSur();
		this.precioCompra = new DineroAlgoPoly(20000);
		this.alquilerTerreno = new DineroAlgoPoly(2000);
	}
	
	public void agregarHermana(BuenosAiresNorte hermana){
		this.hermana=hermana;
	}
	
	@Override
	public void informarBarrio(){
		this.inmobiliaria.ofrecerHotel();
		this.hermana.getInmobiliaria().ofrecerHotel();
	}
	
	@Override
	public void comprar(Jugador jugador) throws DineroInsuficienteException {
		// esto lo elevaria a Terreno, y para hacerlo habria que hacer una hermanaNull que 
		// devuelva JugadorNull a obtenerPropietario()
		jugador.pagar(precioCompra);
		propietario = jugador;
		// esto falla si no hay hermana cuando se instancia
		if(this.hermana.obtenerPropietario().equals(jugador)) informarBarrio();
	}
	
	public Inmobiliaria getInmobiliaria(){
		return this.inmobiliaria;
	}
	
	
	
}
