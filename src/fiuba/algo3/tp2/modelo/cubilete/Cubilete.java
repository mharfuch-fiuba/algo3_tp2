package fiuba.algo3.tp2.modelo.cubilete;

import java.util.ArrayList;

public class Cubilete {
	
	private ArrayList<Lanzable> dados;
	
    private static final Cubilete INSTANCE = new Cubilete();

    public static Cubilete getInstance() {
        return INSTANCE;
    }
		
    // El constructor privado/protected no permite que se genere un constructor por defecto.
	protected Cubilete() {
		this.dados = new ArrayList<Lanzable>();
	}
	
	public void vaciar(){
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
