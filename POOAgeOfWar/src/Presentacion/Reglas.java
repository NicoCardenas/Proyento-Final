package Presentacion;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Reglas extends JFrame{
	
	static JFrame ventanaPadre = new MenuGUI();
	JPanel layout = new JPanel(new BorderLayout(50, 50));
	JLabel titulo = new JLabel("Reglas", JLabel.CENTER);
	JLabel texto = new JLabel();

	public Reglas() {
		super();
		prepararElementos();
		prepareAcciones();
	}
	
	private void prepararElementos() {
		//Configuracion del la ventana
		setTitle("Reglas de Juego");
		setSize(500, 500);
		setResizable(false);
		center();
		titulo.setVerticalAlignment(JLabel.CENTER);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Arial", 0, 32));
		texto.setText("Reglas del juego:");
		texto.setFont(new Font("Arial", 0, 14));
		texto.setHorizontalAlignment(JLabel.CENTER);
		layout.add(titulo, BorderLayout.NORTH);
		layout.add(texto, BorderLayout.CENTER);
		add(layout);
	}
	
	private void prepareAcciones() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				dispose();
				ventanaPadre.setVisible(true);
			}
		});
	}
	
	private void center(){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - getSize().width)/2;
		int y = (screen.height - getSize().height)/2;
		setLocation(x,y);
	}

}
