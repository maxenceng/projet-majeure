package fct0.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fct0.models.Capteur;
import fct0.utils.Orientation;

public class CapteurTest {

	@Test
	public void testUpdateMatrice() {
		Capteur capteur = new Capteur();
		assertNotEquals(capteur, null);
		Integer[][] copieMatrice = capteur.getMatrice();
		assertArrayEquals(capteur.getMatrice(), copieMatrice);
		capteur.updateMatrice(Orientation.N, Orientation.W);
		assertNotEquals(capteur.getMatrice(), copieMatrice);
		copieMatrice = capteur.getMatrice();
		capteur.updateMatrice(Orientation.W, Orientation.W);
		assertArrayEquals(capteur.getMatrice(), copieMatrice);
	}

}
