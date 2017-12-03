package Presentacion;

import java.awt.Graphics;

public abstract class GameObject {
	
	protected int x, y;
	protected int id;
	protected int velX, velY;

	public GameObject(int x, int y, int id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setId(int id) {
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
	
	public int getId() {
		return id;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public int getVelY() {
		return velY;
	}

}
