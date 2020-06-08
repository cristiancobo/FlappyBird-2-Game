package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import modelo.Jugador;

public class PanelListaJugadores extends JPanel {
	
	//CONSTANTES 
	
	
	//RELACIONES
	
	//private InterfazGoBird principal;
	
	//ATRIBUTOS
	
	private JList<Object> listaJugadores;
	private DefaultListModel<String> modeloListaJugadores;
	private JLabel lbPuntajes;

	
	/*
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
	public PanelListaJugadores() {
		
		
		setLayout(new BorderLayout());
		//principal = c;
		lbPuntajes = new JLabel("                        **       *Nick*       **");
		listaJugadores = new JList<>();
		Color marino = new Color(191, 232, 229  );
		Font letra = new Font("Comic Sans MS", Font.BOLD, 15);
		listaJugadores.setBackground(Color.BLACK);
		listaJugadores.setFont(letra);
		listaJugadores.setForeground(Color.WHITE);
		modeloListaJugadores = new DefaultListModel<>();
		add(lbPuntajes, BorderLayout.NORTH);
		add(listaJugadores, BorderLayout.CENTER);
		add(new JScrollPane(listaJugadores), BorderLayout.CENTER);
		setSize(300,500);

		
	}

	
	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */



	public JList<Object> darListaJugadores() {
		return listaJugadores;
	}


	public void modificarListaJugadores(JList<Object> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}


	public DefaultListModel<String> darModeloListaJugadores() {
		return modeloListaJugadores;
	}


	public void modificarModeloListaJugadores(DefaultListModel<String> modeloListaJugadores) {
		this.modeloListaJugadores = modeloListaJugadores;
	}


	public JLabel darLbPuntajes() {
		return lbPuntajes;
	}


	public void setLbPuntajes(JLabel lbPuntajes) {
		this.lbPuntajes = lbPuntajes;
	}
	
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */
	

	public void actualizarLista(ArrayList<Jugador> jugadores){
		String [] lista = new String[jugadores.size()];
			for (int i = 0; i < lista.length; i++) {
		
				lista[i] = "                 "+jugadores.get(i).darNombre();
			}
			listaJugadores.setListData(lista);
			listaJugadores.updateUI();
			listaJugadores.repaint();
	}
	

}
