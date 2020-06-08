package modelo;

import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.Timer;

import javax.swing.ImageIcon;

import interfaz.PanelJuego;

public class Comodin implements Movible , Puntable, Intersectable{
	
	//CONSTANTES
	
	public static final char TIPO_COMODIN_MANZANA  = 'm'; 
	public static final char TIPO_COMODIN_NARANJA  = 'n'; 
	public static final int ALTURA_AREA = 80;
	public static final int  LARGO_AREA = 80;
	public static final long TIEMPO_APARICION_COMODIN = 2000;
	public static final long INMUNIDAD = 2000;
	public static final String IMAGEN_MANZANA = "imagenes/manzana.png";
	public static final String IMAGEN_NARANJA = "imagenes/naraja.png";
	
	//RELACIONES
	
	private Comodin siguiente;
	private Comodin anterior;
	
	//ATRIBUTOS
	private char tipo;
	private long tiempoAparicion;
	private String imagen;
	protected int posicionX;
	private int posicionY;
	private boolean atrapado;
	private Rectangle area;
	private int altoArea;
	private int largoArea;
	protected int velocidad;

	/*
	 * METODO CONSTRUCTOR DE CLASE 
	 */
	
	public Comodin(char tipo,  int posicionX, int posicionY) {
		super();
		this.tipo = tipo;
		this.tiempoAparicion = TIEMPO_APARICION_COMODIN;
		this.imagen = "";
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.atrapado = false;
		this.area = new Rectangle(posicionX, posicionY, LARGO_AREA,ALTURA_AREA);
		this.altoArea = ALTURA_AREA;
		this.largoArea = LARGO_AREA;
		this.velocidad = 10;
		siguiente = null;
		anterior = null;
		
	}
	
	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
	/*
	 * Metodo que retorna un valor booleano que indica si un comodin está o no atrapado
	 * @return boolean atrapado, valor booleano que representa el estado de un comodin
	 */
	public boolean darAtrapado(){
		return atrapado;
	}
	/*
	 * Metodo que modifica el estado de un comodin
	 * @param boolean atrapado, nuevo valor booleano para modificar el estado del comodin
	 */
	public void modificarAtrapado(boolean atrapado){
		this.atrapado = atrapado;
	}
	/*
	 * Metodo que retorno la imagen de un comodin 
	 * @return String imgen, cadena de caracteres que representa la ruta de la imagen de un comodin
	 */
	public String darImagen(){
		return imagen;
	}
	/*
	 * Metodo que modifica la imagen de un comodin
	 * @param String imagen, cadena de caracteres que representa la nueva ruta de la imagen
	 */
	public void modificarImagen(String imagen){
		this.imagen = imagen;
	}
	/*
	 * Metodo que retorna  la posicion x del Comodin
	 * @return posicionX, que indica la posicion en el eje x de la pantalla del juego
	 */
	public int darPosicionX(){
		return posicionX;
	}
	/*
	 * Metodo que modifica la posicion x del comodin
	 * @param int x , que representa la nueva posicion x del comodin en la pantalla del juego
	 */
	public void modificarPosicionX(int posicionX){
		this.posicionX = posicionX;
	}
	/*
	 * Metodo que retorna  la posicion y del comodin
	 * @return posicionY, que indica la posicion en el eje y de la pantalla del juego
	 */
	public int darPosicionY(){
		return posicionY;
	}
	/*
	 * Metodo que modifica la posicion y del comodin
	 * @param int y , que representa la nueva posicion y del comodin en la pantalla del juego
	 */
	public void modificarPosicionY(int posicionY){
		this.posicionY = posicionY;
	}
	/*
	 * Metodo que retorna el tiempor de aparicion de un comodin en pantalla
	 * @retun long timepoAparicion, variable tipo long que representa el tiempo de duracion de un comodin en pantalla
	 */
	public long darTiempoAparicion(){
		return tiempoAparicion;
	}
	/*
	 * Meotod que modifica el tiempo de aparicion de un comodin
	 * @param int tiempoAparicion, valor tipo entero que representa el nuevo tiempo de aparicion
	 */
	public void modificarTiempoAparicion(int tiempoAparicion){
		this.tiempoAparicion = tiempoAparicion;
	}
	/*
	 * Metodo que retorna la velocidad de comodin
	 * @return int velocidad, valor que representa al velocidad de un comodin 
	 */
	public int darVelocidad(){
		return this.velocidad;
	}
	/*
	 * Metodo que modifica la velocidad de un comodin
	 * @param velocidad, valor tipo entero que representa la nueva velocidad
	 */
	public void modificarVelocidad(int velocidad){
		this.velocidad = velocidad;
	}
	/*
	 * Metodo que retorna el comodin siguiente a este
	 * @return siguiente, objeto tipo  comodin que representa al siguiente de este
	 */
	public Comodin darComodinSiguiente(){
		return siguiente;
	}
	/*
	 * Metodo que modifica al siguiente comodin a este
	 * @param x, vafriable tipo Comodin que representa al nuevo comodin siguiente
	 */
	
	public void modificarComodinSiguiente(Comodin x){
		siguiente = x;
	}
	/*
	 * Metodo que retorna el comodinAnteior a este
	 * @return anterior, variable tipo Comodin que representa el comodin anterior a este
	 */
	
	public Comodin darComodinAnterior(){
		return anterior;
	}
	/*Metodo que modifica el comodin anterior a este
	 * @param x, variable tipo comodin que representa el nuevo comodin anterior a este2
	 * 
	 */
	
	public void modificarComodinAnterior(Comodin x){
		anterior = x;
	}
	/*
	 * Metodo que retorna el area del comodin
	 * @return area, variable tipo Rectangle que representa el area del comodin
	 */
	public Rectangle darArea(){
		return area;
	}
	/*Metodo que modifica el area del comodin
	 * @param area, variable tipo rectangle que representa el area del comodin
	 * 
	 */
	
	public void modificarArea(Rectangle area){
		this.area = area;
	}
	/*
	 * Metodo que retorna el tipo de comodin
	 * @return tipo, variable tipo char que representa el tipo de comodin
	 */
	public char darTipo(){
		return tipo;
	}

	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */
	
	/*
	 * Metodo queasigna el tipo de imagen dependiendo de el tipo de comodin
	 * @param imagen, cadena de caracteres que representa la imagen del comodin
	 */
	
	public void asinarImagen(String imagen){
		modificarImagen(imagen);
	}
	
	/*
	 * Metodo que Indica si un comodin está o no atrapado
	 * @return darAtrapdo(), valor boolean que indica si un comodin estac o no atrapado
	 */
	public boolean estaAtrapado(){
		return darAtrapado();
	}


	/*
	 * Metod que retorna el tiempo de duracion de un comodin en pantalla
	 * @return darTiempoAparicion(), valor tipo long que indica el tiempo de aparicion de un comodin
	 */
	
	public long tiempoAparicion(){
		return darTiempoAparicion();
	}
	/*
	 * Metodo que temporiza el tiempo de aparicion de un comodin
	 * @param tiempoReductor, variable tipo entera  que indica el cueanto de disminuirá el timepo de aparicion
	 */
	
	public void temporizarTiempoAparicion(int reductorTiempo){
		tiempoAparicion-=reductorTiempo;
	}
	
	/*
	 * Meotod que cambia de forma aleatoria la posicion del comodin en el eje y
	 * 
	 */
	public void posicionAleatoriaComodin(){
		int randomY = (int) (Math.random()* PanelJuego.AlTURA_JUEGO-50);
		posicionY = randomY;
	}
	
	/*
	 * Meotod que modifica la posicion del area (rectangulo) del comodin
	 */
	public void actualizarAreaComodin(int x){
		modificarArea(new Rectangle(posicionX, posicionY, LARGO_AREA, ALTURA_AREA));
	}
	

	
	/*
	 * Metodo que mueve al comodin en el eje x 
	 */
	@Override
	public void mover() {
		posicionX -= velocidad;
		actualizarAreaComodin(posicionX);
			if(posicionX < 0){
				reiniciarPosicionComodin();
				posicionAleatoriaComodin();
			}
		
	}
	/*
	 * reinicia la posicion del comodin a su posicion original en el eje x
	 */
	public void reiniciarPosicionComodin(){
		posicionX = PanelJuego.AlTURA_JUEGO-50;
			}
	
	/*
	 * Metodo que indica si un comodin esta o no intersectado con un comodin
	 * @return intersectado, valor booleano que indica si un  comodin està o no intersectado con bird
	 */	
	
	public boolean interseccion(Bird c){
		boolean intersectado = false;
			if(this.area.intersects(c.darAreaBird())){
				intersectado = true;
			}
		return intersectado;
		}

	/*
	 * (non-Javadoc)
	 * @see modelo.Puntable#puntos(int)
	 * Metodo que retorna la cantidad de puntos que debe sumar a un  jugador
	 * @param c , entero que representa los puntos a agregar
	 * @return c , puntos que se le debe sumar al jugador
	 */
	@Override
	public int puntos(int c) {
		return c;
	}


}
	
	
