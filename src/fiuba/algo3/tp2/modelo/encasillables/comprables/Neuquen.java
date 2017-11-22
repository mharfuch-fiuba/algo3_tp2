package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class Neuquen extends TerrenoAlgoPoly{
	
	public Neuquen() {
		this.inmobiliaria=new InmobiliariaNeuquen();
		this.precioCompra = new DineroAlgoPoly(17000);
		this.alquilerTerreno = new DineroAlgoPoly(1800);
	}


	
}
