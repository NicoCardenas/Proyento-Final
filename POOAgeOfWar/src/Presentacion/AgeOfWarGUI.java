package Presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;

import Aplicacion.CampoDeBatalla;
import Aplicacion.Jugador;

public class AgeOfWarGUI extends Canvas implements Runnable{

	private static final long serialVersionUID = 2391458510354790381L;
	
	//Variables
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private Window ventana;
	
	private CampoDeBatalla juego;
	private Menu menu;
	private JuegoJvsJ juegoJvsJ;
	private JuegoJvsC juegoJvsC;
	private String nombre1;
	private String nombre2;
	
	public state stateGame = state.Menu;
	public boolean pushButton = false;
	
	/**
	 * Constructor
	 */
	public AgeOfWarGUI(){
		
		handler = new Handler();
		ventana = new Window("POO Age Of War", this);
		
		juego = new CampoDeBatalla(handler, this);
		menu = new Menu(this);
		juegoJvsJ = new JuegoJvsJ(this, handler, juego);
		juegoJvsC = new JuegoJvsC(this, handler, juego);
		
		this.addMouseListener(menu);
		this.addMouseListener(juegoJvsC);
		this.addMouseListener(juegoJvsJ);
	}
	
	/**
	 * Enumeracion de estados
	 */
	public enum state{
		Menu,
		Opcion1,
		Opcion2,
		GameJvsJ,
		GameJvsC;
	}
	
	/**
	 * Metodo de actualizacion
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		long ultimoTiempo = System.nanoTime();
		double cantidadTicks = 60.0;
		double ns = 1000000000 / cantidadTicks;
		double delta = 0;
		long minutero = System.currentTimeMillis();
		int frames = 0;
		while (running){
			long actual = System.nanoTime();
			delta += (actual - ultimoTiempo) / ns;
			ultimoTiempo = actual;
			while(delta >= 1){
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			frames++;
			
			if (System.currentTimeMillis() - minutero > 1000) {
				minutero += 1000;
				System.out.println("FPS: " + frames);
				if (juego.win() != -1){
					stop();
				}
				if (!pushButton) {
					juego.colisionador();
				}
				if (stateGame == state.Opcion2) {
					juego.SetUsuario2(new Jugador());
				}
				frames = 0;
			}
			pushButton = false;
		}
		stop();
	}
	
	/*
	 * Metodo de renderizacion
	 */
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		if (stateGame == state.GameJvsJ) {
			try {
				ImageIcon img = new ImageIcon(getClass().getResource("/Recursos/fondo.jpg"));
				g.drawImage(img.getImage(), 0, 0, Window.ANCHO, Window.ALTO-50, null);	
			} catch (Exception e) {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, Window.ANCHO, Window.ALTO);
			}
			juegoJvsJ.render(g);
		}else if (stateGame == state.GameJvsC) {
			try {
				ImageIcon img = new ImageIcon(getClass().getResource("/Recursos/fondo.jpg"));
				g.drawImage(img.getImage(), 0, 0, Window.ANCHO, Window.ALTO-50, null);	
			} catch (Exception e) {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, Window.ANCHO, Window.ALTO);
			}
			juegoJvsC.render(g);
		}else if (stateGame == state.Menu || stateGame == state.Opcion1 || stateGame == state.Opcion2) {
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	/*
	 * Metodo de actualizcion de datos
	 */
	private void tick() {
		nombre1 = menu.getNombre1();
		nombre2 = menu.getNombre2();
		if (stateGame == state.GameJvsC || stateGame == state.GameJvsJ) {
			handler.tick();
			juego.tick();
		}else if (stateGame == state.Menu || stateGame == state.Opcion1 || stateGame == state.Opcion2) {
			menu.tick();
		}	
	}

	/**
	 * Metodo para comenzar un hilo
	 */
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	/**
	 * Metodo para Finalizar un hilo
	 */
	public synchronized void stop(){
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * retorna una cadena que contiene el nombre del jugador
	 * @return String nombre del usuario.
	 */
	public String getNombre1() {
		return nombre1;
	}
	
	/**
	 * retorna una cadena que contiene el nombre del segundo jugador
	 * @return String nombre del usuario.
	 */
	public String getNombre2() {
		return nombre2;
	}
	
	/**
	 * @param valor valor a calcular.
	 * @param min limite inferior.
	 * @param max limite superior.
	 * @return int numero entre un rango especifico
	 */
	public static int clamp(int valor, int min, int max) {
		if (valor >= max) {
			valor = max;
		}else if (valor < min) {
			valor = min;
		}
		return valor;
	}
	
	public static void main(String[] args) {
		new AgeOfWarGUI();
	}


}
