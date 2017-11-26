package fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.Emparejable;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class TerrenoDoble extends Terreno implements Emparejable {
	
	private Propiedad pareja;

	public TerrenoDoble(Dinero precioTerreno, Dinero alquiler, Dinero alquilerCon1Casa, Dinero alquilerCon2Casas, Dinero alquilerConHotel, Dinero costoConstruccionCasa, Dinero costoConstruccionHotel) {
		super(precioTerreno);
		Construible hotel = new ConstruccionHotel(costoConstruccionHotel, alquilerConHotel);
		Construible duplex = new ConstruccionDuplex(costoConstruccionCasa, alquilerCon2Casas, hotel);
		Construible casa = new ConstruccionCasa(costoConstruccionCasa, alquilerCon1Casa, duplex);
		Construible baldio = new ConstruccionBaldio(alquiler, casa);
		this.setConstruccion(baldio);
	}
	
	@Override
	public void agregarPareja(Propiedad casillero) {
		pareja = casillero;
	}
	
	@Override
	public void construir() throws DineroInsuficienteException {
		Construible nueva_construccion = this.getConstruccion().construirSiguiente(this, pareja);
		this.getPropietario().pagar(nueva_construccion.getPrecioConstruccion());
		this.setConstruccion(nueva_construccion);
	}
	
	@Override
	public TerrenoDoble getPareja() {
		return (TerrenoDoble) pareja;
	}

}
