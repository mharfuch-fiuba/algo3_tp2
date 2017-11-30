package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;

public class Intercambio {
	
	Propiedad propiedad;
	Dinero precio;

	public Intercambio(Propiedad propiedad, Dinero precio) {
		this.propiedad = propiedad;
		this.precio = precio;
	}

	public void aceptarIntercambio(Jugador destinatario) {
		Jugador propietario = propiedad.getPropietario();
		destinatario.pagar(precio);
		propietario.cobrar(precio);
		propietario.entregarPropiedad(destinatario, propiedad);
	}

}
