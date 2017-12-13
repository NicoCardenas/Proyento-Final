package Presentacion;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public int HEALT;
	int x, y, ancho, alto;
	

	public HUD(int vida, int x, int y, int ancho, int alto) {
		HEALT = vida;
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}

	public void tick() {
		HEALT = AgeOfWarGUI.clamp(HEALT, 0, alto);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(x, y, ancho, alto);
		g.setColor(Color.green);
		g.fillRect(x, y, ancho, HEALT);
		g.setColor(Color.white);
		g.drawRect(x, y, ancho, alto);
	}
	
	public void setAlto(int alto) {
		this.alto = alto; 
	}
	
	public void setVida(int vida) {
		HEALT = vida;
	}
}
