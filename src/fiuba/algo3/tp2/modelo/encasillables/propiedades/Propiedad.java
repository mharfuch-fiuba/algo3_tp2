package fiuba.algo3.tp2.modelo.encasillables.propiedades;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorNull;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.YaTienePropietarioException;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;

public abstract class Propiedad implements Encasillable {

	private Jugador propietario;
	private Dinero precio;

	public Propiedad(Dinero precio_compra) {
		propietario = new JugadorNull();
		precio = precio_compra;
	}

	public void setPropietario(Jugador nuevo_propietario) {
		propietario = nuevo_propietario;
	}
	
	public Jugador getPropietario() {
		return propietario;
	}

	public void comprar(Jugador jugador) throws DineroInsuficienteException {
		if(!propietario.esNull()) throw new YaTienePropietarioException();
		jugador.pagar(precio);
		propietario = jugador;
	}
	
	public Dinero getPrecio(){
		return precio;
	}
	
	public abstract boolean esNull();

}
