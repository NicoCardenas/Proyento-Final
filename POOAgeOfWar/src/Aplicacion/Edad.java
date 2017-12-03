package com.ageoofwar.entidades;

public enum Edad
{

	//-------------------
	//Atributos de clase
	//-------------------

	EDADPIEDRA("Edad de Piedra",1), EDADMEDIA("Edad Media",2),
	EDADINDUSTRIAL("Edad Industrial",3), EDADMODERNA("Edad Moderna",4);


	private String nombreedad;
	private int ordenedad;

	//Edad edadpiedra     = Edad.EDADPIEDRA;
	//Edad edadmedia      = Edad.EDADMEDIA;
	//Edad edadindustrial = Edad.EDADINDUSTRIAL;
	//Edad edadmoderna    = Edad.EDADMODERNA;
	

	//-------------------
	//Constructor
	//-------------------

	private Edad(String nombreedad, int ordenedad)
	{
		this.nombreedad = nombreedad;
		this.ordenedad = ordenedad;
	}
	
	
	//-------------------
	//Métodos de acceso
	//-------------------


	public String getnombreedad()
	{
		return nombreedad;
	}

	public int getordenedad()
	{
		return ordenedad;
	}

}