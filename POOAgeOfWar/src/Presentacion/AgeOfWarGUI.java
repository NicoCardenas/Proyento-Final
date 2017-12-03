package Presentacion;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class AgeOfWarGUI extends Canvas implements Runnable{

	private static final long serialVersionUID = 2391458510354790381L;
	
	Thread thread;
	boolean running = false;
	Handler handler;
	
	public AgeOfWarGUI(){
		Window ventana = new Window("POO Age Of War", this);
		
		handler = new Handler();
	}
	
	@Override
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
		if (bs.equals(null)) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		handler.render(g);
		
		g.dispose();
		bs.show();
	}

	private void tick() {
		handler.tick();
	}

	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop(){
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new AgeOfWarGUI();
	}


}
