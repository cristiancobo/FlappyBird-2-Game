package test;

import org.junit.Test;

import junit.framework.TestCase;
import modelo.Jugador;
import modelo.PuntajeExiste;

public class JugadorTest extends TestCase {	
	
	private Jugador jugador;
	
	public void escenario1(){
		jugador = new Jugador("Cristobal", 4,0,0,0);
	}
	
	
	@Test
	public void testPeso(){
		escenario1();
		int pesoEsperado = 1;
		int pesoReal = jugador.darPeso();
		assertTrue(pesoEsperado == pesoReal);
		
	}
	
	@Test
	public void testJugadorMayor(){
		escenario1();
		String nombreEsperado = "Pedro";
		try {
			jugador.insertar(new Jugador("Pedro",8,0,0,0));
			jugador.insertar(new Jugador("Jorge",3,0,0,0));

			String nombreReal = jugador.darJugadorDerecho().darNombre();
			assertTrue(nombreEsperado.equals(nombreReal));
		} catch (PuntajeExiste e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testJugadorMenor(){
		escenario1();
		String nombreEsperado = "Jorge";
		try {
			jugador.insertar(new Jugador("Pedro",8,0,0,0));
			jugador.insertar(new Jugador("Jorge",3,0,0,0));

			String nombreReal = jugador.darJugadorIzquierdo().darNombre();
			System.out.println(nombreReal);
			assertTrue(nombreEsperado.equals(nombreReal));
		} catch (PuntajeExiste e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBuscar(){
		escenario1();
		String nombreEsperado = "Jorge";
		
		try {
			jugador.insertar(new Jugador("Pedro",8,0,0,0));
			jugador.insertar(new Jugador("Jorge",3,0,0,0));
			String nombreReal = jugador.buscar(3).darNombre();
			assertTrue(nombreEsperado.equals(nombreReal));
		} catch (PuntajeExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void testEsHoja(){
		escenario1();
		
		boolean esperado = true;
		boolean real = jugador.esHoja();
		assertTrue(esperado == real);
		
	}
}