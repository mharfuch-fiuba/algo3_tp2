package fiuba.algo3.tp2.modelo.encasillables.propiedades;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorNull;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.construibles.Construible;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.FaltaAdquirirParejaException;
import fiuba.algo3.tp2.modelo.excepciones.NoHayConstruccionesParaDemoler;


public abstract class Terreno extends Propiedad implements Edificable {
	
	private Construible construccion;
	private static final int PTJ_DE_REINTEGRO = 85;
	
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
	
	@Override
	public boolean demoler() {
		Dinero precio_construccion = construccion.getPrecioConstruccion();
		Dinero monto_a_cobrar = precio_construccion.obtenerPorcentaje(PTJ_DE_REINTEGRO);
		try {
			construccion = construccion.demoler();
		}catch(NoHayConstruccionesParaDemoler e) {
			return false;
		}
		this.getPropietario().cobrar(monto_a_cobrar);
		return true;
	}
	
	@Override
	public void vender() {
		Jugador propietario = this.getPropietario();
		Dinero precio_terreno = this.getPrecio();
		Dinero monto_a_cobrar = precio_terreno.obtenerPorcentaje(PTJ_DE_REINTEGRO);
		propietario.cobrar(monto_a_cobrar);
		while(this.demoler()) {}
		this.setPropietario(new JugadorNull());
		propietario.quitarPropiedad(this);
	}
	
}
