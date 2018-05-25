package nl.sey;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumTest {

	@Test
	void test_7() {
		// Arrange
		int expected = 7;
		int actual = 4 + 4;
		// Act
		// Assert
		assertEquals(expected, actual, "Optelling mislukt");
	}
	
	@Test
	void test_8() {
		int expected = 8;
		int actual = 4 + 3;
		assertEquals(expected, actual, "Optelling mislukt");
	}

}
