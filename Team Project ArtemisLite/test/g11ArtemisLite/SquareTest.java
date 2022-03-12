/**
 * 
 */
package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Maeve
 *
 */
class SquareTest {
	Square square;
	String squareName;
	String player1Name;
	String player2Name;
	Player player1;
	Player player2;
	List<Player> players;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		squareName = "square1";
		square = new Square(squareName);
	
		player1Name = "player1Name";
		player2Name = "player2Name";
		player1 = new Player(player1Name);
		player2 = new Player(player2Name);
		
		players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
	}

	/**
	 * Test method for {@link g11ArtemisLite.Square#Square(java.lang.String)}.
	 */
	@Test
	void testSquareConstructorWithArgs() {
		Square square = new Square(squareName);
		assertEquals(squareName, square.getName());
	}

	/**
	 * Test method for {@link g11ArtemisLite.Square#onLand(java.util.List, g11ArtemisLite.Player)}.
	 */
	@Test
	void testOnLand() {
		square.onLand(players, player1);
		assertEquals(square, player1.getCurrentSquare());
	}

	/**
	 * Test method for {@link g11ArtemisLite.Square#onPass(g11ArtemisLite.Player)}.
	 */
	@Test
	void testOnPass() {
		square.onPass(player2);
		assertEquals(square, player2.getCurrentSquare());
	}

	/**
	 * Test method for {@link g11ArtemisLite.Square#getName()}.
	 */
	@Test
	void testGetName() {
		assertEquals(squareName, square.getName());
	}

}
