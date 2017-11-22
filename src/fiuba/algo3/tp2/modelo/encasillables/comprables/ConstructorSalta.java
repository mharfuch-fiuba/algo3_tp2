package fiuba.algo3.tp2.modelo.encasillables.comprables;

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
