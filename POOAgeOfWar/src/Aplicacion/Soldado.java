package Aplicacion;

import java.awt.Color;
import java.awt.Graphics;

import Presentacion.AgeOfWarGUI;
import Presentacion.Window;


public abstract class Soldado extends GameObject{

	//-------------------
	//Atributos de clase
	//-------------------

	protected int ataque;
	protected int salud;
	protected int defensa;
	protected int precio;
	protected int devolucion;

	//-------------------
	//Constructor
	//-------------------

	public Soldado(int x, int y, Edad id)	{
		super(x, y, id);
		setVelX(1);
		setVelY(0);
	} 
	
	//------------------
	//Metodos estaticos
	//------------------
	
	public abstract void mover();

	public abstract void atacar();
	
	public void tick() {
		mover();
		
		x = AgeOfWarGUI.clamp(x, 0, Window.ANCHO-56);
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 50, 100);
	}

	//-------------------
	//Metodos de acceso
	//-------------------

	public void setAtaque(int ataque)	{
		this.ataque = ataque;
	}

	public int getAtaque()	{
		return ataque;
	}

	public void setSalud(int salud)	{
		this.salud = salud;
	}

	public int getSalud()	{
		return salud;
	}

	public void setDefensa(int defensa)	{
		this.defensa = defensa;
	}

	public int getDefensa()	{
		return defensa;
	} 

	public void setPrecio(int precio){
		this.precio = precio;
	}
	
	public int getPrecio(){
		return precio;
	}
}