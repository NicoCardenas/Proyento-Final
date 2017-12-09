package Aplicacion;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Presentacion.Handler;

public class Caballero extends Soldado {

	public Caballero(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		ataque = 7;
		salud = 15;
		defensa = 10;
		precio = 25;
		devolucion = 2;
	}

	@Override
	public void mover() {
		x += velX;
	}
	
	@Override
	public void render(Graphics g) {
		ImageIcon img = new ImageIcon(getClass().getResource("/Recursos/caballero.gif"));
		if (jugador.getTipo() == 1) {
			g.drawImage(img.getImage(), x+60, y, -120, 120, null);
		}else {
			g.drawImage(img.getImage(), x-60, y, 120, 120, null);
		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
