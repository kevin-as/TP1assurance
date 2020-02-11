import java.io.*;
import java.util.*;

public class FichierEntree {
	
	public static String[] clients;
	public static String[][] plats;
	public static String [][][] commandes;
	
	public static String lireNomFichier() {
		Scanner entreeUtil = new Scanner(System.in);
		
		System.out.print("\nEntrez le nom du fichier à importer : ");
		String nomFichier = entreeUtil.nextLine();
		
		entreeUtil.close();
		
		return nomFichier;
	}
	
	public static void lireFichier() {
		String nomFichier = lireNomFichier();
		Scanner scanner;
		
		try {
			scanner = new Scanner(new File("nomFichier"));
		} catch(Exception e) {
			
		}
		
	}
	
	
	
}
