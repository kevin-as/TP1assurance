package main;

import java.text.*;

public class Factures {
	
	static final double TAUX_TPS = 0.05;
	static final double TAUX_TVQ = 0.09975;
	private static final DecimalFormat TOTAL = new DecimalFormat("0.00");
	private static final DecimalFormat PRE_TOTAL = new DecimalFormat("0.000");
	
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
	
	public static void afficherFacture(String[][] erreurs, String [][] facture) {
		String factureAffichee = "";
		
	}
	
}
