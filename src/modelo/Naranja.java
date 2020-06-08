package modelo;

import java.awt.Rectangle;

public class Naranja extends Comodin {
	public Naranja(char tipo, int posicionX, int posicionY) {
		super(tipo, posicionX, posicionY);
		modificarImagen(Comodin.IMAGEN_NARANJA);
	}
	public long tiempoInmunidad(){
		return Comodin.INMUNIDAD;
	}
	
}
