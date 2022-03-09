/**
 * 
 */
package g11ArtemisLite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author crclarke
 *
 */
public class DevelopmentInfoManager implements java.io.Serializable {
	
	private static final long serialVersionUID = 2938313309603492644L;

	public static final String START_SQUARE_NAME = "Mission Control";
	public static final String EMPTY_SQUARE_NAME = "Exploration Ground Systems";
	public static final String ELEMENT1_NAME = "Power & Propulsion Element";
	public static final String ELEMENT1_MINOR1_NAME = "Solar Arrays";
	public static final String ELEMENT1_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT1_MINOR2_NAME = "S-band Communications System";
	public static final String ELEMENT1_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT1_MINOR3_NAME = "Science Payload";
	public static final String ELEMENT1_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT1_MAJOR_NAME = "Ion Thrusters";
	public static final String ELEMENT1_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo dI1 = new DevelopmentInfo(ELEMENT1_MINOR1_NAME, ELEMENT1_MINOR1_DESC, ELEMENT1_MINOR2_NAME, ELEMENT1_MINOR2_DESC, ELEMENT1_MINOR3_NAME, ELEMENT1_MINOR3_DESC, ELEMENT1_MAJOR_NAME, ELEMENT1_MAJOR_DESC);
	
	public static final String ELEMENT2_NAME = "Habitation & Logistics Outpost";
	public static final String ELEMENT2_MINOR1_NAME = "CAPSTONE Cubesat";
	public static final String ELEMENT2_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT2_MINOR2_NAME = "Pressure control systems";
	public static final String ELEMENT2_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT2_MINOR3_NAME = "Comms to lunar surface";
	public static final String ELEMENT2_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT2_MAJOR_NAME = "Docking ports";
	public static final String ELEMENT2_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo dI2 = new DevelopmentInfo(ELEMENT2_MINOR1_NAME, ELEMENT2_MINOR1_DESC, ELEMENT2_MINOR2_NAME, ELEMENT2_MINOR2_DESC, ELEMENT2_MINOR3_NAME, ELEMENT2_MINOR3_DESC, ELEMENT2_MAJOR_NAME, ELEMENT2_MAJOR_DESC);
	
	public static final String ELEMENT3_NAME = "Avionics";
	public static final String ELEMENT3_MINOR1_NAME = "Rocket sensors";
	public static final String ELEMENT3_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT3_MINOR2_NAME = "Controller boxes & cabling";
	public static final String ELEMENT3_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT3_MINOR3_NAME = "Virtual launch environment";
	public static final String ELEMENT3_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT3_MAJOR_NAME = "Flight computers";
	public static final String ELEMENT3_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo dI3 = new DevelopmentInfo(ELEMENT3_MINOR1_NAME, ELEMENT3_MINOR1_DESC, ELEMENT3_MINOR2_NAME, ELEMENT3_MINOR2_DESC, ELEMENT3_MINOR3_NAME, ELEMENT3_MINOR3_DESC, ELEMENT3_MAJOR_NAME, ELEMENT3_MAJOR_DESC);
	
	public static final String ELEMENT4_NAME = "Core Stage & Propulsion";
	public static final String ELEMENT4_MINOR1_NAME = "Fuel tanks";
	public static final String ELEMENT4_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT4_MINOR2_NAME = "Propellant";
	public static final String ELEMENT4_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT4_MINOR3_NAME = "4 RS-25 Engines";
	public static final String ELEMENT4_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT4_MAJOR_NAME = "Rocket Boosters";
	public static final String ELEMENT4_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo dI4 = new DevelopmentInfo(ELEMENT4_MINOR1_NAME, ELEMENT4_MINOR1_DESC, ELEMENT4_MINOR2_NAME, ELEMENT4_MINOR2_DESC, ELEMENT4_MINOR3_NAME, ELEMENT4_MINOR3_DESC, ELEMENT4_MAJOR_NAME, ELEMENT4_MAJOR_DESC);
	
	public static final String ELEMENT5_NAME = "Interim Cryogenic Propulsion Stage";
	public static final String ELEMENT5_MINOR1_NAME = "Orion Stage Adapter";
	public static final String ELEMENT5_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT5_MINOR2_NAME = "Liquid oxygen tank";
	public static final String ELEMENT5_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT5_MINOR3_NAME = "Liquid hydrogen tank";
	public static final String ELEMENT5_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT5_MAJOR_NAME = "Aerojet Rocketdyne engine";
	public static final String ELEMENT5_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo dI5 = new DevelopmentInfo(ELEMENT5_MINOR1_NAME, ELEMENT5_MINOR1_DESC, ELEMENT5_MINOR2_NAME, ELEMENT5_MINOR2_DESC, ELEMENT5_MINOR3_NAME, ELEMENT5_MINOR3_DESC, ELEMENT5_MAJOR_NAME, ELEMENT5_MAJOR_DESC);
	
	public static final String ELEMENT6_NAME = "Service Module";
	public static final String ELEMENT6_MINOR1_NAME = "Spacecraft adapter";
	public static final String ELEMENT6_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT6_MINOR2_NAME = "Power & thermal control";
	public static final String ELEMENT6_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT6_MINOR3_NAME = "Water & air support";
	public static final String ELEMENT6_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT6_MAJOR_NAME = "Orbital transfer propulsion";
	public static final String ELEMENT6_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo dI6 = new DevelopmentInfo(ELEMENT6_MINOR1_NAME, ELEMENT6_MINOR1_DESC, ELEMENT6_MINOR2_NAME, ELEMENT6_MINOR2_DESC, ELEMENT6_MINOR3_NAME, ELEMENT6_MINOR3_DESC, ELEMENT6_MAJOR_NAME, ELEMENT6_MAJOR_DESC);
	
	public static final String ELEMENT7_NAME = "Launch Abort Systems";
	public static final String ELEMENT7_MINOR1_NAME = "Fairing Assembly";
	public static final String ELEMENT7_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT7_MINOR2_NAME = "Attitude Control Motor";
	public static final String ELEMENT7_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT7_MINOR3_NAME = "Jettison Motor";
	public static final String ELEMENT7_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT7_MAJOR_NAME = "Abort Motor";
	public static final String ELEMENT7_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo dI7 = new DevelopmentInfo( ELEMENT7_MINOR1_NAME, ELEMENT7_MINOR1_DESC, ELEMENT7_MINOR2_NAME, ELEMENT7_MINOR2_DESC, ELEMENT7_MINOR3_NAME, ELEMENT7_MINOR3_DESC, ELEMENT7_MAJOR_NAME, ELEMENT7_MAJOR_DESC);
	
	public static final String ELEMENT8_NAME = "Crew Module";
	public static final String ELEMENT8_MINOR1_NAME = "Power generators";
	public static final String ELEMENT8_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT8_MINOR2_NAME = "Crew quarters";
	public static final String ELEMENT8_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT8_MINOR3_NAME = "Guidance, Nav & Control Systems";
	public static final String ELEMENT8_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT8_MAJOR_NAME = "ECLSS";
	public static final String ELEMENT8_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo dI8 = new DevelopmentInfo(ELEMENT8_MINOR1_NAME, ELEMENT8_MINOR1_DESC, ELEMENT8_MINOR2_NAME, ELEMENT8_MINOR2_DESC, ELEMENT8_MINOR3_NAME, ELEMENT8_MINOR3_DESC, ELEMENT8_MAJOR_NAME, ELEMENT8_MAJOR_DESC);
	
	public static final String ELEMENT9_NAME = "Human Landing System";
	public static final String ELEMENT9_MINOR1_NAME = "Super Heavy Booster";
	public static final String ELEMENT9_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT9_MINOR2_NAME = "Surface transportation";
	public static final String ELEMENT9_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT9_MINOR3_NAME = "Payload storage & habitable module";
	public static final String ELEMENT9_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT9_MAJOR_NAME = "Reaction Control System thrusters";
	public static final String ELEMENT9_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo dI9 = new DevelopmentInfo(ELEMENT9_MINOR1_NAME, ELEMENT9_MINOR1_DESC, ELEMENT9_MINOR2_NAME, ELEMENT9_MINOR2_DESC, ELEMENT9_MINOR3_NAME, ELEMENT9_MINOR3_DESC, ELEMENT9_MAJOR_NAME, ELEMENT9_MAJOR_DESC);
	
	public static final String ELEMENT10_NAME = "xEMU Spacesuit";
	public static final String ELEMENT10_MINOR1_NAME = "Portable life support system";
	public static final String ELEMENT10_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT10_MINOR2_NAME = "High-speed data comms system";
	public static final String ELEMENT10_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT10_MINOR3_NAME = "Membrane evaporative cooling system";
	public static final String ELEMENT10_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT10_MAJOR_NAME = "Enhanced mobility system";
	public static final String ELEMENT10_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo dI10 = new DevelopmentInfo(ELEMENT10_MINOR1_NAME, ELEMENT10_MINOR1_DESC, ELEMENT10_MINOR2_NAME, ELEMENT10_MINOR2_DESC, ELEMENT10_MINOR3_NAME, ELEMENT10_MINOR3_DESC, ELEMENT10_MAJOR_NAME, ELEMENT10_MAJOR_DESC);
	
	private List<DevelopmentInfo> allDevelopmentInfo = new ArrayList<>();

	/**
	 * @param allDevelopmentInfo
	 */
	public DevelopmentInfoManager() {
		allDevelopmentInfo.add(dI1);
		allDevelopmentInfo.add(dI2);
		allDevelopmentInfo.add(dI3);
		allDevelopmentInfo.add(dI4);
		allDevelopmentInfo.add(dI5);
		allDevelopmentInfo.add(dI6);
		allDevelopmentInfo.add(dI7);
		allDevelopmentInfo.add(dI8);
		allDevelopmentInfo.add(dI9);
		allDevelopmentInfo.add(dI10);
	}
	
	public void addDevelopmentInfo(DevelopmentInfo developmentInfo) {
		allDevelopmentInfo.add(developmentInfo);
	}
	
	public void removeDevelopmentInfo(DevelopmentInfo developmentInfo) {
		allDevelopmentInfo.remove(developmentInfo);
	}

	/**
	 * @return the allDevelopmentInfo
	 */
	public List<DevelopmentInfo> getAllDevelopmentInfo() {
		return allDevelopmentInfo;
	}
	
	
	
}
