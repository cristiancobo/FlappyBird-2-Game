package modelo;

import java.awt.Rectangle;
import java.rmi.RemoteException;

import interfaz.PanelJuego;

public class Bird {
	
	
	//CONSTANTES
		public static final int BIRD_LIMITE = 40;
		public static final int POSICION_X = PanelJuego.ANCHURA_JUEGO/2 - BIRD_LIMITE/2;
		public static final int POSICION_Y = PanelJuego.AlTURA_JUEGO/2;
		public static final int ALTURA_AREA_BIRD = 50;
		public static final int ANCHO_AREA_BIRD = 50;
		
		
	//RELACIONES
		
	//ATRIBUTOS
	private int posicionX; 
	private int posicionY;
	private String imagenBird;
	private int velocidad;
	private int aceleracion;
	private Rectangle area;
	
		
	/*
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
		
	public Bird(){
		
		/*
		 * INICIALIZO ATRIBUTOS Y RELACIONES
		 */
		posicionX = POSICION_X;
		posicionY = POSICION_Y;
		imagenBird = "imagenes/birdRojo.png";
		velocidad = 2;
		aceleracion = 1;
		area = new Rectangle(posicionX, posicionY, ANCHO_AREA_BIRD, ALTURA_AREA_BIRD);
		
	
		
	}
	

	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
	/*
	 * Metodo que retorna  la posicion x del bird
	 * @return posicionX, que indica la posicion en el eje x de la pantalla del juego
	 */
	
	public int darPosicionX(){
		return posicionX;
	}
	
	/*
	 * Metodo que retorna  la posicion y del bird
	 * @return posicionY, que indica la posicion en el eje y de la pantalla del juego
	 */
	public int darPosicionY(){
		return posicionY;
	}
	/*
	 * Metodo que modifica la posicion x del bird
	 * @param int x , que representa la nueva posicion x del bird en la pantalla del juego
	 */
	public void modificarPosicionX(int x){
		posicionX = x;
	}
	/*
	 * Metodo que modifica la posicion y del bird
	 * @param int y , que representa la nueva posicion y del bird en la pantalla del juego
	 */
	public void modificarPosiciony(int y){
		posicionY = y;
	}
	
	/*
	 * Metodo que retorna una cadena de String, la cual representa la ruta de la imagen del bird
	 * @return String imagenBird, valor que representa la ruta de la imagen del bird
	 */
	public String darImagenBird(){
		return imagenBird;
	}
	/*
	 * Metodo que modifica la ruta de la imagen del bird
	 * @param String img, representa la nueva ruta de la imagen
	 */
	public void modificarImagenBird(String img){
		imagenBird = img;
	}
	/*
	 * Meotodo que retorna el area del bird
	 * @return Rectangle area, representa el area del bird
	 */
	public Rectangle darAreaBird(){
		return area;
	}
	
	/*
	 * Metodo que modifica el area del bird
	 * @param Rectangle area, que represental la nueva area del bird.
	 */
	public void modificarAreaBird(Rectangle area){
		this.area = area;
	}
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS DEL JUEGO
	 */
	
	/*
	 * Metodo que mueve al bird en la posicion y
	 * 
	 */
	public void movimientoBirdCaida(){
		if(posicionY>=0 && posicionY<= PanelJuego.AlTURA_JUEGO){
			velocidad += aceleracion;
			posicionY+= velocidad;
			actualizarArea(posicionY);
		
			
		}else{
			reiniciarPosicion();
		}
	}
	
	/*
	 * Metodo que actualiza el area del bird
	 * @param int y, que repesenta el nuevo punto en el eje y donde se debe actualizar el area
	 */
	public void actualizarArea(int y){
		modificarAreaBird(new Rectangle(posicionX, posicionY, ANCHO_AREA_BIRD, ALTURA_AREA_BIRD));
	}
	
	/*
	 * Metodo que retorna a bird a su posicion original en el eje y 
	 *
	 */
	public void reiniciarPosicion(){
			velocidad = 2;
			posicionY = PanelJuego.AlTURA_JUEGO/2;
	}
	
	/*
	 *Metodo que verifica si el bird está o no intersectado con un Tubo
	 *@param Tubo tubo1, objeto tipo Tubo que reprensenta un el primer tubo 
	 *@param Tubo tubo2, objeto tipo Tubo que representa el segundo tubo
	 *@return boolean intersectado, valor booleano que inidica si el bird está o no intersectsdo con algun tubo 
	 */
	public boolean interseccion(Tubo tubo1 , Tubo tubo2){
		boolean intersectado = false;
		if(this.area.intersects(tubo1.darAreaSuperior())|| this.area.intersects(tubo1.darAreaInferior())|| this.area.intersects(tubo2.darAreaInferior())|| this.area.intersects(tubo2.darAreaSuperior())){
				intersectado = true;
				System.out.println("Intersectado "+ intersectado);		
		}
		return intersectado;
	}
	
	/*
	 *Metodo que verifica si el bird está o no intersectado con un Comodin
	 *@param Tubo comodin, objeto tipo Comodin que reprensenta un comodin
	 *@return boolean atrpado, valor booleano que inidica si el bird está o no intersectsdo con algun comodin
	 */
	public boolean interseccionComodin(Comodin c){
		boolean atrapado= false;
		if(c.darArea().intersects(this.area)){
			atrapado = true;
		}
	return atrapado;
	}
	/*
	 * Metodo que disminuye la velocidad del personaje bird 
	 * 
	 */
	public void subirBird(){
		velocidad = -17;
	}
	

	
	

}

