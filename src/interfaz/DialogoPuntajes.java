package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class DialogoPuntajes  extends JDialog implements ActionListener{
	
	//CONSTANTES 
	
	public static final String SALIR = "salir";
	public static final String ORDENAMIENTO_NOMBRE = "1";
	public static final String ORDENAMIENTO_PUNTAJE = "2";
	public static final String ORDENAMIENTO_NIVEL = "3";
	public static final String BUSCAR_NOMBRE = "4";
	public static final String BUSCAR_PUNTAJE = "5";

	
	//RELACIONES
	
	private PanelListaJugadores panelListaJugadores;
	private InterfazGoBird principal;
	
	//ATRIBUTOS
	
	private JButton btSalir;
	private JButton btOnombre;
	private JButton btOpuntaje;
	private JButton btOnivel;
	private JButton btBuscar;
	private JButton btBuscar2;
	
	private JPanel panelBotones;
	
	/*
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
	
	public DialogoPuntajes( InterfazGoBird c) {
		principal = c;
		
		Color marino = new Color(86, 172, 164  );
		panelListaJugadores = new PanelListaJugadores();
		
		
		panelBotones = new JPanel();
		//panelBotones.setSize(40,500);
		panelBotones.setLayout(new GridLayout(6, 1));
		panelBotones.setBackground(Color.black);
		btSalir = new JButton("Salir");
		btSalir.setActionCommand(SALIR);
		btSalir.addActionListener(this);
		
		btOnombre = new JButton("Ordenar por nombre");
		btOnombre.setActionCommand(ORDENAMIENTO_NOMBRE);
		btOnombre.addActionListener(this);
		
		btOpuntaje = new JButton("Ordenar por puntaje");
		btOpuntaje.setActionCommand(ORDENAMIENTO_PUNTAJE);
		btOpuntaje.addActionListener(this);
		
		btOnivel = new JButton("Odenar por nivel");
		btOnivel.setActionCommand(ORDENAMIENTO_NIVEL);
		btOnivel.addActionListener(this);
		
		btBuscar = new JButton("Buscar por nombre.");
		btBuscar.setActionCommand(BUSCAR_NOMBRE);
		btBuscar.addActionListener(this);
		
		btBuscar2 = new JButton("Buscar por puntaje");
		btBuscar2.setActionCommand(BUSCAR_PUNTAJE);
		btBuscar2.addActionListener(this);
		
		panelBotones.add(btOnombre);
		panelBotones.add(btOpuntaje);
		panelBotones.add(btOnivel);
		panelBotones.add(btBuscar);
		panelBotones.add(btBuscar2);
		panelBotones.add(btSalir);
		
		setTitle("Puntajes.");
		setSize(300, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(false);
		setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		
		add(panelListaJugadores, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
			if(comando.equals(SALIR)){
				this.dispose();
			}else if (comando.equals(ORDENAMIENTO_NOMBRE)) {
				principal.actualizarListaPorNombre();
			}else if (comando.equals(ORDENAMIENTO_NIVEL)) {
				principal.actualizarListaPorNivel();
			}else if (comando.equals(ORDENAMIENTO_PUNTAJE)) {
				principal.actualizarListaPorPuntaje();
				
			}else if (comando.equals(BUSCAR_NOMBRE)) {
				principal.buscar();
			}else if (comando.equals(BUSCAR_PUNTAJE)) {
				principal.buscar2();
			}
		
	}
	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */

	public PanelListaJugadores darPanelListaJugadores() {
		return panelListaJugadores;
	}

	public void modificarPanelListaJugadores(PanelListaJugadores panelListaJugadores) {
		this.panelListaJugadores = panelListaJugadores;
	}
	
	
	
	
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */


}
