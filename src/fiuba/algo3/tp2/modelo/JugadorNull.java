package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.tablero.Encasillable;
import javafx.scene.paint.Color;

public class JugadorNull extends Jugador {

	@Override
	public Dinero obtenerDinero() {
		// TODO Auto-generated method stub
		return null;
	}

	public void comprarCasilleroActual() {
		// TODO Auto-generated method stub

	}

	@Override
	public Encasillable obtenerCasilleroActual() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void pagarFianza() {
		// TODO Auto-generated method stub

	}

	@Override
	public void encarcelar() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCantidadDePropiedades() {
		return 0;
	}

	@Override
	public void aplicarEfectoDeCasilleroActual(Cubilete cubilete) throws DineroInsuficienteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void pagar(Dinero monto) {
	}

	@Override
	public void avanzarHasta(Encasillable casillero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cobrar(Dinero monto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disminuirDiasDeCarcel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void avanzar(int cant_casilleros) {
		// TODO Auto-generated method stub

	}

	@Override
	public void retroceder(int cant_casilleros) {
		// TODO Auto-generated method stub

	}

	@Override
	public void comprar(Propiedad comprable) throws DineroInsuficienteException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public void entregarPropiedad(Jugador destinatario, Propiedad propiedad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarPropiedad(Propiedad propiedad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean esNull() {
		return true;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		
	}

}
