package fiuba.algo3.tp2.modelo.encasillables;

import fiuba.algo3.tp2.modelo.Cubilete;
import fiuba.algo3.tp2.modelo.DadoCargado;
import fiuba.algo3.tp2.modelo.Encasillable;
import fiuba.algo3.tp2.modelo.Jugador;

public class AvanceDinamico implements Encasillable{


	@Override
	public void ejecutarEfecto(Jugador jugador, Cubilete dados) {
		int valor_obtenido = dados.sumarValores();
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(new DadoCargado(valor_obtenido - 2));
		jugador.avanzar(cubilete);
	}

}
