package main;

import java.io.File;
import java.io.IOException;

public class CreerFichier {
	
	public static boolean creerFichier(String nomFichier) {
		boolean cree = false;
		try {
		      File myObj = new File(nomFichier);
		      if (myObj.createNewFile()) {
		        System.out.println("Fichier créé: " + myObj.getName());
		        cree = true;
		      } else {
		        System.out.println("Le fichier existe déjà.");
		        cree = true;
		      }
		    } catch (IOException e) {
		      System.out.println("Une erreur s'est produite.");
		    }
		return cree;
	}
	
	
}
