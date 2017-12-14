package Aplicacion;

import java.awt.Graphics;

import Presentacion.AgeOfWarGUI;
import Presentacion.AgeOfWarGUI.state;
import Presentacion.HUD;
import Presentacion.Handler;
import Presentacion.Window;

public class CampoDeBatalla {
	
	private Soldado[] tablero;
	private Edificio[] jugadores;
	private Usuario usuario1;
	private Usuario usuario2;
	private Handler handler;
	private HUD hudPlayer;
	private HUD hudComputer;
	private AgeOfWarGUI game;

	public CampoDeBatalla(Handler handler, AgeOfWarGUI game) {
		tablero = new Soldado[12];
		jugadores = new Edificio[2];
		this.handler = handler;
		this.game = game;
		usuario1 = new Jugador();
		usuario2 = new Computadora("ingenuo");
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
		if(game.stateGame == state.GameJvsC) {
			g.drawString("oro: "+ jugadores[0].getOro(), Window.porcentaje(Window.ANCHO, 0.07), Window.porcentaje(Window.ALTO, 0.1));
		}else if (game.stateGame == state.GameJvsJ) {
			g.drawString("oro: "+ jugadores[0].getOro(), Window.porcentaje(Window.ANCHO, 0.07), Window.porcentaje(Window.ALTO, 0.1));
			g.drawString("oro: "+ jugadores[1].getOro(), Window.porcentaje(Window.ANCHO, 0.8), Window.porcentaje(Window.ALTO, 0.1));
		}
		
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
	
	public void colisionador() {
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
		int winner = -1; 
		if (jugadores[0].getVida() <= 0){
			winner = usuario2.getTipo();
		}else if (jugadores[1].getVida() <= 0){
			winner = usuario1.getTipo();
		}
		return winner;
	}
	
	public Edad getEdificioEdad1() {
		return jugadores[0].getEdad();
	}
	
	public Edad getEdificioEdad2() {
		return jugadores[1].getEdad();
	}
	
	public Edificio getEdificio1() {
		return jugadores[0];
	}
	
	public Edificio getEdificio2() {
		return jugadores[1];
	}
	
	public Usuario getUsuario1() {
		return usuario1;
	}
	
	public void SetUsuario1(Usuario usuario) {
		this.usuario1 = usuario;
	}
	
	public Usuario getUsuario2() {
		return usuario2;
	}
	
	public void SetUsuario2(Usuario usuario) {
		this.usuario2 = usuario;
	}
	
}
