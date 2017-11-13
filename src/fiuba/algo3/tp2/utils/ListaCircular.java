package fiuba.algo3.tp2.utils;

import java.util.ArrayList;


@SuppressWarnings("serial")
public class ListaCircular<Encasillable> extends ArrayList<Encasillable> {
	
	@Override
	public Encasillable get(int index) {
		if (index < 0)
			index = index + size();
		if (index>size()){
			index = index-size();
		}
		return super.get(index);
	}
	
}
