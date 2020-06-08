package hilos;

import interfaz.InterfazGoBird;
import modelo.Juego;

public class HiloComodin  extends Thread{
	
	private InterfazGoBird principal;
	private Juego juego;
	
	public HiloComodin(InterfazGoBird c, Juego j){
		principal =c;
		juego = j;
	}
	
	@Override
	public void run() {
		while(true){
			juego.generarComodin();
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			principal.refrescar();
			
		}
	}

}
