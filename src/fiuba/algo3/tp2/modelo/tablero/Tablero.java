package fiuba.algo3.tp2.modelo.tablero;

import fiuba.algo3.tp2.modelo.encasillables.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples.*;
import fiuba.algo3.tp2.utils.DoublyLinkedCircularList;
import fiuba.algo3.tp2.utils.DoublyLinkedCircularListIterator;

public class Tablero {

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

	public Tablero() {
		casilleros = new DoublyLinkedCircularList();
		Carcel carcel = new Carcel();

		Subte subte = new Subte();
		Tren tren = new Tren();
		Aysa aysa = new Aysa();
		Edesur edesur = new Edesur();
		BuenosAiresNorte buenosairesnorte = new BuenosAiresNorte();
		BuenosAiresSur buenosairessur = new BuenosAiresSur();
		CordobaNorte cordobanorte = new CordobaNorte();
		CordobaSur cordobasur = new CordobaSur();
		SaltaNorte saltanorte = new SaltaNorte();
		SaltaSur saltasur = new SaltaSur();

		casilleros.add(new Salida());
		casilleros.add(new Quini6());
		casilleros.add(buenosairessur);
		casilleros.add(edesur);
		casilleros.add(buenosairesnorte);
		casilleros.add(carcel);
		casilleros.add(cordobasur);
		casilleros.add(new AvanceDinamico());
		casilleros.add(subte);
		casilleros.add(cordobanorte);
		casilleros.add(new ImpuestoDeLujo());
		casilleros.add(new SantaFe());
		casilleros.add(aysa);
		casilleros.add(saltanorte);
		casilleros.add(saltasur);
		casilleros.add(new Policia(carcel));
		casilleros.add(tren);
		casilleros.add(new Neuquen());
		casilleros.add(new RetrocesoDinamico());
		casilleros.add(new Tucuman());

		tren.agregarPareja(subte);
		subte.agregarPareja(tren);
		aysa.agregarPareja(edesur);
		edesur.agregarPareja(aysa);
		buenosairesnorte.agregarPareja(buenosairessur);
		buenosairessur.agregarPareja(buenosairesnorte);
		cordobanorte.agregarPareja(cordobasur);
		cordobasur.agregarPareja(cordobanorte);
		saltanorte.agregarPareja(saltasur);
		saltasur.agregarPareja(saltanorte);
	}

	public IterTablero crearIterador() {
		return new IterTableroAlgoPoly();
	}
}
