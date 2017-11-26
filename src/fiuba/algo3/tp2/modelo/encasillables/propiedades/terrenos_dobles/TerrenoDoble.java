package fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.*;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.Emparejable;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples.Edificable;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class TerrenoDoble extends Propiedad implements Edificable, Emparejable {
	
	private Propiedad pareja;
	private Construible construccion;

	public TerrenoDoble(Dinero precioTerreno, Dinero alquiler, Dinero alquilerCon1Casa, Dinero alquilerCon2Casas, Dinero alquilerConHotel, Dinero costoConstruccionCasa, Dinero costoConstruccionHotel) {
		super(precioTerreno);
		Construible hotel = new ConstruccionHotel(costoConstruccionHotel, alquilerConHotel, null);
		Construible duplex = new ConstruccionDuplex(costoConstruccionCasa, alquilerCon2Casas, hotel);
		Construible casa = new ConstruccionCasa(costoConstruccionCasa, alquilerCon1Casa, duplex);
		construccion = new ConstruccionBaldio(alquiler, casa);
	}
	
	@Override
	public void agregarPareja(Propiedad casillero) {
		pareja = casillero;
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		if(this.getPropietario().esNull()) return;
		Dinero precio_alquiler = construccion.getAlquiler();
		jugador.pagar(precio_alquiler);
		this.getPropietario().cobrar(precio_alquiler);
	}
	
	@Override
	public void construir() throws DineroInsuficienteException {
		Construible nueva_construccion = construccion.construirSiguiente(this, pareja);
		this.getPropietario().pagar(nueva_construccion.getPrecioConstruccion());
		construccion = nueva_construccion;
	}
	
	@Override
	public TerrenoDoble getPareja() {
		return (TerrenoDoble) pareja;
	}
	
	@Override
	public boolean esNull() {
		return false;
	}
	
	@Override
	public Construible getConstruccion() {
		return construccion;
	}

}
