package modelo;

public class Veneno extends Descomodin {


	
	//CONSTANTES 
	
	
	//RELACIONES
	
	//ATRIBUTOS
	
	
	/*
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
	public Veneno(char tipo, int posicionX, int posicionY) {
		super(tipo, posicionX, posicionY);
		modificarImagen(IMAGEN_VENENO);
	}
	
	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
	
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */
	
	/*
	 * metodo que relentiza la velocidad de los tubos
	 * @return valor el cual disminuira la velocidad de los tubos
	 */
	public int  lentitudTubo(){
		return -2;
	}

}
