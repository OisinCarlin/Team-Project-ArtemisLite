package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author Robbie and Maeve
 *
 */
class ElementTest {

	// test data
	String elementName, playerName, player2Name;
	int elementNum, purchasePrice, rentPrice, developmentPrice, startingDevLevel, increasedDevLevel, startingRes, afterPurchRes, afterRentRes, afterDevRes, adjustedRentPrice, addedRentRes;
	
	Player owner;
	Player ownerNull;
	Element element;
	Player player1;
	Player player2;
	List<Player> players;

	@BeforeEach
	void setUp() throws Exception {
		elementName = "element";
		playerName = "player";
		player2Name = "player2";
		elementNum = 1;

		startingRes = 1000;
		purchasePrice = 100;
		afterPurchRes = startingRes - purchasePrice;
		rentPrice = 200;
		adjustedRentPrice = 400;
		afterRentRes = startingRes - rentPrice;
		addedRentRes = startingRes + rentPrice;
		developmentPrice = 50;
		afterDevRes = startingRes - developmentPrice;
		startingDevLevel = 0;
		increasedDevLevel = 2;
		
		element = new Element(elementName, elementNum, purchasePrice, rentPrice, developmentPrice);
		
		ownerNull = null;
		owner = new Player(playerName);
		player1 = new Player(playerName);
		player2 = new Player(player2Name);
		
		players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
	}

	/**
	 * Test constructor with args
	 */
	@Test
	void testElementConstructorArgs() {
		Element element = new Element(elementName, elementNum, purchasePrice, rentPrice, developmentPrice);

		assertEquals(elementName, element.getName());
		assertEquals(purchasePrice, element.getPurchasePrice());
		assertEquals(rentPrice, element.getRentPrice());
		assertEquals(developmentPrice, element.getDevelopmentPrice());
		assertEquals(startingDevLevel, element.getDevLevel());
	}

	@Test
	void testGetSetRentPrice() {
		element.setRentPrice(rentPrice);
		assertEquals(rentPrice, element.getRentPrice());
	}

	@Test
	void testGetDevelopmentPrice() {
		assertEquals(developmentPrice, element.getDevelopmentPrice());
	}

	@Test
	void testIncreaseDevLevel() {
		element.increaseDevLevel();
		element.increaseDevLevel();
		assertEquals(increasedDevLevel, element.getDevLevel());
		assertEquals(adjustedRentPrice, element.getRentPrice());
	}

	@Test
	void testGetSetOwner() {
		element.setOwner(owner);
		assertEquals(owner, element.getOwner());
	}
	
	@Test
	void testGetSetOwnerNull() {
		assertEquals(ownerNull, element.getOwner());
	}
	
	@Test
	void testOnLandAndPurchase() {
		element.onLand(players, player1);
		
		assertEquals(element, player1.getCurrentSquare());
		assertEquals(afterPurchRes, player1.getResources());
		assertTrue(player1.getSquaresOwned().size() == 1 && player1.getSquaresOwned().contains(element));
	}
	
	@Test
	void testOnLandAndAltPlayerPurchase() {
		element.onLand(players, player1);

		assertEquals(element, player1.getCurrentSquare());
		assertEquals(afterPurchRes, player2.getResources());
		assertTrue(player2.getSquaresOwned().size() == 1 && player2.getSquaresOwned().contains(element));
	}
	
	@Test
	void testOnLandAndNoPurchase() {
		element.onLand(players, player1);
		
		assertEquals(element, player1.getCurrentSquare());
		assertEquals(startingRes, player2.getResources()); 
		assertTrue(player1.getSquaresOwned().size() == 0);	
	}
	
	@Test
	void testOnLandAndPayRent() {
		element.setOwner(player2);
		element.onLand(players, player1);
		
		assertEquals(element, player1.getCurrentSquare());
		assertEquals(afterRentRes, player1.getResources());
		assertEquals(addedRentRes, player2.getResources());
	}
	
	@Test
	void testOnLandAndNoRent() {
		element.setOwner(player2);
		element.onLand(players, player1);
		
		assertEquals(element, player1.getCurrentSquare());
		assertEquals(startingRes, player1.getResources());
		assertEquals(startingRes, player2.getResources());
	}
}