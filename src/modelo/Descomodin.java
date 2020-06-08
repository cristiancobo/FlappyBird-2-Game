package modelo;

import java.awt.Rectangle;

import interfaz.PanelJuego;

public class Descomodin implements Movible, Puntable , Intersectable {
	
	//CONSTANTES 
	public static final char TIPO_DESCOMODIN_VENENO  = 'v'; 
	public static final char TIPO_DESCOMODIN_MINA  = 'a'; 
	public static final int ALTURA_AREA = 400;
	public static final int  LARGO_AREA = 400;
	public static final long TIEMPO_APARICION_DESCOMODIN = 2000;
	public static final String IMAGEN_MINA = "imagenes/bomba.png";
	public static final String IMAGEN_VENENO = "imagenes/veneno.png";

	//RELACIONES
	
	private Descomodin siguiente;
	private Descomodin anterior;

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
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
	public Descomodin( char tipo, int posicionX, int posicionY) {
		super();
		this.siguiente =null;
		this.anterior = null;
		this.tipo = tipo;
		this.tiempoAparicion =TIEMPO_APARICION_DESCOMODIN;
		this.imagen = "";
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.atrapado = false;
		this.area = new Rectangle(posicionX, posicionY, LARGO_AREA,ALTURA_AREA);;
		this.altoArea = ALTURA_AREA;
		this.largoArea = LARGO_AREA;
		this.velocidad = 5;
	}

	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	

	/*
	 * Metodo que retorna el comodin siguiente a este
	 * @return siguiente, objeto tipo  comodin que representa al siguiente de este
	 */
	public Descomodin darSiguiente() {
		return siguiente;
	}
	/*
	 * Metodo que modifica al siguiente comodin a este
	 * @param x, vafriable tipo Comodin que representa al nuevo comodin siguiente
	 */

	public void modificarSiguiente(Descomodin siguiente) {
		this.siguiente = siguiente;
	}

	/*
	 * Metodo que retorna el comodinAnteior a este
	 * @return anterior, variable tipo Comodin que representa el comodin anterior a este
	 */
	public Descomodin darAnterior() {
		return anterior;
	}

	/*Metodo que modifica el comodin anterior a este
	 * @param x, variable tipo comodin que representa el nuevo comodin anterior a este2
	 * 
	 */
	public void modificarAnterior(Descomodin anterior) {
		this.anterior = anterior;
	}

	/*
	 * Metodo que retorna el tipo de comodin
	 * @return tipo, variable tipo char que representa el tipo de comodin
	 */
	public char darTipo() {
		return tipo;
	}

//
//	public void modificarTipo(char tipo) {
//		this.tipo = tipo;
//	}


	/*
	 * Metodo que retorna el tiempor de aparicion de un comodin en pantalla
	 * @retun long timepoAparicion, variable tipo long que representa el tiempo de duracion de un comodin en pantalla
	 */
	public long darTiempoAparicion() {
		return tiempoAparicion;
	}

	/*
	 * Meotod que modifica el tiempo de aparicion de un comodin
	 * @param int tiempoAparicion, valor tipo entero que representa el nuevo tiempo de aparicion
	 */
	public void modificarTiempoAparicion(long tiempoAparicion) {
		this.tiempoAparicion = tiempoAparicion;
	}

	/*
	 * Metodo que retorno la imagen de un comodin 
	 * @return String imgen, cadena de caracteres que representa la ruta de la imagen de un comodin
	 */
	public String darImagen() {
		return imagen;
	}

	/*
	 * Metodo que modifica la imagen de un comodin
	 * @param String imagen, cadena de caracteres que representa la nueva ruta de la imagen
	 */
	public void modificarImagen(String imagen) {
		this.imagen = imagen;
	}

	/*
	 * Metodo que retorna  la posicion x del Comodin
	 * @return posicionX, que indica la posicion en el eje x de la pantalla del juego
	 */
	public int darPosicionX() {
		return posicionX;
	}
	/*
	 * Metodo que modifica la posicion x del comodin
	 * @param int x , que representa la nueva posicion x del comodin en la pantalla del juego
	 */

	public void modificarPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	/*
	 * Metodo que retorna  la posicion y del comodin
	 * @return posicionY, que indica la posicion en el eje y de la pantalla del juego
	 */

	public int darPosicionY() {
		return posicionY;
	}

	/*
	 * Metodo que modifica la posicion y del comodin
	 * @param int y , que representa la nueva posicion y del comodin en la pantalla del juego
	 */
	public void modificarPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

//
//	public boolean darAtrapado() {
//		return atrapado;
//	}


//	public void modificarAtrapado(boolean atrapado) {
//		this.atrapado = atrapado;
//	}

	/*
	 * Metodo que retorna el area del comodin
	 * @return area, variable tipo Rectangle que representa el area del comodin
	 */
	public Rectangle darArea() {
		return area;
	}
	/*Metodo que modifica el area del comodin
	 * @param area, variable tipo rectangle que representa el area del comodin
	 * 
	 */
	

	public void modificarArea(Rectangle area) {
		this.area = area;
	}


//	public int darltoArea() {
//		return altoArea;
//	}


//	public void modificarAltoArea(int altoArea) {
//		this.altoArea = altoArea;
//	}
//
//
//	public int darLargoArea() {
//		return largoArea;
//	}
//
//
//	public void modificarLargoArea(int largoArea) {
//		this.largoArea = largoArea;
//	}
	/*
	 * Metodo que retorna la velocidad de comodin
	 * @return int velocidad, valor que representa al velocidad de un comodin 
	 */

	public int darVelocidad() {
		return velocidad;
	}
	/*
	 * Metodo que modifica la velocidad de un comodin
	 * @param velocidad, valor tipo entero que representa la nueva velocidad
	 */

	public void modificarVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */

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
	 * cambia de forma aleatoria la posicion del comodin
	 */
	public void posicionAleatoriaDescomodin(){
		int randomY = (int) (Math.random()* PanelJuego.AlTURA_JUEGO-50);
		posicionY = randomY;
	}
	
	/*
	 * modifica la posicion del area (rectangulo) del comodin
	 */
	public void actualizarAreaDescomodin(int x){
		modificarArea(new Rectangle(posicionX, posicionY, LARGO_AREA, ALTURA_AREA));
	}
	
	/*
	 * mueve el comodin en el eje x
	 */

//	public void movimientoDescomodin(){
//		posicionX -= velocidad;
//		actualizarAreaDescomodin(posicionX);
//			if(posicionX < 0){
//				reiniciarPosicionDescomodin();
//				posicionAleatoriaDescomodin();
//			}
//	}
	
	/*
	 * 
	 */

	@Override
	public void mover() {
	
		posicionX -= velocidad;
		actualizarAreaDescomodin(posicionX);
			if(posicionX < 0){
				reiniciarPosicionDescomodin();
				posicionAleatoriaDescomodin();
			}
		
	}
	/*
	 * reinicia la posicion del comodin a su posicion original en el eje x
	 */
	public void reiniciarPosicionDescomodin(){
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
