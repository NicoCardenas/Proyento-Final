package Presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Aplicacion.Caballero;
import Aplicacion.CampoDeBatalla;
import Aplicacion.Canion;
import Aplicacion.DinosaurioPiedra;
import Aplicacion.Edad;
import Aplicacion.HombreAcero;
import Aplicacion.HombrePiedra;
import Aplicacion.Jugador;
import Aplicacion.Lancero;
import Aplicacion.Marine;
import Aplicacion.Soldado;
import Aplicacion.Tanque;

public class JuegoJvsJ extends MouseAdapter {

	private AgeOfWarGUI game;
	private Handler handler;
	private CampoDeBatalla juego;
	
	/**
	 * Constructor
	 * @param game
	 * @param handler
	 * @param juego
	 */
	public JuegoJvsJ(AgeOfWarGUI game, Handler handler, CampoDeBatalla juego) {
		this.game = game;
		this.handler = handler;
		this.juego = juego;
	}
	
	/**
	 * Metodo que permite deteminar las acciones del mouse
	 * @param e Evento del mouse
	 */
	public void mousePressed(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		
		int width = Window.porcentaje(Window.ANCHO, 0.025);
		int height = Window.porcentaje(Window.ALTO, 0.05);
		//Jugador 1
		if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.07), Window.porcentaje(Window.ALTO, 0.15), width, height)) {
			game.pushButton = true;
			Soldado tropa = null;
			if (juego.getEdificioEdad1() == Edad.EDADPIEDRA) {
				tropa = new HombrePiedra(0, 0, handler, juego.getUsuario1());
			}else if (juego.getEdificioEdad1() == Edad.EDADMEDIA) {
				tropa = new HombreAcero(0, 0, handler, juego.getUsuario1());
			}else if (juego.getEdificioEdad1() == Edad.EDADINDUSTRIAL) {
				tropa = new Lancero(0, 0, handler, juego.getUsuario1());
			}else if (juego.getEdificioEdad1() == Edad.EDADMODERNA) {
				tropa = new Marine(0, 0, handler, juego.getUsuario1());
			}
			juego.addSoldado(tropa);
		}else if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.12), Window.porcentaje(Window.ALTO, 0.15), width, height)) {
			game.pushButton = true;
			Soldado tropa = null;
			if (juego.getEdificioEdad1() == Edad.EDADPIEDRA) {
				tropa = new DinosaurioPiedra(0, 0, handler, juego.getUsuario1());
			}else if (juego.getEdificioEdad1() == Edad.EDADMEDIA) {
				tropa = new Caballero(0, 0, handler, juego.getUsuario1());
			}else if (juego.getEdificioEdad1() == Edad.EDADINDUSTRIAL) {
				tropa = new Canion(0, 0, handler, juego.getUsuario1());
			}else if (juego.getEdificioEdad1() == Edad.EDADMODERNA) {
				tropa = new Tanque(0, 0, handler, juego.getUsuario1());
			}
			juego.addSoldado(tropa);
		}else if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.17), Window.porcentaje(Window.ALTO, 0.15), width, height)) {
			
			juego.AvanzarEdad(juego.getUsuario1());
		}
		
		//Jugador 2
		if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.8), Window.porcentaje(Window.ALTO, 0.15), width, height)) {
			game.pushButton = true;
			Soldado tropa = null;
			if (juego.getEdificioEdad2() == Edad.EDADPIEDRA) {
				tropa = new HombrePiedra(0, 0, handler, juego.getUsuario2());
			}else if (juego.getEdificioEdad2() == Edad.EDADMEDIA) {
				tropa = new HombreAcero(0, 0, handler, juego.getUsuario2());
			}else if (juego.getEdificioEdad2() == Edad.EDADINDUSTRIAL) {
				tropa = new Lancero(0, 0, handler, juego.getUsuario2());
			}else if (juego.getEdificioEdad2() == Edad.EDADMODERNA) {
				tropa = new Marine(0, 0, handler, juego.getUsuario2());
			}
			
			juego.addSoldado(tropa);
		}else if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.85), Window.porcentaje(Window.ALTO, 0.15), width, height)) {
			game.pushButton = true;
			Soldado tropa = null;
			if (juego.getEdificioEdad2() == Edad.EDADPIEDRA) {
				tropa = new DinosaurioPiedra(0, 0, handler, juego.getUsuario2());
			}else if (juego.getEdificioEdad2() == Edad.EDADMEDIA) {
				tropa = new Caballero(0, 0, handler, juego.getUsuario2());
			}else if (juego.getEdificioEdad2() == Edad.EDADINDUSTRIAL) {
				tropa = new Canion(0, 0, handler, juego.getUsuario2());
			}else if (juego.getEdificioEdad2() == Edad.EDADMODERNA) {
				tropa = new Tanque(0, 0, handler, juego.getUsuario2());
			}
			juego.addSoldado(tropa);
			
		}else if (mouseOver(x, y, Window.porcentaje(Window.ANCHO, 0.9), Window.porcentaje(Window.ALTO, 0.15), width, height)) {
			juego.AvanzarEdad(juego.getUsuario2());
		}
	}
	
	/*
	 * Metodo que determina si el mouse esta en un area
	 */
	private boolean mouseOver(int nx, int  ny, int x, int y, int width, int height) {
		boolean res = false;
		if (nx > x && nx < x + width) {
			if (ny > y && ny < y + height) {
				res = true;
			}
		}
		return res;
	}
	
	/**
	 * Metodo para renderizar
	 * @param g Graficos
	 */
	public void render(Graphics g){
		handler.render(g);
		juego.render(g);
		
		//Dimenciones de los botones
		int width = Window.porcentaje(Window.ANCHO, 0.025);
		int height = Window.porcentaje(Window.ALTO, 0.05);
		//Botones
		g.setColor(Color.DARK_GRAY);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.07), Window.porcentaje(Window.ALTO, 0.15), width, height);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.12), Window.porcentaje(Window.ALTO, 0.15), width, height);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.17), Window.porcentaje(Window.ALTO, 0.15), width, height);
		
		g.setColor(Color.white);
		g.drawString(game.getNombre1(), Window.porcentaje(Window.ANCHO, 0.07), Window.porcentaje(Window.ALTO, 0.07));
		
		g.setColor(Color.DARK_GRAY);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.8), Window.porcentaje(Window.ALTO, 0.15), width, height);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.85), Window.porcentaje(Window.ALTO, 0.15), width, height);
		g.drawRect(Window.porcentaje(Window.ANCHO, 0.9), Window.porcentaje(Window.ALTO, 0.15), width, height);
		
		g.setColor(Color.white);
		g.drawString(game.getNombre2(), Window.porcentaje(Window.ANCHO, 0.8), Window.porcentaje(Window.ALTO, 0.07));
		
	}
}
