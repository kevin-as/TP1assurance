package main;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FichierSortie {
	
	public static void sauvegarderFichier( String[][] factures ) throws IOException {
		
		String nomFichier = "fichierSortie.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier));
		
		writer.write("Bienvenue chez Barette!\n");
		writer.write("Factures:\n");
		
		for (int i = 0; i < factures.length; i++) {
			writer.write(factures[i][0] + " " + factures[i][1] + "\n");
		}
		
		writer.close();
		
		System.out.println("Les factures ont été enregistrées dans le fichier \"fichierSortie.txt\".");
	}
	
	public static String sauvegarderFichierString(String chaine) throws IOException {
		SimpleDateFormat formatDateHeure = new SimpleDateFormat("dd/MM-HH:mm");
		Date date = new Date();
		String nomFichier = "Facture-du-" + formatDateHeure.format(date) + ".txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier));
		
		writer.write(chaine);
		
		writer.close();
		
		System.out.println("Les factures ont été enregistrées dans le fichier \"" + nomFichier + "\"");
		return nomFichier;
	}
}