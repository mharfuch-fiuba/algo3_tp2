package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;
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
		if (this.propietario.equals(jugador))
			return; // si sos propietario no pasa nada
		if (this.propietario.isNull())
			jugador.comprar(this); // si caes y esta libre compras
		else
			cobrarAlquiler(jugador); // si hay propietario le pagas
	}

	private void cobrarAlquiler(Jugador jugador) throws DineroInsuficienteException {
		Dinero dineroACobrar = new DineroAlgoPoly(0);
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
