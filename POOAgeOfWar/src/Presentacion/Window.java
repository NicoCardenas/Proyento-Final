package Presentacion;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Window extends Canvas{

	private static final long serialVersionUID = 3702118492471104108L;
	
	static JFrame ventana;
	
	public static int ANCHO_PREFERIDO;
    public static int ALTO_PREFERIDO;
    public static int ANCHO;
    public static int ALTO;
    
    AgeOfWarGUI juego;
    
    //Elementos del menu
    JMenuBar menuBar;
    JMenu archivo;
    JMenuItem abrir;
    JMenuItem guardar;
    JMenuItem importar;
    JMenuItem exportar;
    JMenuItem salir;
    
    //Archivo
    JFileChooser file;
    
	public Window(String titulo, AgeOfWarGUI ventanaJuego){
		ventana = new JFrame(titulo);
		juego = ventanaJuego;
		ajustes();
		acciones();
	}
	
	private void ajustes() {
		// Tamaño de la pantalla
		GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		ANCHO_PREFERIDO = graphicsDevice.getDisplayMode().getWidth();
        ALTO_PREFERIDO = graphicsDevice.getDisplayMode().getHeight();
		
        // Dimensiones estaticas de la ventana
        ANCHO = porcentaje(ANCHO_PREFERIDO,0.6);
        ALTO = porcentaje(ALTO_PREFERIDO,0.6);
        
		ventana.setPreferredSize(new Dimension(ANCHO, ALTO));
		ventana.setMaximumSize(new Dimension(ANCHO, ALTO));
		ventana.setMinimumSize(new Dimension(ANCHO, ALTO));
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		
		ElementosMenu();
		ventana.add(juego);
		
		ventana.setVisible(true);
		juego.start();
	}
	
	private void acciones(){
		
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitAccion();
				}
			}
		);
		
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
	
	/*
     * Metodo que prepara todos los elementos del menu principal al iniciar el programa
     */
    private void ElementosMenu() {
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
        //agrgando items - iniciar,abrir,salvar,reiniciar,importar,exportar,salir
        archivo.add(abrir);
        archivo.add(guardar);
        archivo.add(importar);
        archivo.add(exportar);
        archivo.add(salir);
        menuBar.add(archivo);
        ventana.setJMenuBar(menuBar);
        file = new JFileChooser();
    }
    
	/*
	 * Metodo para mostrar una confirmación antes de salir
	 */
	public static void exitAccion(){
		if (JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir? ", "Salir del sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	//Metodo que retorna el porcentage de un numero entero 
	public int porcentaje(int numero, double porcentaje) {
		return (int)(numero*porcentaje);
	}
	
}
