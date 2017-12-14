package Aplicacion;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Presentacion.Handler;

public class Tanque extends Soldado {

	public Tanque(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		ataque = 50;
		salud = 100;
		defensa = 50;
		precio = 90;
		devolucion = 4;
	}

	@Override
	public void mover() {
		x += velX;
	}
	
	@Override
	public void render(Graphics g) {
		ImageIcon img = new ImageIcon(getClass().getResource("/Recursos/tanque.gif"));
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
