package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class BuenosAiresSur extends Terreno {
	
	private Dinero costoCasa=new DineroAlgoPoly(5000);
	private Dinero alquilerCasa= new DineroAlgoPoly(1000);
	
	public BuenosAiresSur() {
		precioCompra = new DineroAlgoPoly(20000);
		alquilerTerreno = new DineroAlgoPoly(2000);
	}
	
	@Override
	public void construir() throws DineroInsuficienteException{
		Construccion construccion = new Construccion(costoCasa,alquilerCasa);
		construccion.comprar(this.propietario);
		this.construcciones.agregarConstruccion(construccion);
	}
	
	
	
}
