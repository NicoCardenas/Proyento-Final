package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Aplicacion.CampoDeBatalla;
import Aplicacion.Edificio;
import Aplicacion.Usuario;
import Presentacion.Handler;

public class TestCampo {

	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void debePoderGenerarElCampo() {
		CampoDeBatalla campo = new CampoDeBatalla(new Handler(), null);
		assertFalse(campo.getEdificioEdad1() == null);
		assertFalse(campo.getEdificioEdad2() == null);
		assertFalse(campo.getUsuario1() == null);
		assertFalse(campo.getUsuario2() == null);
	}
	
	@Test
	public void debePoderDeterminarElGanador() {
		CampoDeBatalla campo = new CampoDeBatalla(new Handler(), null);
		Edificio temp = campo.getEdificio1();
		temp.setVida(0);
		assertTrue(campo.win() == Usuario.COMPUTADORA);
	}

	@After
	public void tearDown() throws Exception {
		
	}

}
