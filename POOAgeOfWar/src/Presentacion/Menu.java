package Presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Presentacion.AgeOfWarGUI.state;

public class Menu extends MouseAdapter {
	
	AgeOfWarGUI game;
	
	public Menu(AgeOfWarGUI game) {
		this.game = game;
	}

	public void mousePressed(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		
		int width = Window.porcentaje(Window.ANCHO, 0.2);
		int height = Window.porcentaje(Window.ALTO, 0.1);
		
		if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.5), width, height)) {
			game.stateGame = state.Game;
		}
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int nx, int  ny, int x, int y, int width, int height) {
		boolean res = false;
		if (nx > x && nx < x + width) {
			if (ny > y && ny < y + height) {
				res = true;
			}
		}
		return res;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		try {
			ImageIcon img = new ImageIcon(getClass().getResource("/Recursos/fondoMenu.jpeg"));
			g.drawImage(img.getImage(), 0, 0, Window.ANCHO, Window.ALTO-50, null);	
		} catch (Exception e) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Window.ANCHO, Window.ALTO);
		}
		
		Font fuente = new Font("Arial", Font.BOLD, 50);
		Font fuente2 = new Font("Arial", 0, 15);
		
		g.setFont(fuente);
		g.setColor(Color.RED);
		g.drawString("Menu", Window.porcentaje(Window.ANCHO, 0.5)-fuente.getSize(), Window.porcentaje(Window.ALTO, 0.3));
		
		int width = Window.porcentaje(Window.ANCHO, 0.2);
		int height = Window.porcentaje(Window.ALTO, 0.1);
		
		g.setColor(Color.DARK_GRAY);
		g.setFont(fuente2);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.5), width, height);
		g.drawString("Jugador VS Computadora", Window.porcentaje(Window.ANCHO, 0.5)-80, Window.porcentaje(Window.ALTO, 0.5)+(height/2));
		
		g.setColor(Color.DARK_GRAY);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.65), width, height);
		g.drawString("Jugador VS Jugador", Window.porcentaje(Window.ANCHO, 0.5)-60, Window.porcentaje(Window.ALTO, 0.65)+(height/2));
	}
}
