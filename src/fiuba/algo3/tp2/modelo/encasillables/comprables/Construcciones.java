package fiuba.algo3.tp2.modelo.encasillables.comprables;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.Dinero;
import fiuba.algo3.tp2.modelo.DineroAlgoPoly;

public class Construcciones {
	
	private ArrayList<Construccion> construcciones;
	
	public Construcciones() {
		this.construcciones = new ArrayList<Construccion>();
	}
	
	public void agregarConstruccion(Construccion construccion){
		this.construcciones.add(construccion);
	}
	
	public void quitarConstruccion(Construccion construccion){
		this.construcciones.remove(construccion);
	}
	
	public Dinero getAlquilerTotal(){
		Dinero alquilerTotal=new DineroAlgoPoly(0);
		construcciones.forEach(construccion->alquilerTotal.aumentarCantidad(construccion.getAlquiler()));
		return alquilerTotal;
	}
	
	public Construccion verPrimera(){
		Construccion construccion;
		try{
			construccion = this.construcciones.get(0);
		}
		catch (Exception e){
			construccion = new ConstruccionNull();
		}
		return construccion;
	}
	
	public Construccion sacarPrimera(){
		Construccion construccion;
		try{
			construccion = this.construcciones.remove(0);
		}
		catch (Exception e){
			construccion = new ConstruccionNull();
		}
		return construccion;		
	}
	
}
