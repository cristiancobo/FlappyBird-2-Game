package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.EstiloIcorrecto;

public class DialogoPersonajes  extends JDialog implements ActionListener{
	
	//CONSTANTES 
	
	public static final String CANCELAR = "cancelar";
	public static final String ELEGIR = "elegir";
	public static final String IMAGEN_PANTALLA = "imagenes/pantallaPersonajes.png";
	
	//RELACIONES
	private InterfazGoBird principal;
	
	//ATRIBUTOS
	
	
	private JPanel panelOpciones;
	
	private JLabel lbImagen;

	
	private JTextField txtEntrada;
	private JButton btElegir;
	private JButton btCancelar;
	private JLabel lbEnunciado;
	
	/*
	 * METODO CONSTRUCTOR DE LA CLASE
	 */
	public DialogoPersonajes(InterfazGoBird c) {
		principal = c;
		
		Color marino = new Color( 189, 229, 250);
		setTitle("Personajes");
		setSize(200, 640);
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);

		
		panelOpciones = new JPanel();
		panelOpciones.setLayout(new GridLayout(4, 1));
		panelOpciones.setBackground(Color.BLACK);

		Font letra = new Font("Comic Sans MS", Font.PLAIN, 13);
		lbImagen = new JLabel("");
		lbImagen.setIcon(new ImageIcon(IMAGEN_PANTALLA));
		lbEnunciado = new JLabel("            Ingresa tu estilo:");
		lbEnunciado.setFont(letra);
		lbEnunciado.setForeground(Color.white);
		
;
		
		txtEntrada = new JTextField();
		
		btElegir = new JButton("Elegir");
		btElegir.setActionCommand(ELEGIR);
		btElegir.addActionListener(this);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setActionCommand(CANCELAR);
		btCancelar.addActionListener(this);
		panelOpciones.add(lbEnunciado);
		panelOpciones.add(txtEntrada);
		panelOpciones.add(btElegir);
		panelOpciones.add(btCancelar);
		
	
		add(lbImagen, BorderLayout.CENTER);
		add(panelOpciones, BorderLayout.SOUTH);
	}

	
	/*
	 * METODOS DAR Y MODIFICAR DE LA CLASE
	 */
	
	public String darEdicionTxt(){
		return txtEntrada.getText();
	}
	
	/*
	 * METODOS PARA CUMPLIR CON LOS REQUERIMIENTOS
	 */


	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
			if (comando.equals(CANCELAR)) {
				this.dispose();
			}else if (comando.equals(ELEGIR)) {
				int edicion = Integer.parseInt(darEdicionTxt());
				try {
					principal.accionBotonElegir(edicion);
				} catch (EstiloIcorrecto e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Éste estilo no está disponible");
				}
				this.dispose();
			}
		
	}
}
