package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.encasillables.*;
import fiuba.algo3.tp2.modelo.encasillables.comprables.*;
import fiuba.algo3.tp2.utils.DoublyLinkedCircularList;
import fiuba.algo3.tp2.utils.DoublyLinkedCircularList.DoublyLinkedCircularListIterator;

public class TableroAlgoPoly extends Tablero {

	public class IterTableroAlgoPoly implements IterTablero {

		private DoublyLinkedCircularListIterator iterador;

		public IterTableroAlgoPoly() {
			iterador = casilleros.iterator();
		}

		public Encasillable avanzar() {
			return (Encasillable) iterador.next();
		}

		public Encasillable retroceder() {
			return (Encasillable) iterador.prev();
		}

		public Encasillable verActual() {
			return (Encasillable) iterador.actual();
		}

		public void avanzarHasta(Encasillable casillero_destino) {
			for (int i = 0; i < iterador.size(); i++) {
				if (iterador.actual() == casillero_destino)
					return;
				iterador.next();
			}
		}

	}

	private DoublyLinkedCircularList casilleros;
	// private Salida salida;

	public TableroAlgoPoly() {
		casilleros = new DoublyLinkedCircularList();

		Carcel carcel = new Carcel();
		// salida = new Salida();

		// casilleros.add(salida);
		casilleros.add(new Salida());
		casilleros.add(new Quini6());
		casilleros.add(new BuenosAiresSur());
		casilleros.add(new Edesur());
		casilleros.add(new BuenosAiresNorte());
		casilleros.add(carcel);
		casilleros.add(new CordobaSur());
		casilleros.add(new AvanceDinamico());
		casilleros.add(new Subte());
		casilleros.add(new CordobaNorte());
		casilleros.add(new ImpuestoDeLujo());
		casilleros.add(new SantaFe());
		casilleros.add(new Aysa());
		casilleros.add(new SaltaNorte());
		casilleros.add(new SaltaSur());
		casilleros.add(new Policia(carcel));
		casilleros.add(new Tren());
		casilleros.add(new Neuquen());
		casilleros.add(new RetrocesoDinamico());
		casilleros.add(new Tucuman());
	}

	@Override
	public IterTablero crearIterador() {
		return new IterTableroAlgoPoly();
	}

	// TEMPORAL, DESPUES LO CAMBIO
	// public ArrayList<Encasillable> obtenerListaCasilleros(){
	// return casilleros;
	// }

	/*
	 * LOS METODOS QUE SIGUEN SE USAN UNICAMENTE PARA LOS TESTS, PROPONGO HACER
	 * LOS TESTS DE OTRA MANERA Y DESPUES SACARLOS
	 * 
	 * 
	 */

	// public Encasillable getCasilleroDestino(Encasillable origen,int saltos){
	// return this.casilleros.get(this.casilleros.indexOf(origen)+saltos);
	// }

	/*
	 * public Encasillable getCasilleroDestino(Encasillable origen,int saltos){
	 * DoublyLinkedCircularListIterator iterador = casilleros.iterator();
	 * //AVANZA EL ITERADOR HASTA ENCONTRAR EL ORIGEN while(origen !=
	 * iterador.actual()) { iterador.next(); } //AVANZA "SALTOS" CASILLEROS MAS
	 * for(int i = 0;i < saltos;i++) { iterador.next(); } return (Encasillable)
	 * iterador.actual(); }
	 * 
	 * public Encasillable getSalida(){ return this.salida; }
	 */

}
