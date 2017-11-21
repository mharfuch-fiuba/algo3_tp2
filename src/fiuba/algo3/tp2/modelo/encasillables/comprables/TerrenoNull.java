package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorNull;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;

public class TerrenoNull extends Terreno{
	
	public TerrenoNull(){
		this.propietario= new JugadorNull();
		this.inmobiliaria=new InmobiliariaNull();
	}
	
	@Override
	public void construir() throws DineroInsuficienteException {
		//no quiero implementar esto 
	}

	@Override
	public void aplicarEfecto(Jugador jugador, Cubilete dados) throws DineroInsuficienteException {
		//no quiero implementar esto
	}


	
}
