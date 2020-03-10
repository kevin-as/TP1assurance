package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import main.FichierSortie;

public class TestFichierSortie {

	@Test
	public void testNomFichier() throws IOException {
		//actualiser date et heure avant de tester à nouveau
		assertEquals("","Facture-du-10/03-11:16.txt", FichierSortie.sauvegarderFichierString("yes"));
	}

}
