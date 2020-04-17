package main;

import java.util.ArrayList;


public class GestionErreurs {
	
	static String[][] tableauErreurs = { {"Erreur dans le nom du client."}, {"Erreur dans le nom du plat."}, {"Erreur dans le nombre de plats."} };
	static ArrayList<String[]> listeErreurs = new ArrayList<String[]>();
	static ArrayList<String[]> listeValide = new ArrayList<String[]>();

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
		
		return tableauValide;
		
	}
	
	public static String[][] gestionNomPlat( String[][] tableauPlats, String[][] tableauCommandes ) {
		
		for ( int i = 0; i < tableauCommandes.length; i++ ) {
			for ( int j = 0; j < tableauPlats.length; j++ ) {
				
				if ( tableauCommandes[i][1].equalsIgnoreCase( tableauPlats[j][0] ) ) {
					listeValide.add( tableauCommandes[i] );
				} else {
					listeErreurs.add( tableauCommandes[i] );
					listeErreurs.add( tableauErreurs[1] );
				}
			}
		}
		
		String[][] tableauValide = new String[listeValide.size()][3];
		
		for (int i = 0; i < listeValide.size(); i++) {
			String[] ligne = listeValide.get(i); 
			tableauValide[i] = ligne;
		}
		
		return tableauValide;
		
	}
	
	public static String[][] gestionQtePlat( String[][] tableauCommandes ) {
		
		for ( int i = 0; i < tableauCommandes.length; i++ ) {
			
			try {
				Integer.parseInt( tableauCommandes[i][2] );
			} catch ( Exception e ) {
				listeErreurs.add( tableauCommandes[i] );
				listeErreurs.add( tableauErreurs[2] );
			}
			
			listeValide.add( tableauCommandes[i] );
			
		}
		
		String[][] tableauValide = new String[listeValide.size()][3];
		
		for (int i = 0; i < listeValide.size(); i++) {
			String[] ligne = listeValide.get(i); 
			tableauValide[i] = ligne;
		}
		
		return tableauValide;
		
	}
}
