package fiuba.algo3.tp2.modelo.inmobiliaria;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.construible.Construccion;
import fiuba.algo3.tp2.modelo.construible.Construcciones;

public class InmobiliariaSaltaNorte extends Inmobiliaria {

	public InmobiliariaSaltaNorte() {
		this.construcciones=new Construcciones();
		Construccion primerCasa = new Construccion(new Dinero(4500), new Dinero(1250));
		Construccion segundaCasa = new Construccion(new Dinero(4500), new Dinero(600));
		this.construcciones.agregarConstruccion(primerCasa);
		this.construcciones.agregarConstruccion(segundaCasa);
		
	}

	@Override
	public void ofrecerHotel() {
		Construccion hotel = new Construccion(new Dinero(7500), new Dinero(1650));
		construcciones.agregarConstruccion(hotel);
	}

}
