package hilos;

import interfaz.InterfazGoBird;
import modelo.Juego;

public class HiloDescomodin extends Thread {
	
	//CONSTANTES 
	
	
	//RELACIONES
	private Juego juego;
	private InterfazGoBird principal;
	//ATRIBUTOS
	
	
	/*
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
	
	public HiloDescomodin(InterfazGoBird c , Juego v) {
		principal =c;
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
			juego.generarDescomodin();
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
