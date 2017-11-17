package Presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class AgeOfWar extends JFrame{

	static JFrame ventanaPadre = new MenuGUI();

	public AgeOfWar() {
		super();
		prepararElementos();
		prepareAcciones();
	}

	private void prepararElementos() {
		//Configuracion del la ventana
		setTitle("Age Of War");
		setSize(500, 500);
		setResizable(false);
		center();
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
