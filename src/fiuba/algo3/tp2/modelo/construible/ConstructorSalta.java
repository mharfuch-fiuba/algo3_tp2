package fiuba.algo3.tp2.modelo.construible;

import fiuba.algo3.tp2.modelo.encasillables.comprables.SaltaNorte;
import fiuba.algo3.tp2.modelo.encasillables.comprables.SaltaSur;

public class ConstructorSalta {
	
	private SaltaSur sur;
	private SaltaNorte norte;
	
	public ConstructorSalta(){
		this.sur=new SaltaSur();
		this.norte=new SaltaNorte();
		this.sur.agregarVecino(norte);
		this.norte.agregarVecino(sur);
	}
	
	public SaltaSur getSur(){
		return this.sur;
	}
	
	public SaltaNorte getNorte(){
		return this.norte;
	}
}
