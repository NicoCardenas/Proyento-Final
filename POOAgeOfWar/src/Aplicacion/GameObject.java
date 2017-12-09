package Aplicacion;

import java.awt.Graphics;
import java.awt.Rectangle;

import Presentacion.Handler;

public abstract class GameObject {
	
	protected int x, y;
	protected int velX, velY;
	Handler handler;

	public GameObject(int x, int y, Handler handler) {
		this.x = x;
		this.y = y;
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setVelX(int velocidadX) {
		this.velX = velocidadX;
	}
	
	public void setVelY(int velocidadY) {
		this.velY = velocidadY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public int getVelY() {
		return velY;
	}

}
