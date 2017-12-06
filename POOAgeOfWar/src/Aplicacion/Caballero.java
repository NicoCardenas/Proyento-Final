package Aplicacion;

import com.sun.javafx.geom.Rectangle;

public class Caballero extends Soldado {

	public Caballero(int x, int y, Edad id) {
		super(x, y, id);
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
	public void atacar() {
		// TODO Auto-generated method stub

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
