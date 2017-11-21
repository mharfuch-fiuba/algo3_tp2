package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public abstract class Terreno extends Propiedad {
	
	protected Dinero alquilerTerreno;
	protected Construcciones construcciones;
	
	public Terreno(){
		this.construcciones=new Construcciones();
	}

	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		if(this.propietario.equals(jugador)) return;	//si sos propietario no pasa nada
		if(this.propietario.isNull())jugador.comprar(this); //si caes y esta libre compras
		else cobrarAlquiler(jugador);	//si hay propietario le pagas
	}
	
	private void cobrarAlquiler(Jugador jugador) throws DineroInsuficienteException{
		Dinero dineroACobrar = new DineroAlgoPoly(0);
		dineroACobrar.aumentarCantidad(this.alquilerTerreno);
		dineroACobrar.aumentarCantidad(this.construcciones.getAlquilerTotal());
		jugador.pagar(dineroACobrar);
		propietario.cobrar(dineroACobrar);
	}
	
	
	public abstract void construir() throws DineroInsuficienteException;
	
}
