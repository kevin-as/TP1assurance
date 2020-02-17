import java.io.*;

public class FichierSortie {
	
	public static void sauvegarderFichier( String[][] factures ) throws IOException {
		
		String nomFichier = "fichierSortie.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier));
		
		writer.write("Bienvenue chez Barette!\n");
		writer.write("Factures:\n");
		
		for (int i = 0; i < factures.length; i++) {
			writer.write(factures[i][0] + " " + factures[i][1] + "\n");
		}
		
		writer.close();
	}
}