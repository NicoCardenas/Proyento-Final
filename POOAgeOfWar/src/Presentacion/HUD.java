package Presentacion;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public int HEALT;
	int x, y, ancho, alto;
	
	/**
	 * Constructor
	 * @param vida
	 * @param x posicion x
	 * @param y posicion y
	 * @param ancho
	 * @param alto
	 */
	public HUD(int vida, int x, int y, int ancho, int alto) {
		HEALT = vida;
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}

	/**
	 * Metodo para actualizar datos
	 */
	public void tick() {
		HEALT = AgeOfWarGUI.clamp(HEALT, 0, alto);
	}
	
	/**
	 * Metodo para renderizar
	 * @param g Graficos
	 */
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(x, y, ancho, alto);
		g.setColor(Color.green);
		g.fillRect(x, y, ancho, HEALT);
		g.setColor(Color.white);
		g.drawRect(x, y, ancho, alto);
	}
	
	/**
	 * Asigna la altura.
	 * @param alto altura de la barra
	 */
	public void setAlto(int alto) {
		this.alto = alto; 
	}
	
	/**
	 * Asigna el valor de la vida
	 * @param vida
	 */
	public void setVida(int vida) {
		HEALT = vida;
	}
}
