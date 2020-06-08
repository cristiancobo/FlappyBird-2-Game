
package modelo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable {
	
	//CONSTANTES
	
	//RELACIONES
	
	private Jugador derecho;
	private Jugador izquierdo;
	
	//ATRIBUTOS
	private String nombre;
	private int puntaje;
	private int nivel;
	private int numeroComodinManaza;
	private int numeroComodinNaranja;
	private String personaje;
	private ArrayList<Jugador> arrayJugaodores;
	
	/*
	 * METODO CONSTRUCTOR DE CLASE 
	 */
	
	public Jugador(String nombre, int puntaje , int nivel, int numeroComodinManzana, int numeroComodinNaranja) {
		super();
		this.nombre = nombre;
		this.puntaje = puntaje;
		this.nivel = nivel;
		this.numeroComodinManaza =numeroComodinManzana;
		this.numeroComodinNaranja = numeroComodinNaranja;
		this.personaje = "imagenes/birdRojo.png";
		arrayJugaodores = new ArrayList<>();
	}
	
	
	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
	/*
	 * metodo que retorna el nombre del jugador
	 * @return nombre, variable que representa el nombre  del jugador
	 */
	public String darNombre(){
		return nombre;
	}

	/*
	 * metodo que retorna el puntaje del jugador
	 * @return puntaje, variable que representa el puntaje del jugador
	 */
	public int darPuntaje(){
		return puntaje;
	}
	/*
	 * metodo que modifica el puntaje del jugador
	 * @param puntaje, variable que representa el nuevo puntaje del jugador
	 */
	public void modificarPuntaje(int puntaje){
		this.puntaje= puntaje;
	}
	
	/*
	 * metodo que retorna el nivel del jugador
	 * @return nivel, variable que representa el nivel de jugador
	 */
	public int darNivel(){
		return nivel;
	}
	/*
	 * metodo que modifica el nivel del jugador
	 * @param nivel, variable tipo int que representa el nuevo nivel de jugador
	 */
	
	public void modificarNivel(int nivel){
		this.nivel = nivel;
	}
	/*
	 * metodo que retorna el jugador izquierdo de este nodo
	 * @return izquierdo, variable tipo Jugador que representael jugador izquierdo de este nodo
	 */
	public Jugador darJugadorIzquierdo(){
		return izquierdo;
	}

	/*
	 * metodo que retorna el jugador derecho de este nodo
	 * @return derecho, variable tipo Jugador que representael jugador izquierdo de este nodo
	 */
	public Jugador darJugadorDerecho(){
		return derecho;
	}

	/*
	 * metodo que retorna el numero de manzanas del jugador
	 * @return numeroComodinManaza, variable tipo int que representa el numero de manazanas del jugador
	 */
	public int darNumeroComodinManaza() {
		return numeroComodinManaza;
	}
	/*
	 * metodo que modifica el numero de manzanas del jugador
	 * @param numeroComodinManaza, variable tipo int que representa el nuevo numero de manzanas del jugador
	 */
	public void modificarNumeroComodinManaza(int numeroComodinManaza) {
		this.numeroComodinManaza = numeroComodinManaza;
	}

	/*
	 * metodo que retorna el numero de naranajas del jugador
	 * @return numeroComodinManaza, variable tipo int que representa el numero de naranjas del jugador
	 */
	public int darNumeroComodinNaranja() {
		return numeroComodinNaranja;
	}

	/*
	 * metodo que modifica el numero de naranajas del jugador
	 * @param numeroComodinManaza, variable tipo int que representa el nuevo numero de naranjas del jugador
	 */
	public void modificarNumeroComodinNaranja(int numeroComodinNaranja) {
		this.numeroComodinNaranja = numeroComodinNaranja;
	}
	@Override
	public String toString() {
		
		return "      "+nivel +"    |    "+ puntaje + "     |    " +nombre;
	}

	
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */

	
	/*
	 * metodo que retorna el numero de nodos del arbol binario
	 * @return cantidad de nodos del arbol
	 */
    public int darPeso( )
    {
        int p1 = ( izquierdo == null ) ? 0 : izquierdo.darPeso( );
        int p2 = ( derecho == null ) ? 0 : derecho.darPeso( );
        return 1 + p1 + p2;
    }



	/*
	 * metodo que compara por puntos un jugador con otro por puntos
	 * @param x, variable tipo jugador que representa el jugador para comparar
	 * @return u, variable tipo int que representa el resultado de la comparacion
	 */
	public int compararPorPuntos(Jugador x){
		int u = 0;
		if(this.puntaje > x.puntaje){
					u = -1;
		}else if (this.puntaje < x.puntaje) {
					u = 1;
		}else{
			u =0;
		}
		return u;
	}
	/*
	 * metodo que compara por puntos un jugador con otro por nivel
	 * @param x, variable tipo jugador que representa el jugador para comparar
	 * @return u, variable tipo int que representa el resultado de la comparacion
	 */
	public int compararPorNivel(Jugador x){
		int u = 0;
		if(this.nivel > x.nivel){
					u = -1;
		}else if (this.nivel < x.nivel) {
					u = 1;
		}else{
			u =0;
		}
		return u;
	}
	/*
	 * metodo que compara por puntos un jugador con otro por nombre
	 * @param x, variable tipo jugador que representa el jugador para comparar
	 * @return u, variable tipo int que representa el resultado de la comparacion
	 */
	public int compararPorNombre(Jugador x){
        int valorComparacion = nombre.compareToIgnoreCase( x.nombre );
    	if(valorComparacion < 0){
    		valorComparacion = -1;
    	}else if(valorComparacion == 0){
    		valorComparacion = 0;
    	}else{
    		valorComparacion = 1;
    	}
        return valorComparacion;
	}

	/*
	 * Metodo que escribe la informacion de cada jugador en un archivo plano
	 * @param x, variable tipo jugador el, cual se escribira en el archivo
	 * @param pw, variable tipo Printwriter que  representa el escritor
	 */
	public void inOrden3(Jugador x, PrintWriter pw){
		if(x !=null){
			inOrden3(x.derecho, pw);
				pw.write(x.toString());
					inOrden3(x.izquierdo, pw);
		}
	}
	/*
	 * metodo que retorna el jugador con menor puntaje en la parte de este nodo
	 * @return jugador mayor a este nodo
	 */
	public Jugador jugadorMayor(){
		 return (derecho == null) ? null : derecho.jugadorMayor();
	}
	
	/*
	 * metodo que retorna el jugador con menor puntaje en la parte de este nodo
	 * @return jugador menor a este nodo
	 */
	
	public Jugador jugadorMenor(){
		return (izquierdo == null) ? null : izquierdo.jugadorMenor();
	}
	
	/*
	 *  metodo que Inserta un nuevo jugador al arbol que conmienza en este nodo
	 *  @param x, variable tipo jugador que se va a insertar
	 */
	
	public void insertar(Jugador x) throws PuntajeExiste{
		if(this.compararPorPuntos(x) == 0){
			throw new PuntajeExiste("Ya existe un jugador con este puntaje." + "\n "+ "Sé unico y rompe el Record.");
		}else if(this.compararPorPuntos(x ) > 0){
			if(derecho == null){
				derecho = x;
			}else{
				derecho.insertar(x);
			}
		}else{
			if(izquierdo == null){
				izquierdo= x;
			}else{
				izquierdo.insertar(x);
			}
		}
	}
	
	/*
	 * metodo que Busca un contacto de forma recursiva en la parte donde comienza este nodo
	 * @param puntaje, variable tipo int que representa el puntaje con el que se va buscar
	 */
	
	public Jugador buscar(int puntaje){
		Jugador x = new Jugador("", puntaje, 0,0,0);
			if(this.compararPorPuntos(x) == 0){
				return this;
			}else if (this.compararPorPuntos(x) > 0) {
				return (derecho == null) ? null : derecho.buscar(x.puntaje);
			}else{
				return (izquierdo == null) ? null : izquierdo.buscar(x.puntaje);
			}
	}
	

	/*
	 * metodo que Elimina un jugador del Arbol que comienza en este nodo 
	 * @param puntaje, variable tipo int que representa el puntaje del jugador a eliminar
	 */
	
	public Jugador eliminar(int puntaje){
		Jugador x = new Jugador("", puntaje, 0,0,0);
		//x.modificarPuntaje(puntaje);
			if(esHoja()){
				return null;
			}
		if(this.compararPorPuntos(x) == 0 ){
			if(izquierdo == null){
				return derecho;
			}
			if(derecho == null){
				return izquierdo;
			}
			Jugador suscesor = derecho.jugadorMenor();
			derecho = derecho.eliminar(suscesor.puntaje);
			suscesor.izquierdo = izquierdo;
			suscesor.derecho =derecho;
			return suscesor;
			
		}else if (this.compararPorPuntos(x) > 0) {
			derecho = derecho.eliminar(x.puntaje);
		}else{
			izquierdo = izquierdo.eliminar(x.puntaje);
		}
		
		return this;
	}
	
	/*
	 * metodo que Indica si este nodo es o no una hoja
	 * @return valor booleano que indica si el nodo actual es una hoja
	 * 
	 */
	
	public boolean esHoja(){
		return izquierdo == null && derecho == null;
	}
	
	/*
	 * metodo que recorre y agrega jugadores a un arraylist
	 * @param c, arraylist tipo Jugador 
	 * @param x, jugador el cual se va agregar al arraylist 
	 */
	public void listaNombres(Jugador x , ArrayList<Jugador > c){
		if(x != null){
			listaNombres(x.izquierdo, c);
				c.add(x);
				 	listaNombres(x.derecho, c);
			
		}
	
	}

}
