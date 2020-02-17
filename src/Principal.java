import java.io.*;

public class Principal {

	public static void main(String[] args) throws IOException {
		String[] factures = new String[]{"Roger 10.50$","Céline 20.75$","Steeve 0.00$"};
		FichierSortie.sauvegarderFichier( factures );
		
	}

}
