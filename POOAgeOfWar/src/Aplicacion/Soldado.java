package Aplicacion;

public class Soldado {

	//-------------------
	//Atributos de clase
	//-------------------

	private int posicion;
	private int ataque;
	private int salud;
	private int defensa;
	private int precio;

	//-------------------
	//Constructor
	//-------------------

	public Soldado()	{

	} 
	//Soldado

	//-------------------
	//Métodos de acceso
	//-------------------

	public void setPosicion(int posicion)	{
		this.posicion = posicion;
	}

	public int getPosicion()	{
		return posicion;
	}

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

	void mover(){
		
	}

	void atacar() {
		
	}

}