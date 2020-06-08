package hilos;

import javax.swing.plaf.SliderUI;

import interfaz.InterfazGoBird;
import modelo.Juego;

public class HiloMoverComodin extends Thread {

	private InterfazGoBird principal;
	private Juego juego;
	
		public HiloMoverComodin(InterfazGoBird c, Juego j){
			principal =c;
			juego = j;
			
		}
		
		public void run() {
			while(true){
				juego.moverEnHiloComodin();
	
				try {
					sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				principal.refrescar();
				
			}
		}
	
}
