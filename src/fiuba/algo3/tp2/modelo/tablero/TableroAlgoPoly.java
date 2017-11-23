package fiuba.algo3.tp2.modelo.tablero;

import fiuba.algo3.tp2.modelo.construible.ConstructorBuenosAires;
import fiuba.algo3.tp2.modelo.construible.ConstructorCordoba;
import fiuba.algo3.tp2.modelo.construible.ConstructorSalta;
import fiuba.algo3.tp2.modelo.encasillables.*;
import fiuba.algo3.tp2.modelo.encasillables.comprables.*;
import fiuba.algo3.tp2.modelo.encasillables.comprables.servicios.Aysa;
import fiuba.algo3.tp2.modelo.encasillables.comprables.servicios.Edesur;
import fiuba.algo3.tp2.modelo.encasillables.comprables.servicios.Subte;
import fiuba.algo3.tp2.modelo.encasillables.comprables.servicios.Tren;
import fiuba.algo3.tp2.utils.DoublyLinkedCircularList;
import fiuba.algo3.tp2.utils.DoublyLinkedCircularListIterator;

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

	public TableroAlgoPoly() {
		casilleros = new DoublyLinkedCircularList();
		Carcel carcel = new Carcel();

		ConstructorBuenosAires constructorBuenosAires = new ConstructorBuenosAires(); 
		ConstructorCordoba constructorCordoba = new ConstructorCordoba();
		ConstructorSalta constructorSalta= new ConstructorSalta();

		Subte subte = new Subte();
		Tren tren = new Tren();
		Aysa aysa = new Aysa();
		Edesur edesur = new Edesur();

		casilleros.add(new Salida());
		casilleros.add(new Quini6());
		casilleros.add(constructorBuenosAires.getSur());
		casilleros.add(edesur);
		casilleros.add(constructorBuenosAires.getNorte());
		casilleros.add(carcel);
		casilleros.add(constructorCordoba.getSur());
		casilleros.add(new AvanceDinamico());
		casilleros.add(subte);
		casilleros.add(constructorCordoba.getNorte());
		casilleros.add(new ImpuestoDeLujo());
		casilleros.add(new SantaFe());
		casilleros.add(aysa);
		casilleros.add(constructorSalta.getNorte());
		casilleros.add(constructorSalta.getSur());
		casilleros.add(new Policia(carcel));
		casilleros.add(tren);
		casilleros.add(new Neuquen());
		casilleros.add(new RetrocesoDinamico());
		casilleros.add(new Tucuman());

		tren.agregarPareja(subte);
		subte.agregarPareja(tren);
		aysa.agregarPareja(edesur);
		edesur.agregarPareja(aysa);
	}

	@Override
	public IterTablero crearIterador() {
		return new IterTableroAlgoPoly();
	}
}
