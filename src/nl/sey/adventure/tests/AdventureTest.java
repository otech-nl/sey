package nl.sey.adventure.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nl.sey.adventure.Adventure;
import nl.sey.adventure.Locatie;

class AdventureTest {

	@Test
	void testStartLocatie() {
		Adventure adventure = new Adventure();
		String startNaam = adventure.getLocatieNaam();
		assertEquals("rivier",startNaam,"start is niet rivier");
	}
	
	@Test
	void testStartRichtingen() {
		Adventure adventure = new Adventure();
		Locatie start = adventure.getLocatie();
		int aantalVerbindingen = start.getAantalVerbindingen();
		assertEquals(2,aantalVerbindingen,"start heeft geen 2 richtingen");
	}
	
	@Test
	void testBergNaarZuid() {
		Adventure adventure = new Adventure();
		Locatie locatie = Locatie.zoekOpNaam("berg");
		Locatie nieuw = locatie.gaNaar('z');
		assertNotNull(nieuw,"kan niet van berg naar zuid");
	}
	
	@Test
	void testTopNietNaarNoord() {
		Adventure adventure = new Adventure();
		Locatie locatie = Locatie.zoekOpNaam("top");
		Locatie nieuw = locatie.gaNaar('n');
		assertNull(nieuw,"van top naar noord moet niet kunnen");
	}
}
