package fiuba.algo3.tp2.vista.partida;

import javafx.scene.layout.VBox;

public class ContenedorTurno extends VBox {

	public ContenedorTurno(){
		VistaTurnoTitulo vistaTurnoTitulo=new VistaTurnoTitulo();
		System.out.println("AAA1");
		VistaTurnoDinamica vistaTurnoDinamica = new VistaTurnoDinamica();
		System.out.println("AAA2");
		this.getChildren().addAll(vistaTurnoTitulo,vistaTurnoDinamica);
	}
}
