package main;

import java.text.*;

public class Factures {
	
	static final double TAUX_TPS = 0.05;
	static final double TAUX_TVQ = 0.09975;
	private static final DecimalFormat DF = new DecimalFormat("0.00");
	
	public static double calculerTaxes(double sousTotal) {
		double total, montantTPS, montantTVQ;
		
		montantTPS = sousTotal * TAUX_TPS;
		montantTVQ = sousTotal * TAUX_TVQ;
		
		total = sousTotal + montantTPS + montantTVQ;
		
		total = Double.valueOf(DF.format(total));
		
		return total;
	}
}
