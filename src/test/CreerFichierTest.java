package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.CreerFichier;

public class CreerFichierTest {

	@Test
	public void testCreerFichier() {
		assertEquals(true, CreerFichier.creerFichier("fichier.txt"));
		assertEquals(false, CreerFichier.creerFichier("fichier/nonCorrect.txt"));
	}

}
