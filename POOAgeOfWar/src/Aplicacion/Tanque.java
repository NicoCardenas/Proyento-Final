package Aplicacion;

import com.sun.javafx.geom.Rectangle;

public class Tanque extends Soldado {

	public Tanque(int x, int y, Edad id) {
		super(x, y, id);
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
	public void atacar() {
		// TODO Auto-generated method stub

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
