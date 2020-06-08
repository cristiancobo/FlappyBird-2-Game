package modelo;

import javax.swing.ImageIcon;

public class Personaje  {
	
	//CONSTANTES 
	
	
	//RELACIONES
	
	private Personaje izquierdo;
	private Personaje derecho;
	
	//ATRIBUTOS
	private String imagen;
	private int edicion;
	
	/*
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
	public Personaje(String img, int edicion) {
		
		this.imagen = img;
		this.edicion = edicion;
		izquierdo = null;
		derecho = null;
	}


	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
//	public Personaje darIzquierdo() {
//		return izquierdo;
//	}
//
//	public void modificarIzquierdo(Personaje izquierdo) {
//		this.izquierdo = izquierdo;
//	}
//
//	public Personaje darDerecho() {
//		return derecho;
//	}
//
//	public void modificarDerecho(Personaje derecho) {
//		this.derecho = derecho;
//	}

	public String darImagen() {
		return imagen;
	}
//	public void modicarImagen(String imagen) {
//		this.imagen = imagen;
//	}


	public int darEdicion() {
		return edicion;
	}

//
//	public void modificarEdicion(int edicion) {
//		this.edicion = edicion;
//	}
//	
//	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */

	/*
	 * metodo que compara por edicion a los personajes
	 * @param x, personaje el cual se va comparar
	 * @return u, valor de comparacion
	 */
	public int compararPorEdicion(Personaje x){
		int u = 0;
		if(this.edicion > x.edicion){
					u = -1;
		}else if (this.edicion < x.edicion) {
					u = 1;
		}else{
			u =0;
		}
		return u;
	}
	
	/*
	 * metodo que inserta un nuevo Personajes en este nodo
	 * @param x, varible tipo jugador el cual se va insertar
	 */
	
	public void insertar(Personaje x) {
		if(this.compararPorEdicion(x) == 0){
			
		}else if(this.compararPorEdicion(x) > 0){
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
	 *@param edicion, variable tipo int que representa el puntaje con el cual se va buscar el personaje
	 */
	
	public Personaje buscar(int edicion){
		Personaje x = new Personaje("", edicion);
			if(this.compararPorEdicion(x) == 0){
				return this;
			}else if (this.compararPorEdicion(x) > 0) {
				return (derecho == null) ? null : derecho.buscar(x.edicion);
			}else{
				return (izquierdo == null) ? null : izquierdo.buscar(x.edicion);
			}
	}
	
}
