package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomEventsTest {
	
	RandomEvents randomEvents;

	@BeforeEach
	void setUp() throws Exception {
		randomEvents = new RandomEvents();
	}

	@Test
	void testRandomEvents() {
		assertNotNull(randomEvents);
	}

}
