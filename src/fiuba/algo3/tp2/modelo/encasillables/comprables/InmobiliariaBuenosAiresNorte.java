package fiuba.algo3.tp2.modelo.encasillables.comprables;


import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class InmobiliariaBuenosAiresNorte extends Inmobiliaria {

	public InmobiliariaBuenosAiresNorte() {
		this.construcciones=new Construcciones();
		Construccion primerCasa = new Construccion(new DineroAlgoPoly(5500), new DineroAlgoPoly(3500));
		Construccion segundaCasa = new Construccion(new DineroAlgoPoly(5500), new DineroAlgoPoly(4000));
		this.construcciones.agregarConstruccion(primerCasa);
		this.construcciones.agregarConstruccion(segundaCasa);
		
	}

	@Override
	public void ofrecerHotel() {
		Construccion hotel = new Construccion(new DineroAlgoPoly(9000), new DineroAlgoPoly(2000));
		construcciones.agregarConstruccion(hotel);
	}

}
