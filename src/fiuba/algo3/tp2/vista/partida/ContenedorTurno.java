package fiuba.algo3.tp2.vista.partida;

import javafx.scene.layout.VBox;

public class ContenedorTurno extends VBox {

	public ContenedorTurno(){
		VistaTurnoTitulo vistaTurnoTitulo=new VistaTurnoTitulo();
		VistaTurnoDinamica vistaTurnoDinamica = new VistaTurnoDinamica();
		this.getChildren().addAll(vistaTurnoTitulo,vistaTurnoDinamica);
	}
}
