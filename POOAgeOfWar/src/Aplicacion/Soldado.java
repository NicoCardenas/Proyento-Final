package Aplicacion;

import java.awt.Color;
import java.awt.Graphics;

import Presentacion.AgeOfWarGUI;
import Presentacion.Handler;
import Presentacion.Window;


public abstract class Soldado extends GameObject{

	//-------------------
	//Atributos de clase
	//-------------------

	protected Usuario jugador;
	protected Edad id;
	protected int ataque;
	protected int salud;
	protected int defensa;
	protected int precio;
	protected int devolucion;

	//-------------------
	//Constructor
	//-------------------

	public Soldado(int x, int y, Handler handler, Usuario jugador)	{
		super(x, y, handler);
		this.jugador = jugador;
	} 
	
	//------------------
	//Metodos estaticos
	//------------------
	
	public abstract void mover();

	public void damage(int ataque) {
		if (defensa > 0) {
			defensa -= ataque;
		}else if (salud > 0 ) {
			salud -= ataque;
		}
	}
	
	public void tick() {
		mover();
		x = AgeOfWarGUI.clamp(x, 0, Window.ANCHO-56);
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 50, 100);
	}
	//Colision grafica
	/*private void collision(){
		for (int i = 0; i < handler.objetos.size(); i++) {
			
			GameObject tempObjeto = handler.objetos.get(i);
			
			System.out.println(getBounds().intersects(tempObjeto.getBounds()));
			
			if (getBounds().intersects(tempObjeto.getBounds())) {
				setVelX(0);
				tempObjeto.setVelX(0);
				da�o();
			}else if (!getBounds().intersects(tempObjeto.getBounds())) {
				setVelX(1);
				tempObjeto.setVelX(-1);
			}
			
		}
	}*/

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
	
	public Edad getId() {
		return id;
	}
	
	public Usuario getUsuario() {
		return jugador;
	}
}