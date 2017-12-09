package Aplicacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Presentacion.Handler;

public class HombrePiedra extends Soldado{

	public HombrePiedra(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		ataque = 1;
		salud = 10;
		defensa = 0;
		precio = 5;
		devolucion = 1;
	}

	@Override
	public void mover() {
		x += velX;
	}

	@Override
	public void damage(int ataque) {
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 100);
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 50, 100);
	}
	
	public int getAtaque() {
		return ataque;
	}

}
