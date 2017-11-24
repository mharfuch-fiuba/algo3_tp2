package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.terrenos_simples.Propiedad;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import fiuba.algo3.tp2.modelo.tablero.Tablero;
import javafx.scene.paint.Color;

public class JugadorHumano extends Jugador {

	private Movimiento movimiento;
	private Dinero dinero;
	private String nombre;
	private Color color;
	

	private ArrayList<Propiedad> propiedades;

	public JugadorHumano(Tablero tablero, Dinero dinero_inicial) {
		dinero = dinero_inicial;
		propiedades = new ArrayList<Propiedad>();
		this.movimiento = new Movimiento(tablero);
	}

	@Override
	public void avanzar(int cant_casilleros) throws JugadorEnCarcelException {
		this.movimiento.avanzar(cant_casilleros);		
	}

	@Override
	public void retroceder(int cant_casilleros) {
		for (int i = 0; i < cant_casilleros; i++) {
			this.movimiento.retroceder();
		}
	}

	@Override
	public Dinero obtenerDinero() {
		return this.dinero;
	}

	@Override
	public void cobrar(Dinero monto) {
		this.dinero.aumentarCantidad(monto);
	}

	public void comprar(Propiedad comprable) throws DineroInsuficienteException{
		comprable.comprar(this);
		this.propiedades.add(comprable);
	}

	@Override
	public Encasillable obtenerCasilleroActual() {
		return this.movimiento.verActual();
	}

	@Override
	public void pagarFianza() throws DineroInsuficienteException {	
		if (this.movimiento.getTurnosPendientesDeCarcel() == 3)	return;
		this.pagar(new Dinero(45000));
		this.movimiento.desencarcelar();
	}

	@Override
	public void encarcelar() {
		this.movimiento.encarcelar();
	}

	@Override
	public int getCantidadDePropiedades() {
		return propiedades.size();
	}

	@Override
	public void aplicarEfectoDeCasilleroActual(Cubilete cubilete) throws DineroInsuficienteException {
		Encasillable casillero = this.movimiento.verActual();
		casillero.aplicarEfecto(this, cubilete);
	}

	@Override
	public void avanzarHasta(Encasillable casillero) {
		this.movimiento.avanzarHasta(casillero);
	}

	@Override
	public Dinero pagar(Dinero monto) throws DineroInsuficienteException {
		this.dinero.disminuirCantidad(monto);
		return monto;
	}

	@Override
	public void disminuirDiasDeCarcel(){
		this.movimiento.disminuirDiasDeCarcel();
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public void comprarCasilleroActual() throws DineroInsuficienteException {
		Propiedad casillero_actual = (Propiedad) this.obtenerCasilleroActual();
		this.comprar(casillero_actual);
	}

	@Override
	public void entregarPropiedad(Jugador destinatario, Propiedad propiedad) {
		if(propiedades.contains(propiedad)) {
			destinatario.agregarPropiedad(propiedad);
			propiedades.remove(propiedad);
		}
	}

	@Override
	public void agregarPropiedad(Propiedad propiedad) {
		propiedades.add(propiedad);
		propiedad.setPropietario(this);
	}

	@Override
	public boolean esNull() {
		return false;
	}
	
	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	//Provisorio! Debería ir en constructor
	@Override
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	@Override
	public void setColor(Color color) {
		this.color=color;
		
	}
	
}
