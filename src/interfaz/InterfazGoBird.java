package interfaz;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.ActionMapUIResource;

import hilos.HiloComodin;
import hilos.HiloDescomodin;
import hilos.HiloMoverComodin;
import hilos.HiloMoverDescomodin;
import hilos.HiloMovimientoBird;
import hilos.HiloPrincipal;
import hilos.HiloTemporizadorComodin;
import hilos.HiloTemporizadorDescomodin;
import modelo.EstiloIcorrecto;
import modelo.Juego;
import modelo.Jugador;
import modelo.NoExisteJugador;
import modelo.Personaje;
import modelo.PuntajeExiste;
import modelo.PuntajeNoExiste;

public class InterfazGoBird extends JFrame implements ActionListener {
	
	//CONSTANTES
	
	public static final ImageIcon ICONO_VENTANA = new ImageIcon("imagenes/bird.png");
	
	//RELACIONES
	
	private PanelMenu panelMenu;
	private PanelJuego panelJuego;
	private DialogoPuntajes dialogoPuntajes;
	private DialogoPersonajes dialogoPersonajes;
	private DialogoInstrucciones dialogoInstrucciones;
	private HiloMovimientoBird hiloMovimientoBird;
	private HiloComodin hiloComodin;
	private HiloMoverComodin hiloMoverComodin;
	private HiloTemporizadorComodin hiloTemporizadorComodin;
	private HiloDescomodin hiloDescomodin;
	private HiloMoverDescomodin hiloMoverDescomodin;
	private HiloTemporizadorDescomodin hiloTemporizadorDescomodin ;
	private HiloPrincipal hiloPrincipal;
	private Juego juego;	
	
	//ATRTIBUTOS
	
	/*
	 * Metodo constructor de la clase InterfazGoBird
	 */
	public InterfazGoBird(){
		/*
		 * INICIALIZO ATRIBUTOS Y RELACIONES DE CLASE IntergazGoBird.
		 */
		panelMenu = new PanelMenu(this);
		panelJuego = new PanelJuego(this);
		dialogoPuntajes = new DialogoPuntajes(this);
		dialogoPersonajes = new DialogoPersonajes(this);
		dialogoInstrucciones = new DialogoInstrucciones();
		juego = new Juego();
		hiloMovimientoBird = new HiloMovimientoBird(this);
		hiloComodin = new HiloComodin(this, juego);
		hiloMoverComodin = new HiloMoverComodin(this, juego);
		hiloTemporizadorComodin = new HiloTemporizadorComodin(this, juego);
		hiloPrincipal = new HiloPrincipal(this, juego);
		hiloDescomodin = new HiloDescomodin(this, juego);
		hiloMoverDescomodin = new HiloMoverDescomodin(this, juego);
		hiloTemporizadorDescomodin = new HiloTemporizadorDescomodin(this, juego);
		cargar();
		
		//----------------------------------------------------------------
		
		/*
		 * CONFIGURACIONES DE LA VENTANA PRINCIPAL 
		 *
		 */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,700);
		setResizable(true);
		setTitle("GoBird");
		setLocationRelativeTo(null);
		//setVisible(true);
		cargarPantallas();
		
	}	
	
	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
	
	public PanelMenu darPanelMenu(){
		return panelMenu;
	}
	public PanelJuego darPanelJuego(){
		return panelJuego;
	}
	
	public Juego darJuego(){
		return juego;
	}
	
	public HiloMovimientoBird darHiloMovimientoBird() {
		return hiloMovimientoBird;
	}

	public void modificarHiloMovimientoBird(HiloMovimientoBird hiloMovimientoBird) {
		this.hiloMovimientoBird = hiloMovimientoBird;
	}

	public HiloComodin darHiloComodin() {
		return hiloComodin;
	}

	public void modificarHiloComodin(HiloComodin hiloComodin) {
		this.hiloComodin = hiloComodin;
	}

	public HiloMoverComodin darHiloMoverComodin() {
		return hiloMoverComodin;
	}

	public void modificarHiloMoverComodin(HiloMoverComodin hiloMoverComodin) {
		this.hiloMoverComodin = hiloMoverComodin;
	}

	public HiloTemporizadorComodin darHiloTemporizadorComodin() {
		return hiloTemporizadorComodin;
	}

	public void modificarHiloTemporizadorComodin(HiloTemporizadorComodin hiloTemporizadorComodin) {
		this.hiloTemporizadorComodin = hiloTemporizadorComodin;
	}

	public void cargarPantallas(){
	
		add(panelMenu);

		
	}
	
	public HiloDescomodin darHiloDescomodin() {
		return hiloDescomodin;
	}

	public void modificarHiloDescomodin(HiloDescomodin hiloDescomodin) {
		this.hiloDescomodin = hiloDescomodin;
	}

	public HiloMoverDescomodin darHiloMoverDescomodin() {
		return hiloMoverDescomodin;
	}

	public void modificarHiloMoverDescomodin(HiloMoverDescomodin hiloMoverDescomodin) {
		this.hiloMoverDescomodin = hiloMoverDescomodin;
	}

	public HiloTemporizadorDescomodin darHiloTemporizadorDescomodin() {
		return hiloTemporizadorDescomodin;
	}

	public void modificarHiloTemporizadorDescomodin(HiloTemporizadorDescomodin hiloTemporizadorDescomodin) {
		this.hiloTemporizadorDescomodin = hiloTemporizadorDescomodin;
	}
	
	
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS DE LA CLASE
	 */
	


		/*
	 * 
	 */
		public void ejecutarJuego(){
			int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea renudar partida?.", "Aviso ",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ICONO_VENTANA);
			if(pregunta == 0){
				String ventana = JOptionPane.showInputDialog("Ingresa el puntaje del jugador");
				try {
					
					int puntos = Integer.parseInt(ventana);
					juego.modificarPuntajeTemporalJugador(juego.establecerItemsActuales(puntos).darPuntaje());
					juego.modificarMaquina(true);
					hiloComodin.start();
					hiloDescomodin.start();
					hiloMoverComodin.start();
					hiloMoverDescomodin.start();
					remove(panelMenu);
					this.add(panelJuego);
					hiloMovimientoBird.start();
					hiloTemporizadorComodin.start();
					hiloTemporizadorDescomodin.start();
					hiloPrincipal.start();
					
					revalidate();
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Solo puedes ingresar numeros.");
				}
				
				
				
			}else{
				
				hiloComodin.start();
				hiloDescomodin.start();
				hiloMoverComodin.start();
				hiloMoverDescomodin.start();
				remove(panelMenu);
				this.add(panelJuego);
				hiloMovimientoBird.start();
				hiloTemporizadorComodin.start();
				hiloTemporizadorDescomodin.start();
				hiloPrincipal.start();
				revalidate();
				
			}
				
		}

		
	/*
	 * Se ejecuta cuando se presionar el botor jugar de la clase PanelMenu
	 */
	
	public void accionBotonJugar(){
		ejecutarJuego();
	}
	
	/*
	 * Se ejecuta cuando se presionar el boton  Instrucciones jugar de la clase PanelMenu
	 */
	public void accionBotonInstrucciones(){
		
		dialogoInstrucciones.setVisible(true);
	}
	public void accionBotonEleccion(){
		dialogoPersonajes.setVisible(true);
		
	}
	
	public void accionBotonElegir(int edicion) throws EstiloIcorrecto{
		Personaje buscado = juego.buscarPersonaje(edicion);
			if(buscado == null){
				throw new EstiloIcorrecto("El estilo no se encuntra disponible");
			}else{
				juego.darBird().modificarImagenBird(juego.buscarPersonaje(edicion).darImagen());
			}

	}
	
	/*
	 * Se ejecuta cuando se presionar el botor puntajes de la clase PanelMenu
	 */
	public void accionBotonPuntajes(){
		dialogoPuntajes.setVisible(true);
	}
	
	/*
	 * actualiza los elementos del PanelJuego 
	 */
	public void refrescar(){
		panelJuego.repaint();
		
	}
	/*
	 * 
	 */
	public void guardar(){
		try {
			juego.guardar();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error en guardar la partida");
		}
	}
	/*
	 * 
	 */
	public void cargar(){
		try {
			juego.cargar();
		} catch (ClassNotFoundException | IOException e) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido una error solucionando el error");
				this.dispose();
		}
	}
	/*
	 * llama el metodo registrar de la clase juego
	 */
	public void registrarJugador(String nombre , int puntaje, int nivel, int manzanas , int naranjas) throws PuntajeExiste{
		juego.agregarJugador(nombre, puntaje, nivel, manzanas , naranjas);
		actualizarListaPorNombre();
		try {
			juego.registroJugadores();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 
	 */


	public void actualizarListaPorNombre(){
		dialogoPuntajes.darPanelListaJugadores().actualizarLista(juego.ordenamientoInsercionPorNombre(juego.jugadores()));
	}
	/*
	 * 
	 */
	public void actualizarListaPorPuntaje(){
		dialogoPuntajes.darPanelListaJugadores().actualizarLista(juego.ordenamientoInsercionPorPuntos(juego.jugadores()));
	}
	/*
	 * 
	 */
	public void actualizarListaPorNivel(){
		dialogoPuntajes.darPanelListaJugadores().actualizarLista(juego.ordenamientoInsercionPorNivel(juego.jugadores()));
	}
	
	
	
	/*
	 * 
	 */
	public void buscar(){
		String nombre = JOptionPane.showInputDialog("Ingresa el nombre");
		int pos;
		try {
			pos = juego.busquedaBinariaNombre(nombre);
			String mensaje = "Informacion:" +"\n"+ 
					"Nick: "+ juego.ordenamientoInsercionPorNombre(juego.jugadores()).get(pos).darNombre()
			+"\n"+"Nivel: "+juego.ordenamientoInsercionPorNombre(juego.jugadores()).get(pos).darNivel()+
			"\n"+"Puntaje: "+juego.ordenamientoInsercionPorNombre(juego.jugadores()).get(pos).darNivel();
	JOptionPane.showMessageDialog(null,mensaje );
		} catch (NoExisteJugador e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	
		
		
	}
	/*
	 * 
	 */
	
	public void buscar2(){
		int puntos = Integer.parseInt( JOptionPane.showInputDialog("Ingresa el nombre"));
		int pos;
		try {
			pos = juego.busquedaBinariaPuntaje(puntos);
			String mensaje = "Informacion:"
					 +"\n"+ 	"Nick: "+ juego.ordenamientoInsercionPorPuntos(juego.jugadores()).get(pos).darNombre()
			 +"\n"+ 	"Nivel: "+ juego.ordenamientoInsercionPorPuntos(juego.jugadores()).get(pos).darNivel()
			 +"\n"+ 	"Puntaje: "+ juego.ordenamientoInsercionPorPuntos(juego.jugadores()).get(pos).darPuntaje();
	JOptionPane.showMessageDialog(null,mensaje );
		} catch (PuntajeNoExiste e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	public void juegoTerminado(){
		
		if(juego.juegoTerminado()){
			if(juego.darMaquina() == false){
				JOptionPane.showMessageDialog(null, "Game Over!");
				int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea registrar el puntaje?.", "Aviso ",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ICONO_VENTANA);
					if(pregunta == 0){
					
						String nombre = JOptionPane.showInputDialog("Ingresa tu nombre:");

						int puntaje =juego.darPuntaje();
						int manzanas = juego.darNumeroComodinManzana();
						int naranjas = juego.darNumeroComodinNaranja();
						int nivel = juego.darNivel();
						
						try {
							registrarJugador(nombre,puntaje,nivel, manzanas, naranjas);
							guardar();
							this.dispose();
						} catch (PuntajeExiste e) {
								JOptionPane.showMessageDialog(null, e.getMessage());
								JOptionPane.showMessageDialog(null,"");
						}	
				
			}else{
				this.dispose();
				System.out.println("Gracias");
			}
				
			}else{
				JOptionPane.showMessageDialog(null, "Game Over!");
				int puntajeInicial = juego.darPuntajeTemporalJugador();
				int puntajeFinal = juego.darPuntaje();
				int manzanas = juego.darNumeroComodinManzana();
				int naranjas = juego.darNumeroComodinNaranja();
				juego.actualizarJugador(puntajeInicial, puntajeFinal, manzanas, naranjas);
				guardar();
				System.err.println("Aplicacion terminada");
				this.dispose();
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	/*
	 * METODO PRINCIPAL DEL PROYECTO.
	 */

	public static void main(String[] args){
		InterfazGoBird goBird = new InterfazGoBird();
		goBird.setVisible(true);
				
				
	}

}
