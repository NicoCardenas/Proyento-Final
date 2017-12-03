package Aplicacion;

public class Usuario
{

	//-------------------
	//Atributos de clase
	//-------------------

	private int tipo;
	// 0 Computadora
	// 1 Jugador1
	// 2 Jugador2


	//-------------------
	//Constructor
	//-------------------

	public Usuario()
	{

	} 
	//Usuario

	//-------------------
	//Métodos de acceso
	//-------------------

	public void setTipo(int tipo)
	{
		this.tipo = tipo;
	}

	public int getTipo()
	{
		return tipo;
	}

}