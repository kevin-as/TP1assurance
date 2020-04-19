package test;

import static org.junit.Assert.*;
import org.junit.Test;
import main.GestionErreurs;

public class GestionErreursTest {

	String[] tableauClients = {"Roger", "Céline", "Steeve"};
	String[][] tableauPlats = { {"Poutine", "10.5"}, {"Frites", "2.5"}, {"Repas_Poulet", "15.75"} };
	String[][] tableauCommandes = { {"Roger", "Poutine", "2"}, {"Céline", "Frites", "2"}, {"Steeve", "Repas_Poulet", "1"} };
	
	String[][] tableauErreurNom = { {"Rogr", "Poutine", "2"}, {"Céline", "Frites", "2"}, {"Steeve", "Repas_Poulet", "1"} };
	String[][] tableauRetourErreurNom = { {"Céline", "Frites", "2"}, {"Steeve", "Repas_Poulet", "1"} };
	
	String[][] tableauErreurPlat = { {"Roger", "Poutie", "2"}, {"Céline", "Frites", "2"}, {"Steeve", "Repas_Poulet", "1"} };
	String[][] tableauRetourErreurPlat = { {"Céline", "Frites", "2"}, {"Steeve", "Repas_Poulet", "1"} };
	
	@Test
	public void testGestionNomClient() {
		//cas où il n'y a pas d'erreur dans le nom du client.
		assertArrayEquals(tableauCommandes, GestionErreurs.gestionNomClient(tableauClients, tableauCommandes));
		//cas où il y a une erreur dans le nom du client et le retour est bon.
		assertArrayEquals(tableauRetourErreurNom, GestionErreurs.gestionNomClient(tableauClients, tableauErreurNom));
	}
	
	@Test
	public void testGestionNomPlat() {
		//cas où il n'y a pas d'erreur dans le nom du plat.
		assertArrayEquals(tableauCommandes, GestionErreurs.gestionNomPlat(tableauPlats, tableauCommandes));
		//cas où il y a une erreur dans le nom du plat et le retour est bon.
		assertArrayEquals(tableauRetourErreurPlat, GestionErreurs.gestionNomPlat(tableauPlats, tableauErreurPlat));
	}
	
	@Test
	public void testGestionQtePlat() {
		//cas où il n'y a pas d'erreur dans les quantités.
		assertArrayEquals(tableauCommandes, GestionErreurs.gestionQtePlat(tableauCommandes));
		assertArrayEquals(tableauRetourErreurNom, GestionErreurs.gestionQtePlat( tableauRetourErreurNom ));
	}

}
