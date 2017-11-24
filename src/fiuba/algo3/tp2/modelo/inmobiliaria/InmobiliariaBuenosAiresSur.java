package fiuba.algo3.tp2.modelo.inmobiliaria;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.construible.Construccion;
import fiuba.algo3.tp2.modelo.construible.Construcciones;

public class InmobiliariaBuenosAiresSur extends Inmobiliaria {

	public InmobiliariaBuenosAiresSur() {
		this.construcciones=new Construcciones();
		Construccion primerCasa = new Construccion(new Dinero(5000), new Dinero(1000));
		Construccion segundaCasa = new Construccion(new Dinero(5000), new Dinero(500));
		this.construcciones.agregarConstruccion(primerCasa);
		this.construcciones.agregarConstruccion(segundaCasa);
	}

	@Override
	public void ofrecerHotel() {
		Construccion hotel = new Construccion(new Dinero(8000), new Dinero(1500));
		construcciones.agregarConstruccion(hotel);
	}

}
