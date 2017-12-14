package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Aplicacion.HombreAcero;
import Aplicacion.Jugador;
import Aplicacion.Lancero;
import Aplicacion.Soldado;
import Aplicacion.Usuario;
import Presentacion.Handler;

public class TestSoldado {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void deberiaMoverse() {
		Soldado sol = new HombreAcero(0, 0, new Handler(), new Jugador(Usuario.JUGADOR1));
		sol.setVelX(1);
		sol.mover();
		assertTrue(sol.getX() != 0);
	}
	
	@Test
	public void deberiaRecibirDamage() {
		Soldado sol = new Lancero(0, 0, new Handler(), new Jugador(Usuario.JUGADOR1));
		int defensaInit = sol.getDefensa();
		sol.damage(5);
		assertTrue(sol.getDefensa() < defensaInit);
	}

	@After
	public void tearDown() throws Exception {
	}

}
