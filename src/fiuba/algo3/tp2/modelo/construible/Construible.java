package fiuba.algo3.tp2.modelo.construible;

import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public interface Construible {
	
	public void construir() throws DineroInsuficienteException;
	
}
