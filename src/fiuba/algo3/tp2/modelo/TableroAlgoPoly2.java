package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.encasillables.AvanceDinamico;
import fiuba.algo3.tp2.modelo.encasillables.Carcel;
import fiuba.algo3.tp2.modelo.encasillables.ImpuestoDeLujo;
//import fiuba.algo3.tp2.modelo.encasillables.Policia;
import fiuba.algo3.tp2.modelo.encasillables.Quini6;
import fiuba.algo3.tp2.modelo.encasillables.RetrocesoDinamico;
import fiuba.algo3.tp2.modelo.encasillables.Salida;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Aysa;
import fiuba.algo3.tp2.modelo.encasillables.comprables.BuenosAiresNorte;
import fiuba.algo3.tp2.modelo.encasillables.comprables.BuenosAiresSur;
import fiuba.algo3.tp2.modelo.encasillables.comprables.CordobaNorte;
import fiuba.algo3.tp2.modelo.encasillables.comprables.CordobaSur;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Edesur;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Neuquen;
import fiuba.algo3.tp2.modelo.encasillables.comprables.SaltaNorte;
import fiuba.algo3.tp2.modelo.encasillables.comprables.SaltaSur;
import fiuba.algo3.tp2.modelo.encasillables.comprables.SantaFe;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Subte;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Tren;
import fiuba.algo3.tp2.modelo.encasillables.comprables.Tucuman;
import fiuba.algo3.tp2.utils.ListaCircular;

public class TableroAlgoPoly2 {
	private Casillero salida;
	private Casillero carcel;
	
	private ListaCircular<Casillero> casilleros;
	//private ArrayList<Encasillable> casilleros;
	
	public TableroAlgoPoly2(){
		casilleros = new ListaCircular<Casillero>();
		this.salida=new CasilleroAlgoPoly(new Salida());
		this.carcel=new CasilleroAlgoPoly(new Carcel());
		
		casilleros.add(this.salida);
		casilleros.add(new CasilleroAlgoPoly(new Quini6()));
		casilleros.add(new CasilleroAlgoPoly(new BuenosAiresSur()));
		casilleros.add(new CasilleroAlgoPoly(new Edesur()));
		casilleros.add(new CasilleroAlgoPoly(new BuenosAiresNorte()));
		casilleros.add(this.carcel);
		casilleros.add(new CasilleroAlgoPoly(new CordobaSur()));
		casilleros.add(new CasilleroAlgoPoly(new AvanceDinamico()));
		casilleros.add(new CasilleroAlgoPoly(new Subte()));
		casilleros.add(new CasilleroAlgoPoly(new CordobaNorte()));
		casilleros.add(new CasilleroAlgoPoly(new ImpuestoDeLujo()));
		casilleros.add(new CasilleroAlgoPoly(new SantaFe()));
		casilleros.add(new CasilleroAlgoPoly(new Aysa()));
		casilleros.add(new CasilleroAlgoPoly(new SaltaNorte()));
		casilleros.add(new CasilleroAlgoPoly(new SaltaSur()));
		//casilleros.add(new CasilleroAlgoPoly(new Policia(this.carcel)));
		casilleros.add(new CasilleroAlgoPoly(new Tren()));
		casilleros.add(new CasilleroAlgoPoly(new Neuquen()));
		casilleros.add(new CasilleroAlgoPoly(new RetrocesoDinamico()));
		casilleros.add(new CasilleroAlgoPoly(new Tucuman()));
	}
	
	public Casillero getCasilleroDestino(Casillero origen,int saltos){
		return this.casilleros.get(this.casilleros.indexOf(origen)+saltos);
	}
	
	public Casillero getSalida(){
		return this.salida;
	}

}
