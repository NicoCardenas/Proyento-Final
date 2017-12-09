package Aplicacion;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Presentacion.Handler;

public class HombreAcero extends Soldado {

	public HombreAcero(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		ataque = 5;
		salud = 10;
		defensa = 5;
		precio = 15;
		devolucion = 0;
	}

	@Override
	public void mover() {
		x += velX;
	}
	
	@Override
	public void render(Graphics g) {
		ImageIcon img = new ImageIcon(getClass().getResource("/Recursos/hombreacero.gif"));
		if (jugador.getTipo() == 1) {
			g.drawImage(img.getImage(), x, y, 60, 100, null);
		}else {
			g.drawImage(img.getImage(), x, y, -60, 100, null);
		}
	}
	
	@Override
	public Rectangle getBounds(){
		return new Rectangle(x, y);
	}

}
