package Aplicacion;

import java.awt.Rectangle;

import Presentacion.Handler;

public class Caballero extends Soldado {

	public Caballero(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		setX(50);
		setY(100);
		ataque = 7;
		salud = 15;
		defensa = 10;
		precio = 25;
		devolucion = 2;
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
