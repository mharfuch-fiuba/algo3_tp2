package fiuba.algo3.tp2.modelo.inmobiliaria;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.construible.Construccion;
import fiuba.algo3.tp2.modelo.construible.Construcciones;

public class InmobiliariaNeuquen extends Inmobiliaria {

	public InmobiliariaNeuquen(){
		this.construcciones=new Construcciones();
		Construccion casa = new Construccion(new Dinero(4800),new Dinero(2000));
		this.construcciones.agregarConstruccion(casa);
	}
	
	@Override
	public void ofrecerHotel() {
		//no hacer nada!
	}

}
