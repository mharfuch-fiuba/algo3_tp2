package fiuba.algo3.tp2.modelo;

public class DadoCargado implements Lanzable {

	private int valor_mostrado;
	
	public DadoCargado(int valor_esperado) {
		//CREA UN DADO QUE SIEMPRE SACA EL MISMO NUMERO
		this.valor_mostrado = valor_esperado;
	}

	@Override
	public void lanzar() {}

	@Override
	public int obtenerValor() {
		return this.valor_mostrado;
	}

}
