package main;

import java.io.File;
import java.io.IOException;

public class CreerFichier {
	
	public static void creerFichier(String nomFichier) {
		try {
		      File myObj = new File(nomFichier);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	
}
