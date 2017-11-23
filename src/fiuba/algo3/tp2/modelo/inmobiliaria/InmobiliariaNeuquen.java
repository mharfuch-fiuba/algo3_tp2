package fiuba.algo3.tp2.modelo.inmobiliaria;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.construible.Construccion;
import fiuba.algo3.tp2.modelo.construible.Construcciones;

public class InmobiliariaNeuquen extends Inmobiliaria {

	public InmobiliariaNeuquen(){
		this.construcciones=new Construcciones();
		Construccion casa = new Construccion(new DineroAlgoPoly(4800),new DineroAlgoPoly(2000));
		this.construcciones.agregarConstruccion(casa);
	}
	
	@Override
	public void ofrecerHotel() {
		//no hacer nada!
	}

}
