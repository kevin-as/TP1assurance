package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Factures;

public class TestFactures {
	
	@Test
	public void testTaxes() {
		assertEquals("","114,97", Factures.calculerTaxes(100));
		assertEquals("", "63,24", Factures.calculerTaxes(55));
		assertEquals("", "27,02", Factures.calculerTaxes(23.50));
		assertEquals("", "14,37", Factures.calculerTaxes(12.50));
	}
	
	@Test
	public void testAfficherFactures() {
		
	}

}
