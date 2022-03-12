package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	Game game;
	Player p1;
	Player p2;
	Player p3;
	List<Player> players;
	Element e1;
	Element e2;
	Element e3;
	Element e4;
	List<Element> elements;
	List<Element> developableElements;

	@BeforeEach
	void setUp() throws Exception {
		
		System.setOut(new PrintStream(outputStreamCaptor));
		
		game = new Game();
		elements = new ArrayList<>();
		
		p1 = new Player("player1");
		p2 = new Player("player2");
		p3 = new Player("player3");
		players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
	
		e1 = new Element("element1", 0, 0, 0);
		e2 = new Element("element2", 0, 0, 2000);
		e3 = new Element("element3", 2000, 0, 1000);
		e4 = new Element("element4", 0, 0, 0);
		e4.increaseDevLevel();
		e4.increaseDevLevel();
		e4.increaseDevLevel();
		e4.increaseDevLevel();
		
		elements.add(e1);
		elements.add(e2);
		elements.add(e3);
		elements.add(e4);
		
		p1.addSquare(e1);
		p2.addSquare(e2);
		p3.addSquare(e3);
		
		e1.setOwner(p1);
		e2.setOwner(p2);
		e3.setOwner(p3);
		
	}
	
	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	void testGame() {
		assertNotNull(game);
	}
 
	@Test
	void testDisplayIntroMessage() {
		game.displayIntroMessage(players);
		assertEquals(p1.getName() +", "+ p2.getName() +" & "+ p3.getName()+" "+"will lead an innovative and sustainable program of exploration with commercial and international partners "
				+ "\nto enable human expansion across the solar system and to bring back to earth new knowledge and opportunities. "
				+ "\nBeginning with missions beyond low-earth orbit, "
				+ "\nthe US will lead the return of humans to the Moon for long-term exploration and utilisation, "
				+ "\nfollowed by human missions to Mars and other destinations", outputStreamCaptor.toString().trim());
	}

	@Test
	void testQuitGame() {
		boolean quitGame;
		quitGame = game.quitGame();
		assertTrue(quitGame);
		assertEquals("You've quit the game, which means Game Over for all players!", outputStreamCaptor.toString().trim());
	}

	@Test
	void testReturnDevelopableElements() {
		developableElements = game.returnDevelopableElements(p1);
		assertTrue(developableElements.size()==0);
	}

	@Test
	void testNoDevelopmentsToMakeChecker() {
		// test that one fully developed element is removed
		boolean breaker = game.noDevelopmentsToMakeChecker(p1, elements);
		assertFalse(breaker);
		assertTrue(elements.size()==3 && elements.contains(e1) && elements.contains(e2) && elements.contains(e3) && !elements.contains(e4));
		
		e1.increaseDevLevel();
		e1.increaseDevLevel();
		e1.increaseDevLevel();
		e1.increaseDevLevel();
		
		e2.increaseDevLevel();
		e2.increaseDevLevel();
		e2.increaseDevLevel();
		e2.increaseDevLevel();
		
		e3.increaseDevLevel();
		e3.increaseDevLevel();
		e3.increaseDevLevel();
		e3.increaseDevLevel();
		
		// test that when all elements are fully developed they are removed and system displays message
		breaker = game.noDevelopmentsToMakeChecker(p1, elements);
		assertTrue(breaker);
		assertTrue(elements.size()==0);
		assertEquals("You don't have any developments to make!", outputStreamCaptor.toString().trim());
	}

	@Test
	void testDevelopElement() {
		
		// test for valid development
		int currentDevLevelE1 = e1.getDevLevel();
		int developedDevLevelE1 = currentDevLevelE1+1;
		int developmentPriceE1 = e1.getDevelopmentPrice();
		int startingResourcesP1 = p1.getResources();
		game.developElement(e1, p1);
		assertEquals(developedDevLevelE1, e1.getDevLevel());
		assertEquals(startingResourcesP1-developmentPriceE1, p1.getResources());
		
		// test for invalid development
		int currentDevLevelE2 = e2.getDevLevel();
		int startingResourcesP2 = p2.getResources();
		game.developElement(e2, p2);
		assertEquals(currentDevLevelE2, e2.getDevLevel());
		assertEquals(startingResourcesP2, p2.getResources());
		
		
		// test at boundary, developmentPrice == playerResources
		int currentDevLevelE3 = e3.getDevLevel();
		int developedDevLevelE3 = currentDevLevelE3+1;
		int developmentPriceE3 = e3.getDevelopmentPrice();
		int startingResourcesP3 = p3.getResources();
		game.developElement(e3, p3);
		assertEquals(developedDevLevelE3, e3.getDevLevel());
		assertEquals(startingResourcesP3-developmentPriceE3, p3.getResources());
		
		
	}

	@Test
	void testTradeElement() {
		int startingResourcesP1 = p1.getResources();
		int startingResourcesP2 = p2.getResources();
		int startingResourcesP3 = p3.getResources();
		
		// test for valid trade
		game.tradeElement(e1, p1, p2);
		assertTrue(!p1.getSquaresOwned().contains(e1) && p2.getSquaresOwned().contains(e1));
		assertTrue(e1.getOwner()==p2);
		assertEquals(startingResourcesP1+e1.getPurchasePrice(), p1.getResources());
		assertEquals(startingResourcesP2-e1.getPurchasePrice(), p2.getResources());
		
		// test for invalid trade
		game.tradeElement(e3, p3, p2);
		assertTrue(!p2.getSquaresOwned().contains(e3) && p3.getSquaresOwned().contains(e3));
		assertTrue(e3.getOwner()==p3);
		assertEquals(startingResourcesP2, p2.getResources());
		assertEquals(startingResourcesP3, p3.getResources());
	}

}
