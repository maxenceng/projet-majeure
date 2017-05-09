package fct0.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fct0.models.Grille;
import fct0.utils.Contenu;

public class GrilleTest {

	@Test
	public void testGetMatrice() {
		Grille grille1 = new Grille(0, 0);
		assertNotNull(grille1);
		assertNotNull(grille1.getMatrice());
		Grille grille2 = new Grille(0, 0);
		assertNotEquals(grille1, grille2);
		assertArrayEquals(grille1.getMatrice(), grille2.getMatrice());
		
	}
	
	@Test
	public void testSetMatrice() {
		Grille grille1 = new Grille(0, 0);
		grille1.setMatrice(1, 0, Contenu.FREE);
		Grille grille2 = new Grille(1, 1);
		grille2.setMatrice(0, 0, Contenu.FREE);
		assertEquals(grille2.getMatrice()[0][0], Contenu.FREE);
		assertNotEquals(grille2.getMatrice()[0][0], Contenu.UNKNOWN);
		assertNotEquals(grille2.getMatrice()[0][0], Contenu.OBSTACLE);
		assertNotEquals(grille2.getMatrice()[0][0], "FREE");
	}
	
	@Test
	public void testGetXAndGetY() {
		Grille grille = new Grille(1, 7);
		assertEquals(grille.getX(), 1);
		assertNotEquals(grille.getX(), -1);
		assertNotEquals(grille.getX(), 1.5);
		assertEquals(grille.getY(), 7);
		assertNotEquals(grille.getY(), "7");
	}
}
