package fiuba.algo3.tp2.vista.partida.turno;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.encasillables.propiedades.Propiedad;
import fiuba.algo3.tp2.vista.botones.BotonAlgoPoly;
import fiuba.algo3.tp2.vista.botones.BotonVender;
import fiuba.algo3.tp2.vista.botones.eventos.BotonConstruirHandler;
import fiuba.algo3.tp2.vista.botones.eventos.BotonIntercambiarHandler;
import fiuba.algo3.tp2.vista.botones.eventos.BotonTirarDadosHandler;
import fiuba.algo3.tp2.vista.partida.turno.efectos.VistaAccion;

public class VistaTurnoInicial extends VistaAccion {

	private ArrayList<Propiedad> propiedades;
	
	public VistaTurnoInicial(ArrayList<Propiedad> propiedades){
		this.propiedades = propiedades;
		this.getChildren().addAll(construirBotones());
	}

	private BotonAlgoPoly[] construirBotones(){
		BotonAlgoPoly construir = new BotonAlgoPoly("Construir");
		construir.setOnAction(new BotonConstruirHandler());
		
		BotonVender vender = new BotonVender(propiedades);
		
		BotonAlgoPoly intercambiar = new BotonAlgoPoly("Intercambiar");
		intercambiar.setOnAction(new BotonIntercambiarHandler());
		
		BotonAlgoPoly tirarDados = new BotonAlgoPoly("Tirar Dados");
		tirarDados.setOnAction(new BotonTirarDadosHandler());
		
		BotonAlgoPoly[] botones = {construir,vender,intercambiar,tirarDados};
		return botones;
	}
}
