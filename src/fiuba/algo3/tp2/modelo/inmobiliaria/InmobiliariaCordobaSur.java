package fiuba.algo3.tp2.modelo.inmobiliaria;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.construible.Construccion;
import fiuba.algo3.tp2.modelo.construible.Construcciones;

public class InmobiliariaCordobaSur extends Inmobiliaria {

	public InmobiliariaCordobaSur(){
		this.construcciones=new Construcciones();
		Construccion primerCasa = new Construccion(new Dinero(2000), new Dinero(500));
		Construccion segundaCasa = new Construccion(new Dinero(2000), new Dinero(1000));
		this.construcciones.agregarConstruccion(primerCasa);
		this.construcciones.agregarConstruccion(segundaCasa);
	}
	@Override
	public void ofrecerHotel() {
		Construccion hotel = new Construccion(new Dinero(3000), new Dinero(500));
		construcciones.agregarConstruccion(hotel);
	}

}