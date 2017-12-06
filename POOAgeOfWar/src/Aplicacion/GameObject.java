package Aplicacion;

import java.awt.Graphics;

import com.sun.javafx.geom.Rectangle;

import Presentacion.Handler;

public abstract class GameObject {
	
	protected int x, y;
	protected Edad id;
	protected int velX, velY;
	Handler handler;

	public GameObject(int x, int y, Edad id, Handler handler) {
		this.x = x;
		this.y = y;
		this.id = id;
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
	
	public void setId(Edad id) {
		this.id = id;
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
	
	public Edad getId() {
		return id;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public int getVelY() {
		return velY;
	}

}
