package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author Robbie and Maeve
 *
 */
class PlayerTest {

	// test data
	Player player, player2;
	String playerName, elementName, element2Name, element3Name, elementSystemName;
	Set<Element> squaresOwned;
	int resources, resourcesToAdd, startingResources;
	Square currentSquare;
	Element element, element2, element3;
	ElementSystem elementSystem;

	
	@BeforeEach
	void setUp() throws Exception {
		playerName = "player";
		resources = 100;
		resourcesToAdd = 100;
		startingResources = 1000;
		player = new Player(playerName);
		player2 = new Player(playerName);
		
		elementName = "element";
		element2Name = "element2";
		element3Name = "element3";
		element = new Element(elementName, 0, 0, 0);
		element2 = new Element(element2Name, 0, 0, 0);
		element3 = new Element(element3Name, 0, 0, 0);
		
		elementSystemName = "elementSystem";
		elementSystem = new ElementSystem(elementSystemName);
		elementSystem.addElement(element);
		elementSystem.addElement(element2);

		currentSquare = element;
		squaresOwned = new HashSet<>();
		squaresOwned.add(element);
		squaresOwned.add(element2);
		player.addSquare(element);
		player.addSquare(element2);
	}

	/**
	 * Test constructor with args
	 */
	@Test
	void testPlayerConstuctorArgs() {
		Player player = new Player(playerName);

		assertEquals(playerName, player.getName());
		assertEquals(startingResources, player.getResources());
		assertTrue(player.getSquaresOwned().size() == 0);
	}

	@Test
	void testGetNameString() {
		String expected = playerName;
		String actual = player.getName();

		assertEquals(expected, actual);

	}

	@Test
	void testGetSquaresOwnedElement() {
		assertEquals(squaresOwned, player.getSquaresOwned());
	}

	@Test
	void testGetResourcesInt() {
		int expected = startingResources;
		int actual = player.getResources();

		assertEquals(expected, actual);
	}

	@Test
	void testGetSetCurrentSquareSquare() {
		player.setCurrentSquare(currentSquare);

		assertEquals(currentSquare, player.getCurrentSquare());
	} 

	@Test
	void testAddSquareElement() {
		player.addSquare(element3);
		
		assertTrue(player.getSquaresOwned().size() == 3 && player.getSquaresOwned().contains(element) && player.getSquaresOwned().contains(element2) && player.getSquaresOwned().contains(element3));
	}

	@Test
	void testRemoveSquareElement() {
		player.removeSquare(element);
		
		assertTrue(player.getSquaresOwned().size() == 1 && player.getSquaresOwned().contains(element2));
	} 

	@Test
	void testAddResources() {
		player.addResources(resourcesToAdd);

		int expected = (startingResources + resourcesToAdd);
		int actual = player.getResources();

		assertEquals(expected, actual);
	}

	@Test
	void testRemoveResources() {
		player.removeResources(resourcesToAdd);

		int expected = (startingResources - resourcesToAdd);
		int actual = player.getResources();

		assertEquals(expected, actual);
	}

	@Test
	void testOwnsFullSystemTrue() {
		assertTrue(player.ownsFullSystem(elementSystem));
	}
	
	@Test
	void testOwnsFullSystemFalse() {
		assertFalse(player2.ownsFullSystem(elementSystem));
	}

	@Test
	void testBankruptCheckFalse() {
		assertFalse(player.bankruptCheck());
	}
	
	@Test
	void testBankruptCheckTrue() {
		player.removeResources(startingResources + 10);
		assertTrue(player.bankruptCheck());
	}
	
	@Test
	void testCurrentTurnTrue() {
		player.setCurrentTurn(true);
		assertTrue(player.isCurrentTurn());
	}
	
	@Test
	void testCurrentTurnFalse() {
		player.setCurrentTurn(false);
		assertFalse(player.isCurrentTurn());
	}
	
	@Test
	void testHasMovedTrue() {
		player.setHasMoved(true);
		assertTrue(player.hasMoved());
	}
	
	@Test
	void testHasMovedFalse() {
		player.setHasMoved(false);
		assertFalse(player.hasMoved());
	}
}
