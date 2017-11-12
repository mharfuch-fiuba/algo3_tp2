package fiuba.algo3.tp2.modelo;

public class JugadorHumano extends Jugador {
	
	//private static final double DINERO_INICIAL = 100000;
	private IterTablero posicion;
	private Dinero dinero;
	private int dias_de_carcel;
	
	public JugadorHumano(Tablero tablero, Dinero dinero_inicial) {
		this.posicion = tablero.crearIterador();
		this.dinero = dinero_inicial;
		this.dias_de_carcel = 0;
	}
	
	@Override
	public void avanzar(Cubilete cubilete) throws DineroInsuficienteException {
		if(dias_de_carcel != 0) {dias_de_carcel--; return;}//ESTO SE PUEDE HACER DE OTRA FORMA
		int cant_casilleros = cubilete.sumarValores();
		for(int i = 0; i < cant_casilleros; i++) {
			this.posicion.avanzar();
		}
		//EJECUTA EL EFECTO DEL CASILLERO:
		Encasillable casillero = posicion.verActual();
		casillero.ejecutarEfecto(this, cubilete);
	}

	@Override
	public Dinero obtenerDinero() {
		return this.dinero;
	}

	@Override
	public void incrementarDinero(Dinero monto) {
		this.dinero.aumentarCantidad(monto);
	}

	@Override
	public void comprarCasilleroActual() throws DineroInsuficienteException {
		Comprable casillero = (Comprable) posicion.verActual();
		casillero.comprar(this);
	}

	@Override
	public Encasillable obtenerCasilleroActual() {
		return posicion.verActual();
	}

	@Override
	public void disminuirCapital(Dinero monto) throws DineroInsuficienteException {
		try{
			dinero.disminuirCantidad(monto);
		}catch (DineroNegativoException e) {
			throw new DineroInsuficienteException();
		}
	}

	@Override
	public void aumentarCapital(Dinero monto) {
		dinero.aumentarCantidad(monto);
	}

	@Override
	public void pagarFianza() throws DineroInsuficienteException {
		if(dias_de_carcel != 2 && dias_de_carcel != 1) return;
		try {
			this.disminuirCapital(new Dinero(45000));
		} catch (DineroInsuficienteException e) {
			throw new DineroInsuficienteException();
		}
		dias_de_carcel = 0;
	}

	@Override
	public void encarcelar() {
		dias_de_carcel = 3;
	}
	
}
