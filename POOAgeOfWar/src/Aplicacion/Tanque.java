package Aplicacion;

import java.awt.Rectangle;

import Presentacion.Handler;

public class Tanque extends Soldado {

	public Tanque(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		setX(50);
		setY(100);
		ataque = 50;
		salud = 100;
		defensa = 50;
		precio = 90;
		devolucion = 4;
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle();
	}


}
