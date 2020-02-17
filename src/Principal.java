import java.io.*;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		String[] tableauClients = new String[] {"Roger","Céline","Steeve"};
		String[][] tableauPlats = new String[][] {{"Poutine", "10.5"},{"Frites","2.5"},{"Repas_Poulet","15.75"}};
		String[][] tableauCommandes = new String[][] {{"Roger", "Poutine", "1"},{"Céline","Frites","2"},{"Céline","Repas_Poulet","1"}};
		
		String[][] tableauFactures = new String[tableauClients.length][2];
		
		for (int i = 0; i < tableauFactures.length; i++) {
			tableauFactures[i][0] = tableauClients[i];
			tableauFactures[i][1] = "0.00";
		}
		
		for (int i = 0; i < tableauCommandes.length; i++) {
			for (int j = 0; j < tableauPlats.length; j++) {
				for (int k = 0; k < tableauFactures.length; k++) {
					
					if (tableauCommandes[i][1].equals(tableauPlats[j][0])) {
						if (tableauFactures[k][0].equals(tableauCommandes[i][0])) {
							tableauFactures[k][1] = String.valueOf( Double.parseDouble(tableauFactures[k][1]) + ( Double.parseDouble(tableauCommandes[i][2]) * Double.parseDouble(tableauPlats[j][1]) ) );
						}
						
					}
				}
			}
		}
		
		for (int i = 0; i < tableauFactures.length; i++) {
			tableauFactures[i][1] = tableauFactures[i][1] + "$";
			System.out.print(tableauFactures[i][0] + " ");
			System.out.println(tableauFactures[i][1]);
		}
		
		FichierSortie.sauvegarderFichier( tableauFactures );

	}

}
