package nl.sey.adventure.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nl.sey.adventure.Adventure;

class AdventureTest {

	@Test
	void testStartLocatie() {
		Adventure adventure = new Adventure();
		String startNaam = adventure.getLocatieNaam();
		assertEquals("rivier",startNaam);
	}

}
