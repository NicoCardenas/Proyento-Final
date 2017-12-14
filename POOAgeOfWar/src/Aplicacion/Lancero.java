package Aplicacion;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Presentacion.Handler;

public class Lancero extends Soldado {

	public Lancero(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
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
		x += velX;
	}
	
	@Override
	public void render(Graphics g) {
		ImageIcon img = new ImageIcon(getClass().getResource("/Recursos/cazador.gif"));
		if (jugador.getTipo() == 1)
			g.drawImage(img.getImage(), x, y, 50, 100, null);
		else
			g.drawImage(img.getImage(), x, y, -50, 100, null);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle();
	}

}
