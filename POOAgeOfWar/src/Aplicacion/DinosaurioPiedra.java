package Aplicacion;

import java.awt.Rectangle;

import Presentacion.Handler;

public class DinosaurioPiedra extends Soldado{

	public DinosaurioPiedra(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		setX(50);
		setY(100);
		ataque = 2;
		salud = 15;
		defensa = 3;
		precio = 10;
		devolucion = 1;
	}

	@Override
	public void mover() {
		
	}

	@Override
	public void atacar() {
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
