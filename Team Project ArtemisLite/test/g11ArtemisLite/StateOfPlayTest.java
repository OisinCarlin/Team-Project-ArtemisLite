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
 * @author oisincarlin
 *
 */
class StateOfPlayTest {


	//=============================================
	// Test Data
	//=============================================


	// Declare player and element objects
	Player player1, player2, player3, player4;

	//Player class data
	String playerName1, playerName2, playerName3, playerName4;

	//Declare a StateOfPlay
	StateOfPlay stateOfPlay;

	//Declare a List of Players
	List<Player> players;

	//Declare a Board
	Board board;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		// Names for Players
		playerName1 = "Maeve";
		playerName2 = "Robbie";
		playerName3 = "Richard";
		playerName4 = "Jamie";

		//Instantiate players
		player1 = new Player(playerName1);
		player2 = new Player(playerName2);
		player3 = new Player(playerName3);
		player4 = new Player(playerName4);

		//Instantiate List
		players = new ArrayList<Player>();

		//Add players to List
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);

		//Instantiate board
		board = new Board();

	}

	/**
	 * Testing getPlayers to get the List of Players from the StateOfPlay
	 */
	@Test
	void testGetPlayers() {

		stateOfPlay = new StateOfPlay();
		stateOfPlay.setPlayers(players);
		assertEquals(players, stateOfPlay.getPlayers());

	}

	/**
	 * Testing getBoard to get the Board from the StateOfPlay
	 */
	@Test
	void testGetBoard() {

		stateOfPlay = new StateOfPlay();
		stateOfPlay.setBoard(board);
		assertEquals(board, stateOfPlay.getBoard());
	}
}

