package fiuba.algo3.tp2.modelo.inmobiliaria;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.construible.Construccion;
import fiuba.algo3.tp2.modelo.construible.Construcciones;

public class InmobiliariaCordobaNorte extends Inmobiliaria {

	public InmobiliariaCordobaNorte() {
		this.construcciones = new Construcciones();
		Construccion primerCasa = new Construccion(new Dinero(2200), new Dinero(500));
		Construccion segundaCasa = new Construccion(new Dinero(2200), new Dinero(1100));
		this.construcciones.agregarConstruccion(primerCasa);
		this.construcciones.agregarConstruccion(segundaCasa);
	}

	@Override
	public void ofrecerHotel() {
		Construccion hotel = new Construccion(new Dinero(3500), new Dinero(600));
		construcciones.agregarConstruccion(hotel);
	}
}
