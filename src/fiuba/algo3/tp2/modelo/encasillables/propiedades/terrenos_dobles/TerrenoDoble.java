package fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_dobles;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Emparejable;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Terreno;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.Construccion;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionBaldio;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionCasa;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionDuplex;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.ConstruccionHotel;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.NoHayMasMejorasException;


public abstract class TerrenoDoble extends Terreno implements Emparejable {
	
	private Terreno pareja;

	public TerrenoDoble(Dinero precioTerreno, Dinero alquiler, Dinero alquilerCon1Casa, Dinero alquilerCon2Casas, Dinero alquilerConHotel, Dinero costoConstruccionCasa, Dinero costoConstruccionHotel) {
		super(precioTerreno);
		Construccion baldio = new ConstruccionBaldio(alquiler);
		Construccion casa = new ConstruccionCasa(costoConstruccionCasa, alquilerCon1Casa, baldio);
		Construccion duplex = new ConstruccionDuplex(costoConstruccionCasa, alquilerCon2Casas, casa);
		Construccion hotel = new ConstruccionHotel(costoConstruccionHotel, alquilerConHotel, duplex);
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
		try{
			Construccion nueva_construccion = this.getConstruccion().construirMejora(this, pareja);
			this.getPropietario().pagar(nueva_construccion.getPrecioConstruccion());
			this.setConstruccion(nueva_construccion);			
		}
		catch(NoHayMasMejorasException error){
			//No hago nada porque no hay mejoras
		}
	}

}
