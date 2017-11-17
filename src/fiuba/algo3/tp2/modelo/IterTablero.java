package fiuba.algo3.tp2.modelo;

public interface IterTablero{
	public Encasillable avanzar();
	public Encasillable retroceder();
	public Encasillable verActual();
	public void avanzarHasta(Encasillable casillero_destino);
}
