package Aplicacion;

import com.sun.javafx.geom.Rectangle;

public class DinosaurioPiedra extends Soldado{

	public DinosaurioPiedra(int x, int y, Edad id) {
		super(x, y, id);
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
