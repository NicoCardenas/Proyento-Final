package Presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Aplicacion.CampoDeBatalla;

public class JuegoJvsJ extends MouseAdapter {

	AgeOfWarGUI game;
	Handler handler;
	CampoDeBatalla juego;
	
	public JuegoJvsJ(AgeOfWarGUI game, Handler handler, CampoDeBatalla juego) {
		this.game = game;
		this.handler = handler;
		this.juego = juego;
	}
	
	public void mousePressed(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		
		int width = Window.porcentaje(Window.ANCHO, 0.05);
		int height = Window.porcentaje(Window.ALTO, 0.05);
		
		if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.5), width, height)) {
			
		}else if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.65), width, height)) {
			
		}
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
	
	public void render(Graphics g){
		handler.render(g);
		juego.render(g);
		
		//Dimenciones de los botones
		int width = Window.porcentaje(Window.ANCHO, 0.025);
		int height = Window.porcentaje(Window.ALTO, 0.05);
		//Botones
		g.setColor(Color.DARK_GRAY);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.1), Window.porcentaje(Window.ALTO, 0.15), width, height);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.15), Window.porcentaje(Window.ALTO, 0.15), width, height);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.2), Window.porcentaje(Window.ALTO, 0.15), width, height);
		
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.8), Window.porcentaje(Window.ALTO, 0.15), width, height);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.85), Window.porcentaje(Window.ALTO, 0.15), width, height);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.9), Window.porcentaje(Window.ALTO, 0.15), width, height);
	}
}
