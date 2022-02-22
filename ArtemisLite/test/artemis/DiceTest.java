package artemis;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiceTest {
	
	//test data
	int numSides, numSidesInvalidLower, numSidesInvalidUpper, numDice, numDiceInvalidLower, numDiceInavlidUpper; 
	Dice Dice;

	@BeforeEach
	void setUp() throws Exception {
		
		numSides = 3;
		numSidesInvalidLower = 0;
		numDiceInavlidUpper = 7;
		
		numDice = 2;
		numDiceInvalidLower = 0;
		numDiceInavlidUpper = 3;
		
		Dice = new Dice();
		
	}

	@Test
	void testDice() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNumSides() {
		fail("Not yet implemented");
	}

	@Test
	void testSetNumSides() {
		fail("Not yet implemented");
	}

	@Test
	void testRollDice() {
		fail("Not yet implemented");
	}

}
