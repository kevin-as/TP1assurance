import java.io.*;
import java.util.*;

public class FichierEntree {
	
	public static String[] clients;
	public static String[][] plats;
	public static String [][] commandes;
	
	private static String lireNomFichier() {
		Scanner entreeUtil = new Scanner(System.in);
		
		System.out.print("\nEntrez le nom du fichier à importer : ");
		String nomFichier = entreeUtil.nextLine();
		
		entreeUtil.close();
		
		return nomFichier;
	}
	
	private static String[] lireFichier() throws IOException{
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
			System.out.println("\nLe fichier n'existe pas.");
			System.out.println("\nFermeture du programme.");
			System.exit(0);
		}
		
		return lignesFichier;
	}
	
	public static void separerLignesFichier() throws IOException{
		String[] lignesFichier = lireFichier();
		
		int noLigne = 1;
		List<String> listeClients = new ArrayList<>();
		List<String> listePlats = new ArrayList<>();
		List<String> listeCommandes = new ArrayList<>();
		
		noLigne = separerParType(lignesFichier, noLigne, listeClients);
		clients = listeClients.toArray(new String[0]);
		
		noLigne = separerParType(lignesFichier, noLigne, listePlats);
		plats = separerLignesTableau2D(listePlats);
		
		while(!lignesFichier[noLigne].equals("Fin")) {
			listeCommandes.add(lignesFichier[noLigne]);
			noLigne++;
		}
		commandes = separerLignesTableau2D(listeCommandes);
		
	}

	private static String[][] separerLignesTableau2D(List<String> listeLignes) {
		String[][] tableau = new String[listeLignes.size()][];
		
		for (int i = 0; i < tableau.length; i++) {
			tableau[i] = listeLignes.get(i).split(" ");
		}
		return tableau;
	}

	private static int separerParType(String[] lignesFichier, int noLigne, List<String> listeVoulue) {
		while(!lignesFichier[noLigne].contains(":")) {
			listeVoulue.add(lignesFichier[noLigne]);
			noLigne++;
		}
		noLigne++;
		return noLigne;
	}
	
}
