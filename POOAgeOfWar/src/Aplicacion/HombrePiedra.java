package Aplicacion;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Presentacion.Handler;

public class HombrePiedra extends Soldado{

	public HombrePiedra(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
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
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 100);
	}
	
	@Override
	public void render(Graphics g) {
		ImageIcon img = new ImageIcon(getClass().getResource("/Recursos/cavernicola.gif"));
		if (jugador.getTipo() == 1)
			g.drawImage(img.getImage(), x, y, 50, 100, null);
		else
			g.drawImage(img.getImage(), x, y, -50, 100, null);
	}
	
	public int getAtaque() {
		return ataque;
	}

}
