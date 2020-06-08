package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel implements MouseListener, ActionListener{
	
	//CONSTANTES
	
	public static final String JUGAR = "jugar";
	public static final String INSTRUCCIONES = "instrucciones";
	public static final String ELEGIR = "elegir";
	public static final String PUNTAJES = "puntajes";
	
	//RELACIONES
	
	private InterfazGoBird principal;
		
	//ATRTIBUTOS
	private JPanel panelAux;
	private JButton botonJugar;
	private JButton botonIstrucciones;
	private JButton botonPuntajes;
	private JButton botonElegir;
	public  boolean cambioDePantalla = false;
	
	
	/*
	 * METODO CONSTRUTOR DE LA CLASE PanelMenu
	 * 
	 */
	
	public PanelMenu(InterfazGoBird c){
		

		
		/*
		 * INICIALIZO ATRIBUTOS Y RELACIONES DE CLASE PanelMenuGoBird.
		 */
		principal = c;
		panelAux = new JPanel();
		
		botonJugar = new JButton();
		botonJugar.addActionListener(this);
		botonJugar.setActionCommand(JUGAR);
		ImageIcon imagenJugar = new ImageIcon("imagenes/botonJugar.png");
		botonJugar.setIcon(imagenJugar);
		botonJugar.setBorderPainted(false);
		
		botonIstrucciones = new JButton();
		botonIstrucciones.addActionListener(this);
		botonIstrucciones.setActionCommand(INSTRUCCIONES);
		ImageIcon imagenInstrucciones = new ImageIcon("imagenes/instrucciones.png");
		botonIstrucciones.setIcon(imagenInstrucciones);
		botonIstrucciones.setBorderPainted(false);
		
		
		botonPuntajes = new JButton();
		botonPuntajes.addActionListener(this);
		botonPuntajes.setActionCommand(PUNTAJES);
		ImageIcon imagenPuntajes = new ImageIcon("imagenes/botonPuntajes.png");
		botonPuntajes.setIcon(imagenPuntajes);
		botonPuntajes.setBorderPainted(false);
		
		botonElegir = new JButton();
		botonElegir.setActionCommand(ELEGIR);
		botonElegir.addActionListener(this);
		ImageIcon imagenElegir = new ImageIcon("imagenes/elegir.png");
		botonElegir.setIcon(imagenElegir);
		botonElegir.setBorderPainted(false);
		
		/*
		 * CONFIGURACIONES DEL PANEL.
		 * 
		 */
		ImageIcon imagenFondoMenu = new ImageIcon("imagenes/fondoGoBird.png");

		Color colorAzulCielo = new Color(157,217,226);
		panelAux.setBackground(colorAzulCielo);
		setLayout(null);
		botonJugar.setBounds(200, 396, 100, 100);
		botonIstrucciones.setBounds(200, 485, 100, 60);
		botonPuntajes.setBounds(200, 535, 100, 60);
		botonElegir.setBounds(200, 585, 100, 60);
		add(botonJugar);
		add(botonIstrucciones);
		add(botonPuntajes);
		add(botonElegir);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				cambioDePantalla = true;
			}
		});
	}
	
	

	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
	public boolean darCambioDePantalla(){
		return cambioDePantalla;
	}
	
	public void modificarCambioDePantalla(boolean cambio){
		cambioDePantalla = cambio;
	}
	
	//METODOS RELACIONADOS CON MouseListener
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals(JUGAR)){
			principal.accionBotonJugar();
		}else if(comando.equals(INSTRUCCIONES)){
			principal.accionBotonInstrucciones();
			
		}else if(comando.equals(PUNTAJES)){
			principal.actualizarListaPorPuntaje();
			principal.accionBotonPuntajes();
			
		}else if (comando.equals(ELEGIR)) {
			principal.accionBotonEleccion();
		}
	}
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 * 
	 */
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		ImageIcon imagen1 = new ImageIcon("imagenes/pantallaMenu.png");
		g.drawImage(imagen1.getImage(),0,0 , null);

		
		
		
	}

}
