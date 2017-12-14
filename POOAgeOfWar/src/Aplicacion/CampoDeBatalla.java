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

	/**
	 * Constructor
	 * @param handler
	 * @param game
	 */
	public CampoDeBatalla(Handler handler, AgeOfWarGUI game) {
		tablero = new Soldado[12];
		jugadores = new Edificio[2];
		this.handler = handler;
		this.game = game;
		usuario1 = new Jugador(Usuario.JUGADOR1);
		usuario2 = new Computadora("ingenuo");
		addEdificios();
	}
	
	public void AvanzarEdad(Usuario usuario ){
		//usuario1
		if (usuario.equals(usuario1)){
			if(jugadores[0].getEdad() == Edad.EDADPIEDRA && jugadores[0].getOro() >= 180){
				jugadores[0].setEdad(Edad.EDADMEDIA);
				jugadores[0].setOro(jugadores[0].getOro()-180);
				jugadores[0].setDefensa(jugadores[0].getDefensa() + (Window.porcentaje(jugadores[0].getDefensa(), 0.6)));
				jugadores[0].setVida(jugadores[0].getVida() + (Window.porcentaje(jugadores[0].getVida(), 0.5)));
			}
			if(jugadores[0].getEdad() == Edad.EDADMEDIA && jugadores[0].getOro() >= 270){
				jugadores[0].setEdad(Edad.EDADINDUSTRIAL);
				jugadores[0].setOro(jugadores[0].getOro()-270);
				jugadores[0].setDefensa(jugadores[0].getDefensa() + (Window.porcentaje(jugadores[0].getDefensa(), 0.7)));
				jugadores[0].setVida(jugadores[0].getVida() + (Window.porcentaje(jugadores[0].getVida(), 0.6)));
			}
			if(jugadores[0].getEdad() == Edad.EDADINDUSTRIAL && jugadores[0].getOro() >= 360){
				jugadores[0].setEdad(Edad.EDADMODERNA);
				jugadores[0].setOro(jugadores[0].getOro()-360);
				jugadores[0].setDefensa(jugadores[0].getDefensa() + (Window.porcentaje(jugadores[0].getDefensa(), 0.8)));
				jugadores[0].setVida(jugadores[0].getVida() + (Window.porcentaje(jugadores[0].getVida(), 0.7)));
			}
		}else {
		//usuario2
			if(jugadores[1].getEdad() == Edad.EDADPIEDRA && jugadores[1].getOro() >= 180){
				jugadores[1].setEdad(Edad.EDADMEDIA);
				jugadores[1].setOro(jugadores[1].getOro()-180);
				jugadores[1].setDefensa(jugadores[1].getDefensa() + (Window.porcentaje(jugadores[1].getDefensa(), 0.6)));
				jugadores[1].setVida(jugadores[1].getVida() + (Window.porcentaje(jugadores[1].getVida(), 0.5)));
			}
			if(jugadores[1].getEdad() == Edad.EDADMEDIA && jugadores[1].getOro() >= 270){
				jugadores[1].setEdad(Edad.EDADINDUSTRIAL);
				jugadores[1].setOro(jugadores[1].getOro()-270);
				jugadores[1].setDefensa(jugadores[1].getDefensa() + (Window.porcentaje(jugadores[1].getDefensa(), 0.7)));
				jugadores[1].setVida(jugadores[1].getVida() + (Window.porcentaje(jugadores[1].getVida(), 0.6)));
			}
			if(jugadores[1].getEdad() == Edad.EDADINDUSTRIAL && jugadores[1].getOro() >= 360){
				jugadores[1].setEdad(Edad.EDADMODERNA);
				jugadores[1].setOro(jugadores[1].getOro()-360);
				jugadores[1].setDefensa(jugadores[1].getDefensa() + (Window.porcentaje(jugadores[1].getDefensa(), 0.8)));
				jugadores[1].setVida(jugadores[1].getVida() + (Window.porcentaje(jugadores[1].getVida(), 0.7)));
			}	
		}
	}
	
	/*
	 * Agregar edificios
	 */
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
	/**
	 * Actualización de datos
	 */
	public void tick(){
		hudPlayer.tick();
		hudComputer.tick();
	}
	
	/**
	 * Actualizar los gráficos
	 * @param g gráficos
	 */
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
	
	/**
	 * Agregar soldados
	 * @param tropa un objeto tipo soldado
	 */
	public void addSoldado(Soldado tropa) {
		tropa.setY(Window.porcentaje(Window.ALTO, 0.52));
		if (tropa.getUsuario().getTipo() == 1 && tropa.getPrecio() <= jugadores[0].getOro()) {
			jugadores[0].setOro(jugadores[0].getOro()-(tropa.getPrecio()/2));
			System.out.println(tropa.getPrecio());
			tropa.setVelX(1);
			tropa.setX(Window.porcentaje(Window.ANCHO, 0.05));
			if (tablero[1] == null) {
				tablero[1] = tropa;
				handler.addObject(tropa);
			}
		}else if(tropa.getPrecio() <= jugadores[1].getOro()) {
			jugadores[1].setOro(jugadores[1].getOro()-(tropa.getPrecio()/2));
			tropa.setVelX(-1);
			tropa.setX(Window.porcentaje(Window.ANCHO, 0.95)-56);
			if (tablero[tablero.length-2] == null) {
				tablero[tablero.length-2] = tropa;
				handler.addObject(tropa);
			}
		}
	}
	
	/**
	 * Comprueba movimiento de los soldados, colisión entre soldados y soldados y edificios y la acción de atacar de cada soldado
	 */
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
					
					if(i+1 < tablero.length && tablero[i+1] == null && i != tablero.length-2) {
						tablero[i].setVelX(1);
						temp[i+1] = tablero[i];
						colision = false;
						
					}else if ( i != tablero.length-2 && i+1 < tablero.length && tablero[i].getUsuario().getTipo() == tablero[i+1].getUsuario().getTipo()){
						tablero[i].setVelX(0);	
					}else {
						if (i == tablero.length-2){
							jugadores[1].damage(tablero[i].getAtaque());
							hudComputer.setVida(jugadores[1].getVida());
						}
						else 
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

	/**
	 * Determina el ganador del juego
	 * @return tipo del usuario ganador
	 */
	public int win(){
		int winner = -1; 
		if (jugadores[0].getVida() <= 0){
			winner = usuario2.getTipo();
		}else if (jugadores[1].getVida() <= 0){
			winner = usuario1.getTipo();
		}
		return winner;
	}
	
	/**
	 * Retorna la edad del jugador 1
	 * @return edad jugador 1
	 */
	public Edad getEdificioEdad1() {
		return jugadores[0].getEdad();
	}
	
	/**
	 * Retorna la edad del jugador 2
	 * @return edad jugador 2
	 */	
	public Edad getEdificioEdad2() {
		return jugadores[1].getEdad();
	}
	
	/**
	 * Retorna el edificio del jugador 1
	 * @return edificio jugador 1
	 */
	public Edificio getEdificio1() {
		return jugadores[0];
	}
	
	/**
	 * Retorna el edificio del jugador 2
	 * @return edficio jugador 2
	 */
	public Edificio getEdificio2() {
		return jugadores[1];
	}
	
	/**
	 * Retorna el usuario izquierdo
	 * @return usuario
	 */
	public Usuario getUsuario1() {
		return usuario1;
	}
	
	/**
	 * Asigna el usuario
	 * @param usuario 
	 */
	public void SetUsuario1(Usuario usuario) {
		this.usuario1 = usuario;
	}
	
	/**
	 * Retorna el usuario derecho
	 * @return usuario
	 */
	public Usuario getUsuario2() {
		return usuario2;
	}
	
	/**
	 * Asigna el usuario
	 * @param usuario
	 */
	public void SetUsuario2(Usuario usuario) {
		this.usuario2 = usuario;
	}
	
}
