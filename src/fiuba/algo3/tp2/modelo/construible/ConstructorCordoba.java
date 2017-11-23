package fiuba.algo3.tp2.modelo.construible;

import fiuba.algo3.tp2.modelo.encasillables.comprables.CordobaNorte;
import fiuba.algo3.tp2.modelo.encasillables.comprables.CordobaSur;

public class ConstructorCordoba {

	private CordobaSur sur;
	private CordobaNorte norte;
	
	public ConstructorCordoba(){
		this.sur=new CordobaSur();
		this.norte=new CordobaNorte();
		sur.agregarVecino(norte);
		norte.agregarVecino(sur);
	}
	
	public CordobaSur getSur(){
		return this.sur;
	}
	public CordobaNorte getNorte(){
		return this.norte;
	}
	

}
