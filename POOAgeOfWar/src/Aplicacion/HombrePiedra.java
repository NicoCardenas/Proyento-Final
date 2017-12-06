package Aplicacion;

import com.sun.javafx.geom.Rectangle;

import Presentacion.Handler;

public class HombrePiedra extends Soldado{

	public HombrePiedra(int x, int y, Edad id, Handler handler) {
		super(x, y , id, handler);
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
	public void atacar() {

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 50, 100);
	}

}
