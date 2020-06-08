package hilos;

import interfaz.InterfazGoBird;
import modelo.Juego;

public class HiloPrincipal extends Thread{
	private InterfazGoBird principal;
	private Juego juego;
	
	public HiloPrincipal( InterfazGoBird c , Juego j){
		principal = c;
		juego = j;
	}
	
	@Override
	public void run() {
		while(!juego.juegoTerminado()){
			juego.cambiarPantallaFondo(principal.darPanelJuego());
		}
		principal.darHiloComodin().stop();
		principal.darHiloMoverComodin().stop();
		principal.darHiloMovimientoBird().stop();
		principal.darHiloTemporizadorComodin().stop();
		principal.darHiloDescomodin().stop();
		principal.darHiloMoverDescomodin().stop();
		principal.darHiloTemporizadorDescomodin().stop();
		principal.juegoTerminado();

	}
}
