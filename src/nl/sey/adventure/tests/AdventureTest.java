package nl.sey.adventure.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nl.sey.adventure.Adventure;
import nl.sey.adventure.Locatie;

class AdventureTest {

	@Test
	void test_StartNaam() {
		Adventure adventure = new Adventure();
		String naam = adventure.getLocatieNaam();
		assertEquals("rivier", naam, "Start is niet rivier, maar " + naam);
	}

	/* we weten dat je vanuit de startpositie naar o en naar n kan
	 * -> test dat het aantal richtingen van de startpositie 2 is
	 */
	@Test
	void test_Locatie() {
		// Arrange
		Adventure adventure = new Adventure();
		
		// Act
		Locatie start = adventure.getLocatie();
		int aantalVerbindingen = start.getAantalVerbindingen();
		
		// assert
		assertEquals(2, aantalVerbindingen, "Aantal verbindingen is niet 2");
	}
}
