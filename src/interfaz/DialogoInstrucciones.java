package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class DialogoInstrucciones extends JDialog implements ActionListener {
	
	
	
	
	//CONSTANTES 
	
	public static final String IMAGEN_FONDO = "imagenes/pantallaInstrucciones.png";
	public static final String SALIR = "salir";
	//RELACIONES
	
	//ATRIBUTOS
	private JLabel imagenFondo;
	private JButton btSalir;
	
	/*
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
	public DialogoInstrucciones() {
		
		setVisible(false);
		setTitle("Instrucciones");
		setSize(500, 700);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		imagenFondo = new JLabel("Hola");
		imagenFondo.setIcon(new ImageIcon(IMAGEN_FONDO));
		imagenFondo.setBounds(0, -10, 500,700);
		btSalir = new JButton("");
		btSalir.setBounds(214, 550, 70, 70);
		btSalir.setActionCommand(SALIR);
		btSalir.addActionListener(this);
		btSalir.setIcon(new ImageIcon("imagenes/salir.png"));
		btSalir.setBorderPainted(false);
		
		add(btSalir);
		add(imagenFondo);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
			if(comando.equals(SALIR)){
				this.dispose();
			}
		
	}
	
	
	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
	
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */

}
