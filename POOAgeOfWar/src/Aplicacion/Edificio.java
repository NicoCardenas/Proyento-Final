package Aplicacion;

public class Edificio
{

	//-------------------
	//Atributos de clase
	//-------------------

	private int posicion;
	private int vida;
	private int defensa;
	private int oro;

	//-------------------
	//Constructores
	//-------------------

	public Edificio()
	{

	} 
	//Edificio

	//-------------------
	//Métodos de acceso
	//-------------------

	public void setPosicion(int posicion)
	{
		this.posicion = posicion;
	}

	public int getPosicion()
	{
		return posicion;
	}

	public void setVida(int vida)
	{
		this.vida = vida;
	}

	public int getVida()
	{
		return vida;
	}

	public void setDefensa(int defensa)
	{
		this.defensa = defensa;
	}

	public int getDefensa()
	{
		return defensa;
	} 

	public void setOro(int oro)
	{
		this.oro = oro;
	}
	public int getOro()
	{
		return oro;
	}

}