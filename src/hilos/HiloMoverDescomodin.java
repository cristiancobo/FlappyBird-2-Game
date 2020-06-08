package hilos;

import interfaz.InterfazGoBird;
import modelo.Juego;

public class HiloMoverDescomodin extends Thread {
	
	//CONSTANTES 
	
	
	//RELACIONES
	private Juego juego;
	private InterfazGoBird principal;
	
	//ATRIBUTOS
	
	
	/*
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
	public HiloMoverDescomodin( InterfazGoBird c , Juego v) {
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
			juego.moverEnHiloDescomodin();
			try {
				sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			principal.refrescar();
		}
		

	}
	

}
