package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import main.FichierSortie;

public class TestFichierSortie {
	
	String[][] factures = { {"Roger", "Poutine", "2"}, {"Céline", "Frites", "2"}, {"Steeve", "Repas_Poulet", "1"} };
	SimpleDateFormat formatDateHeure = new SimpleDateFormat("dd-MM-HH-mm");
	Date date = new Date();
	String nomFichier = "Facture-du-" + formatDateHeure.format(date) + ".txt";
	
	@Test
	public void testSauvegarderFichierString() throws IOException {
		//actualiser date et heure avant de tester à nouveau
		assertEquals("", nomFichier, FichierSortie.sauvegarderFichierString("yes"));
	}
	
	@Test
	public void testSauvegarderFichier() throws IOException {
		assertEquals("", "fichierSortie.txt", FichierSortie.sauvegarderFichier(factures));
	}

}
