/**
 * 
 */
package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author crclarke
 *
 */
class SerializationTest {
	
	Player p1;
	Player p2;
	Board board;
	Element e1;
	Square s1;
	Serializaion serialization;
	List<Player> players;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// create players to add to save list
		p1 = new Player("Player1");
		p1.addResources(1000);
		p2 = new Player("Player2");
		p2.addResources(500);
		
		// add players to list
		players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
		
		// create element and square to add to board
		e1 = new Element("Element1", 1, 100, 100, 100);
		s1 = new StartSquare("Start", 100);
		
		// add squares to board
		board = new Board();
		board.addSquareToBoard(s1);
		board.addSquareToBoard(e1);
		
		serialization = new Serializaion();
		
	}

	/**
	 * Test method for SaveData
	 */
	@Test
	void testSaveData() {
		serialization.SaveData(players, board);
		File file = new File("myData");
		assertNotNull(file);
	}

	/**
	 * Test method for Saving and Restoring Players
	 */
	@Test
	void testSaveRestorePlayers() {
		serialization.SaveData(players, board);
		List<Player> restoredPlayers = serialization.RestorePlayers();
		assertTrue(restoredPlayers.size()==2);
		assertTrue(restoredPlayers.get(0).getName().equals(players.get(0).getName()));
		assertTrue(restoredPlayers.get(1).getName().equals(players.get(1).getName()));
		assertTrue(restoredPlayers.get(0).getResources()==players.get(0).getResources());
		assertTrue(restoredPlayers.get(1).getResources()==players.get(1).getResources());
		
	}

	/**
	 * Test method for Saving and Restoring Board
	 */
	@Test
	void testSaveRestoreBoard() {
		serialization.SaveData(players, board);
		Board restoredBoard = serialization.RestoreBoard();
		List<Square> originalSquares = board.getSquares();
		List<Square> restoredSquares = restoredBoard.getSquares();
		assertTrue(restoredSquares.size()==2);
		assertEquals(originalSquares.get(0).getName(), restoredSquares.get(0).getName());
		assertEquals(originalSquares.get(1).getName(), restoredSquares.get(1).getName());
		
	}

}
