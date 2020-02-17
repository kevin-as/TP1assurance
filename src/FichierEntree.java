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
	
	public static String[] lireFichier() throws IOException{
		String nomFichier = lireNomFichier();
		Scanner scanner;
		List<String> listeLignesFichier = new ArrayList<>();
		String[] lignesFichier = null;
		try {
			scanner = new Scanner(new File(nomFichier));
			while (scanner.hasNextLine()) {
				String ligne = scanner.nextLine();
				listeLignesFichier.add(ligne);
			}
			lignesFichier = listeLignesFichier.toArray(new String[0]);
			scanner.close();
		} catch(Exception e) {
			System.out.println("\nLe fichier n'existe pas");
		}
		
		return lignesFichier;
	}
	
	
	
}
