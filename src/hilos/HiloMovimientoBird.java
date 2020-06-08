package hilos;

import interfaz.InterfazGoBird;

public class HiloMovimientoBird  extends Thread{
	
	
	//CONSTANTES

	//RELACIONES
	private InterfazGoBird principal;
	
	//ATRIBUTOS
	
	/*
	 * METODO CONSTRUCTOR DE LA CLASE.
	 */
	public HiloMovimientoBird(InterfazGoBird c){
		principal = c;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
	
			while(true){
				principal.darJuego().moverBird();
				try {
					sleep(20);
					principal.refrescar();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}

		}

}
