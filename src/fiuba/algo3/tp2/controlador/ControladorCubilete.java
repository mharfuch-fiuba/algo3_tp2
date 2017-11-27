package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.vista.partida.turno.VistaDado;

public class ControladorCubilete {
	
	private Cubilete cubilete;
	
	public ControladorCubilete(Cubilete cubilete){
		this.cubilete=cubilete;
	}
	
	public VistaDado getVistaDadoUno(){
		
		return new VistaDado(1);
	}
	
	public VistaDado getVistaDadoDos(){
		
		return new VistaDado(2);
	}

	
}
