package Aplicacion;

public class Computadora extends Usuario {
	
	String dificultad;

	public Computadora(String dificultad) {
		super(Usuario.COMPUTADORA);
		this.dificultad = dificultad;
	}

}
