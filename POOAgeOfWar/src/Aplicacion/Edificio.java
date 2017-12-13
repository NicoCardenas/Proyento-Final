package Aplicacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Presentacion.HUD;
import Presentacion.Handler;
import Presentacion.Window;

public class Edificio extends GameObject{

	//-------------------
	//Atributos de clase
	//-------------------

	private int vida;
	private int defensa;
	private int oro;
	private Edad edad;
	int time;
	Usuario usuario;

	//-------------------
	//Constructores
	//-------------------

	public Edificio(int x, int y, Handler handler, Usuario usuario) {
		super(x, y, handler);
		this.edad = Edad.EDADPIEDRA;
		this.vida = 50;
		this.defensa = 0;
		this.oro = 0;
		this.usuario = usuario;
	}
	
	//Edificio

	//-------------------
	//Metodos de acceso
	//-------------------

	public void setVida(int vida){
		this.vida = vida;
	}

	public int getVida(){
		return vida;
	}

	public void setDefensa(int defensa){
		this.defensa = defensa;
	}

	public int getDefensa(){
		return defensa;
	} 

	public void setOro(int oro){
		this.oro = oro;
	}
	public int getOro(){
		return oro;
	}
	
	public void damage(int ataque){
		vida -= ataque;
	}

	@Override
	public void tick() {
		time+=1;
		if (time == 900){
			oro += 15;
			time = 0;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, 100, 100);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}