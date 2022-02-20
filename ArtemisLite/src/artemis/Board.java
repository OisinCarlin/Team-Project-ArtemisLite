/**
 * 
 */
package artemis;

import java.util.ArrayList;

/**
 * @author crclarke
 *
 */
public class Board {
	
	// all the values for element names/descriptions, development level names/descriptions can be set below
	
	public static final String START_SQUARE_NAME = "Start";
	public static final String EMPTY_SQUARE_NAME = "Empty Square";
	
	public static final DevelopmentLevel NONE = DevelopmentLevel.NONE;
	public static final DevelopmentLevel MINOR1 = DevelopmentLevel.MINOR1;
	public static final DevelopmentLevel MINOR2 = DevelopmentLevel.MINOR2;
	public static final DevelopmentLevel MINOR3 = DevelopmentLevel.MINOR3;
	public static final DevelopmentLevel MAJOR = DevelopmentLevel.MAJOR;
	
	public static final String ELEMENT1_NAME = "element1";
	public static final Sys ELEMENT1_SYSTEM = Sys.SYSTEM1;
	public static final int ELEMENT1_PRICE = 200;
	public static final int ELEMENT1_RENT_PRICE = 2500;
	public static final String ELEMENT1_NODEV_NAME = "No Development";
	public static final String ELEMENT1_NODEV_DESC = "No Development";
	public static final String ELEMENT1_MINOR1_NAME = "Minor 1 Name";
	public static final String ELEMENT1_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT1_MINOR2_NAME = "Minor 2 Name";
	public static final String ELEMENT1_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT1_MINOR3_NAME = "Minor 3 Name";
	public static final String ELEMENT1_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT1_MAJOR_NAME = "Major Name";
	public static final String ELEMENT1_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo ELEMENT1_NODEV = new DevelopmentInfo(NONE, ELEMENT1_NODEV_NAME, ELEMENT1_NODEV_DESC);
	public static final DevelopmentInfo ELEMENT1_MINOR1 = new DevelopmentInfo(MINOR1, ELEMENT1_MINOR1_NAME, ELEMENT1_MINOR1_DESC);
	public static final DevelopmentInfo ELEMENT1_MINOR2 = new DevelopmentInfo(MINOR2, ELEMENT1_MINOR2_NAME, ELEMENT1_MINOR2_DESC);
	public static final DevelopmentInfo ELEMENT1_MINOR3 = new DevelopmentInfo(MINOR3, ELEMENT1_MINOR3_NAME, ELEMENT1_MINOR3_DESC);
	public static final DevelopmentInfo ELEMENT1_MAJOR = new DevelopmentInfo(MAJOR, ELEMENT1_MAJOR_NAME, ELEMENT1_MAJOR_DESC);
	
	public static final String ELEMENT2_NAME = "element2";
	public static final Sys ELEMENT2_SYSTEM = Sys.SYSTEM1;
	public static final int ELEMENT2_PRICE = 200;
	public static final int ELEMENT2_RENT_PRICE = 2500;
	public static final String ELEMENT2_NODEV_NAME = "No Development";
	public static final String ELEMENT2_NODEV_DESC = "No Development";
	public static final String ELEMENT2_MINOR1_NAME = "Minor 1 Name";
	public static final String ELEMENT2_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT2_MINOR2_NAME = "Minor 2 Name";
	public static final String ELEMENT2_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT2_MINOR3_NAME = "Minor 3 Name";
	public static final String ELEMENT2_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT2_MAJOR_NAME = "Major Name";
	public static final String ELEMENT2_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo ELEMENT2_NODEV = new DevelopmentInfo(NONE, ELEMENT2_NODEV_NAME, ELEMENT2_NODEV_DESC);
	public static final DevelopmentInfo ELEMENT2_MINOR1 = new DevelopmentInfo(MINOR1, ELEMENT2_MINOR1_NAME, ELEMENT2_MINOR1_DESC);
	public static final DevelopmentInfo ELEMENT2_MINOR2 = new DevelopmentInfo(MINOR2, ELEMENT2_MINOR2_NAME, ELEMENT2_MINOR2_DESC);
	public static final DevelopmentInfo ELEMENT2_MINOR3 = new DevelopmentInfo(MINOR3, ELEMENT2_MINOR3_NAME, ELEMENT2_MINOR3_DESC);
	public static final DevelopmentInfo ELEMENT2_MAJOR = new DevelopmentInfo(MAJOR, ELEMENT2_MAJOR_NAME, ELEMENT2_MAJOR_DESC);
	
	public static final String ELEMENT3_NAME = "element3";
	public static final Sys ELEMENT3_SYSTEM = Sys.SYSTEM2;
	public static final int ELEMENT3_PRICE = 200;
	public static final int ELEMENT3_RENT_PRICE = 2500;
	public static final String ELEMENT3_NODEV_NAME = "No Development";
	public static final String ELEMENT3_NODEV_DESC = "No Development";
	public static final String ELEMENT3_MINOR1_NAME = "Minor 1 Name";
	public static final String ELEMENT3_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT3_MINOR2_NAME = "Minor 2 Name";
	public static final String ELEMENT3_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT3_MINOR3_NAME = "Minor 3 Name";
	public static final String ELEMENT3_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT3_MAJOR_NAME = "Major Name";
	public static final String ELEMENT3_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo ELEMENT3_NODEV = new DevelopmentInfo(NONE, ELEMENT3_NODEV_NAME, ELEMENT3_NODEV_DESC);
	public static final DevelopmentInfo ELEMENT3_MINOR1 = new DevelopmentInfo(MINOR1, ELEMENT3_MINOR1_NAME, ELEMENT3_MINOR1_DESC);
	public static final DevelopmentInfo ELEMENT3_MINOR2 = new DevelopmentInfo(MINOR2, ELEMENT3_MINOR2_NAME, ELEMENT3_MINOR2_DESC);
	public static final DevelopmentInfo ELEMENT3_MINOR3 = new DevelopmentInfo(MINOR3, ELEMENT3_MINOR3_NAME, ELEMENT3_MINOR3_DESC);
	public static final DevelopmentInfo ELEMENT3_MAJOR = new DevelopmentInfo(MAJOR, ELEMENT3_MAJOR_NAME, ELEMENT3_MAJOR_DESC);
	
	public static final String ELEMENT4_NAME = "element4";
	public static final Sys ELEMENT4_SYSTEM = Sys.SYSTEM2;
	public static final int ELEMENT4_PRICE = 200;
	public static final int ELEMENT4_RENT_PRICE = 2500;
	public static final String ELEMENT4_NODEV_NAME = "No Development";
	public static final String ELEMENT4_NODEV_DESC = "No Development";
	public static final String ELEMENT4_MINOR1_NAME = "Minor 1 Name";
	public static final String ELEMENT4_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT4_MINOR2_NAME = "Minor 2 Name";
	public static final String ELEMENT4_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT4_MINOR3_NAME = "Minor 3 Name";
	public static final String ELEMENT4_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT4_MAJOR_NAME = "Major Name";
	public static final String ELEMENT4_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo ELEMENT4_NODEV = new DevelopmentInfo(NONE, ELEMENT4_NODEV_NAME, ELEMENT4_NODEV_DESC);
	public static final DevelopmentInfo ELEMENT4_MINOR1 = new DevelopmentInfo(MINOR1, ELEMENT4_MINOR1_NAME, ELEMENT4_MINOR1_DESC);
	public static final DevelopmentInfo ELEMENT4_MINOR2 = new DevelopmentInfo(MINOR2, ELEMENT4_MINOR2_NAME, ELEMENT4_MINOR2_DESC);
	public static final DevelopmentInfo ELEMENT4_MINOR3 = new DevelopmentInfo(MINOR3, ELEMENT4_MINOR3_NAME, ELEMENT4_MINOR3_DESC);
	public static final DevelopmentInfo ELEMENT4_MAJOR = new DevelopmentInfo(MAJOR, ELEMENT4_MAJOR_NAME, ELEMENT4_MAJOR_DESC);
	
	public static final String ELEMENT5_NAME = "element5";
	public static final Sys ELEMENT5_SYSTEM = Sys.SYSTEM2;
	public static final int ELEMENT5_PRICE = 200;
	public static final int ELEMENT5_RENT_PRICE = 2500;
	public static final String ELEMENT5_NODEV_NAME = "No Development";
	public static final String ELEMENT5_NODEV_DESC = "No Development";
	public static final String ELEMENT5_MINOR1_NAME = "Minor 1 Name";
	public static final String ELEMENT5_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT5_MINOR2_NAME = "Minor 2 Name";
	public static final String ELEMENT5_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT5_MINOR3_NAME = "Minor 3 Name";
	public static final String ELEMENT5_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT5_MAJOR_NAME = "Major Name";
	public static final String ELEMENT5_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo ELEMENT5_NODEV = new DevelopmentInfo(NONE, ELEMENT5_NODEV_NAME, ELEMENT5_NODEV_DESC);
	public static final DevelopmentInfo ELEMENT5_MINOR1 = new DevelopmentInfo(MINOR1, ELEMENT5_MINOR1_NAME, ELEMENT5_MINOR1_DESC);
	public static final DevelopmentInfo ELEMENT5_MINOR2 = new DevelopmentInfo(MINOR2, ELEMENT5_MINOR2_NAME, ELEMENT5_MINOR2_DESC);
	public static final DevelopmentInfo ELEMENT5_MINOR3 = new DevelopmentInfo(MINOR3, ELEMENT5_MINOR3_NAME, ELEMENT5_MINOR3_DESC);
	public static final DevelopmentInfo ELEMENT5_MAJOR = new DevelopmentInfo(MAJOR, ELEMENT5_MAJOR_NAME, ELEMENT5_MAJOR_DESC);
	
	public static final String ELEMENT6_NAME = "element6";
	public static final Sys ELEMENT6_SYSTEM = Sys.SYSTEM3;
	public static final int ELEMENT6_PRICE = 200;
	public static final int ELEMENT6_RENT_PRICE = 2500;
	public static final String ELEMENT6_NODEV_NAME = "No Development";
	public static final String ELEMENT6_NODEV_DESC = "No Development";
	public static final String ELEMENT6_MINOR1_NAME = "Minor 1 Name";
	public static final String ELEMENT6_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT6_MINOR2_NAME = "Minor 2 Name";
	public static final String ELEMENT6_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT6_MINOR3_NAME = "Minor 3 Name";
	public static final String ELEMENT6_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT6_MAJOR_NAME = "Major Name";
	public static final String ELEMENT6_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo ELEMENT6_NODEV = new DevelopmentInfo(NONE, ELEMENT6_NODEV_NAME, ELEMENT6_NODEV_DESC);
	public static final DevelopmentInfo ELEMENT6_MINOR1 = new DevelopmentInfo(MINOR1, ELEMENT6_MINOR1_NAME, ELEMENT6_MINOR1_DESC);
	public static final DevelopmentInfo ELEMENT6_MINOR2 = new DevelopmentInfo(MINOR2, ELEMENT6_MINOR2_NAME, ELEMENT6_MINOR2_DESC);
	public static final DevelopmentInfo ELEMENT6_MINOR3 = new DevelopmentInfo(MINOR3, ELEMENT6_MINOR3_NAME, ELEMENT6_MINOR3_DESC);
	public static final DevelopmentInfo ELEMENT6_MAJOR = new DevelopmentInfo(MAJOR, ELEMENT6_MAJOR_NAME, ELEMENT6_MAJOR_DESC);
	
	public static final String ELEMENT7_NAME = "element7";
	public static final Sys ELEMENT7_SYSTEM = Sys.SYSTEM3;
	public static final int ELEMENT7_PRICE = 200;
	public static final int ELEMENT7_RENT_PRICE = 2500;
	public static final String ELEMENT7_NODEV_NAME = "No Development";
	public static final String ELEMENT7_NODEV_DESC = "No Development";
	public static final String ELEMENT7_MINOR1_NAME = "Minor 1 Name";
	public static final String ELEMENT7_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT7_MINOR2_NAME = "Minor 2 Name";
	public static final String ELEMENT7_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT7_MINOR3_NAME = "Minor 3 Name";
	public static final String ELEMENT7_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT7_MAJOR_NAME = "Major Name";
	public static final String ELEMENT7_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo ELEMENT7_NODEV = new DevelopmentInfo(NONE, ELEMENT7_NODEV_NAME, ELEMENT7_NODEV_DESC);
	public static final DevelopmentInfo ELEMENT7_MINOR1 = new DevelopmentInfo(MINOR1, ELEMENT7_MINOR1_NAME, ELEMENT7_MINOR1_DESC);
	public static final DevelopmentInfo ELEMENT7_MINOR2 = new DevelopmentInfo(MINOR2, ELEMENT7_MINOR2_NAME, ELEMENT7_MINOR2_DESC);
	public static final DevelopmentInfo ELEMENT7_MINOR3 = new DevelopmentInfo(MINOR3, ELEMENT7_MINOR3_NAME, ELEMENT7_MINOR3_DESC);
	public static final DevelopmentInfo ELEMENT7_MAJOR = new DevelopmentInfo(MAJOR, ELEMENT7_MAJOR_NAME, ELEMENT7_MAJOR_DESC);
	
	public static final String ELEMENT8_NAME = "element8";
	public static final Sys ELEMENT8_SYSTEM = Sys.SYSTEM3;
	public static final int ELEMENT8_PRICE = 200;
	public static final int ELEMENT8_RENT_PRICE = 2500;
	public static final String ELEMENT8_NODEV_NAME = "No Development";
	public static final String ELEMENT8_NODEV_DESC = "No Development";
	public static final String ELEMENT8_MINOR1_NAME = "Minor 1 Name";
	public static final String ELEMENT8_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT8_MINOR2_NAME = "Minor 2 Name";
	public static final String ELEMENT8_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT8_MINOR3_NAME = "Minor 3 Name";
	public static final String ELEMENT8_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT8_MAJOR_NAME = "Major Name";
	public static final String ELEMENT8_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo ELEMENT8_NODEV = new DevelopmentInfo(NONE, ELEMENT8_NODEV_NAME, ELEMENT8_NODEV_DESC);
	public static final DevelopmentInfo ELEMENT8_MINOR1 = new DevelopmentInfo(MINOR1, ELEMENT8_MINOR1_NAME, ELEMENT8_MINOR1_DESC);
	public static final DevelopmentInfo ELEMENT8_MINOR2 = new DevelopmentInfo(MINOR2, ELEMENT8_MINOR2_NAME, ELEMENT8_MINOR2_DESC);
	public static final DevelopmentInfo ELEMENT8_MINOR3 = new DevelopmentInfo(MINOR3, ELEMENT8_MINOR3_NAME, ELEMENT8_MINOR3_DESC);
	public static final DevelopmentInfo ELEMENT8_MAJOR = new DevelopmentInfo(MAJOR, ELEMENT8_MAJOR_NAME, ELEMENT8_MAJOR_DESC);
	
	public static final String ELEMENT9_NAME = "element9";
	public static final Sys ELEMENT9_SYSTEM = Sys.SYSTEM4;
	public static final int ELEMENT9_PRICE = 200;
	public static final int ELEMENT9_RENT_PRICE = 2500;
	public static final String ELEMENT9_NODEV_NAME = "No Development";
	public static final String ELEMENT9_NODEV_DESC = "No Development";
	public static final String ELEMENT9_MINOR1_NAME = "Minor 1 Name";
	public static final String ELEMENT9_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT9_MINOR2_NAME = "Minor 2 Name";
	public static final String ELEMENT9_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT9_MINOR3_NAME = "Minor 3 Name";
	public static final String ELEMENT9_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT9_MAJOR_NAME = "Major Name";
	public static final String ELEMENT9_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo ELEMENT9_NODEV = new DevelopmentInfo(NONE, ELEMENT9_NODEV_NAME, ELEMENT9_NODEV_DESC);
	public static final DevelopmentInfo ELEMENT9_MINOR1 = new DevelopmentInfo(MINOR1, ELEMENT9_MINOR1_NAME, ELEMENT9_MINOR1_DESC);
	public static final DevelopmentInfo ELEMENT9_MINOR2 = new DevelopmentInfo(MINOR2, ELEMENT9_MINOR2_NAME, ELEMENT9_MINOR2_DESC);
	public static final DevelopmentInfo ELEMENT9_MINOR3 = new DevelopmentInfo(MINOR3, ELEMENT9_MINOR3_NAME, ELEMENT9_MINOR3_DESC);
	public static final DevelopmentInfo ELEMENT9_MAJOR = new DevelopmentInfo(MAJOR, ELEMENT9_MAJOR_NAME, ELEMENT9_MAJOR_DESC);
	
	public static final String ELEMENT10_NAME = "element10";
	public static final Sys ELEMENT10_SYSTEM = Sys.SYSTEM4;
	public static final int ELEMENT10_PRICE = 200;
	public static final int ELEMENT10_RENT_PRICE = 2500;
	public static final String ELEMENT10_NODEV_NAME = "No Development";
	public static final String ELEMENT10_NODEV_DESC = "No Development";
	public static final String ELEMENT10_MINOR1_NAME = "Minor 1 Name";
	public static final String ELEMENT10_MINOR1_DESC = "Minor 1 Desc";
	public static final String ELEMENT10_MINOR2_NAME = "Minor 2 Name";
	public static final String ELEMENT10_MINOR2_DESC = "Minor 2 Desc";
	public static final String ELEMENT10_MINOR3_NAME = "Minor 3 Name";
	public static final String ELEMENT10_MINOR3_DESC = "Minor 3 Desc";
	public static final String ELEMENT10_MAJOR_NAME = "Major Name";
	public static final String ELEMENT10_MAJOR_DESC = "Major Desc";
	public static final DevelopmentInfo ELEMENT10_NODEV = new DevelopmentInfo(NONE, ELEMENT10_NODEV_NAME, ELEMENT10_NODEV_DESC);
	public static final DevelopmentInfo ELEMENT10_MINOR1 = new DevelopmentInfo(MINOR1, ELEMENT10_MINOR1_NAME, ELEMENT10_MINOR1_DESC);
	public static final DevelopmentInfo ELEMENT10_MINOR2 = new DevelopmentInfo(MINOR2, ELEMENT10_MINOR2_NAME, ELEMENT10_MINOR2_DESC);
	public static final DevelopmentInfo ELEMENT10_MINOR3 = new DevelopmentInfo(MINOR3, ELEMENT10_MINOR3_NAME, ELEMENT10_MINOR3_DESC);
	public static final DevelopmentInfo ELEMENT10_MAJOR = new DevelopmentInfo(MAJOR, ELEMENT10_MAJOR_NAME, ELEMENT10_MAJOR_DESC);
	

	private ArrayList<Square> gameLayout;

	/**
	 * @param gameLayout
	 */
	public Board() {
		this.setGameLayout();
	}

	/**
	 * @return the gameLayout
	 */
	public ArrayList<Square> getGameLayout() {
		return gameLayout;
	}

	/**
	 * sets the board layout with start, empty square and elements 1-10, with args defined by constants above
	 * @param gameLayout the gameLayout to set
	 */
	public void setGameLayout() {
		Start start = new Start(START_SQUARE_NAME);
		EmptySquare emptySquare = new EmptySquare(EMPTY_SQUARE_NAME);
		
		Element element1 = new Element(ELEMENT1_NAME, ELEMENT1_SYSTEM, ELEMENT1_PRICE, ELEMENT1_RENT_PRICE, ELEMENT1_NODEV, ELEMENT1_MINOR1, ELEMENT1_MINOR2, ELEMENT1_MINOR3, ELEMENT1_MAJOR);
		Element element2 = new Element(ELEMENT2_NAME, ELEMENT2_SYSTEM, ELEMENT2_PRICE, ELEMENT2_RENT_PRICE, ELEMENT2_NODEV, ELEMENT2_MINOR1, ELEMENT2_MINOR2, ELEMENT2_MINOR3, ELEMENT2_MAJOR);
		Element element3 = new Element(ELEMENT3_NAME, ELEMENT3_SYSTEM, ELEMENT3_PRICE, ELEMENT3_RENT_PRICE, ELEMENT3_NODEV, ELEMENT3_MINOR1, ELEMENT3_MINOR2, ELEMENT3_MINOR3, ELEMENT3_MAJOR);
		Element element4 = new Element(ELEMENT4_NAME, ELEMENT4_SYSTEM, ELEMENT4_PRICE, ELEMENT4_RENT_PRICE, ELEMENT4_NODEV, ELEMENT4_MINOR1, ELEMENT4_MINOR2, ELEMENT4_MINOR3, ELEMENT4_MAJOR);
		Element element5 = new Element(ELEMENT5_NAME, ELEMENT5_SYSTEM, ELEMENT5_PRICE, ELEMENT5_RENT_PRICE, ELEMENT5_NODEV, ELEMENT5_MINOR1, ELEMENT5_MINOR2, ELEMENT5_MINOR3, ELEMENT5_MAJOR);
		Element element6 = new Element(ELEMENT6_NAME, ELEMENT6_SYSTEM, ELEMENT6_PRICE, ELEMENT6_RENT_PRICE, ELEMENT6_NODEV, ELEMENT6_MINOR1, ELEMENT6_MINOR2, ELEMENT6_MINOR3, ELEMENT6_MAJOR);
		Element element7 = new Element(ELEMENT7_NAME, ELEMENT7_SYSTEM, ELEMENT7_PRICE, ELEMENT7_RENT_PRICE, ELEMENT7_NODEV, ELEMENT7_MINOR1, ELEMENT7_MINOR2, ELEMENT7_MINOR3, ELEMENT7_MAJOR);
		Element element8 = new Element(ELEMENT8_NAME, ELEMENT8_SYSTEM, ELEMENT8_PRICE, ELEMENT8_RENT_PRICE, ELEMENT8_NODEV, ELEMENT8_MINOR1, ELEMENT8_MINOR2, ELEMENT8_MINOR3, ELEMENT8_MAJOR);
		Element element9 = new Element(ELEMENT9_NAME, ELEMENT9_SYSTEM, ELEMENT9_PRICE, ELEMENT9_RENT_PRICE, ELEMENT9_NODEV, ELEMENT9_MINOR1, ELEMENT9_MINOR2, ELEMENT9_MINOR3, ELEMENT9_MAJOR);
		Element element10 = new Element(ELEMENT10_NAME, ELEMENT10_SYSTEM, ELEMENT10_PRICE, ELEMENT10_RENT_PRICE, ELEMENT10_NODEV, ELEMENT10_MINOR1, ELEMENT10_MINOR2, ELEMENT10_MINOR3, ELEMENT10_MAJOR);
		
		ArrayList<Square> gameLayout = new ArrayList<>();
		
		gameLayout.add(start);
		gameLayout.add(element1);
		gameLayout.add(element2);
		gameLayout.add(element3);
		gameLayout.add(element4);
		gameLayout.add(element5);
		gameLayout.add(emptySquare);
		gameLayout.add(element6);
		gameLayout.add(element7);
		gameLayout.add(element8);
		gameLayout.add(element9);
		gameLayout.add(element10);

		this.gameLayout = gameLayout;
	}
	
	public void displayEndGame() {
		System.out.println("Final state of play");
		for (Square square : gameLayout) {
			if (square instanceof Element) {
				System.out.println("_____________________");
				square.displayAll();
				
			}
		}
	}

}
