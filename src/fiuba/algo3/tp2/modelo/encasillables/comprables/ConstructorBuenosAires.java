package fiuba.algo3.tp2.modelo.encasillables.comprables;

public class ConstructorBuenosAires {
	
	private BuenosAiresSur sur;
	private BuenosAiresNorte norte;
	
	public ConstructorBuenosAires(){
		this.sur=new BuenosAiresSur();
		this.norte=new BuenosAiresNorte();
		sur.agregarHermana(norte);
		norte.agregarHermana(sur);
	}
	
	public BuenosAiresSur getSur(){
		return this.sur;
	}
	
	public BuenosAiresNorte getNorte(){
		return this.norte;
	}
	
}