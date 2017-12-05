package Aplicacion;

public class Lancero extends Soldado {

	public Lancero(int x, int y, Edad id) {
		super(x, y, id);
		setX(50);
		setY(100);
		ataque = 15;
		salud = 10;
		defensa = 5;
		precio = 20;
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

}
