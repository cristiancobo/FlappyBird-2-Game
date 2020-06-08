package modelo;

import java.awt.Rectangle;
import java.util.Random;

import interfaz.PanelJuego;

public class Tubo {
	
	
	//CONSTANTES
	
	public static final int ANCHO_TUBO = 45;
	public static final int ABERTURA = 400;
	public static final int lARGO_TUBO = PanelJuego.AlTURA_JUEGO;
	public static final int ANCHO_AREA_TUBO_SUPERIOR = 45;
	public static final int ANCHO_AREA_TUBO_INFERIOR = 45;



	//RELACIONES
	


	//ATRIBUTOS
	

	/*
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
	
	
	private int posicionX;
	private int posicionY ;
	private int anchoTubo ;
	private int largoTubo ;
	private int abertura;
	private int velocidad ;
	private String imagenTubo;
	private Rectangle areaInferior;
	private Rectangle areaSuperior;
	
	
	public Tubo(int x){
		   /*
		 	* INICIALIZO ATRIBUTOS Y RELACIONES DE LA CLASEE
		 	*/
		Random c = new Random();
		posicionX = x;
		posicionY =  c.nextInt(PanelJuego.AlTURA_JUEGO-600)+200;
		anchoTubo = 45;
		largoTubo =PanelJuego.AlTURA_JUEGO-posicionY;
		abertura = ABERTURA;
		velocidad = -6;
		imagenTubo ="imagenes/tubo.png";
		areaInferior =new Rectangle(posicionX, posicionY, ANCHO_AREA_TUBO_INFERIOR,largoTubo);
		areaSuperior =new Rectangle(posicionX, 60 , ANCHO_AREA_TUBO_SUPERIOR, PanelJuego.AlTURA_JUEGO-(largoTubo+ABERTURA));
		//areaInferior =new Rectangle(posicionX, posicionY, 0,0);
		//areaSuperior =new Rectangle(posicionX, 100 ,0, 0);
	}
	
	

	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
	
	public int darPosicionX() {
		return posicionX;
	}
	public String darImagenTubo() {
		return imagenTubo;
	}

	public void modificarImagenTubo(String imagenTubo) {
		this.imagenTubo = imagenTubo;
	}

	public void modificarPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public int darPosicionY() {
		return posicionY;
	}
	public void modificarPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
//	public int darAnchoTubo() {
//		return anchoTubo;
//	}
//	public void modificarAnchoTubo(int anchoTubo) {
//		this.anchoTubo = anchoTubo;
//	}
//	public int darLargoTubo() {
//		return largoTubo;
//	}
//	public void modificarLargoTubo(int largoTubo) {
//		this.largoTubo = largoTubo;
//	}
	public int darAbertura() {
		return abertura;
	}
//	public void modificarAbertura(int abertura) {
////		this.abertura = abertura;
////	}
	
	public Rectangle darAreaSuperior(){
		return areaSuperior;
	}
	
	public void modificarAreaSuperior(Rectangle areaSupeior){
		this.areaSuperior = areaSupeior;
	}
	public Rectangle darAreaInferior(){
		return areaInferior;
	}
	
	public void modificarAreaInferior(Rectangle areaInferior){
		this.areaInferior = areaInferior;
	}
	
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */
		
	/*
	 * 
	 */
	public void movimientoTubo(){	
	  posicionX += velocidad;
	  actualizarAreaSuperior(posicionX, posicionY);
	  actualizarAreaInferior(posicionX);
	  if(posicionX<=-ANCHO_TUBO){
		  posicionX = PanelJuego.ANCHURA_JUEGO;
		  posicionY = MovimientoAleatorio();
		  largoTubo = PanelJuego.AlTURA_JUEGO-posicionY;
		 
			
	  }
	}
	
	/*
	 * 
	 */
	public int  MovimientoAleatorio(){
		int randomY = (int) (Math.random()*(PanelJuego.AlTURA_JUEGO-200))+100;
		int movAleatorio = randomY;
		return movAleatorio;
		
	}
	
	/*
	 * 
	 */
	
	public void reiniciarPosicion(){
		Random c = new Random();
		posicionY = c.nextInt(PanelJuego.AlTURA_JUEGO-400)+200;
		largoTubo = PanelJuego.AlTURA_JUEGO-posicionY;
	}
	
	/*
	 * actualiza el area del tubo
	 */
	public void actualizarAreaSuperior(int x , int y){
		modificarAreaSuperior(new Rectangle(x, y, ANCHO_AREA_TUBO_INFERIOR,largoTubo));
		//modificarAreaSuperior(new Rectangle(x, y,0,0));
	}
	public void actualizarAreaInferior(int x ){
		modificarAreaInferior(new Rectangle(x, 100, ANCHO_AREA_TUBO_SUPERIOR, PanelJuego.AlTURA_JUEGO-(largoTubo+ABERTURA)));
		//modificarAreaInferior(new Rectangle(x, 100, 0, 0));
	}
	
}

		
	
	



	


