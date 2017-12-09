package Aplicacion;

import java.awt.Rectangle;

import Presentacion.Handler;

public class Marine extends Soldado {

	public Marine(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		setX(50);
		setY(100);
		ataque = 35;
		salud = 20;
		defensa = 5;
		precio = 40;
		devolucion = 3;
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
