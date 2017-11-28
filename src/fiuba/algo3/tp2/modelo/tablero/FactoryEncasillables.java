package fiuba.algo3.tp2.modelo.tablero;

import fiuba.algo3.tp2.modelo.encasillables.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples.*;

public class FactoryEncasillables {
	
	private Carcel carcel;
	private Subte subte;
	private Tren tren;
	private Aysa aysa;
	private Edesur edesur;
	private BuenosAiresNorte buenosairesnorte;
	private BuenosAiresSur buenosairessur;
	private CordobaNorte cordobanorte = new CordobaNorte();
	private CordobaSur cordobasur = new CordobaSur();
	private SaltaNorte saltanorte = new SaltaNorte();
	private SaltaSur saltasur = new SaltaSur();
	private Salida salida;
	private Quini6 quini6;
	private AvanceDinamico avancedinamico;
	private Policia policia;
	private SantaFe santafe;
	private ImpuestoDeLujo impuestodelujo;
	private Neuquen neuquen;
	private RetrocesoDinamico retrocesodinamico;
	private Tucuman tucuman;
	

	public FactoryEncasillables() {
		carcel = new Carcel();
		subte = new Subte();
		tren = new Tren();
		aysa = new Aysa();
		edesur = new Edesur();
		buenosairesnorte = new BuenosAiresNorte();
		buenosairessur = new BuenosAiresSur();
		cordobanorte = new CordobaNorte();
		cordobasur = new CordobaSur();
		saltanorte = new SaltaNorte();
		saltasur = new SaltaSur();
		salida = new Salida();
		quini6 = new Quini6();
		avancedinamico = new AvanceDinamico();
		impuestodelujo = new ImpuestoDeLujo();
		santafe = new SantaFe();
		policia = new Policia(carcel);
		neuquen = new Neuquen();
		retrocesodinamico = new RetrocesoDinamico();
		tucuman = new Tucuman();
		this.emparejar();
	}
	
	private void emparejar() {
		tren.setPareja(subte);
		subte.setPareja(tren);
		aysa.setPareja(edesur);
		edesur.setPareja(aysa);
		buenosairesnorte.setPareja(buenosairessur);
		buenosairessur.setPareja(buenosairesnorte);
		cordobanorte.setPareja(cordobasur);
		cordobasur.setPareja(cordobanorte);
		saltanorte.setPareja(saltasur);
		saltasur.setPareja(saltanorte);
	}

	public Encasillable getCarcel() {return carcel;}
	public Encasillable getSubte() {return subte;}
	public Encasillable getTren() {return tren;}
	public Encasillable getAysa() {return aysa;}
	public Encasillable getEdesur() {return edesur;}
	public Encasillable getBuenosAiresNorte() {return buenosairesnorte;}
	public Encasillable getBuenosAiresSur() {return buenosairessur;}
	public Encasillable getCordobaNorte() {return cordobanorte;}
	public Encasillable getCordobaSur() {return cordobasur;}
	public Encasillable getSaltaNorte() {return saltanorte;}
	public Encasillable getSaltaSur() {return saltasur;}
	public Encasillable getSalida() {return salida;}
	public Encasillable getQuini6() {return quini6;}
	public Encasillable getAvanceDinamico() {return avancedinamico;}
	public Encasillable getPolicia() {return policia;}
	public Encasillable getSantaFe() {return santafe;}
	public Encasillable getImpuestoDeLujo() {return impuestodelujo;}
	public Encasillable getNeuquen() {return neuquen;}
	public Encasillable getRestrocesoDinamico() {return retrocesodinamico;}
	public Encasillable getTucuman() {return tucuman;}

}
