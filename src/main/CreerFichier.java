package main;

import java.io.File;
import java.io.IOException;

public class CreerFichier {
	
	public static void creerFichier(String nomFichier) {
		try {
		      File myObj = new File(nomFichier);
		      if (myObj.createNewFile()) {
		        System.out.println("Fichier créé: " + myObj.getName());
		      } else {
		        System.out.println("Le fichier existe déjà.");
		      }
		    } catch (IOException e) {
		      System.out.println("Une erreur s'est produite.");
		      e.printStackTrace();
		    }
	}
	
	
}
