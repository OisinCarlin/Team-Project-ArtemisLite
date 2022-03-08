package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DevelopmentInfoManagerTest {
	
	DevelopmentInfoManager devInfoManager;
	
	String element1Minor1Name;
	String element1Minor1Desc;
	String element1Minor2Name;
	String element1Minor2Desc;
	String element1Minor3Name;
	String element1Minor3Desc;
	String element1MajorName;
	String element1Major4Desc;
	DevelopmentInfo d1;
	
	String element2Minor1Name = "Element2Minor1Name";
	String element2Minor1Desc = "Element2Minor1Desc";
	String element2Minor2Name = "Element2Minor1Name";
	String element2Minor2Desc = "Element2Minor2Desc";
	String element2Minor3Name = "Element2Minor1Name";
	String element2Minor3Desc = "Element2Minor3Desc";
	String element2MajorName = "Element2Minor1Name";
	String element2Major4Desc = "Element2MajorDesc";
	DevelopmentInfo d2;
	
	String element3Minor1Name = "Element3Minor1Name";
	String element3Minor1Desc = "Element3Minor1Desc";
	String element3Minor2Name = "Element3Minor1Name";
	String element3Minor2Desc = "Element3Minor2Desc";
	String element3Minor3Name = "Element3Minor1Name";
	String element3Minor3Desc = "Element3Minor3Desc";
	String element3MajorName = "Element3Minor1Name";
	String element3Major4Desc = "Element3MajorDesc";
	DevelopmentInfo d3;

	@BeforeEach
	void setUp() throws Exception {
		element1Minor1Name = "Element1Minor1Name";
		element1Minor1Desc = "Element1Minor1Desc";
		element1Minor2Name = "Element1Minor1Name";
		element1Minor2Desc = "Element1Minor2Desc";
		element1Minor3Name = "Element1Minor3Name";
		element1Minor3Desc = "Element1Minor3Desc";
		element1MajorName = "Element1MajorName";
		element1Major4Desc = "Element1MajorDesc";
		d1 = new DevelopmentInfo(element1Minor1Name, element1Minor1Desc, element1Minor2Name, element1Minor2Desc, element1Minor3Name, element1Minor3Desc, element1MajorName, element1Major4Desc);
		element2Minor1Name = "Element2Minor1Name";
		element2Minor1Desc = "Element2Minor1Desc";
		element2Minor2Name = "Element2Minor1Name";
		element2Minor2Desc = "Element2Minor2Desc";
		element2Minor3Name = "Element2Minor3Name";
		element2Minor3Desc = "Element2Minor3Desc";
		element2MajorName = "Element2MajorName";
		element2Major4Desc = "Element2MajorDesc";
		d2 = new DevelopmentInfo(element2Minor1Name, element2Minor1Desc, element2Minor2Name, element2Minor2Desc, element2Minor3Name, element2Minor3Desc, element2MajorName, element2Major4Desc);
		element3Minor1Name = "Element3Minor1Name";
		element3Minor1Desc = "Element3Minor1Desc";
		element3Minor2Name = "Element3Minor1Name";
		element3Minor2Desc = "Element3Minor2Desc";
		element3Minor3Name = "Element3Minor3Name";
		element3Minor3Desc = "Element3Minor3Desc";
		element3MajorName = "Element3MajorName";
		element3Major4Desc = "Element3MajorDesc";
		d3 = new DevelopmentInfo(element3Minor1Name, element3Minor1Desc, element3Minor2Name, element3Minor2Desc, element3Minor3Name, element3Minor3Desc, element3MajorName, element3Major4Desc);
		
		devInfoManager = new DevelopmentInfoManager();
		
	}

	@Test
	void testDevelopmentInfoManagerConstructorNotNull() {
		assertNotNull(devInfoManager);
		List<DevelopmentInfo> myDevInfo = devInfoManager.getAllDevelopmentInfo();
		assertTrue(myDevInfo.size()==10);
		
		
	}

	@Test
	void testAddRemoveGetAllDevelopmentInfo() {
		devInfoManager.getAllDevelopmentInfo().clear();
		
		List<DevelopmentInfo> myDevInfo = devInfoManager.getAllDevelopmentInfo();
		
		assertTrue(myDevInfo.size()==0);
		
		devInfoManager.addDevelopmentInfo(d1);
		devInfoManager.addDevelopmentInfo(d2);
		devInfoManager.addDevelopmentInfo(d3);
		
		myDevInfo = devInfoManager.getAllDevelopmentInfo();
		
		assertNotNull(myDevInfo);
		assertTrue(myDevInfo.size()==3 && myDevInfo.contains(d1) && myDevInfo.contains(d2) && myDevInfo.contains(d3));
		
		devInfoManager.removeDevelopmentInfo(d1);
		devInfoManager.removeDevelopmentInfo(d2);
		
		myDevInfo = devInfoManager.getAllDevelopmentInfo();
		
		assertNotNull(myDevInfo);
		assertTrue(myDevInfo.size()==1 && !myDevInfo.contains(d1) && !myDevInfo.contains(d2) && myDevInfo.contains(d3));
		
	}

}
