package main;

import java.io.IOException;
import java.text.*;

public class Factures {
	
	
	
	public static String[][] calculerFactures(String[][] commandes, String[][] plats, String[] clients) {
		String[][] factures = new String[commandes.length][2];
		
		for (int i = 0; i < factures.length; i++) {
			factures[i][0] = clients[i];
			factures[i][1] = "0.00";
		}
		
		for (int i = 0; i < commandes.length; i++) {
			for (int j = 0; j < plats.length; j++) {
				for (int k = 0; k < factures.length; k++) {
					
					if (commandes[i][1].equalsIgnoreCase(plats[j][0])) {
						if (factures[k][0].equalsIgnoreCase(commandes[i][0])) {
							factures[k][1] = String.valueOf(Double.parseDouble(factures[k][1]) + (Double.parseDouble(commandes[i][2]) * Double.parseDouble(plats[j][1])));
						}
						
					}
				}
			}
		}
		
		for (int i = 0; i < factures.length; i++) {
			if (factures[i][1].equals("0.00")) {
				factures[i][0] = "";
				factures[i][1] = "";
			} else {
				factures[i][1] = calculerTaxes((Double.valueOf(factures[i][1])));
			}
		}
		
		return factures;
	}
	
	public static String calculerTaxes(double sousTotal) {
		final double TAUX_TPS = 0.05;
		final double TAUX_TVQ = 0.09975;
		final DecimalFormat TOTAL = new DecimalFormat("#.##");
		
		double total, montantTPS, montantTVQ;
		String totalChaine;
		
		montantTPS = sousTotal * TAUX_TPS;
		montantTVQ = sousTotal * TAUX_TVQ;
		
		total = sousTotal + montantTPS + montantTVQ;
		
		totalChaine = TOTAL.format(total);
		
		return totalChaine;
	}
	
	public static void afficherFacture(String[][] erreurs, String [][] facture) throws IOException {
		String factureAffichee = "";
		if (erreurs.length > 0) {
			factureAffichee += "### ERREURS ###\n";
			
			for (int i = 0; i < erreurs.length; i++) {
				factureAffichee += "\n";
				for (int j = 0; j < erreurs[i].length; j++) {
					factureAffichee += erreurs[i][j] + " ";
				}
			}
			
			factureAffichee += "\n\n";
		}
		
		factureAffichee += "FACTURES\n";
		
		for (int i = 0; i < facture.length; i++) {
			factureAffichee += "\n";
			for (int j = 0; j < facture[i].length; j++) {
				factureAffichee += facture[i][j] + " ";
			}
		}
		
		System.out.println(factureAffichee);
		FichierSortie.sauvegarderFichierString(factureAffichee);
	}
	
}
