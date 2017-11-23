package fiuba.algo3.tp2.modelo.cubilete;

public class DadoCargado implements Lanzable {

	private int valor_mostrado;
	
	public DadoCargado(int valor_esperado) {
		//Crea un dado que saca siempre el mismo n�mero, sin limitaciones
		this.valor_mostrado = valor_esperado;
	}

	@Override
	public void lanzar() {}

	@Override
	public int obtenerValor() {
		return this.valor_mostrado;
	}

}
