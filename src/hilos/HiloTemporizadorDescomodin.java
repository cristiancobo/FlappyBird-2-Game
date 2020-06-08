package hilos;

import interfaz.InterfazGoBird;
import modelo.Juego;

public class HiloTemporizadorDescomodin extends Thread {
	
	//CONSTANTES 
	
	
	//RELACIONES
	private Juego juego;
	private InterfazGoBird principal;
	
	//ATRIBUTOS
	
	
	/*
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
	public HiloTemporizadorDescomodin( InterfazGoBird c , Juego v) {
		principal = c;
		juego = v;
		
	}
	
	
	
	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
	
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */
	public void run() {
		while(true){
			juego.temporizarHiloDescomodin(1);
			try {
				sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			principal.refrescar();
		}
		

	}
	

}
