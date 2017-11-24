package fiuba.algo3.tp2.modelo.inmobiliaria;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.construible.Construccion;
import fiuba.algo3.tp2.modelo.construible.Construcciones;

public class InmobiliariaSantaFe extends Inmobiliaria{

	public InmobiliariaSantaFe() {
		this.construcciones=new Construcciones();
		Construccion unicaCasa = new Construccion(new Dinero(4000), new Dinero(2000));
		this.construcciones.agregarConstruccion(unicaCasa);
	}
	
	@Override
	public void ofrecerHotel() {
		//no hacer nada!
	}

}
