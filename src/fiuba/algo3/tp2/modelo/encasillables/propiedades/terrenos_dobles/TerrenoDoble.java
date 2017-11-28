package fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Emparejable;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.*;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;


public abstract class TerrenoDoble extends Terreno implements Emparejable {
	
	private Terreno pareja;

	public TerrenoDoble(Dinero precioTerreno, Dinero alquiler, Dinero alquilerCon1Casa, Dinero alquilerCon2Casas, Dinero alquilerConHotel, Dinero costoConstruccionCasa, Dinero costoConstruccionHotel) {
		super(precioTerreno);
		Construible baldio = new ConstruccionBaldio(alquiler);
		Construible casa = new ConstruccionCasa(costoConstruccionCasa, alquilerCon1Casa, baldio);
		Construible duplex = new ConstruccionDuplex(costoConstruccionCasa, alquilerCon2Casas, casa);
		Construible hotel = new ConstruccionHotel(costoConstruccionHotel, alquilerConHotel, duplex);
		baldio.setMejora(casa);
		casa.setMejora(duplex);
		duplex.setMejora(hotel);
		this.setConstruccion(baldio);
	}
	
	@Override
	public void setPareja(Propiedad casillero) {
		pareja = (Terreno)casillero;
	}
	
	@Override
	public TerrenoDoble getPareja() {
		return (TerrenoDoble) pareja;
	}
	
	@Override
	public void construir() throws DineroInsuficienteException {
		Construible nueva_construccion = this.getConstruccion().construirMejora(this, pareja);
		this.getPropietario().pagar(nueva_construccion.getPrecioConstruccion());
		this.setConstruccion(nueva_construccion);
	}

}
