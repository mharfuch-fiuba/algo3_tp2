package fiuba.algo3.tp2.modelo.inmobiliaria;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.construible.Construccion;
import fiuba.algo3.tp2.modelo.construible.Construcciones;

public class InmobiliariaSantaFe extends Inmobiliaria{

	public InmobiliariaSantaFe() {
		this.construcciones=new Construcciones();
		Construccion unicaCasa = new Construccion(new DineroAlgoPoly(4000), new DineroAlgoPoly(2000));
		this.construcciones.agregarConstruccion(unicaCasa);
	}
	
	@Override
	public void ofrecerHotel() {
		//no hacer nada!
	}

}
