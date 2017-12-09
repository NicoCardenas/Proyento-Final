package Aplicacion;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Presentacion.Handler;

public class DinosaurioPiedra extends Soldado{

	public DinosaurioPiedra(int x, int y, Handler handler, Usuario jugador) {
		super(x, y , handler, jugador);
		ataque = 2;
		salud = 15;
		defensa = 3;
		precio = 10;
		devolucion = 1;
	}

	@Override
	public void mover() {
		x += velX;
	}
	
	@Override
	public void render(Graphics g) {
		ImageIcon img = new ImageIcon(getClass().getResource("/Recursos/dino.gif"));
		if (jugador.getTipo() == 1) {
			g.drawImage(img.getImage(), x-15, y, 60, 120, null);
		}else {
			g.drawImage(img.getImage(), x+15, y, -60, 120, null);
		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
