package Aplicacion;

import java.awt.Graphics;

import Presentacion.HUD;
import Presentacion.Handler;
import Presentacion.Window;

public class CampoDeBatalla {
	
	Soldado[] tablero;
	Edificio[] jugadores;
	Usuario usuario1;
	Usuario usuario2;
	Handler handler;
	HUD hudPlayer;
	HUD hudComputer;

	public CampoDeBatalla(Handler handler) {
		tablero = new Soldado[12];
		jugadores = new Edificio[2];
		this.handler = handler;
		usuario1 = new Jugador();
		usuario2 = new Computadora("novata");
		addEdificios();
	}
	
	private void addEdificios(){
		Edificio jugador1 = new Edificio(0, 0, handler, usuario1);
		Edificio jugador2 = new Edificio(0, 0, handler, usuario2);
		hudPlayer = new HUD(jugador1.getVida(), Window.porcentaje(Window.ANCHO, 0.015), Window.porcentaje(Window.ALTO, 0.05), 15, jugador1.getVida());
		hudComputer = new HUD(jugador2.getVida(), Window.porcentaje(Window.ANCHO, 0.96), Window.porcentaje(Window.ALTO, 0.05), 15, jugador2.getVida());
		jugadores[0] = jugador1;
		jugadores[1] = jugador2;
		jugador1.setX(Window.porcentaje(Window.ANCHO, 0.05));
		jugador1.setY(Window.porcentaje(Window.ALTO, 0.52));
		jugador2.setX(Window.porcentaje(Window.ANCHO, 0.95)-100);
		jugador2.setY(Window.porcentaje(Window.ALTO, 0.52));
		handler.addObject(jugador1);
		handler.addObject(jugador2);
	}
	
	public void tick(){
		hudPlayer.tick();
		hudComputer.tick();
	}
	
	public void render(Graphics g){
		hudPlayer.render(g);
		hudComputer.render(g);
		g.drawString("oro: "+ jugadores[0].getOro(), Window.porcentaje(Window.ANCHO, 0.07), Window.porcentaje(Window.ALTO, 0.1));
	}
	
	public void addSoldado(Soldado tropa) {
		tropa.setY(Window.porcentaje(Window.ALTO, 0.52));
		if (tropa.getUsuario().getTipo() == 1) {
			tropa.setVelX(1);
			tropa.setX(Window.porcentaje(Window.ANCHO, 0.05));
			if (tablero[1] == null) {
				tablero[1] = tropa;
				handler.addObject(tropa);
			}
		}else {
			tropa.setVelX(-1);
			tropa.setX(Window.porcentaje(Window.ANCHO, 0.95)-56);
			if (tablero[tablero.length-2] == null) {
				tablero[tablero.length-2] = tropa;
				handler.addObject(tropa);
			}
		}
	}
	
	public void colicionador() {
		Soldado[] temp = new Soldado[12];
		boolean colision = false;
		for (int i = 1; i < tablero.length-1; i++) {
			if (tablero[i] != null) {
				if (tablero[i].getSalud() <= 0) {
					handler.removeObject(tablero[i]);
					tablero[i] = null;
					return;
				}
				
				if (tablero[i].getUsuario().getTipo() == 1) {
					
					if(i+1 < tablero.length && tablero[i+1] == null) {
						tablero[i].setVelX(1);
						temp[i+1] = tablero[i];
						colision = false;
						
					}else if (i+1 < tablero.length && tablero[i].getUsuario().getTipo() == tablero[i+1].getUsuario().getTipo()){
						tablero[i].setVelX(0);	
					}else {
						tablero[i].damage(tablero[i+1].getAtaque());
						tablero[i].setVelX(0);
						colision = true;
					}
				}else{
					
					if(0 < i-1 && tablero[i-1] == null) {
						tablero[i].setVelX(-1);
						temp[i-1] = tablero[i];
						colision = false;
					}else if (0 < i-1 && tablero[i].getUsuario().getTipo() == tablero[i-1].getUsuario().getTipo()){
						tablero[i].setVelX(0);
					}else {
						if (i == 1){
							jugadores[0].damage(tablero[i].getAtaque());
							hudPlayer.setVida(jugadores[0].getVida());
						}
						else
							tablero[i].damage(tablero[i-1].getAtaque());
						tablero[i].setVelX(0);
						colision = true;
					}					
				}
			}
		}
		if (!colision) tablero = temp.clone();
	}

	public int win(){
		int winer = -1; 
		if (jugadores[0].getVida() <= 0){
			winer = usuario1.getTipo();
		}else if (jugadores[1].getVida() <= 0){
			winer = usuario2.getTipo();
		}
		return winer;
	}
	
}
