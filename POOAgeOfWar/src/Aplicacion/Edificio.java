package Aplicacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;

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
		try {
			ImageIcon img = null;
			if (edad == Edad.EDADPIEDRA) {
				img = new ImageIcon(getClass().getResource("/Recursos/cueva.jpeg"));
			}else if (edad == Edad.EDADMEDIA){
				img = new ImageIcon(getClass().getResource("/Recursos/castillo.jpeg"));
			}else if (edad == Edad.EDADINDUSTRIAL){
				img = new ImageIcon(getClass().getResource("/Recursos/iglecia.jpeg"));
			}else if (edad == Edad.EDADMODERNA){
				img = new ImageIcon(getClass().getResource("/Recursos/militar2.jpeg"));
			}
			g.drawImage(img.getImage(), 0, 0, Window.ANCHO, Window.ALTO-50, null);
		} catch (Exception e) {
			g.setColor(Color.black);
			g.fillRect(x, y, 100, 100);
		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}