package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.cubilete.Cubilete;
import fiuba.algo3.tp2.vista.partida.turno.VistaDado;

public class ControladorCubilete {
	
	private Cubilete cubilete;
	
	public ControladorCubilete(Cubilete cubilete){
		this.cubilete=cubilete;
	}
	
	public VistaDado getVistaDadoUno(){
		
		return new VistaDado(cubilete.getDado1());
	}
	
	public VistaDado getVistaDadoDos(){
		
		return new VistaDado(cubilete.getDado2());
	}

	public String getValor1(){
		return String.valueOf(cubilete.getDado1());
	}
	
	public String getValor2(){
		return String.valueOf(cubilete.getDado2());
	}
}
