package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.PrinterResolution;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelo.Comodin;
import modelo.Descomodin;

public class PanelJuego extends JPanel implements MouseListener{
	
	
	//CONSTANTES
	
	public static final int AlTURA_JUEGO  =  700;
	public static final int ANCHURA_JUEGO  =  500;
	public static final String PANTALLA_1 = "imagenes/pantalla1.png";
	public static final String PANTALLA_2 = "imagenes/pantalla2.png";
	public static final String PANTALLA_3 = "imagenes/pantalla3.png";
	public static final String PANTALLA_4 = "imagenes/pantalla4.png";
	
	
	//RELACIONES
	
	
	
	private InterfazGoBird principal;
	

		
	//ATRTIBUTOS
	private int coordenadaX = 0;
	private String imagenFondoJuego;
	
	/*
	 * METODO CONSTRUTOR DE LA CLASE PanelJuego
	 * 
	 */
	
	
	public PanelJuego(InterfazGoBird c){
		
		/*
		 * INICIALIZO ATRIBUTOS Y RELACIONES DE CLASE PanelJuegoGoBird.
		 */	
		
		principal = c;
		addMouseListener(this);
		
		imagenFondoJuego = PANTALLA_1;
		
		
	}
	
	
	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */


	
	public void modificarPantalla(String pantalla){
		imagenFondoJuego = pantalla;
	}
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		

		
		ImageIcon fondo = new ImageIcon(imagenFondoJuego);
		super.paintComponent(g);
		g.drawImage(fondo.getImage(),0,0 ,  null);
		ImageIcon imagenBird = new ImageIcon(principal.darJuego().darBird().darImagenBird());
		int x = principal.darJuego().darBird().darPosicionX();
		int y = principal.darJuego().darBird().darPosicionY();
		g.drawImage(imagenBird.getImage(), x, y, null);
		
		ImageIcon imagenTubo = new ImageIcon(principal.darJuego().darTubo1().darImagenTubo());
		int x2 = principal.darJuego().darTubo1().darPosicionX();
		int y2= principal.darJuego().darTubo1().darPosicionY();
		int z2= principal.darJuego().darTubo1().darAbertura();
		g.drawImage(imagenTubo.getImage(), x2, y2, null);
		g.drawImage(imagenTubo.getImage(), x2, (-PanelJuego.AlTURA_JUEGO)+(principal.darJuego().darTubo1().darPosicionY()-z2), null);
		
		ImageIcon imagenTubo2 = new ImageIcon(principal.darJuego().darTubo2().darImagenTubo());
		int x3 = principal.darJuego().darTubo2().darPosicionX();
		int y3= principal.darJuego().darTubo2().darPosicionY();
		int z3= principal.darJuego().darTubo2().darAbertura();
		g.drawImage(imagenTubo2.getImage(), x3, y3, null);
		g.drawImage(imagenTubo2.getImage(), x3, (-PanelJuego.AlTURA_JUEGO)+(principal.darJuego().darTubo2().darPosicionY()-z3), null);
		
		
		ImageIcon imagenPuntaje =  new ImageIcon("imagenes/puntaje.png");
		g.drawImage(imagenPuntaje.getImage(), 152, 17, null);
		ImageIcon imagenManzana =  new ImageIcon("imagenes/manzana.png");
		g.drawImage(imagenManzana.getImage(), 220, 17, null);
		ImageIcon imagenNaranja =  new ImageIcon("imagenes/naraja.png");
		g.drawImage(imagenNaranja.getImage(), 290, 17, null);
	
		//principal.darJuego().pintarComodin(g);
		
		Font tipoLetra = new Font("Comic Sans MS",Font.BOLD, 25);
		g.setFont(tipoLetra);
		Color rojo1= new Color(255, 0, 100   );
		g.setColor(rojo1);
		g.drawString(principal.darJuego().darPuntaje() +"", 167, 100);
		g.drawString(principal.darJuego().darNumeroComodinManzana() +"", 230, 100);
		g.drawString(principal.darJuego().darNumeroComodinNaranja() +"",300, 100);
		
		Comodin actual = principal.darJuego().darPrimero();
		if(actual != null){
			while(actual !=null){
			ImageIcon imagenComodin = new ImageIcon(actual.darImagen());
				g.drawImage(imagenComodin.getImage(), actual.darPosicionX(), actual.darPosicionY(),null);
					actual = actual.darComodinSiguiente();

			}
		}
		Descomodin actual2 = principal.darJuego().darrPrimeroDescomodin();
		if(actual2 != null){
			while(actual2 !=null){
			ImageIcon imagenComodin2 = new ImageIcon(actual2.darImagen());
				g.drawImage(imagenComodin2.getImage(), actual2.darPosicionX(), actual2.darPosicionY(),null);
					actual2 = actual2.darSiguiente();

			}
		}
		Color rojo = new Color(255, 29, 101  );
		g.setColor(rojo);
		g.fillRect(0, 0, 5, 700);
		g.fillRect(496, 0, 5, 700);
		g.fillRect(0, 673, 500,5);
		g.fillRect(0, 0, 500, 5);
		

		
		

}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		principal.darJuego().manejarBird();
		//System.out.println(e.getX() + " " + e.getY());
		
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


}
