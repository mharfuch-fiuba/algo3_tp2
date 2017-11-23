package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.construible.Construible;
import fiuba.algo3.tp2.modelo.inmobiliaria.Inmobiliaria;

public abstract class Terreno extends Propiedad implements Construible{

	protected Inmobiliaria inmobiliaria;
	
	
	public Inmobiliaria getInmobiliaria(){
		return this.inmobiliaria;
	}
	
	
}
