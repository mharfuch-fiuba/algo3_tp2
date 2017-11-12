package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import fiuba.algo3.tp2.modelo.encasillables.*;
import fiuba.algo3.tp2.modelo.encasillables.comprables.*;
import fiuba.algo3.tp2.utils.DoublyCircularList;

public class TableroAlgoPoly extends Tablero{
	
	//private DoublyCircularList casilleros;
	private ArrayList<Encasillable> casilleros;
	
	public TableroAlgoPoly(){
		//casilleros = new DoublyCircularList();
		casilleros = new ArrayList<Encasillable>();
		casilleros.add(new Salida());
		casilleros.add(new Quini6());
		casilleros.add(new BuenosAiresSur());
		casilleros.add(new Edesur());
		casilleros.add(new BuenosAiresNorte());
		casilleros.add(new Carcel());
		casilleros.add(new CordobaSur());
		casilleros.add(new AvanceDinamico());
		casilleros.add(new Subte());
		casilleros.add(new CordobaNorte());
		casilleros.add(new ImpuestoDeLujo());
		casilleros.add(new SantaFe());
		casilleros.add(new Aysa());
		casilleros.add(new SaltaNorte());
		casilleros.add(new SaltaSur());
		casilleros.add(new Policia());
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
	
}
