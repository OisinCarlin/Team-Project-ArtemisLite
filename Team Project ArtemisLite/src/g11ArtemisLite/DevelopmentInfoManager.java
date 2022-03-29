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
	public static final String ELEMENT1_MINOR1_DESC = "Two Roll-Out Solar Arrays will provide a staggering 65 kilowatts of power to the largest solar \n"
														+ "electric propulsion system ever produced for a civilian spacecraft.";
	public static final String ELEMENT1_MINOR2_NAME = "S-band Communications System";
	public static final String ELEMENT1_MINOR2_DESC = "Today's the public expects high definition video and images from Artemis. Gateway will support \n"
														+ "near 24/7 communication with Earth when crew is present, either on board Gateway or via the relay \n"
														+ "capability to crew ascending or descending to the lunar surface or living on the Moon.";
	public static final String ELEMENT1_MINOR3_NAME = "Science Payload";
	public static final String ELEMENT1_MINOR3_DESC = "The unique environment in lunar orbit, one that cannot be duplicated on Earth or on the International \n"
														+ "Space Station, will provide new opportunities for scientific investigation. ";
	public static final String ELEMENT1_MAJOR_NAME = "Ion Thrusters";
	public static final String ELEMENT1_MAJOR_DESC = "PPE’s 50kW electric propulsion system will be the most powerful electric propulsion spacecraft ever flown \n"
														+ "and it will maneuver Gateway around the Moon, opening up more of the lunar surface for exploration than ever before.";
	public static final DevelopmentInfo dI1 = new DevelopmentInfo(ELEMENT1_MINOR1_NAME, ELEMENT1_MINOR1_DESC, ELEMENT1_MINOR2_NAME, ELEMENT1_MINOR2_DESC, ELEMENT1_MINOR3_NAME, ELEMENT1_MINOR3_DESC, ELEMENT1_MAJOR_NAME, ELEMENT1_MAJOR_DESC);
	
	public static final String ELEMENT2_NAME = "Habitation & Logistics Outpost";
	public static final String ELEMENT2_MINOR1_NAME = "CAPSTONE Cubesat";
	public static final String ELEMENT2_MINOR1_DESC = "The satellite will be launched into the lunar Near Rectilinear Halo Orbit (NRHO), testing new \n"
														+ "navigation techniques to validate predictive models, reducing uncertainties about the orbit, \n"
														+ "and paving the way for the eventual launch of the Gateway.";
	public static final String ELEMENT2_MINOR2_NAME = "Pressure Control Systems";
	public static final String ELEMENT2_MINOR2_DESC = "Thales Alenia Space has been commissioned to design and build the HALO's primary structure (the \n"
														+ "pressurised module), and the pressure control system for the module and vestibule, part of the protection \n"
														+ "system against micrometeorites.";
	public static final String ELEMENT2_MINOR3_NAME = "Lunar Surface Comms";
	public static final String ELEMENT2_MINOR3_DESC = "Unlike typical science missions which require a very low data rate to support commanding, crewed missions \n"
														+ "require much higher uplink rates with low latency to support synchronized audio with video transfer, family communications, \n"
														+ "and private medical conferences.";
	public static final String ELEMENT2_MAJOR_NAME = "Docking Ports";
	public static final String ELEMENT2_MAJOR_DESC = "HALO will be equipped with 3 docking ports for visiting vehicles and future modules, \n"
														+ "as well as space for science and stowage.";
	public static final DevelopmentInfo dI2 = new DevelopmentInfo(ELEMENT2_MINOR1_NAME, ELEMENT2_MINOR1_DESC, ELEMENT2_MINOR2_NAME, ELEMENT2_MINOR2_DESC, ELEMENT2_MINOR3_NAME, ELEMENT2_MINOR3_DESC, ELEMENT2_MAJOR_NAME, ELEMENT2_MAJOR_DESC);
	
	public static final String ELEMENT3_NAME = "Avionics";
	public static final String ELEMENT3_MINOR1_NAME = "Rocket Sensors";
	public static final String ELEMENT3_MINOR1_DESC = "Sensors form a crucial part of the avionics setup, allowing for continous monitoring of the rocket components and \n"
														+ "the effect of external factors on their operation.";
	public static final String ELEMENT3_MINOR2_NAME = "Controller Boxes & Cabling";
	public static final String ELEMENT3_MINOR2_DESC = "Avionics act as the 'central nervous system' for the SLS, coordinating its actions, with the contoller boxes and over 55 miles of \n"
														+ "cabling forming a complex web to allow for intercommunication between avionics components";
	public static final String ELEMENT3_MINOR3_NAME = "Virtual Launch Environment";
	public static final String ELEMENT3_MINOR3_DESC = "The VLE allows engineers to fully simulate the integration of systems in virtual space prior to hardware manufacturing and test flight. \n"
														+ "Engineers in the lab also create and run end-to-end simulation environments in support of the entire project life cycle.";
	public static final String ELEMENT3_MAJOR_NAME = "Flight Computers";
	public static final String ELEMENT3_MAJOR_DESC = "Three redundant flight computers, monitors the rocket’s condition, senses vehicle motion, generates navigation and control data, \n"
														+ "actuates main propulsion system valves, monitors the main propulsion system and engine controls, and routes flight-critical commands \n"
														+ "to engine thrust vector control systems, and controllers.";
	public static final DevelopmentInfo dI3 = new DevelopmentInfo(ELEMENT3_MINOR1_NAME, ELEMENT3_MINOR1_DESC, ELEMENT3_MINOR2_NAME, ELEMENT3_MINOR2_DESC, ELEMENT3_MINOR3_NAME, ELEMENT3_MINOR3_DESC, ELEMENT3_MAJOR_NAME, ELEMENT3_MAJOR_DESC);
	
	public static final String ELEMENT4_NAME = "Core Stage & Propulsion";
	public static final String ELEMENT4_MINOR1_NAME = "Fuel tanks";
	public static final String ELEMENT4_MINOR1_DESC = "The liquid hydrogen fuel tank consists of five welded barrel sections and two end domes. The aft end of the liquid hydrogen tank includes \n"
														+ "four liquid hydrogen feedlines to the RS-25 engines.";
	public static final String ELEMENT4_MINOR2_NAME = "Propellant";
	public static final String ELEMENT4_MINOR2_DESC = "The main propulsion system flow rates and interfaces were designed around the RS-25 configuration and the need to supply propellants to the \n"
														+ "engines under temperature and pressure conditions required by the engines.";
	public static final String ELEMENT4_MINOR3_NAME = "4 RS-25 Engines";
	public static final String ELEMENT4_MINOR3_DESC = "Each of the RS-25 engines burn cryogenic liquid hydrogen and liquid oxygen propellants, with each engine producing 1,859 kN of thrust at liftoff.";
	public static final String ELEMENT4_MAJOR_NAME = "Rocket Boosters";
	public static final String ELEMENT4_MAJOR_DESC = "A pair of solid rocket boosters attached to the core stage supply more than 75 percent of total SLS thrust for the first \n"
														+ "two minutes of flight. They are are the largest, most powerful solid propellant boosters ever built for flight.";
	public static final DevelopmentInfo dI4 = new DevelopmentInfo(ELEMENT4_MINOR1_NAME, ELEMENT4_MINOR1_DESC, ELEMENT4_MINOR2_NAME, ELEMENT4_MINOR2_DESC, ELEMENT4_MINOR3_NAME, ELEMENT4_MINOR3_DESC, ELEMENT4_MAJOR_NAME, ELEMENT4_MAJOR_DESC);
	
	public static final String ELEMENT5_NAME = "Interim Cryogenic Propulsion Stage";
	public static final String ELEMENT5_MINOR1_NAME = "Orion Stage Adapter";
	public static final String ELEMENT5_MINOR1_DESC = "The highest SLS element in the SLS stack, the Orion stage adapter, connects the ICPS to the Orion spacecraft. The Orion \n"
														+ "stage adapter is 18 ft. (5.5 m) in diameter, 5 ft. (1.5 m) tall, and is made of lightweight aluminum.";
	public static final String ELEMENT5_MINOR2_NAME = "Liquid oxygen tank";
	public static final String ELEMENT5_MINOR2_DESC = "The ICPS is a single-engine liquid hydrogen/liquid oxygen-based system that provides in-space propulsion after the solid \n"
														+ "rocket boosters and core stage are jettisoned.";
	public static final String ELEMENT5_MINOR3_NAME = "Liquid hydrogen tank";
	public static final String ELEMENT5_MINOR3_DESC = "Based on the proven Delta Cryogenic Second Stage, the ICPS will include a lengthened liquid hydrogen tank, \n"
														+ "and added hydrazine bottles for attitude control";
	public static final String ELEMENT5_MAJOR_NAME = "Aerojet Rocketdyne engine";
	public static final String ELEMENT5_MAJOR_DESC = "The Rocketdyne RL10 has been in use for more than 50 years to launch numerous military, government, and commercial \n"
														+ "satellites into orbit and send spacecraft to every planet in the solar system.";
	public static final DevelopmentInfo dI5 = new DevelopmentInfo(ELEMENT5_MINOR1_NAME, ELEMENT5_MINOR1_DESC, ELEMENT5_MINOR2_NAME, ELEMENT5_MINOR2_DESC, ELEMENT5_MINOR3_NAME, ELEMENT5_MINOR3_DESC, ELEMENT5_MAJOR_NAME, ELEMENT5_MAJOR_DESC);
	
	public static final String ELEMENT6_NAME = "Crew Module";
	public static final String ELEMENT6_MINOR1_NAME = "Power generators";
	public static final String ELEMENT6_MINOR1_DESC = "The four Orion solar arrays generate about 11kW of power and spread 62 feet when extended. Orion’s batteries use small cell \n"
														+ "packaging technology to ensure crew safety when providing 120V power to the many systems on Orion.";
	public static final String ELEMENT6_MINOR2_NAME = "Crew quarters";
	public static final String ELEMENT6_MINOR2_DESC = "Inside Orion's cabin are four adjustable seats, which can accommodate a range of different body sizes and shapes. While the \n"
														+ "astronauts are strapped into them, they can see out through four windows located above the head rests.";
	public static final String ELEMENT6_MINOR3_NAME = "Guidance, Nav & Control Systems";
	public static final String ELEMENT6_MINOR3_DESC = "A control console with three display screens and 67 physical switches allows the pilot and commander to monitor the spacecraft \n"
														+ "during flight. For comparison, each space shuttle had 10 displays along with more than 1,200 switches, dials and gauges.";
	public static final String ELEMENT6_MAJOR_NAME = "ECLSS";
	public static final String ELEMENT6_MAJOR_DESC = "Orion Environmental Control and Life Support System (ECLSS) will allow for a speedy abort of the mission should issues be \n"
														+ "found in the system which may compromise crew safety.";
	public static final DevelopmentInfo dI6 = new DevelopmentInfo(ELEMENT6_MINOR1_NAME, ELEMENT6_MINOR1_DESC, ELEMENT6_MINOR2_NAME, ELEMENT6_MINOR2_DESC, ELEMENT6_MINOR3_NAME, ELEMENT6_MINOR3_DESC, ELEMENT6_MAJOR_NAME, ELEMENT6_MAJOR_DESC);
	
	public static final String ELEMENT7_NAME = "Launch Abort Systems";
	public static final String ELEMENT7_MINOR1_NAME = "Fairing Assembly";
	public static final String ELEMENT7_MINOR1_DESC = "The Fairing Assembly will shield the crew module from the severe vibrations and sounds it will experience during launch. \n"
														+ "One of the fairing panels has a hatch to allow access to the crew module before launch.";
	public static final String ELEMENT7_MINOR2_NAME = "Attitude Control Motor";
	public static final String ELEMENT7_MINOR2_DESC = "On an aborted launch, the Attitude Control Motor will steer and orient the Orion capsule for a safe ocean landing";
	public static final String ELEMENT7_MINOR3_NAME = "Jettison Motor";
	public static final String ELEMENT7_MINOR3_DESC = "The jettison motor will be used during every launch whether an issue occurs or not. That’s because, even when everything \n"
														+ "goes according to plan, the LAS needs to safely separate from the crew module so Orion can continue on its mission.";
	public static final String ELEMENT7_MAJOR_NAME = "Abort Motor";
	public static final String ELEMENT7_MAJOR_DESC = "Pulls the orion capsule away from the rocket in the event of an aborted launch.";
	public static final DevelopmentInfo dI7 = new DevelopmentInfo( ELEMENT7_MINOR1_NAME, ELEMENT7_MINOR1_DESC, ELEMENT7_MINOR2_NAME, ELEMENT7_MINOR2_DESC, ELEMENT7_MINOR3_NAME, ELEMENT7_MINOR3_DESC, ELEMENT7_MAJOR_NAME, ELEMENT7_MAJOR_DESC);
	
	public static final String ELEMENT8_NAME = "Service Module";
	public static final String ELEMENT8_MINOR1_NAME = "Spacecraft adapter";
	public static final String ELEMENT8_MINOR1_DESC = "During launch the service module is held in place by the Spacecraft Adapter and is \n"
														+ "connected to the capsule where the astronauts are by the Crew Module Adapter.";
	public static final String ELEMENT8_MINOR2_NAME = "Power & thermal control";
	public static final String ELEMENT8_MINOR2_DESC = "Radiators and heat exchangers keep the astronauts and equipment at a comfortable temperature, while \n"
														+ "the module’s structure is the backbone of the entire vehicle, like a car chassis.";
	public static final String ELEMENT8_MINOR3_NAME = "Water & air support";
	public static final String ELEMENT8_MINOR3_DESC = "The service module will provide enough water and air for up to four astronauts on a 20-day mission.";
	public static final String ELEMENT8_MAJOR_NAME = "Orbital transfer propulsion";
	public static final String ELEMENT8_MAJOR_DESC = "Three types of engine push Orion to its destination and can turn it in all directions to align the spacecraft as needed.";
	public static final DevelopmentInfo dI8 = new DevelopmentInfo(ELEMENT8_MINOR1_NAME, ELEMENT8_MINOR1_DESC, ELEMENT8_MINOR2_NAME, ELEMENT8_MINOR2_DESC, ELEMENT8_MINOR3_NAME, ELEMENT8_MINOR3_DESC, ELEMENT8_MAJOR_NAME, ELEMENT8_MAJOR_DESC);
	
	public static final String ELEMENT9_NAME = "Human Landing System";
	public static final String ELEMENT9_MINOR1_NAME = "Super Heavy Booster";
	public static final String ELEMENT9_MINOR1_DESC = "The first stage, located at the bottom of the rocket, housing up to thirty-three sea \n"
														+ "level-optimized Raptor engines. The engine cluster may be more than twice as powerful as the Saturn V.";
	public static final String ELEMENT9_MINOR2_NAME = "Surface transportation";
	public static final String ELEMENT9_MINOR2_DESC = "As the habitable module will be located well above ground level, the HLS will provide an elevator \n"
														+ "system to allow for crew and payload transportation to the lunar surface.";
	public static final String ELEMENT9_MINOR3_NAME = "Payload storage & habitable module";
	public static final String ELEMENT9_MINOR3_DESC = "As the Starship HLS will never reenter an atmosphere, it does not have a heat shield or Flight control \n"
														+ "surfaces, allowing maximum weight and space for payload volume and crew quarters.";
	public static final String ELEMENT9_MAJOR_NAME = "Reaction Control System thrusters";
	public static final String ELEMENT9_MAJOR_DESC = "When operating within tens of meters of the lunar surface the HLS will use high‑thrust RCS thrusters located \n"
														+ "mid‑body to avoid plume impingement problems with the lunar soil. The thrusters burn gaseous oxygen and methane.";
	public static final DevelopmentInfo dI9 = new DevelopmentInfo(ELEMENT9_MINOR1_NAME, ELEMENT9_MINOR1_DESC, ELEMENT9_MINOR2_NAME, ELEMENT9_MINOR2_DESC, ELEMENT9_MINOR3_NAME, ELEMENT9_MINOR3_DESC, ELEMENT9_MAJOR_NAME, ELEMENT9_MAJOR_DESC);
	
	public static final String ELEMENT10_NAME = "xEMU Spacesuit";
	public static final String ELEMENT10_MINOR1_NAME = "Portable life support system";
	public static final String ELEMENT10_MINOR1_DESC = "The familiar backpack astronauts wear on spacewalks that houses the suit’s power and breathable air \n"
														+ "and removes exhaled carbon dioxide and other toxic gasses, odors and moisture from the suit.";
	public static final String ELEMENT10_MINOR2_NAME = "High-speed data comms system";
	public static final String ELEMENT10_MINOR2_DESC = "The new audio system includes multiple, embedded, voice-activated microphones inside the upper torso that automatically \n"
															+ "pick up the astronaut’s voice when they speak to their fellow spacewalker, their crewmates aboard the Gateway, \n"
															+ "or mission control in Houston.";
	public static final String ELEMENT10_MINOR3_NAME = "Membrane evaporative cooling system";
	public static final String ELEMENT10_MINOR3_DESC = "An innovate approach to temperature regulation. Miniaturization of electronics and plumbing systems have made it \n"
															+ "possible to build in duplicates for much of the system, making some failures less of a concern.";
	public static final String ELEMENT10_MAJOR_NAME = "Enhanced mobility system";
	public static final String ELEMENT10_MAJOR_DESC = "Includes advanced materials and joint bearings that allow bending and rotating at the hips, increased bending at the \n"
														+ "knees, and hiking-style boots with flexible soles. On the upper torso, shoulder enhancements allow astronauts \n"
														+ "to move their arms more freely and easily lift objects over their heads in the pressurized suit.";
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
