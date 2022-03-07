package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElementTest {
	
	
	//test data
	String name;
	int purchasePrice, rentPrice, developmentPrice, devLevel;
	boolean ansTrue, ansFalse;
	Player owner;
	Player ownerNull;
	UserInput userInput;

	@BeforeEach
	void setUp() throws Exception {
		
		Element element = new Element(name, purchasePrice, rentPrice, developmentPrice);
		Player player = new Player();
	}
	
	/**
	 * Test constructor with args
	 */
	@Test
	void testElementConstructorArgs() {
		
		Element element = new Element(name, purchasePrice, rentPrice, developmentPrice);
		
		assertEquals(name, element.getName());
		assertEquals(purchasePrice, element.getPurchasePrice());
		assertEquals(rentPrice, element.getRentPrice());
		assertEquals(developmentPrice, element.getDevelopmentPrice());
		
	}

	@Test
	void testGetSetRentPrice() {
		Element element = new Element(name, purchasePrice, rentPrice, developmentPrice);
		
		element.setRentPrice(rentPrice);
		assertEquals(rentPrice, element.getRentPrice());
		
	}

	@Test
	void testGetSetDevelopmentPrice() {
		Element element = new Element(name, purchasePrice, rentPrice, developmentPrice);

		element.setDevelopmentPrice(developmentPrice);
		assertEquals(developmentPrice, element.getDevelopmentPrice());
		
	}

	@Test
	void testIncreaseDevLevel() {
		

		Element element = new Element(name, purchasePrice, rentPrice, developmentPrice);
		
		element.increaseDevLevel();
		
		assertEquals((devLevel + 1), element.getDevLevel());
		
	}

	@Test
	void testGetSetOwner() {
		
		Element element = new Element(name, purchasePrice, rentPrice, developmentPrice);

		element.setOwner(owner);
		assertEquals(owner, element.getOwner());
		
	}
}
/*
	@Test
	void testOnLandNull() 
		
		Element element = new Element(name, purchasePrice, rentPrice, developmentPrice);
		Player player = new Player();
		
//assert true? - mock out private method, call onland, check private method has been called
		assertEquals(element.onLand(player), attemptPurchaseElement(player));
	}
	@Test
	void testOnLandPlayerEqualsOwner() {
		
		Element element = new Element(name, purchasePrice, rentPrice, developmentPrice);
		Player player = new Player();
		element.setOwner(owner);
		
// set own as player - mockito? assert method has been called
		assert(System.out.println("You own this element"));
	}
	@Test
	void testOnLandPlayerElse() {

		Element element = new Element(name, purchasePrice, rentPrice, developmentPrice);
		Player player = new Player();

		assertEquals(player.requestRent(player), element.requestRent(player));
	}
}		
*/

