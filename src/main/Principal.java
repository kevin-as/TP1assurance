package main;

import java.io.*;
import java.util.ArrayList;

public class Principal {
	
	static String[][] tableauErreurs = { {"Erreur dans le nom du client."}, {"Erreur dans le nom du plat."}, {"Erreur dans le nombre de plats."} };
	static ArrayList<String[]> listeErreurs = new ArrayList<String[]>();
	static ArrayList<String[]> listeValide = new ArrayList<String[]>();

	public static void main(String[] args) throws IOException {
		
		String[] tableauClients;
		String[][] tableauPlats;
		String[][] tableauCommandes;
		String[][] tableauFactures;
		
		FichierEntree.separerLignesFichier();
		
		tableauClients = FichierEntree.clients;
		tableauPlats = FichierEntree.plats;
		tableauCommandes = FichierEntree.commandes;
		tableauFactures = new String[tableauClients.length][2];
		
		//calculerFactures(tableauClients, tableauPlats, tableauCommandes, tableauFactures);
		gestionNomClient( tableauClients, tableauCommandes );
	}
	
	public static String[][] gestionNomClient( String[] tableauClients, String[][] tableauCommandes ) {
		
		for ( int i = 0; i < tableauCommandes.length; i++ ) {
			for ( int j = 0; j < tableauClients.length; j++ ) {
				
				if ( tableauCommandes[i][0].equalsIgnoreCase( tableauClients[j] ) ) {
					listeValide.add( tableauCommandes[i] );
				} else {
					listeErreurs.add( tableauCommandes[i] );
					listeErreurs.add( tableauErreurs[0] );
				}
			}
		}
		
		String[][] tableauValide = new String[listeValide.size()][3];
		
		for (int i = 0; i < listeValide.size(); i++) {
			String[] ligne = listeValide.get(i); 
			tableauValide[i] = ligne;
		}
		
		for ( int i = 0; i < tableauValide.length; i++ ) {
			for ( int j = 0; j < tableauValide.length; j++ ) {
				System.out.println( tableauValide[i][j] );
			}
		}
		
		return tableauValide;
	}

//	private static void calculerFactures(String[] tableauClients, String[][] tableauPlats, String[][] tableauCommandes, String[][] tableauFactures) throws IOException {
//		
//		boolean bonFormat = false;
//		
//		for (int i = 0; i < tableauFactures.length; i++) {
//			tableauFactures[i][0] = tableauClients[i];
//			tableauFactures[i][1] = "0.00";
//		}
//		
//		for (int i = 0; i < tableauCommandes.length; i++) {
//			for (int j = 0; j < tableauPlats.length; j++) {
//					
//				if (tableauCommandes[i][1].equalsIgnoreCase(tableauPlats[j][0])) {
//					bonFormat = true;
//				}
//					
//			}
//			
//			if (!bonFormat) {
//				System.out.println("Le fichier ne respecte pas le format demandé !");
//				System.exit(0);
//			}
//		}
//		
//		bonFormat = false;
//		
//		for (int i = 0; i < tableauCommandes.length; i++) {
//			for (int j = 0; j < tableauClients.length; j++) {
//					
//				if (tableauCommandes[i][0].equalsIgnoreCase(tableauClients[j])) {
//					bonFormat = true;
//				}
//					
//			}
//			
//			if (!bonFormat) {
//				System.out.println("Le fichier ne respecte pas le format demandé !");
//				System.exit(0);
//			}
//		}
//		
//		for (int i = 0; i < tableauCommandes.length; i++) {
//			for (int j = 0; j < tableauPlats.length; j++) {
//				for (int k = 0; k < tableauFactures.length; k++) {
//					
//					if (tableauCommandes[i][1].equalsIgnoreCase(tableauPlats[j][0])) {
//						if (tableauFactures[k][0].equalsIgnoreCase(tableauCommandes[i][0])) {
//							tableauFactures[k][1] = String.valueOf(Double.parseDouble(tableauFactures[k][1]) + (Double.parseDouble(tableauCommandes[i][2]) * Double.parseDouble(tableauPlats[j][1])));
//						}
//						
//					}
//				}
//			}
//		}
//		
//		for (int i = 0; i < tableauFactures.length; i++) {
//			tableauFactures[i][1] = tableauFactures[i][1] + "$";
//		}
//		
//		FichierSortie.sauvegarderFichier(tableauFactures);
//		
//	}
}
