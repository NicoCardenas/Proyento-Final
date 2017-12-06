package Presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.File;

import javax.imageio.ImageIO;

import Aplicacion.Edad;
import Aplicacion.HombrePiedra;

public class AgeOfWarGUI extends Canvas implements Runnable{

	private static final long serialVersionUID = 2391458510354790381L;
	
	Thread thread;
	boolean running = false;
	Handler handler;
	Window ventana;
	HUD hudPlayer;
	HUD hudComputer;
	
	public AgeOfWarGUI(){
		handler = new Handler();
		ventana = new Window("POO Age Of War", this);	
		
		hudPlayer = new HUD(100, Window.porcentaje(Window.ANCHO, 0.015), Window.porcentaje(Window.ALTO, 0.05), 15, 100);
		hudComputer = new HUD(100, Window.porcentaje(Window.ANCHO, 0.96), Window.porcentaje(Window.ALTO, 0.05), 15, 100);
		
		handler.addObject(new HombrePiedra(Window.porcentaje(Window.ALTO, 0.05), Window.porcentaje(Window.ALTO, 0.6), Edad.EDADPIEDRA, handler));
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

		try {
			g.drawImage(ImageIO.read(new File("C:/Users/NickZennin/Documents/GitHub/Proyento-Final/POOAgeOfWar/Recursos/fondo.png")), 0, 0, Window.ANCHO, Window.ALTO-100, null);	
		} catch (Exception e) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Window.ANCHO, Window.ALTO);
		}
		
		handler.render(g);
		
		hudPlayer.render(g);
		hudComputer.render(g);
		
		g.dispose();
		bs.show();
	}

	private void tick() {
		handler.tick();
		hudPlayer.tick();
		hudComputer.tick();
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
