package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

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
