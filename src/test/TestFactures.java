package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Factures;

public class TestFactures {
	
	//cas #1
	String[][] commandes1 = {{"Marie", "Steak", "1"}, {"Jean", "Poulet", "2"}, {"Paul", "Poutine", "2"}, {"Natalie", "Poulet", "1"}};
	String[][] plats = {{"Poutine", "9.50"}, {"Poulet", "11.75"}, {"Steak", "13"}};
	String[] clients1 = {"Marie", "Jean", "Paul", "Natalie"};
	String[][] facturesAttendues1 = {{"Marie", "14,95$"}, {"Jean", "27,02$"}, {"Paul", "21,85$"}, {"Natalie", "13,51$"}};
	
	//cas #2
	String[][] commandes2 = {{"Marie", "Steak", "1"}, {"Jean", "Poulet", "2"}, {"Paul", "Poutine", "2"}, {"Natalie", "Poulet", "1"}, {"Natalie", "Poutine", "1"}, {"Myriam", "Steak", "3"}};
	String[] clients2 = {"Marie", "Jean", "Paul", "Natalie", "Cédric", "Myriam"};
	String[][] facturesAttendues2 = {{"Marie", "14,95$"}, {"Jean", "27,02$"}, {"Paul", "21,85$"}, {"Natalie", "24,43$"}, {"", ""}, {"Myriam", "44,84$"}};;
	
	@Test
	public void testTaxes() {
		assertEquals("","114,97", Factures.calculerTaxes(100));
		assertEquals("", "63,24", Factures.calculerTaxes(55));
		assertEquals("", "27,02", Factures.calculerTaxes(23.50));
		assertEquals("", "14,37", Factures.calculerTaxes(12.50));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCalculerFactures() {
		assertEquals(facturesAttendues1, Factures.calculerFactures(commandes1, plats, clients1));
		assertEquals(facturesAttendues2, Factures.calculerFactures(commandes2, plats, clients2));
	}

}
