package Aplicacion;

import java.awt.Rectangle;

import Presentacion.Handler;

public class Lancero extends Soldado {

	public Lancero(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		setX(50);
		setY(100);
		ataque = 15;
		salud = 10;
		defensa = 5;
		precio = 20;
		devolucion = 2;
	}

	@Override
	public void mover() {
		x += velX;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle();
	}

}
