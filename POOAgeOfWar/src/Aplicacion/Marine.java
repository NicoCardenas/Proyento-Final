package Aplicacion;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Presentacion.Handler;

public class Marine extends Soldado {

	public Marine(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		ataque = 35;
		salud = 20;
		defensa = 5;
		precio = 40;
		devolucion = 3;
	}

	@Override
	public void mover() {
		x += velX;
	}
	
	@Override
	public void render(Graphics g) {
		ImageIcon img = new ImageIcon(getClass().getResource("/Recursos/marine.gif"));
		if (jugador.getTipo() == 1)
			g.drawImage(img.getImage(), x, y, 50, 100, null);
		else
			g.drawImage(img.getImage(), x, y, -50, 100, null);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
