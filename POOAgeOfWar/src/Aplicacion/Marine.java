package Aplicacion;

public class Marine extends Soldado {

	public Marine(int x, int y, Edad id) {
		super(x, y, id);
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

}
