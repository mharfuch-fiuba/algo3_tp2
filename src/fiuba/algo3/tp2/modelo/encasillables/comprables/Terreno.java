package fiuba.algo3.tp2.modelo.encasillables.comprables;

public abstract class Terreno extends Propiedad implements Construible{

	protected Inmobiliaria inmobiliaria;
	
	
	public Inmobiliaria getInmobiliaria(){
		return this.inmobiliaria;
	}
	
	
}
