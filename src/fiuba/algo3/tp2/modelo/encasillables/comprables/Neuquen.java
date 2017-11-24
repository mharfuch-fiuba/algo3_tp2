package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.inmobiliaria.InmobiliariaNeuquen;

public class Neuquen extends TerrenoAlgoPoly{
	
	public Neuquen() {
		this.inmobiliaria=new InmobiliariaNeuquen();
		this.precioCompra = new Dinero(17000);
		this.alquilerTerreno = new Dinero(1800);
	}


	
}
