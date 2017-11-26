package fiuba.algo3.tp2.modelo.encasillables.propiedades;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.Construible;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.FaltaAdquirirParejaException;


public abstract class Terreno extends Propiedad implements Edificable {
	
	private Construible construccion;
	
	public Terreno(Dinero precio_compra) {
		super(precio_compra);
	}
	
	public void setConstruccion(Construible nueva_construccion) {
		construccion = nueva_construccion;
	}
	
	@Override
	public boolean esNull() {
		return false;
	}
	
	@Override
	public Construible getConstruccion() {
		return construccion;
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		if(this.getPropietario().esNull()) return;
		Dinero precio_alquiler = construccion.getAlquiler();
		jugador.pagar(precio_alquiler);
		this.getPropietario().cobrar(precio_alquiler);
	}

	public void quiereContruir(Terreno pareja) {
		if(pareja.getPropietario() != this.getPropietario()) throw new FaltaAdquirirParejaException(); 
	}
	
}
