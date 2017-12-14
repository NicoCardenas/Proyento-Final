package Aplicacion;

public class Usuario {

	//-------------------
	//Atributos de clase
	//-------------------
	
	public static final int COMPUTADORA = 0;
	public static final int JUGADOR1 = 1;
	public static final int JUGADOR2 = 2;

	private int tipo;
	// 0 Computadora
	// 1 Jugador1
	// 2 Jugador2


	//-------------------
	//Constructor
	//-------------------

	public Usuario(int tipo){
		this.tipo = tipo;
	} 
	//Usuario

	//-------------------
	//Metodos de acceso
	//-------------------

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return this.tipo;
	}

}