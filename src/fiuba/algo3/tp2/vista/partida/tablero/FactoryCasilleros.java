package fiuba.algo3.tp2.vista.partida.tablero;

import fiuba.algo3.tp2.vista.partida.casillero.ContenedorCasillero;
import javafx.scene.paint.Color;


public class FactoryCasilleros {
	
	private ContenedorCasillero carcel;
	private ContenedorCasillero subte;
	private ContenedorCasillero tren;
	private ContenedorCasillero aysa;
	private ContenedorCasillero edesur;
	private ContenedorCasillero buenosairesnorte;
	private ContenedorCasillero buenosairessur;
	private ContenedorCasillero cordobanorte;
	private ContenedorCasillero cordobasur;
	private ContenedorCasillero saltanorte;
	private ContenedorCasillero saltasur;
	private ContenedorCasillero salida;
	private ContenedorCasillero quini6;
	private ContenedorCasillero avancedinamico;
	private ContenedorCasillero policia;
	private ContenedorCasillero santafe;
	private ContenedorCasillero impuestodelujo;
	private ContenedorCasillero neuquen;
	private ContenedorCasillero retrocesodinamico;
	private ContenedorCasillero tucuman;
	
	public FactoryCasilleros() {
		carcel = new ContenedorCasillero("Carcel", Color.ORANGE);
		subte = new ContenedorCasillero("Subte", Color.ORANGE);
		tren = new ContenedorCasillero("tren", Color.ORANGE);
		aysa = new ContenedorCasillero("aysa", Color.ORANGE);
		edesur = new ContenedorCasillero("edesur", Color.ORANGE);
		buenosairesnorte = new ContenedorCasillero("buenos aires norte", Color.ORANGE);
		buenosairessur = new ContenedorCasillero("buenos aires sur", Color.ORANGE);
		cordobanorte = new ContenedorCasillero("cordoba norte", Color.ORANGE);
		cordobasur = new ContenedorCasillero("cordoba sur", Color.ORANGE);
		saltanorte = new ContenedorCasillero("salta norte", Color.ORANGE);
		saltasur = new ContenedorCasillero("salta sur", Color.ORANGE);
		salida = new ContenedorCasillero("salida", Color.ORANGE);
		quini6 = new ContenedorCasillero("quini 6", Color.ORANGE);
		avancedinamico = new ContenedorCasillero("avance dinamico", Color.ORANGE);
		impuestodelujo = new ContenedorCasillero("impuesto de lujo", Color.ORANGE);
		santafe = new ContenedorCasillero("santa fe", Color.ORANGE);
		policia = new ContenedorCasillero("policia", Color.ORANGE);
		neuquen = new ContenedorCasillero("nququen", Color.ORANGE);
		retrocesodinamico = new ContenedorCasillero("retro", Color.ORANGE);
		tucuman = new ContenedorCasillero("tucu", Color.ORANGE);
	}

	public ContenedorCasillero getCarcel() {return carcel;}
	public ContenedorCasillero getSubte() {return subte;}
	public ContenedorCasillero getTren() {return tren;}
	public ContenedorCasillero getAysa() {return aysa;}
	public ContenedorCasillero getEdesur() {return edesur;}
	public ContenedorCasillero getBuenosAiresNorte() {return buenosairesnorte;}
	public ContenedorCasillero getBuenosAiresSur() {return buenosairessur;}
	public ContenedorCasillero getCordobaNorte() {return cordobanorte;}
	public ContenedorCasillero getCordobaSur() {return cordobasur;}
	public ContenedorCasillero getSaltaNorte() {return saltanorte;}
	public ContenedorCasillero getSaltaSur() {return saltasur;}
	public ContenedorCasillero getSalida() {return salida;}
	public ContenedorCasillero getQuini6() {return quini6;}
	public ContenedorCasillero getAvanceDinamico() {return avancedinamico;}
	public ContenedorCasillero getPolicia() {return policia;}
	public ContenedorCasillero getSantaFe() {return santafe;}
	public ContenedorCasillero getImpuestoDeLujo() {return impuestodelujo;}
	public ContenedorCasillero getNeuquen() {return neuquen;}
	public ContenedorCasillero getRestrocesoDinamico() {return retrocesodinamico;}
	public ContenedorCasillero getTucuman() {return tucuman;}

}

