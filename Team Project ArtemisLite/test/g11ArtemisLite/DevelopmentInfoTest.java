package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DevelopmentInfoTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	DevelopmentInfo devInfo;
	String devLv1Name;
	String devLv2Name;
	String devLv3Name;
	String devLv4Name;
	String devLv1Desc;
	String devLv2Desc;
	String devLv3Desc;
	String devLv4Desc;

	@BeforeEach
	void setUp() throws Exception {

		System.setOut(new PrintStream(outputStreamCaptor));

		devLv1Name = "devLevel1Name";
		devLv2Name = "devLevel2Name";
		devLv3Name = "devLevel3Name";
		devLv4Name = "devLevel4Name";
		devLv1Desc = "devLevel1Desc";
		devLv2Desc = "devLevel2Desc";
		devLv3Desc = "devLevel3Desc";
		devLv4Desc = "devLevel4Desc";
		devInfo = new DevelopmentInfo(devLv1Name, devLv1Desc, devLv2Name, devLv2Desc, devLv3Name, devLv3Desc,
				devLv4Name, devLv4Desc);
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	void testDevelopmentInfoConstructorAndGetters() {
		assertNotNull(devInfo);
		assertEquals(devLv1Name, devInfo.getDevelopmentLevel1Name());
		assertEquals(devLv2Name, devInfo.getDevelopmentLevel2Name());
		assertEquals(devLv3Name, devInfo.getDevelopmentLevel3Name());
		assertEquals(devLv4Name, devInfo.getDevelopmentLevel4Name());
		assertEquals(devLv1Desc, devInfo.getDevelopmentLevel1Desc());
		assertEquals(devLv2Desc, devInfo.getDevelopmentLevel2Desc());
		assertEquals(devLv3Desc, devInfo.getDevelopmentLevel3Desc());
		assertEquals(devLv4Desc, devInfo.getDevelopmentLevel4Desc());

	}

	@Test
	void testDisplayCurrentDevInfoInput1() throws Exception {
		
		devInfo.displayCurrentDevInfo(1);
		assertEquals("Dev level: devLevel1Name\nDescription: devLevel1Desc", outputStreamCaptor.toString().trim());
	}

	@Test
	void testDisplayCurrentDevInfoInput2() throws Exception {

		devInfo.displayCurrentDevInfo(2);
		assertEquals("Dev level: devLevel2Name\nDescription: devLevel2Desc", outputStreamCaptor.toString().trim());

	}
	
	@Test
	void testDisplayCurrentDevInfoInput3() throws Exception {

		devInfo.displayCurrentDevInfo(3);
		assertEquals("Dev level: devLevel3Name\nDescription: devLevel3Desc", outputStreamCaptor.toString().trim());

	}
	
	@Test
	void testDisplayCurrentDevInfoInput4() throws Exception {
		
		devInfo.displayCurrentDevInfo(4);
		assertEquals("Dev level: devLevel4Name\nDescription: devLevel4Desc", outputStreamCaptor.toString().trim());

	}

}
