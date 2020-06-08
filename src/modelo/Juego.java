package modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import interfaz.PanelJuego;

public class Juego implements Serializable{
	
	//CONSTANTES
	
	public static final String BIRD_REY = "imagenes/birdRey.png";
	public static final  String BIRD_ROSA = "imagenes/birdRosa.png";
	public static final  String  BIRD_ROJO= "imagenes/birdRojo.png";
	public static final  String  BIRD_NARANJA ="imagenes/birdNaranja.png";
	public static final  String  BIRD_GRIS = "imagenes/birdGris.png";
	public static final  String  BIRD_AZUL = "imagenes/birdAzul.png";
	public static final  String  BIRD_VERDE = "imagenes/birdVerde.png";
	
	//RELACIONES

	private Bird bird;
	private Tubo tubo1;
	private Tubo tubo2;
	
	private Personaje personajeRaiz;
	
	private Jugador JugadorRaiz;
	private int numeroJugadores;
	private Comodin primero;
	private Descomodin primeroDescomodin;
	private int numeroDeComodines;
	private int numeroDeDescomodines;
	
	//ATRIBUTOS
	
	private int puntaje;
	private int numeroComodinManzana;
	private int numeroComodinNaranja;
	private int nivel;
	private String personaje;
	private boolean maquina;
	private int puntajeTemporalJugador;
	
	/*
	 * METODO CONSTRUCTOR DE CLASE 
	 */
	
	public Juego(){
		
		/*
		 * INICIALIZO ATRIBUTOS Y RELACIONES DE LA CLASE
		 */
		bird = new Bird();
		tubo1 = new Tubo(PanelJuego.ANCHURA_JUEGO);
		tubo2 = new Tubo(PanelJuego.ANCHURA_JUEGO + (PanelJuego.ANCHURA_JUEGO /2));
		JugadorRaiz = null;
		numeroJugadores=0;
		puntaje = 0;
		numeroComodinManzana = 0;
		numeroComodinNaranja = 0;
		nivel = 0;
		maquina = false;
		puntajeTemporalJugador = 0;
		personaje = "imagenes/birdRojo.png";
		numeroDeComodines = 0;
		numeroDeDescomodines=0;
		
		agregarPersonaje(BIRD_VERDE, 1980);
		agregarPersonaje(BIRD_ROJO, 1970);
		agregarPersonaje(BIRD_AZUL, 1990);
		agregarPersonaje(BIRD_REY, 1965);
		agregarPersonaje(BIRD_ROSA, 1975);
		agregarPersonaje(BIRD_NARANJA, 1985);
		agregarPersonaje(BIRD_GRIS, 1995);
	
	}
	
	
	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
	
	
	/*
	 * metodo que retorna a bird
	 * @return bird. variable tipo bird que representa bird
	 */
	public Bird darBird(){
		return bird;
	}
	public int darNumeroDeComodines() {
		return numeroDeComodines;
	}


	public int darNumeroDeDescomodines() {
		return numeroDeDescomodines;
	}


	/*
	 * 
	 * metodo que retorna al  tubo1 
	 * @return tubo1, variable tiepo tubo que representa un tubo
	 */
	public Tubo darTubo1(){
		return tubo1;
	}
	/*
	 * 
	 * metodo que retorna al  tubo2 
	 * @return tubo2, variable tiepo tubo que representa un tubo
	 */
	
	public Tubo darTubo2(){
		return tubo2;
	}
	
	/*
	 * Metodo que retorna el primero comodin 
	 * @return primero, variable tipo Comodin que representa al primero comodin
	 */
	public Comodin darPrimero(){
		return primero;
	}
	/*
	 * Metodo que modifica al primero comodin
	 * @param nuevo, variable tipo comodin que indica el nuevo primer comodin
	 */
	public void modificarComodin(Comodin nuevo){
		primero = nuevo;
	}
	
	/*
	 * metodo que retorna el puntaje del juego
	 * @return puntaje, variable que representa el puntaje juego
	 */
	public int darPuntaje() {
		return puntaje;
	}
	
//	
//	public String darPersonaje() {
//		return personaje;
//	}
//
//	public void modificarPersonaje(String personaje) {
//		this.personaje = personaje;
//	}

	/*
	 * metodo que modifica el puntaje
	 * @param puntaje, variable tipo entera que representa el nuevo puntaje
	 */
	public void modificarPuntaje(int puntaje) {
		this.puntaje += puntaje;
	}
	
	/*
	 * merodo que retorna el numero de comodines obetnidos
	 * @return numeroComodinMazanam avariable tipo entera que representa el nuemro de comodines  obtenido
	 */
	public int darNumeroComodinManzana() {
		return numeroComodinManzana;
	}

	/*
	 * metodo que modifica el numero de comodines manzanas 
	 * @param numeroComodinManzana,variable tipo entera que representa el nuevo numero de comodines 
	 */
	public void modificarNumeroComodinManzana(int numeroComodinManzana) {
		this.numeroComodinManzana += numeroComodinManzana;
	}

	/*
	 * merodo que retorna el numero de comodines obetnidos
	 * @return numeroComodinMazanam avariable tipo entera que representa el nuemro de comodines  obtenido
	 */
	public int darNumeroComodinNaranja() {
		return numeroComodinNaranja;
	}
	/*
	 * metodo que retorna el puntaje temporal
	 * @return puntajeTemporalJugador, variable que  representa el puntaje
	 */
	
	public int darPuntajeTemporalJugador() {
		return puntajeTemporalJugador;
	}
	/*
	 * Meotodo que modifica el puntaje temporal del juego
	 * @param puntajeTemporalJugador, variable que repsenta el nuevo puntaje
	 */
	public void modificarPuntajeTemporalJugador(int puntajeTemporalJugador) {
		this.puntajeTemporalJugador = puntajeTemporalJugador;
	}
	/*
	 * metodo que retorna la maquina del juego
	 * @return maquina, valor booleano que representa si es onola  maquina quien juefa
	 */
	public boolean darMaquina() {
		return maquina;
	}
	/*
	 *metodo que modifica la maquina
	 *@param maquina, nuevo valor booleano de la maquina 
	 */
	public void modificarMaquina(boolean maquina) {
		this.maquina = maquina;
	}

	/*
	 * metodo que modifica el numero de comodines manzanas 
	 * @param numeroComodinManzana,variable tipo entera que representa el nuevo numero de comodines 
	 */
	public void modificarNumeroComodinNaranja(int numeroComodinNaranja) {
		this.numeroComodinNaranja += numeroComodinNaranja;
	}
	/*
	 *metodo que retorna el nivel del juego
	 *@param nivel, variable tipo entera que representa el nivel 
	 */
	public int darNivel() {
		return nivel;
	}

	/*
	 * metodo que modifica el nivel del juego
	 * @param nvel, variable tipo int q representa el nuevo nivel
	 */
	public void modificarNivel(int nivel) {
		this.nivel = nivel;
	}
	/*
	 * metodo que retorna el nuemero de jugadores del juego
	 * @return nuemeroJugadores, variable tipo int que representa el numero de jugadores del juego
	 */
	public int darNumeroJugadores(){
		return numeroJugadores;
	}
	/*
	 * metodo que retorna el primer descomdin
	 * @return primeroDescomodin;, variable tipo descomodin que representa el primer descomodin
	 */
	public Descomodin darrPrimeroDescomodin() {
		return primeroDescomodin;
	}
	/*
	 * metodo que modifica el primerDescomodin
	 * @param primeroDescomodin, varaible tipo de descomodin que representa el nuevo primero  descomodin
	 */
	public void modificarPrimeroDescomodin(Descomodin primeroDescomodin) {
		this.primeroDescomodin = primeroDescomodin;
	}
	
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */
	
	/*
	 * metodo que modifica los puntajes obtenidos por el jugador actual
	 * @param puntaj, variable tipo int que representael puntaje del jugador acrtual
	 * @return actual, variable tipo jugador que representaaljugador actual
	 */
	
	public Jugador  establecerItemsActuales(int puntaje){
			Jugador actual = buscarJugador(puntaje);
			modificarPuntaje(actual.darPuntaje());
			modificarNumeroComodinManzana(actual.darNumeroComodinManaza());
			modificarNumeroComodinNaranja(actual.darNumeroComodinNaranja());
		
	return actual;
	}
	/*
	 *mrtodo que actualiza los puntajes del jugador actual
	 *@param puntajeInicial, puntaje inicial del jugador actual
	 *@param puntajeFinal, puntaje final del jugador actual
	 *@param manzanas, numero de manzanas del jugador actual
	 *@param naranjas, numero de naranjas del jugador actual
	 */
	public Jugador actualizarJugador(int puntajeInicial, int puntajeFinal, int manzanas, int naranjas){
		Jugador actual = buscarJugador(puntajeInicial);
		actual.modificarPuntaje(puntaje);
		actual.modificarNumeroComodinNaranja(naranjas);
		actual.modificarNumeroComodinManaza(manzanas);
		//FALTA VER LO DEL NIVEL
		
	return actual;
	}


	/*
	 * guarda la partida del juego
	 */

	public void guardar() throws FileNotFoundException, IOException{
		
	File jugadores = new File("jugadores.txt");

			ObjectOutputStream 	oss = new  ObjectOutputStream(new FileOutputStream(jugadores));
					oss.writeObject(JugadorRaiz);

			
		System.out.println("GUARDADO!");	
	}
	/*
	 * Metodo que registra los jugadores en un archivo plano 
	 */
	public void registroJugadores() throws IOException{
		File listaPuntajes = new File("PuntajesJugadores.txt");
		
		FileWriter fw;
		try {
			fw = new FileWriter(listaPuntajes);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.write("Nivel      Puntaje        Nick");
			if(JugadorRaiz!= null){
				JugadorRaiz.inOrden3(JugadorRaiz, pw);
			}
			
			pw.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
			
	}
	
	/*
	 * metodo que carga la partida del juego 
	 */
	
	public void cargar() throws FileNotFoundException, IOException, ClassNotFoundException{
		File jugadores = new File("jugadores.txt");
		Jugador x = null;
			if(jugadores.exists()){
				ObjectInputStream ois;
		
					ois = new ObjectInputStream(new FileInputStream(jugadores));
					 x = (Jugador) ois.readObject();
					
		
				JugadorRaiz = x;
			}
	}
	/*
	 * Metodo que Genera el movimiento de del personaje (Bird) y los tubos
	 */
	public void moverBird(){

		interseccionTubo();
		bird.movimientoBirdCaida();
		tubo1.movimientoTubo();
		tubo2.movimientoTubo();
		if(tubo1.darPosicionX() == bird.darPosicionX() || tubo2.darPosicionX() == bird.darPosicionX()){
		subirPuntaje(1);
		}
		subirNivel();
	}
	/*
	 * Metodo que sube de nivel al juego
	 */
	public void subirNivel(){
		if(puntaje >= 5 && puntaje <= 10){
			modificarNivel(2);
		}else if (puntaje >10 && puntaje <=15 ) {
			modificarNivel(3);
		}else if (puntaje >15 && puntaje <=20) {
			modificarNivel(4);
		}
	}
	/*
	 * Metodo que cambia de imagen de fondo al juego dependiendo del nivel
	 */
	public void cambiarPantallaFondo(PanelJuego panelJuego){
		if(puntaje >= 5 && puntaje <= 7){
				panelJuego.modificarPantalla(PanelJuego.PANTALLA_1);
		}else if (puntaje >7 && puntaje <=10) {
			panelJuego.modificarPantalla(PanelJuego.PANTALLA_2);
		}else if (puntaje >10 && puntaje <=25) {
					//modificarNivel(4);
			panelJuego.modificarPantalla(PanelJuego.PANTALLA_3);
		}
	}
	/*
	 * Meotodo que sube el puntaje al juego
	 * @param c, variable tipo int quecindica en cuanto subira el puntaje del juego
	 */
	public void subirPuntaje(int c){
		modificarPuntaje(c);
	}
	
	/*
	 * metodo que Permite controlar la caida del personaje (Bird)
	 */
	public void manejarBird(){
		bird.subirBird();
	}
	
	/*
	 * metodo que indica si el bird está o no intersectado con algun tubo
	 * 
	 */
	public boolean  interseccionTubo(){
		boolean intersectado = false;
			if(bird.interseccion(tubo1, tubo2)){
				intersectado = true;
			}
		return intersectado;
	}
	/*
	 * 
	 */
	public void interseccionComodin(){
			Comodin actual = primero;
				if(actual != null){
						while(actual !=null){
							if(actual.interseccion(bird)){
								actual.modificarPosicionY(600);
								if(actual.darTipo() == Comodin.TIPO_COMODIN_NARANJA){
										subirCantidadNaranjas();
										subirPuntaje(actual.puntos(2));
										actual.modificarArea(new Rectangle(0, 0, 0, 0));
								}else if(actual.darTipo() == Comodin.TIPO_COMODIN_MANZANA){
										subirCantidadManzanas();
										actual.puntos(3);
										actual.modificarArea(new Rectangle(0, 0, 0, 0));		
								}
							}
							actual = actual.darComodinSiguiente();
						}
							
					}

				}
	/*
	 * 
	 */
	public void interseccionDescomodin(){
		Descomodin actual = primeroDescomodin;
		if(actual != null){
				while(actual !=null){
					if(actual.interseccion(bird)){
						if(actual.darTipo() == Descomodin.TIPO_DESCOMODIN_VENENO);
								//subirPuntaje(actual.puntos(-3));
								actual.modificarArea(new Rectangle(0, 0, 0, 0));
						}else if(actual.darTipo() == Descomodin.TIPO_DESCOMODIN_MINA){
								//subirPuntaje(actual.puntos(-3));
								actual.modificarArea(new Rectangle(0, 0, 0, 0));
								
						}
						actual.modificarPosicionY(600);
					}
					actual = actual.darSiguiente();
				}
					
			}
	
	/*
	 * metodo que sube la canridad de manzanas en el juego
	 */
	public void subirCantidadNaranjas(){
		modificarNumeroComodinNaranja(1);
	}
	/*
	 * metodo que sube la cantidad de naranajas en el juego
	 */
	public void subirCantidadManzanas(){
		modificarNumeroComodinManzana(1);
	}
	
	/*
	 *  metodo que Agrega un  jugador al Arbol binario
	 *  @param nombre, variable tipo String que indica el nombre del jugador a agregar
	 *  @param puntaje variable  tipo int que indica el puntaje del jugador a agregar
	 *  @param nivel variable  tipo int que indica el nivel del jugador a agregar
	 *  @param manzanas  variable  tipo int que indica el numero de manzanas del jugador a agregar
	 *  @param naranjas variable  tipo int que indica el numero de naranjas del jugador a agregar
	 *  
	 */
	public void agregarJugador(String nombre, int puntaje , int nivel, int manzanas, int naranjas) throws PuntajeExiste{
		Jugador x = new Jugador(nombre, puntaje , nivel, manzanas ,naranjas);
			if(JugadorRaiz == null ){
				JugadorRaiz  = x;
			}else{
				JugadorRaiz.insertar(x);
			}
			numeroJugadores = JugadorRaiz.darPeso();
	}
	/*
	 * metodo que Agrega un  jugador al Arbol binario
	 * @param c, variable que indica la ruta de la imagen del comodin
	 * @param edicion, indica la edicion del comodin
	 */
	public void agregarPersonaje(String c , int edicion){
		Personaje x = new Personaje(c, edicion);
			if(personajeRaiz == null ){
				personajeRaiz  = x;
			}else{
				personajeRaiz.insertar(x);
			}
	}
	/*
	 * Metodo que retorna una lista de nombres de los jugadores
	 * @return lista, arraylist el cual contiene todos los nombres de los jugadores
	 */
	public ArrayList<Jugador> jugadores(){
		ArrayList<Jugador > lista = new ArrayList<Jugador>();
		if(JugadorRaiz!=null){
			JugadorRaiz.listaNombres(JugadorRaiz, lista);
		}
	return lista;
	}
	/*
	 *metodo que ordena a los jugadores por nombre
	 *@param jugadores(), un arraylist tipo Jugador
	 *@return c, un arraylist tipo jugador ordenado por nombre 
	 */
	public ArrayList<Jugador> ordenamientoInsercionPorNombre(ArrayList<Jugador> jugadores){
		ArrayList<Jugador> c = jugadores;
		for( int i = 1; i < c.size( ); i++ ) {
		Jugador porInsertar = ( Jugador )c.get( i );
		boolean termino = false;
		for( int j = i; j > 0 && !termino; j-- ) {
		Jugador actual = ( Jugador )c.get( j - 1 );
		if( actual.compararPorNombre(porInsertar) > 0 ) {
		c.set( j, actual );
		c.set( j - 1, porInsertar ); }
		else
		termino = true;
		} 
	
	}
		return c;
		}
	/*
	 *metodo que ordena a los jugadores por puntaje
	 *@param jugadores(), un arraylist tipo Jugador
	 *@return c, un arraylist tipo jugador ordenado por puntaje
	 */
	public ArrayList<Jugador> ordenamientoInsercionPorPuntos(ArrayList<Jugador> c){
			ArrayList<Jugador> m = c;
			
				for (int i = m.size(); i > 0; i--) {
					for (int j = 0; j < i-1; j++) {
						Jugador actual = m.get(j);
						Jugador siguiente = m.get(j+1);
							if(actual.compararPorPuntos(siguiente)>0){
								Jugador temporal = m.get(j);
								m.set(j,m.get(j+1));
								m.set(j+1, temporal);
							}
						
					}
				}
		return m;
		}
	
	/*
	 *metodo que ordena a los jugadores por nivel
	 *@param jugadores(), un arraylist tipo Jugador
	 *@return c, un arraylist tipo jugador ordenado por nivel
	 */
	public ArrayList<Jugador> ordenamientoInsercionPorNivel(ArrayList<Jugador> c){
		ArrayList<Jugador > b  = c;
			for (int i = 0; i < b.size(); i++) {
				Jugador menor = b.get(i);
				int cual = i;
				for (int j = i+1; j< b.size(); j++) {
					Jugador actual = b.get(j);
						if(menor.compararPorNivel(actual)>0){
							menor = actual;
							cual = j;
					}
				}
				Jugador temporal = b.get(i);
				b.set(i, menor);
				b.set(cual, temporal);
			}
		return b;
		}
	/*
	 * metodo que busca a un jugador por el nombre
	 * @param nombre, variable que representa el nnombre  del jugador a buscar
	 * @return posicion, variable que indica la posicion Jugador en el arraylist
	 */
	public int busquedaBinariaNombre(String nombre) throws NoExisteJugador{
		ArrayList<Jugador> v = ordenamientoInsercionPorNombre(jugadores());
		Jugador c= new Jugador(nombre, 0,0,0,0);
		int posicion = -1;
		int inicio = 0;
		int fin = v.size()-1;
				String aBuscar = nombre;
					while(inicio <= fin && posicion ==-1){
						int medio = (inicio + fin )/2;
						Jugador mitad = (Jugador) v.get(medio);
						
						if(mitad.compararPorNombre(c) ==0){
							posicion = medio;
						}else if (mitad.compararPorNombre(c)>0) {
							fin = medio-1;
						}else{
							inicio = medio+1;
						}
					}
					if(posicion ==-1){
						throw new NoExisteJugador("El jugador no exite");
					}
		return posicion;
	}
	/*
	 * metodo que busca a un jugador por el puntos
	 * @param puntos, variable que representa el puntaje  del jugador a buscar
	 * @return posicion, variable que indica la posicion Jugador en el arraylist
	 */
	public int busquedaBinariaPuntaje(int puntos)  throws PuntajeNoExiste{
		ArrayList<Jugador> v = ordenamientoInsercionPorPuntos(jugadores());
		Jugador c= new Jugador("", puntos,0,0,0);
		int posicion = -1;
		int inicio = 0;
		int fin = v.size()-1;
				int aBuscar = puntos;
					while(inicio <= fin && posicion ==-1){
						int medio = (inicio + fin )/2;
						Jugador mitad = (Jugador) v.get(medio);
						
						if(mitad.compararPorPuntos(c) ==0){
							posicion = medio;
						}else if (mitad.compararPorPuntos(c)>0) {
							fin = medio-1;
						}else{
							inicio = medio+1;
						}
					}
				if(posicion ==-1){
					throw new PuntajeNoExiste("No existe este puntaje");
				}
		return posicion;
	}
//	/*
//	 * 
//	 */
//	
//	public void pintar(){
//			JugadorRaiz.inOrden(JugadorRaiz);	
//	}
	
	/*
	 * metodo que elimina a un jugador del arbol binario
	 * @param puntaje, variable que representa a el puntaje del jugador a eliminar
	 */
	public void eliminarJugador(int puntaje){
		JugadorRaiz = JugadorRaiz.eliminar(puntaje);
		numeroJugadores = JugadorRaiz.darPeso();
	}
	
	/*
	 * metodo que busca un jugador en especifico en el arbol binario
	 * @param puntaje, variable que representa el puntaje del jugador a buscar
	 */
	public Jugador buscarJugador(int puntaje){
		return (JugadorRaiz == null) ?  null : JugadorRaiz.buscar(puntaje);
		
	}
	/*
	 * metodo que busca un personaje en el arbol binario
	 * @param edicion , variable que indica la edicion del personaje a buscar
	 */
	public Personaje buscarPersonaje(int edicion) throws EstiloIcorrecto{
		return (personajeRaiz == null) ?  null : personajeRaiz.buscar(edicion);
		
	}
	
	/*
	 * metodo que indica si el arbol está o no vacio
	 * @return vacia, variable booleana que indica si el arbol esta o no vacio
	 */
	
	public boolean raizVacia(){
		boolean vacia = false;
			if(JugadorRaiz == null){
				vacia = true;
			}
		return vacia;
	}
	
	/*
	 * metodo que agregar comodines a la lista
	 * @param nuevo, variable tipo comodin que representa al nuevo comodin para agregar
	 */
	
	public void agregarComodin(Comodin nuevo){
		if(primero == null ){
			primero = nuevo;
		}else{
			nuevo.modificarComodinSiguiente(primero);
			primero.modificarComodinAnterior(nuevo);
			primero  = nuevo;
		}
		numeroDeComodines++;
	}
	
	/*
	 * metodo que eliminar a un jugador de la lista
	 * @param actual, variable tipo comodin que indica el comodin a eliminar
	 */

	public void eliminarComodin(Comodin actual){
				boolean terminado = false;
				actual = primero;
				if(primero != null) {
					if(actual.darTiempoAparicion() == 0){
						primero = actual.darComodinSiguiente();
					}else{
						while(!terminado){
							if(actual.darComodinSiguiente() !=null && actual.darComodinSiguiente().darTiempoAparicion() == 0){
								actual.modificarComodinSiguiente(actual.darComodinSiguiente().darComodinSiguiente());
								terminado = true;
							}else{
								actual = actual.darComodinSiguiente();
							}
						}
						
					}
					
				}
				numeroDeComodines--;
			}
	/*
	 *  metodo que genera comodines de forma aleatoria y los agrega a una lista de comodines
	 */
	public void generarComodin(){
		int randomComodin = (int) (Math.random()*3);
			int randomY = (int) (Math.random()*600);
			int randomX = (int) (Math.random()*600);
				if(randomComodin == 1){
					agregarComodin(new Naranja('n', tubo2.darPosicionX(),tubo2.darAbertura()));	
				}else{
					agregarComodin(new Manzana('m',  tubo1.darPosicionX(),tubo1.darAbertura()));
				}
	}
	

	/*
	 * metodo que mueve un comodin en el hilo respectivo
	 * 
	 */
	
	public void moverEnHiloComodin(){
		Comodin actual = primero;
		if(actual != null){
			while(actual !=null){
				actual.mover();
				interseccionComodin();
				actual = actual.darComodinSiguiente();
			}
		}
		
	}
	
	/*
	 * metodo que temporiza el tiempo de un descomodin
	 * @param reductor, variable que indica en cuanto disminuira el tiempo del comodin
	 */
	public void temporizarTiempoHiloComodin(int reductor){
		Comodin actual = primero;
		if(actual != null){
			while(actual !=null){
					while(actual.darTiempoAparicion() != 0){
						actual.temporizarTiempoAparicion(reductor);
					}
					eliminarComodin(actual);
				actual = actual.darComodinSiguiente();
		}
	}
}
	
	/*
	 * metodo para agregar un descomodin a la lista
	 * @param nuevo, variable tipo descomodin que representa al nuevo descomodin a agregar
	 */
	public void agregarDescomodin(Descomodin nuevo){
		if(primeroDescomodin == null ){
			primeroDescomodin = nuevo;
		}else{
			nuevo.modificarSiguiente(primeroDescomodin);
			primeroDescomodin.modificarAnterior(primeroDescomodin);
			primeroDescomodin  = nuevo;
		}
		
	}
	/*
	 * metodo que elimina un descomodin de la lista
	 * @param actual, variable tipo desccomodin que indica el descomodin a eliminar
	 */
	public void eliminarDescomodin(Descomodin actual){
		boolean terminado = false;
		actual = primeroDescomodin;
		if(primeroDescomodin != null) {
			if(actual.darTiempoAparicion() == 0){
				primeroDescomodin = actual.darSiguiente();
			}else{
				while(!terminado){
					if(actual.darSiguiente() !=null && actual.darSiguiente().darTiempoAparicion() == 0){
						actual.modificarSiguiente(actual.darSiguiente().darSiguiente());
						terminado = true;
					}else{
						actual = actual.darSiguiente();
					}
				}
				
			}
			
		}
		numeroDeDescomodines--;
	}
	/*
	 * metodo que genera nuevo descomodines
	 */
	public void generarDescomodin(){
		int randomDescomodin = (int) (Math.random()*3);
		int randomY = (int) (Math.random()*600);
		int randomX = (int) (Math.random()*600);
			if(randomDescomodin == 1){
				agregarDescomodin(new Veneno('v', randomX, randomY));
			}else{
				agregarDescomodin(new Mina('a',  randomX, randomY));
			}
		numeroDeComodines++;
	}
	/*
	 * metodo que mueve un comodin en el hilo respectivo
	 * 
	 */
	public void moverEnHiloDescomodin(){
		Descomodin actual = primeroDescomodin;
		if(actual != null){
			while(actual !=null){
				actual.mover();
				interseccionDescomodin();
				actual = actual.darSiguiente();
			}
		}
		
	}
	/*
	 * metodo que temporiza el tiempo de un descomodin
	 * @param reductor, variable que indica en cuanto disminuira el tiempo del descomodin
	 */
	public void temporizarHiloDescomodin(int reductor){
		Descomodin actual = primeroDescomodin;
		if(actual != null){
			while(actual !=null){
					while(actual.darTiempoAparicion() != 0){
						actual.temporizarTiempoAparicion(reductor);
					}
					eliminarDescomodin(actual);
				actual = actual.darSiguiente();
		}
	}
	}
	
	/*
	 * metodo que indica si el juego esta o no terminado
	 * @return juegoterm, variable que indica si el juego ya termino
	 */
	public boolean juegoTerminado(){
		boolean juegoTerm = false;
			if(interseccionTubo()){
				juegoTerm = true;
			}
		return juegoTerm;
	}
	
	
	

	
}

