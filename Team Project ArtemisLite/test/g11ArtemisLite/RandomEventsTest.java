package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomEventsTest {
	
	public static final int RESOURCES = 1000;
	public static final int SMALL_FEE = 20;
	public static final int MEDIUM_FEE = 20;
	public static final int LARGE_FEE = 20;
	public static final int LIST_SIZE = 20;
	public static final int FEE_LIST_SIZE = 3;
	
	RandomEvents randomEvents;
	Random ran;
	Player p1;
	Player p2;
	String p1Name = "p1Name";
	String p2Name = "p2Name";
	List<Player> players;
	int playerNum;
	int goodOrBad;
	int goodEventNum;
	int badEventNum;
	int fineNum;
	

	@BeforeEach
	void setUp() throws Exception {
		randomEvents = new RandomEvents();
		ran = new Random();
		p1 = new Player(p1Name);
		p2 = new Player(p2Name);
		players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
		playerNum = ran.nextInt(players.size());
		goodOrBad = ran.nextInt(2);
		goodEventNum = ran.nextInt(LIST_SIZE);
		badEventNum = ran.nextInt(LIST_SIZE);
		fineNum = ran.nextInt(FEE_LIST_SIZE);
		
	}

	@Test
	void testRandomEvents() {
		assertNotNull(randomEvents);
	}
	
	@Test
	void testGenerateRandomEvent() {
		randomEvents.generateRandomEvent(players);
		assertTrue((players.get(0).getResources()==RESOURCES-SMALL_FEE || players.get(0).getResources()==RESOURCES+SMALL_FEE || players.get(0).getResources()==RESOURCES-MEDIUM_FEE || players.get(0).getResources()==RESOURCES+MEDIUM_FEE || players.get(0).getResources()==RESOURCES-LARGE_FEE || players.get(0).getResources()==RESOURCES+LARGE_FEE)
				|| (players.get(1).getResources()==RESOURCES-SMALL_FEE || players.get(1).getResources()==RESOURCES+SMALL_FEE || players.get(1).getResources()==RESOURCES-MEDIUM_FEE || players.get(1).getResources()==RESOURCES+MEDIUM_FEE || players.get(1).getResources()==RESOURCES-LARGE_FEE || players.get(1).getResources()==RESOURCES+LARGE_FEE));
	}
	
	@Test
	void testPlayerNumberGenerator() {
		assertTrue(playerNum>=0 && playerNum<=players.size()-1);
	}
	
	@Test
	void testGoodOrBadGenerator() {
		assertTrue(goodOrBad==0 || goodOrBad==1);
	}
	
	@Test
	void testGoodEventNumGenerator() {
		assertTrue(goodEventNum>=0 && goodEventNum<=LIST_SIZE);
	}
	
	@Test
	void testBadEventNumGenerator() {
		assertTrue(badEventNum>=0 && badEventNum<=LIST_SIZE);
	}
	
	@Test
	void testFineNumGenerator() {
		assertTrue(fineNum>=0 && fineNum<=FEE_LIST_SIZE);
	}

}
