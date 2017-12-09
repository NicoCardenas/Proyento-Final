package Aplicacion;

import java.awt.Rectangle;

import Presentacion.Handler;

public class Canion extends Soldado {

	public Canion(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		setX(50);
		setY(100);
		ataque = 30;
		salud = 1;
		defensa = 10;
		precio = 20;
		devolucion = 3;
	}

	@Override
	public void mover() {
		x += velX;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
