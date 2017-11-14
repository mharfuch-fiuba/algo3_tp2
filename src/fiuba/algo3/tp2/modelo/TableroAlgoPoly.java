package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import fiuba.algo3.tp2.modelo.encasillables.*;
import fiuba.algo3.tp2.modelo.encasillables.comprables.*;
import fiuba.algo3.tp2.utils.DoublyCircularList;
import fiuba.algo3.tp2.utils.ListaCircular;

public class TableroAlgoPoly extends Tablero{
	private Encasillable salida;
	private Carcel carcel;
	
	private ListaCircular<Encasillable> casilleros;
	//private ArrayList<Encasillable> casilleros;
	
	public TableroAlgoPoly(){
		casilleros = new ListaCircular<Encasillable>();
		//casilleros = new ArrayList<Encasillable>();
		this.salida=new Salida();
		this.carcel=new Carcel();
		
		casilleros.add(this.salida);
		casilleros.add(new Quini6());
		casilleros.add(new BuenosAiresSur());
		casilleros.add(new Edesur());
		casilleros.add(new BuenosAiresNorte());
		casilleros.add(this.carcel);
		casilleros.add(new CordobaSur());
		casilleros.add(new AvanceDinamico());
		casilleros.add(new Subte());
		casilleros.add(new CordobaNorte());
		casilleros.add(new ImpuestoDeLujo());
		casilleros.add(new SantaFe());
		casilleros.add(new Aysa());
		casilleros.add(new SaltaNorte());
		casilleros.add(new SaltaSur());
		casilleros.add(new Policia(this.carcel));
		casilleros.add(new Tren());
		casilleros.add(new Neuquen());
		casilleros.add(new RetrocesoDinamico());
		casilleros.add(new Tucuman());
	}

	@Override
	public IterTablero crearIterador() {
		return new IterTablero(this);
	}
	
	//TEMPORAL, DESPUES LO CAMBIO
	public ArrayList<Encasillable> obtenerListaCasilleros(){
		return casilleros;
	}
	
	public Encasillable getCasilleroDestino(Encasillable origen,int saltos){
		return this.casilleros.get(this.casilleros.indexOf(origen)+saltos);
	}
	
	public Encasillable getSalida(){
		return this.salida;
	}
}



