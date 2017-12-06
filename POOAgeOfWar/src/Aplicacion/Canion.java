package Aplicacion;

import com.sun.javafx.geom.Rectangle;

public class Canion extends Soldado {

	public Canion(int x, int y, Edad id) {
		super(x, y, id);
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
