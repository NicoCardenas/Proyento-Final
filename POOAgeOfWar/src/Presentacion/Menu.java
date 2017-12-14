package Presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Presentacion.AgeOfWarGUI.state;

public class Menu extends MouseAdapter {
	
	AgeOfWarGUI game;
	String nombre1;
	String nombre2;
	
	public Menu(AgeOfWarGUI game) {
		this.game = game;
	}

	public void mousePressed(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		
		int width = Window.porcentaje(Window.ANCHO, 0.2);
		int height = Window.porcentaje(Window.ALTO, 0.1);
		
		if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.5), width, height) && game.stateGame == state.Menu) {
			game.stateGame = state.Opcion1;
			nombre1 = JOptionPane.showInputDialog("Nombre del jugador 1");
		}else if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.65), width, height) && game.stateGame == state.Menu) {
			game.stateGame = state.Opcion2;
		}else if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.3), width, height) && game.stateGame == state.Opcion1) {
			game.stateGame = state.GameJvsC;
		}else if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.45), width, height) && game.stateGame == state.Opcion1) {
			game.stateGame = state.GameJvsC;
		}else if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.55), width, height) && game.stateGame == state.Opcion2) {
			nombre1 = JOptionPane.showInputDialog("Nombre del jugador 1");
			nombre2 = JOptionPane.showInputDialog("Nombre del jugador 2");
			game.stateGame = state.GameJvsJ;
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
		
		if (game.stateGame == state.Menu) {
			menu(g);
		}else if (game.stateGame == state.Opcion1) {
			opcion1(g);
		}else if (game.stateGame == state.Opcion2) {
			opcion2(g);
		}
	}
	
	private void menu(Graphics g) {
		//Fuentes
		Font fuente = new Font("Arial", Font.BOLD, 50);
		Font fuente2 = new Font("Arial", 0, 15);
		//Titulo
		g.setFont(fuente);
		g.setColor(Color.RED);
		g.drawString("Menu", Window.porcentaje(Window.ANCHO, 0.5)-fuente.getSize(), Window.porcentaje(Window.ALTO, 0.3));
		//Dimenciones de los botones
		int width = Window.porcentaje(Window.ANCHO, 0.2);
		int height = Window.porcentaje(Window.ALTO, 0.1);
		//Boton 1
		g.setColor(Color.DARK_GRAY);
		g.setFont(fuente2);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.5), width, height);
		g.drawString("Jugador VS Computadora", Window.porcentaje(Window.ANCHO, 0.5)-80, Window.porcentaje(Window.ALTO, 0.5)+(height/2));
		//Boton 2
		g.setColor(Color.DARK_GRAY);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.65), width, height);
		g.drawString("Jugador VS Jugador", Window.porcentaje(Window.ANCHO, 0.5)-60, Window.porcentaje(Window.ALTO, 0.65)+(height/2));
	}
	
	private void opcion1(Graphics g) {
		//Fuente
		Font fuente = new Font("Arial", 0, 15);
		//Dimenciones de los botones
		int width = Window.porcentaje(Window.ANCHO, 0.2);
		int height = Window.porcentaje(Window.ALTO, 0.1);
		//Boton 1
		g.setColor(Color.DARK_GRAY);
		g.setFont(fuente);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.3), width, height);
		g.drawString("Ingenuo", Window.porcentaje(Window.ANCHO, 0.5)-fuente.getSize(), Window.porcentaje(Window.ALTO, 0.3)+(height/2));
		//Boton 2
		g.setColor(Color.DARK_GRAY);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.45), width, height);
		g.drawString("Tacaño", Window.porcentaje(Window.ANCHO, 0.5)-fuente.getSize(), Window.porcentaje(Window.ALTO, 0.45)+(height/2));
	}
	
	private void opcion2(Graphics g) {
		//Fuente
		Font fuente = new Font("Arial", 0, 15);
		//Dimenciones de los botones
		int width = Window.porcentaje(Window.ANCHO, 0.2);
		int height = Window.porcentaje(Window.ALTO, 0.1);
		//Boton 1
		g.setColor(Color.DARK_GRAY);
		g.setFont(fuente);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.5)-(width/2), Window.porcentaje(Window.ALTO, 0.55), width, height);
		g.drawString("Jugar", Window.porcentaje(Window.ANCHO, 0.5)-fuente.getSize(), Window.porcentaje(Window.ALTO, 0.55)+(height/2));
	}
}
