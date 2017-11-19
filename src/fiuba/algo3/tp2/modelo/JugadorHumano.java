package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.excepciones.JugadorEnCarcelException;

public class JugadorHumano extends Jugador {

	private Movimiento movimiento;
	private Dinero dinero;
	

	private ArrayList<Comprable> propiedades;

	public JugadorHumano(Tablero tablero, Dinero dinero_inicial) {
		dinero = dinero_inicial;
		propiedades = new ArrayList<Comprable>();
		this.movimiento = new Movimiento(tablero);
	}

	public void agregarPropiedad(Comprable propiedad) {
		propiedades.add(propiedad);
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

	
	public void comprarCasilleroActual() throws DineroInsuficienteException {
		Comprable casillero = (Comprable) this.movimiento.verActual();	//No me gusta como esta resuelto esto.(Mateo)
		casillero.comprar(this);
		propiedades.add(casillero);
	}
	
	public void comprar(Comprable comprable) throws DineroInsuficienteException{
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
		this.pagar(new DineroAlgoPoly(45000));
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

}
