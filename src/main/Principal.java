package main;

import java.io.*;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		String[] tableauClients;
		String[][] tableauPlats;
		String[][] tableauCommandes;
		String[][] tableauValide;
		String[][] tableauErreurs;
		String[][] tableauFactures;
		
		FichierEntree.separerLignesFichier();
		
		tableauClients = FichierEntree.clients;
		tableauPlats = FichierEntree.plats;
		tableauCommandes = FichierEntree.commandes;
		
		tableauValide = GestionErreurs.gestionNomClient( tableauClients, tableauCommandes );
		tableauValide = GestionErreurs.gestionNomPlat( tableauPlats, tableauValide );
		tableauValide = GestionErreurs.gestionQtePlat( tableauValide );
		tableauErreurs = GestionErreurs.creerTableauCommandesErreurs( GestionErreurs.listeErreurs );
		
		tableauFactures = Factures.calculerFactures(tableauValide, tableauPlats, tableauClients);
		
		Factures.afficherFacture( tableauErreurs, tableauFactures );
	}

}
