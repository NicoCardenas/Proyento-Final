package Presentacion;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MenuGUI extends JFrame {
	
	//Elementos de la ventana
	public static MenuGUI ventana = new MenuGUI();
	JButton jugar = new JButton("Jugar");
	JButton reglas = new JButton("Reglas");
	JButton creditos = new JButton("Creditos");
	Container contenedor = new Container();
	JPanel principal = new JPanel(new GridLayout( 4, 1));
	JLabel titulo = new JLabel("POO Age of war", JLabel.CENTER);
	//Ventanas adicionales
	AgeOfWar vjuego = new AgeOfWar();
	Reglas vreglas = new Reglas();
	Creditos vcreditos = new Creditos();

	public MenuGUI() {
		super();
		prepararElementos();
		prepareAcciones();
	}

	public static void main(String[] args) {
		ventana.setVisible(true);
	}
	
	public void prepararElementos() {
		//Configuracion del la ventana
		setTitle("POO Age of war");
		setSize(500, 500);
		setResizable(false);
		center();
		principal.setBackground(Color.WHITE);
		jugar.setLayout(new BorderLayout(10, 10));
		titulo.setFont(new Font("Arial", 0, 32));
		// Agregar elementos
		principal.add(titulo);
		principal.add(jugar);
		principal.add(reglas);
		principal.add(creditos);
		add(principal);
	}
	
	private void prepareAcciones(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitAccion();
				}
			}
		);
		
		jugar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vjuego.setVisible(true);
				ventana.dispose();
			}
		});
		
		reglas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vreglas.setVisible(true);
				ventana.dispose();
			}
		});
		
		creditos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vcreditos.setVisible(true);
				ventana.dispose();
			}
		});
	}
	
	private void center(){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - getSize().width)/2;
		int y = (screen.height - getSize().height)/2;
		setLocation(x,y);
	}

	public static void exitAccion(){
		if (JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir? ", "Salir del sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
	}
}
