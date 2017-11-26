package fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.Construccion;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionNull;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.Construible;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.servicios.Emparejable;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples.Edificable;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.PropietarioDeParejaNoEsElMismoException;

public abstract class TerrenoDoble extends Propiedad implements Edificable, Emparejable {
	
	private Propiedad pareja;
	private Construible construccion;

	public TerrenoDoble(Dinero precioTerreno, Dinero alquiler, Dinero alquilerCon1Casa, Dinero alquilerCon2Casas, Dinero alquilerConHotel, Dinero costoConstruccionCasa, Dinero costoConstruccionHotel) {
		super(precioTerreno);
		Construible hotel = new Construccion(alquilerConHotel, new Dinero(0),  new ConstruccionNull(alquilerConHotel));
		Construible casa2 = new Construccion(alquilerCon2Casas, costoConstruccionHotel,  hotel);
		Construible casa1 = new Construccion(alquilerCon1Casa, costoConstruccionCasa, casa2);
		construccion = new Construccion(alquiler, costoConstruccionCasa, casa1);
	}
	
	@Override
	public void agregarPareja(Propiedad casillero) {
		pareja = casillero;
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		Dinero precio_alquiler = construccion.getAlquiler();
		jugador.pagar(precio_alquiler);
		this.getPropietario().cobrar(precio_alquiler);
	}
	
	@Override
	public void construir() throws DineroInsuficienteException {
		if(pareja.getPropietario() != this.getPropietario()) throw new PropietarioDeParejaNoEsElMismoException();
		this.getPropietario().pagar(construccion.getPrecioMejora());
		construccion = construccion.getSiguienteConstruccion();
	}
	
	@Override
	public TerrenoDoble getPareja() {
		return (TerrenoDoble) pareja;
	}

}
