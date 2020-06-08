package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;
import modelo.Comodin;
import modelo.Juego;
import modelo.Jugador;
import modelo.NoExisteJugador;
import modelo.PuntajeExiste;
import modelo.PuntajeNoExiste;

public class TestJuego  extends TestCase{
	
	private Juego juego;
	
	public void escenario1(){
		juego = new Juego();
	}
	
	@Test
	public void testAgregar(){
		escenario1();
		int valorEsperado = 5;
		try {
			juego.agregarJugador("Ana", 0,1,0,0);
			juego.agregarJugador("Miguel", 2,0,0,0);
			juego.agregarJugador("Fede", 3,3,0,0);
			juego.agregarJugador("Chris", 4,4,0,0);
			juego.agregarJugador("Pipe", 5,5,0,0);
		} catch (PuntajeExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int valorReal = juego.darNumeroJugadores();
		assertTrue(valorReal == valorEsperado);
	}
	@Test
	public void testOrdenamientoNombre(){
		escenario1();
		
		Jugador [] esperado = new Jugador [3];
		
		ArrayList<Jugador > x = new ArrayList<>();
		Jugador [] real = new Jugador [3];
		
		x.add(new Jugador("a", 1,0,0,0));
		x.add(new Jugador("c", 3,0,0,0));
		x.add(new Jugador("b", 2,0,0,0));
		
		esperado[0] = x.get(0);
		esperado[1] = x.get(2);
		esperado[2] = x.get(1);
		
		juego.ordenamientoInsercionPorNombre(x);
		real[0] = x.get(0);
		real[1] = x.get(1);
		real[2] = x.get(2);
		
		assertArrayEquals(esperado, real);

	}
	
	@Test
	public void testOrdenamientoPorPuntaje(){
		escenario1();
		
		Jugador [] esperado = new Jugador [3];
		
		ArrayList<Jugador > x = new ArrayList<>();
		Jugador [] real = new Jugador [3];
		
		x.add(new Jugador("a", 1,0,0,0));
		x.add(new Jugador("c", 3,0,0,0));
		x.add(new Jugador("b", 2,0,0,0));
		
		esperado[0] = x.get(1);
		esperado[1] = x.get(2);
		esperado[2] = x.get(0);
		
		juego.ordenamientoInsercionPorPuntos(x);
		real[0] = x.get(0);
		real[1] = x.get(1);
		real[2] = x.get(2);
		
		assertArrayEquals(esperado, real);

		
	}
	
	@Test
	public void testOrdenamientoPorNivel(){
		escenario1();
		
		Jugador [] esperado = new Jugador [3];
		
		ArrayList<Jugador > x = new ArrayList<>();
		Jugador [] real = new Jugador [3];
		
		x.add(new Jugador("a", 1,5,0,0));
		x.add(new Jugador("c", 3,0,0,0));
		x.add(new Jugador("b", 2,1,0,0));
		
		
		esperado[0] = x.get(0);
		esperado[1] = x.get(2);
		esperado[2] = x.get(1);
		
		juego.ordenamientoInsercionPorNivel(x);
		real[0] = x.get(0);
		real[1] = x.get(1);
		real[2] = x.get(2);
		assertArrayEquals(esperado, real);
	}
	
	@Test
	public void testBusquedaBinariaNombre(){
		escenario1();
		String nombreEsperado = "Pipe";
		try {
			juego.agregarJugador("Ana", 0,1,0,0);
			juego.agregarJugador("Miguel", 2,0,0,0);
			juego.agregarJugador("Fede", 3,3,0,0);
			juego.agregarJugador("Chris", 4,4,0,0);
			juego.agregarJugador("Pipe", 5,5,0,0);
			int pos =juego.busquedaBinariaNombre("Pipe");
			assertTrue(nombreEsperado.equals(juego.jugadores().get(pos).darNombre()));
		} catch (PuntajeExiste | NoExisteJugador e) {
			e.printStackTrace();
		}

		
	}

	@Test
	public void testBusquedaBinariaPuntaje(){
		escenario1();
		String nombreEsperado = "c";
			try {
				juego.agregarJugador("a",1,1,0,0);
				juego.agregarJugador("b",2,0,0,0);
				juego.agregarJugador("c",3,1,0,0);
				juego.agregarJugador("d",4,1,0,0);
				juego.agregarJugador("e",5,9,0,0);
				
				int pos = juego.busquedaBinariaPuntaje(3);

				String nombreResultado = juego.jugadores().get(pos).darNombre();
				assertTrue(nombreEsperado.equals(nombreResultado));
				
			} catch (PuntajeExiste | PuntajeNoExiste e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	@Test
	public void testEliminarJugador(){
		escenario1();
		int numeroEsperado = 4;
		try {
			juego.agregarJugador("a",1,1,0,0);
			juego.agregarJugador("b",2,0,0,0);
			juego.agregarJugador("c",3,1,0,0);
			juego.agregarJugador("d",4,1,0,0);
			juego.agregarJugador("e",5,9,0,0);
			juego.eliminarJugador(4);
			
			int numeroResultado = juego.darNumeroJugadores();
			
			assertTrue(numeroEsperado== numeroResultado);
		} catch (PuntajeExiste e) {
			e.printStackTrace();
		}

		
	}



}
