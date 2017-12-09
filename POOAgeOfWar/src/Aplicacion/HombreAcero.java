package Aplicacion;

import java.awt.Rectangle;

import Presentacion.Handler;

public class HombreAcero extends Soldado {

	public HombreAcero(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		setX(50);
		setY(100);
		ataque = 5;
		salud = 10;
		defensa = 5;
		precio = 15;
		devolucion = 0;
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}
	
	public Rectangle getBonds(){
		return new Rectangle(x, y);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
