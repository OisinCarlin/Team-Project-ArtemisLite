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
	ElementSystem eS1;

	@BeforeEach
	void setUp() throws Exception {
		
		System.setOut(new PrintStream(outputStreamCaptor));
		
		game = new Game();
		
		p1 = new Player("player1");
		p2 = new Player("player2");
		p3 = new Player("player3");
		players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
	
		e1 = new Element("element1", 0, 0, 0);
		e2 = new Element("element1", 0, 0, 0);
		e3 = new Element("element1", 0, 0, 0);
		
		p1.addSquare(e1);
		p2.addSquare(e2);
		p3.addSquare(e3);
		
		eS1 = new ElementSystem("elementSystem1");
		eS1.addElement(e1);
		
		
	}
	
	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	void testGame() {
		
		fail("Not yet implemented");
	}

	@Test
	void testStart() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	void testReturnDevelopableElements() {
		fail("Not yet implemented");
	}

	@Test
	void testNoDevelopmentsToMakeChecker() {
		fail("Not yet implemented");
	}

	@Test
	void testDevelopElement() {
		
		fail("Not yet implemented");
	}

	@Test
	void testDevelopmentMenu() {
		fail("Not yet implemented");
	}

	@Test
	void testTradeElementMenu() {
		fail("Not yet implemented");
	}

}
