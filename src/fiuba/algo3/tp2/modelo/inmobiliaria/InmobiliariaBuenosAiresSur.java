package fiuba.algo3.tp2.modelo.inmobiliaria;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.construible.Construccion;
import fiuba.algo3.tp2.modelo.construible.Construcciones;

public class InmobiliariaBuenosAiresSur extends Inmobiliaria {

	public InmobiliariaBuenosAiresSur() {
		this.construcciones=new Construcciones();
		Construccion primerCasa = new Construccion(new DineroAlgoPoly(5000), new DineroAlgoPoly(1000));
		Construccion segundaCasa = new Construccion(new DineroAlgoPoly(5000), new DineroAlgoPoly(500));
		this.construcciones.agregarConstruccion(primerCasa);
		this.construcciones.agregarConstruccion(segundaCasa);
	}

	@Override
	public void ofrecerHotel() {
		Construccion hotel = new Construccion(new DineroAlgoPoly(8000), new DineroAlgoPoly(1500));
		construcciones.agregarConstruccion(hotel);
	}

}
