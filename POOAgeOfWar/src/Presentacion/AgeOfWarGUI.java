package Presentacion;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AgeOfWarGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	//Elementos estaticos de la ventana
	static JFrame ventana;
	public static int ANCHO_PREFERIDO;
    public static int ALTO_PREFERIDO;
    public static int ANCHO;
    public static int ALTO;
    //Elementos del menu
    JMenuBar menuBar;
    JMenu archivo;
    JMenuItem abrir;
    JMenuItem guardar;
    JMenuItem importar;
    JMenuItem exportar;
    JMenuItem salir;
    //Ventanas del juego
    JPanel menu;
    JPanel juego;
    JPanel instrucciones;
    //Archivo
    JFileChooser file;
    //Botones
    JButton jugar;
    JButton instructivo;
    JButton salida;
    //labes
    JLabel titulo;
    
    
	public AgeOfWarGUI() {
		super("Menu");
		prepararElementos();
		prepararAcciones();
	}

	private void prepararElementos() {
		// Tamaño de la pantalla
		GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		ANCHO_PREFERIDO = graphicsDevice.getDisplayMode().getWidth();
        ALTO_PREFERIDO = graphicsDevice.getDisplayMode().getHeight();
		/*Dimension graphicsDevice = Toolkit.getDefaultToolkit().getScreenSize();
		ANCHO_PREFERIDO = graphicsDevice.width;
		ALTO_PREFERIDO = graphicsDevice.height;*/
        // Dimensiones estaticas de la ventana
        ANCHO = porcentaje(ANCHO_PREFERIDO,0.6);
        ALTO = porcentaje(ALTO_PREFERIDO,0.6);
        setSize(ANCHO,ALTO);
        setResizable(false);
        // Centrado de la ventana
        setLocation((ANCHO_PREFERIDO - getSize().width)/2, (ALTO_PREFERIDO - getSize().height)/2);
        // Metodo para preparar elementos del menu
        prepareElementosMenu();
        // ventanas
        prepararMenu();
        add(menu);
	}
	
	private void prepararAcciones() {
		// Accion al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Oyentes
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitAccion();
				}
			}
		);
	}
	
	/**
     * Metodo que prepara todos los elementos del menu principal al iniciar el programa
     */
    private void prepareElementosMenu() {
        //menú superior ventana
        menuBar = new JMenuBar();
        // se ocupa un menu por cada columna
        archivo = new JMenu("Archivo");
        // se ocupan items para cada menu o columna
        //items de Archivo
        abrir = new JMenuItem("Abrir");
        guardar = new JMenuItem("Guardar");
        importar = new JMenuItem("Emportar");
        exportar = new JMenuItem("Exportar");       
        salir = new JMenuItem("Salir");
        //agrgando items - iniciar,abrir,salvar,reiniciar,importar,exportar,terminar
        archivo.add(abrir);
        archivo.add(guardar);
        archivo.add(importar);
        archivo.add(exportar);
        archivo.add(salir);
        menuBar.add(archivo);
        setJMenuBar(menuBar);
        file = new JFileChooser();
        
        prepareAccionesMenu();
    }
	
	private void prepareAccionesMenu() {
		// Oyentes del menu
		abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				file.showOpenDialog(ventana);
			}
		});
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				file.showSaveDialog(ventana);
			}
		});
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitAccion();				
			}
		});
	}
	
	private void prepararMenu() {
		//
		menu = new JPanel(new BorderLayout(5, 5));
		//
		titulo = new JLabel("POO Age Of War");
		titulo.setHorizontalAlignment(JLabel.CENTER);	
		titulo.setFont(new Font("Arial", 0, porcentaje(ALTO, 0.15)));
		//Botones
		jugar = new JButton("Jugar");
	    instructivo = new JButton("Instrucciones");
	    salida = new JButton("Salida");
	    //Layout
	    JPanel botones = new JPanel(new GridLayout(3, 1, 5, 5));
	    //
	    botones.add(jugar);
	    botones.add(instructivo);
	    botones.add(salida);
	    //
	    menu.add(titulo, BorderLayout.NORTH);
	    menu.add(botones,BorderLayout.CENTER);
	    menu.add(new JPanel(),BorderLayout.EAST);
	    menu.add(new JPanel(), BorderLayout.WEST);
	    menu.add(new JPanel(), BorderLayout.SOUTH);
	    //
	    setBackground(Color.BLACK);
	}
	
	private void prepararJuego() {
		juego = new JPanel(new BorderLayout(5, 5));
		setBackground(Color.GREEN);
	}
	
	private void prepararInstrucciones() {
		instrucciones = new JPanel(new BorderLayout(5, 5));
		setBackground(Color.BLUE);
	}
	
	//Metodo que retorna el porcentage de un numero entero 
	private int porcentaje(int numero, double porcentaje) {
		return (int)(numero*porcentaje);
	}

	public static void exitAccion(){
		if (JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir? ", "Salir del sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	public static void main(String[] args) {
		ventana = new AgeOfWarGUI();
		ventana.setVisible(true);
	}

}
