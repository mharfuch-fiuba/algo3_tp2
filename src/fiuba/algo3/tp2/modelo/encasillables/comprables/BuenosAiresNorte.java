package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class BuenosAiresNorte extends Terreno implements Barrio{
	
	private BuenosAiresSur hermana;
	private Inmobiliaria inmobiliaria;
	
	public BuenosAiresNorte() {
		this.inmobiliaria = new InmobiliariaBuenosAiresNorte();
		precioCompra = new DineroAlgoPoly(25000);
		alquilerTerreno = new DineroAlgoPoly(2000);
	}

	
	public void agregarHermana(BuenosAiresSur hermana){
		this.hermana=hermana;
	}
	
	@Override
	public void comprar(Jugador jugador) throws DineroInsuficienteException {
		jugador.pagar(precioCompra);
		propietario = jugador;
		// esto falla si no hay hermana cuando se instancia
		if(this.hermana.obtenerPropietario().equals(jugador)) informarBarrio();
	}

	public Inmobiliaria getInmobiliaria(){
		return this.inmobiliaria;
	}
	
	@Override
	public void informarBarrio() {
		this.inmobiliaria.ofrecerHotel();
		this.hermana.getInmobiliaria().ofrecerHotel();
	}

}
