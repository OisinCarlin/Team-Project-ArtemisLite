package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author Robbie and Maeve
 *
 */
class StartSquareTest {

	// test data
	StartSquare startSquare;
	Player player;
	String playerName;

	int resources, startingResources;
	String name;

	@BeforeEach
	void setUp() throws Exception {
		
		startingResources = 5000;
		resources = 100;
		name = "test Name";

		startSquare = new StartSquare(name, resources);

		playerName = "player";
		player = new Player(playerName);
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

	/**
	 * Tests when a player passes the start square their current square is set
	 * correctly and they have the appropriate resources added.
	 */
	@Test
	void testOnPass() {
		startSquare.onPass(player);
		assertEquals(startSquare, player.getCurrentSquare());
		assertEquals(startingResources + resources, player.getResources());
	}

}
