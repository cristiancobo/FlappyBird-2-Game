package hilos;

import interfaz.InterfazGoBird;
import modelo.Juego;

public class HiloTemporizadorComodin extends Thread{
	
	
	//CONSTANTES
	
	//RELACIONES
	
	//ATRIBUTOS
	private InterfazGoBird principal;
	private Juego juego;
	
	/*
	 * METODO CONSTRUCTOR DE LA CLASE	
	 */
		public HiloTemporizadorComodin(InterfazGoBird c, Juego j){
			principal =c;
			juego = j;
		}
		
		@Override
		public void run() {
			while(true){
				juego.temporizarTiempoHiloComodin(1);
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				principal.refrescar();
			}
			
		}

}
