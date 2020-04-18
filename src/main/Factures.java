package main;

import java.io.IOException;
import java.text.*;

public class Factures {
	
	static final double TAUX_TPS = 0.05;
	static final double TAUX_TVQ = 0.09975;
	private static final DecimalFormat TOTAL = new DecimalFormat("0.00");
	private static final DecimalFormat PRE_TOTAL = new DecimalFormat("0.000");
	
	public static String[][] calculerFactures(String[][] commandes, String[][] plats) {
		String[][] factures = new String[commandes.length][2];
		
		for (int i = 0; i < factures.length; i++) {
			factures[i][0] = commandes[i][0];
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
		
		return factures;
	}
	
	public static double calculerTaxes(double sousTotal) {
		double total, montantTPS, montantTVQ;
		String totalChaine;
		
		montantTPS = sousTotal * TAUX_TPS;
		montantTVQ = sousTotal * TAUX_TVQ;
		
		total = sousTotal + montantTPS + montantTVQ;
		
		total = Double.valueOf(PRE_TOTAL.format(total));
		
		totalChaine = String.valueOf(total);
		
		if(totalChaine.charAt(totalChaine.length()-1) == '5') {
			total = Double.valueOf(TOTAL.format(total));
			total += 0.01;
		}else {
			total = Double.valueOf(TOTAL.format(total));
		}
		
		return total;
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
