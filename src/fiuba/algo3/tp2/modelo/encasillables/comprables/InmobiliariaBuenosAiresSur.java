package fiuba.algo3.tp2.modelo.encasillables.comprables;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class InmobiliariaBuenosAiresSur extends Inmobiliaria {

	public InmobiliariaBuenosAiresSur() {
		this.construcciones=new ArrayList<Construccion>();
		Construccion primerCasa = new Construccion(new DineroAlgoPoly(5000), new DineroAlgoPoly(1000));
		Construccion segundaCasa = new Construccion(new DineroAlgoPoly(5000), new DineroAlgoPoly(500));
		this.construcciones.add(primerCasa);
		this.construcciones.add(segundaCasa);
	}

	@Override
	public void ofrecerHotel() {
		Construccion hotel = new Construccion(new DineroAlgoPoly(8000), new DineroAlgoPoly(1500));
		construcciones.add(hotel);
	}

}
