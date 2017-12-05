package Aplicacion;

public class HombrePiedra extends Soldado{

	public HombrePiedra(int x, int y, Edad id) {
		super(x, y , id);
		setX(50);
		setY(100);
		ataque = 1;
		salud = 10;
		defensa = 0;
		precio = 5;
		devolucion = 1;
	}

	@Override
	public void mover() {
		x += velX;
	}

	@Override
	public void atacar() {

	}

}
