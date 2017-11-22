package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class InmobiliariaCordobaNorte extends Inmobiliaria {

	public InmobiliariaCordobaNorte() {
		this.construcciones = new Construcciones();
		Construccion primerCasa = new Construccion(new DineroAlgoPoly(2200), new DineroAlgoPoly(500));
		Construccion segundaCasa = new Construccion(new DineroAlgoPoly(2200), new DineroAlgoPoly(1100));
		this.construcciones.agregarConstruccion(primerCasa);
		this.construcciones.agregarConstruccion(segundaCasa);
	}

	@Override
	public void ofrecerHotel() {
		Construccion hotel = new Construccion(new DineroAlgoPoly(3500), new DineroAlgoPoly(600));
		construcciones.agregarConstruccion(hotel);
	}
}
