package Presentacion;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MenuGUI extends JFrame {
	
	JButton jugar = new JButton("Jugar");
	JButton creditos = new JButton("Creditos");
	Container contenedor = new Container();
	JPanel principal = new JPanel(new GridLayout( 3, 10));
	JLabel titulo = new JLabel("Titulo", JLabel.CENTER);

	public MenuGUI() {
		super();
		prepararElementos();
		prepareAcciones();
	}

	public static void main(String[] args) {
		MenuGUI ventana = new MenuGUI();
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitAccion();
				}
			}
		);
		ventana.setVisible(true);
	}
	
	public void prepararElementos() {
		//Configuracion del la ventana
		setTitle("POO Age of war");
		setSize(500, 500);
		setResizable(false);
		center();
		titulo.setFont(new Font("Arial", 0, 32));
		// Agregar elementos
		principal.add(titulo);
		principal.add(jugar);
		principal.add(creditos);
		add(principal);
	}
	
	private void prepareAcciones(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void center(){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - getSize().width)/2;
		int y = (screen.height - getSize().height)/2;
		setLocation(x,y);
	}

	private static void exitAccion(){
		if (JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir? ", "Salir del sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
	}
}
