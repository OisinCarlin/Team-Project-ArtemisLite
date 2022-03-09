/**
 * 
 */
package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author oisincarlin
 *
 */
class ElementSystemTest {
	
	//=============================================
	// Test Data
	//=============================================
	
	//ElementSystem class data
	ElementSystem elementSystem;
	
	String systemName;
	
	// Declare player and element objects
	Player owner;
	Element element1, element2, element3;
	
	//Player class data
	String playerName;
	
	//Element class data
	String elementName1, elementName2, elementName3; 
	int purchasePrice1, purchasePrice2, purchasePrice3; 
	int rentPrice1, rentPrice2, rentPrice3; 
	int developmentPrice1, developmentPrice2, developmentPrice3;
	
	// Declare Set of Elements
//	Set<Element> elements;
	
	/**
	 * Set up test
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// System name for and ElementSystem
		systemName = "System 1";
		
		
		
		// Name for a Player
		playerName = "John";
		
		// Names for Elements
		elementName1 = "Element 1";
		elementName2 = "Element 2";
		elementName3 = "Element 3";
		
		// Purchase prices for Elements
		purchasePrice1 = 500;
		purchasePrice2 = 1000;
		purchasePrice3 = 1200;
		
		// Rent Prices for Elements
		rentPrice1 = 50;
		rentPrice2 = 100;
		rentPrice3 = 200;
		
		//Development prices for Elements
		developmentPrice1 = 300;
		developmentPrice2 = 500;
		developmentPrice3 = 800;
		
		// Instantiate Player
		owner = new Player(playerName);
		
		// Instantiate Elements	
		element1 = new Element(elementName1, purchasePrice1, rentPrice1, developmentPrice1);
		element2 = new Element(elementName2, purchasePrice2, rentPrice2, developmentPrice2);
		element3 = new Element(elementName3, purchasePrice3, rentPrice3, developmentPrice3);
			
	}
	
	/**
	 *  Testing constructor with arguments
	 *  Ensures System name is set to name passed as parameter argument
	 *  Ensures ElementSystem object "es" is created and not null.
	 *  Ensures an empty Set<Element> is created within the ElementSystem object
	 */
	@Test
	void testConstructorArgs() {
		ElementSystem es = new ElementSystem(systemName);
		assertNotNull(es);
		assertEquals(systemName, es.getName());
		
		Set<Element> elements = es.getElements();
		assertTrue(elements.size()==0);
	}
	
	/**
	 *  Testing GetName to retrieve name of ElementSystem
	 */
	@Test
	void testGetName() {
		elementSystem = new ElementSystem(systemName);
		assertEquals(systemName, elementSystem.getName());
		
	}
	
	/**
	 *  Testing GetOwner to retrieve owner (Player) of ElementSystem
	 *  Implements SetOwner method which sets the owner of the ElementSystem
	 */
	@Test
	void testGetOwner() {
		elementSystem = new ElementSystem(systemName);
		elementSystem.setOwner(owner);
		assertEquals(owner, elementSystem.getOwner());
	}
	
	/**
	 *  Testing AddElement to add an Element to the elements Set
	 *  Implements GetElements method which retrieves Elements in Set
	 *  Adds 3 Elements to Set, checks if all 3 are added.
	 */
	@Test
	void testAddElement() {
		elementSystem = new ElementSystem(systemName);
		elementSystem.addElement(element1);
		elementSystem.addElement(element2);
		elementSystem.addElement(element3);

		if(elementSystem.getElements().contains(element1)) {
			if(elementSystem.getElements().contains(element2)) {
				if(elementSystem.getElements().contains(element3)) {
					assertTrue(true);
				} else {
					assertTrue(false);
				}
			} else {
				assertTrue(false);
			}
		} else {
			assertTrue(false);
		}
	}
	
	/**
	 *  Testing RemoveElement to remove an Element to the elements Set
	 *  Implements AddElement to add an Element to the elements Set
	 *  Implements GetElements method which retrieves Elements in Set
	 *  Adds three Elements then removes one, so checks that 2 remain
	 */
	@Test
	void testRemoveElement() {
		elementSystem = new ElementSystem(systemName);
		elementSystem.addElement(element1);
		elementSystem.addElement(element2);
		elementSystem.addElement(element3);



		elementSystem.removeElement(element2);


		if(elementSystem.getElements().contains(element2)) {
			assertTrue(false);
		} else { 
			if(elementSystem.getElements().size()==2) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}

		}
	}
}
