package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.encasillables.*;
import fiuba.algo3.tp2.modelo.encasillables.comprables.*;

public class TableroAlgoPoly extends Tablero{
	
	public TableroAlgoPoly(){
		casilleros.add(new Salida());
		casilleros.add(new Quini6());
		casilleros.add(new BuenosAiresSur());
		casilleros.add(new Edesur());
		casilleros.add(new BuenosAiresNorte());
		casilleros.add(new Carcel());
		casilleros.add(new CordobaSur());
		//ETCETERA
	}
	
}
