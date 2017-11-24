package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.construible.Construccion;
import fiuba.algo3.tp2.modelo.construible.Construcciones;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class TerrenoAlgoPoly extends Terreno{

	protected Dinero alquilerTerreno;
	private Construcciones construcciones;
	protected Terreno vecino;

	public TerrenoAlgoPoly() {
		this.construcciones = new Construcciones();
		this.vecino = new TerrenoNull();
	}

	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		// solo pasa algo si tiene dueno y es otro jugador
		if (! this.propietario.equals(jugador)) cobrarAlquiler(jugador);
		
	}

	private void cobrarAlquiler(Jugador jugador) throws DineroInsuficienteException {
		Dinero dineroACobrar = new Dinero(0);
		dineroACobrar.aumentarCantidad(this.alquilerTerreno);
		dineroACobrar.aumentarCantidad(this.construcciones.getAlquilerTotal());
		jugador.pagar(dineroACobrar);
		propietario.cobrar(dineroACobrar);
	}

	public void construir() throws DineroInsuficienteException {
		Construccion construccion = inmobiliaria.verProximaConstruccion();
		construccion.comprar(this.propietario);
		inmobiliaria.construir();
		this.construcciones.agregarConstruccion(construccion);
	}

	public void agregarVecino(Terreno vecino) {
		this.vecino = vecino;
	}

	@Override
	public void comprar(Jugador jugador) throws DineroInsuficienteException {
		jugador.pagar(precioCompra);
		propietario = jugador;
		if (this.vecino.obtenerPropietario().equals(jugador))
			informarBarrio();
	}

	public void informarBarrio() {
		this.inmobiliaria.ofrecerHotel();
		this.vecino.getInmobiliaria().ofrecerHotel();
	}

}
