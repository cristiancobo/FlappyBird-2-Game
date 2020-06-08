package modelo;

public class Mina extends Descomodin {

	//CONSTANTES 
	
	
	//RELACIONES
	
	//ATRIBUTOS
	
	
	/*
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
	public Mina(char tipo, int posicionX, int posicionY) {
		super(tipo, posicionX, posicionY);
		modificarImagen(IMAGEN_MINA);
	}
	
	
	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
	
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */
	
	/*
	 * metodo que mueve al descomodin en el eje x
	 * 
	 */
	public void movimientoDescomodin(){
		modificarVelocidad(3);
		posicionX -= velocidad;
			if(posicionX < 0){
				super.reiniciarPosicionDescomodin();
				super.posicionAleatoriaDescomodin();
			}	
	}
	
	
}
