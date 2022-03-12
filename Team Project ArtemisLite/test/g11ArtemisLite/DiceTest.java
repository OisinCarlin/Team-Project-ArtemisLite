package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author Robbie
 *
 */
class DiceTest {
	
	//test data
	int numOfSides;

	@BeforeEach
	void setUp() throws Exception {
		numOfSides = 3;
	}

	@Test
	void testDiceIntConstructorArgs() {
		Dice dice = new Dice(numOfSides);
		assertEquals(numOfSides, dice.getNumOfSides());
	}

	@Test
	void testGetNumOfSidesInt() {
		Dice dice = new Dice(numOfSides);
		
		int expected = numOfSides;
		int actual = dice.getNumOfSides();
		
		assertEquals(expected, actual);
	}
}
