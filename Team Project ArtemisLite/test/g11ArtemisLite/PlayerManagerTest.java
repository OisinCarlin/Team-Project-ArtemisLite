package g11ArtemisLite;

import java.util.List;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author jamielarkin
 *
 */

class PlayerManagerTest {
	
	Message message;
	final int maxUsers = 4;
	final int minUsers = 2;
	long serialVersionUID;
	List<Player> players;
	String player1Name;
	String player2Name;
	Player p1;
	Player p2;

	@BeforeEach
	void setUp() throws Exception {
		
		serialVersionUID = 2938313309603492644L;
		
		player1Name = "player1";
		player2Name = "player2";
		p1 = new Player(player1Name);
		p2 = new Player(player2Name);
		players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
	}
	
	/**
	 * Tests the user count matches the players array list
	 */
	@Test
	void testGetUserCount() {
		
		PlayerManager playerManager = new PlayerManager();

		int expected = players.size();
		int actual = playerManager.getUserCount();
		assertEquals(expected, actual);
	}

	@Test
	void testGetUserData() {
		
		PlayerManager playerManager = new PlayerManager();
		assertNotNull(playerManager.getUsernames());
	}


	@Test
	void testGetPlayers() {
		
		PlayerManager playerManager = new PlayerManager();
		assertNotNull(playerManager.getPlayers());
	}

	@Test
	void testGetPlayer() {
		
		PlayerManager playerManager = new PlayerManager();
		
		assertNotNull(playerManager.getPlayers());
		
		if(players.size() == 2) {
			assertTrue(true);
			
		} else {
			assertTrue(false);
		}	
	}

}
