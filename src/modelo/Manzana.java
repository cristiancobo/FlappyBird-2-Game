package modelo;

import java.awt.Rectangle;

public class Manzana extends Comodin {

	public Manzana(char tipo,  int posicionX, int posicionY) {
		super(tipo,  posicionX, posicionY);
		modificarImagen(Comodin.IMAGEN_MANZANA);
	
	}
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */
	
	/*
	 * (non-Javadoc)
	 * @see modelo.Comodin#movimientoComodin()
	 * metodo que mueve el comodin manzana su propiac velocidad
	 * 
	 */
	public void movimientoComodin(){
		modificarVelocidad(10);
		posicionX -= velocidad;
			if(posicionX < 0){
				super.reiniciarPosicionComodin();
				super.posicionAleatoriaComodin();
			}	
	}
	/*
	 * retorna cantidad de puntos que se le agrega al jugador
	 * @return valor el cual se le sumará al puntaje del jugador
	 */
	public int subirPuntos(){
		return 4;
	}
	
	
	
	
	
	
	
	

}
