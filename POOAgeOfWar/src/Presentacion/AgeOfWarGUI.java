package Presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;

import Aplicacion.CampoDeBatalla;
import Aplicacion.Computadora;
import Aplicacion.HombreAcero;
import Aplicacion.HombrePiedra;
import Aplicacion.Jugador;

public class AgeOfWarGUI extends Canvas implements Runnable{

	private static final long serialVersionUID = 2391458510354790381L;
	
	Thread thread;
	boolean running = false;
	Handler handler;
	Window ventana;
	
	CampoDeBatalla juego;
	Menu menu;
	JuegoJvsJ juegoJvsJ;
	
	public state stateGame = state.Menu;
	
	public AgeOfWarGUI(){
		
		handler = new Handler();
		ventana = new Window("POO Age Of War", this);
		
		juego = new CampoDeBatalla(handler, this);
		menu = new Menu(this);
		juegoJvsJ = new JuegoJvsJ(this, handler, juego);
		
		this.addMouseListener(menu);
	}
	
	public enum state{
		Menu,
		Opcion1,
		Opcion2,
		GameJvsJ,
		GameJvsC;
	}
	
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
				juego.colisionador();
				frames = 0;
			}
		}
		stop();
	}
	
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
		}else if (stateGame == state.Menu || stateGame == state.Opcion1 || stateGame == state.Opcion2) {
			menu.render(g);
		}
		
		
		g.dispose();
		bs.show();
	}

	private void tick() {
		if (stateGame == state.GameJvsC) {
			handler.tick();
			juego.tick();
		}else if (stateGame == state.Menu) {
			menu.tick();
		}
		
	}

	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop(){
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
