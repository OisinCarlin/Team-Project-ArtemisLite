package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	// test data
	String name;
	Set<Element> squaresOwned;
	int resources;
	Square currentSquare;
	Element element;
	int resourcesToAdd;
	int startingResources;
	ElementSystem elementSystem;

	
	@BeforeEach
	void setUp() throws Exception {
		
		name = "test Name";
		resources = 100;
		resourcesToAdd = 100;
		
		Player player = new Player();
		
		// reflected final int
		startingResources = player.getResources();
	}

	/**
	 * Test constructor with args
	 */
	@Test
	void testPlayerConstuctorArgs() {

		Player player = new Player(name);

		assertEquals(name, player.getName());

	}

	@Test
	void testGetNameString() {

		Player player = new Player(name);

		String expected = name;
		String actual = player.getName();

		assertEquals(expected, actual);

	}

	@Test
	void testGetSquaresOwnedElement() {

		Player player = new Player();

		Set<Element> expected = squaresOwned;
		Set<Element> actual = player.getSquaresOwned();

		assertEquals(expected, actual);

	}

	@Test
	void testGetResourcesInt() {

		Player player = new Player();
	
		int expected = startingResources;
		int actual = player.getResources();

		assertEquals(expected, actual);

	}

	@Test
	void testGetSetCurrentSquareSquare() {

		Player player = new Player();

		player.setCurrentSquare(currentSquare);

		assertEquals(currentSquare, player.getCurrentSquare());

	}

	@Test
	void testAddSquareElement() {

		/*
		 * Player player = new Player(); 
		 * Element element1 = new Element("element", 100, 100, 100);
		 * 
		 * player.addSquare(element1);
		 * 
		 * Set<Element> expected = Set<Element> element1;
		 * Set<Element> actual = player.getSquaresOwned();
		 * 
		 * assertEquals(expected, actual);
		 */
	}

	@Test
	void testRemoveSquareElement() {
		/*
		 * Player player = new Player(); Element element1 = new Element("element", 100,
		 * 100, 100);
		 * 
		 * player.removeSquare(element1);
		 * 
		 * assertEquals(player.getSquaresOwned(), player.getSquaresOwned());
		 */
	}

	@Test
	void testAddResources() {

		Player player = new Player();

		player.addResources(resourcesToAdd);

		int expected = (startingResources + resourcesToAdd);
		int actual = player.getResources();

		assertEquals(expected, actual);

	}

	@Test
	void testRemoveResources() {

		Player player = new Player();

		player.removeResources(resourcesToAdd);

		int expected = (startingResources - resourcesToAdd);
		int actual = player.getResources();

		assertEquals(expected, actual);
	}

	@Test
	void testOwnsFullSystem() {

		/*
		Player player = new Player();

		boolean testSystem = player.ownsFullSystem(elementSystem);

		assertTrue(testSystem);
		*/

	}

}
