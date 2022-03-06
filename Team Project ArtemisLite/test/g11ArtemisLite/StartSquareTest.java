package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StartSquareTest {
	
    //test data
	int resources;
	String name;
	
	@BeforeEach
	void setUp() throws Exception {
		
		resources = 100;
		name = "test Name";
		
		StartSquare startsquare = new StartSquare(name, resources);

	}

	
	/**
	 * Test constructor with args
	 */
	@Test
	void testStartSquareConstructorArgs() {
		
		StartSquare startsquare = new StartSquare(name, resources);
		
		assertEquals(name, startsquare.getName());
		assertEquals(resources, startsquare.getResources());
		
	}

	@Test
	void testGetResourcesInt() {
		
		StartSquare startsquare = new StartSquare(name, resources);
		
		int expected = resources;
		int actual = startsquare.getResources();
		
		assertEquals(expected, actual);
		
	}
	
	
	@Test
	void testOnPass() {
		
		/*
		StartSquare startsquare = new StartSquare(name, resources);
		Player player = new Player();
		
		int expected = ?
		int actual = player.addResources(getResources();
		
		assertEquals(expected, actual);
		*/

	}

}
