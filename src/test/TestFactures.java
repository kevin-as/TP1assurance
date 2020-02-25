package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Factures;

public class TestFactures {
	
	@Test
	public void testTaxes() {
		assertEquals(114.98, Factures.calculerTaxes(100), 0);
	}

}
