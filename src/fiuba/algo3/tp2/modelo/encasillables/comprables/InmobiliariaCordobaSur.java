package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class InmobiliariaCordobaSur extends Inmobiliaria {

	public InmobiliariaCordobaSur(){
		this.construcciones=new Construcciones();
		Construccion primerCasa = new Construccion(new DineroAlgoPoly(2000), new DineroAlgoPoly(500));
		Construccion segundaCasa = new Construccion(new DineroAlgoPoly(2000), new DineroAlgoPoly(1000));
		this.construcciones.agregarConstruccion(primerCasa);
		this.construcciones.agregarConstruccion(segundaCasa);
	}
	@Override
	public void ofrecerHotel() {
		Construccion hotel = new Construccion(new DineroAlgoPoly(3000), new DineroAlgoPoly(500));
		construcciones.agregarConstruccion(hotel);
	}

}