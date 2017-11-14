package fiuba.algo3.tp2.modelo;

public abstract class Tablero {

	public abstract IterTablero crearIterador();
	//INTENTAR SACAR:
	public abstract Encasillable getCasilleroDestino(Encasillable origen,int saltos);
	public abstract Encasillable getSalida();
	
}
