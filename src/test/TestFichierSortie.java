package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import main.FichierSortie;

public class TestFichierSortie {
	
	String[][] factures = { {"Roger", "Poutine", "2"}, {"Céline", "Frites", "2"}, {"Steeve", "Repas_Poulet", "1"} };
	
	@Test
	public void testSauvegarderFichierString() throws IOException {
		//actualiser date et heure avant de tester à nouveau
		assertEquals("","Facture-du-18-04-20-11.txt", FichierSortie.sauvegarderFichierString("yes"));
	}
	
	@Test
	public void testSauvegarderFichier() throws IOException {
		assertEquals("", "fichierSortie.txt", FichierSortie.sauvegarderFichier(factures));
	}

}
