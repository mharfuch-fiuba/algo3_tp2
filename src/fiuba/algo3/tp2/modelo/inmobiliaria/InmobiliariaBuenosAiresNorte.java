package fiuba.algo3.tp2.modelo.inmobiliaria;


import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.construible.Construccion;
import fiuba.algo3.tp2.modelo.construible.Construcciones;

public class InmobiliariaBuenosAiresNorte extends Inmobiliaria {

	public InmobiliariaBuenosAiresNorte() {
		this.construcciones=new Construcciones();
		Construccion primerCasa = new Construccion(new DineroAlgoPoly(5500), new DineroAlgoPoly(1000));
		Construccion segundaCasa = new Construccion(new DineroAlgoPoly(5500), new DineroAlgoPoly(500));
		this.construcciones.agregarConstruccion(primerCasa);
		this.construcciones.agregarConstruccion(segundaCasa);
		
	}

	@Override
	public void ofrecerHotel() {
		Construccion hotel = new Construccion(new DineroAlgoPoly(9000), new DineroAlgoPoly(2000));
		construcciones.agregarConstruccion(hotel);
	}

}