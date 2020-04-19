package main;

import java.util.ArrayList;


public class GestionErreurs {
	
	static String[][] tableauErreurs = { {"Erreur dans le nom du client."}, {"Erreur dans le nom du plat."}, {"Erreur dans le nombre de plats."} };
	static ArrayList<String[]> listeErreurs = new ArrayList<String[]>();
	static ArrayList<String[]> listeValide = new ArrayList<String[]>();

	public static String[][] gestionNomClient( String[] tableauClients, String[][] tableauCommandes ) {
		listeValide.clear();
		boolean nomPresent;
		
		for ( int i = 0; i < tableauCommandes.length; i++ ) {
			nomPresent = false;
			
			for ( int j = 0; j < tableauClients.length; j++ ) {
				
				if ( tableauCommandes[i][0].equalsIgnoreCase( tableauClients[j] ) ) {
					nomPresent = true;
				}
			}
			
			if ( nomPresent ) {
				listeValide.add( tableauCommandes[i] );
			} else {
				if ( !listeErreurs.contains( tableauCommandes[i] ) ) {
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
		
		listeValide.clear();
		boolean platPresent;
		
		for ( int i = 0; i < tableauCommandes.length; i++ ) {
			platPresent = false;
			
			for ( int j = 0; j < tableauPlats.length; j++ ) {
				
				if ( tableauCommandes[i][1].equalsIgnoreCase( tableauPlats[j][0] ) ) {
					platPresent = true;
				}
			}
			
			if ( platPresent ) {
				if ( !listeValide.contains( tableauCommandes[i] ) ) {
					listeValide.add( tableauCommandes[i] );
				}
			} else {
				if ( !listeErreurs.contains( tableauCommandes[i] ) ) {
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
		
		listeValide.clear();
		boolean qteValide;
		
		for ( int i = 0; i < tableauCommandes.length; i++ ) {
			
			qteValide = true;
			try {
				Integer.parseInt( tableauCommandes[i][2] );
			} catch ( Exception e ) {
				if ( !listeErreurs.contains( tableauCommandes[i] ) ) {
					listeErreurs.add( tableauCommandes[i] );
					listeErreurs.add( tableauErreurs[2] );
					qteValide = false;
				}
			}
			
			if ( qteValide ) {
				if ( !listeValide.contains( tableauCommandes[i] ) ) {
					listeValide.add( tableauCommandes[i] );
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
	
	public static String[][] creerTableauCommandesErreurs( ArrayList<String[]> listeErreurs ) {
		
		String[][] tableauCommandesErreurs = new String[listeErreurs.size()][2];
		
		for ( int i = 0; i < listeErreurs.size(); i++ ) {
			String[] ligne = listeErreurs.get(i);
			tableauCommandesErreurs[i] = ligne;
		}
		
		return tableauCommandesErreurs;
	}
}
