package fiuba.algo3.tp2.modelo.encasillables.comprables;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.JugadorNull;
import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.modelo.excepciones.DineroInsuficienteException;
import fiuba.algo3.tp2.modelo.inmobiliaria.InmobiliariaNull;

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

	@Override
	public void comprar(Jugador jugador){
		//no quiero implementar esto

	}
	
}
