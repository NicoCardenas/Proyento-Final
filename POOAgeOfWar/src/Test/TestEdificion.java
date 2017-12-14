package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Aplicacion.Edificio;
import Aplicacion.Jugador;
import Presentacion.Handler;

public class TestEdificion {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void deberiaSuamarOro() {
		Edificio temp = new Edificio(0, 0, new Handler(), new Jugador());
		int OroInit = temp.getOro();
		for (int i = 0; i < 900; i++) {
			temp.tick();
		}
		assertTrue(temp.getOro() > OroInit);
	}

	@Test
	public void deberiaRecibirDamage() {
		Edificio temp = new Edificio(0, 0, new Handler(), new Jugador());
		int vidaInit = temp.getVida();
		temp.damage(5);
		assertTrue(temp.getVida() < vidaInit);
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
