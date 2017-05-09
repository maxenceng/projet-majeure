package fct0.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fct0.models.Env;
import fct0.utils.Contenu;

public class EnvTest {

	@Test
	public void testFindContenu() {
		Env env = new Env(14, 15, 50);
		assertEquals((env.findContenu(14, 15) == null), true);
		assertEquals((env.findContenu(-1, 10) == null), true);
		assertEquals((env.findContenu(10, -1) == null), true);
		for(int i = 0; i < env.getTailleX(); i++) {
			for(int j = 0; j < env.getTailleY(); j++) {
				assertEquals((env.findContenu(i, j) == Contenu.FREE)|| (env.findContenu(i, j) == Contenu.OBSTACLE), true);
			}
		}
	}
}
