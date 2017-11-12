package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Cubilete {
	
	private ArrayList<Lanzable> dados;
	
	public Cubilete() {
		this.dados = new ArrayList<Lanzable>();
	}

	public void agregar(Lanzable dado) {
		this.dados.add(dado);
	}

	public void lanzar() {
		for(Lanzable dado:dados) {
			dado.lanzar();
		}
	}

	public int sumarValores() {
		int valores_sumados = 0;
		for(Lanzable dado:dados) {
			valores_sumados += dado.obtenerValor();
		}
		return valores_sumados;
	}
		
}
