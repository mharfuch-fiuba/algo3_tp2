package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class BuenosAiresNorte extends Terreno implements Barrio{
	
	
	public BuenosAiresNorte() {
		precioCompra = new DineroAlgoPoly(25000);
		alquilerTerreno = new DineroAlgoPoly(2000);
	}

	@Override
	public void construir() throws DineroInsuficienteException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void comprar(Jugador jugador) throws DineroInsuficienteException {
		jugador.pagar(precioCompra);
		propietario = jugador;
		
	}

	public Inmobiliaria getInmobiliaria(){
		return null;
	}
	
	@Override
	public void informarBarrio() {
		
	}

}
