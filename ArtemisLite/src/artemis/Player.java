/**
 * 
 */
package artemis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author crclarke
 *
 */
public class Player {

	public static final Scanner sc = new Scanner(System.in);

	public static final int STARTING_RESOURCES = 2000;
	public static final int NUM_SIDES = 6;
	public static final int NUM_DICE = 2;

	private String playerName;
	private int resources;
	private Square location;
	private ArrayList<Element> elementsOwned;

	/**
	 * 
	 */
	public Player() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * sets elementsOwned as an empty arrayList as per setElementsOwned business
	 * rule
	 * 
	 * @param playerName
	 * @param resources
	 * @param location
	 * @param elementsOwned
	 */
	public Player(String playerName, Square location) {
		this.playerName = playerName;
		this.resources = STARTING_RESOURCES;
		this.location = location;
		this.setElementsOwned();
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @return the resources
	 */
	public int getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(int resources) {
		this.resources = resources;
	}

	/**
	 * @return the location
	 */
	public Square getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Square location) {
		this.location = location;
	}

	/**
	 * @return the elementsOwned
	 */
	public ArrayList<Element> getElementsOwned() {
		return elementsOwned;
	}

	/**
	 * @param elementsOwned the elementsOwned to set
	 */
	public void setElementsOwned() {
		ArrayList<Element> elementsOwned = new ArrayList<>();
		this.elementsOwned = elementsOwned;
	}

	/**
	 * moves player, updating location and adding resources if player reaches or
	 * passes start square
	 * 
	 * @param player
	 * @param boardLayout
	 */
	public void movePlayer(ArrayList<Square> boardLayout) {
		Square currentLocation = this.getLocation();
		Dice dice = new Dice(NUM_SIDES);
		int roll = dice.rollDice(NUM_DICE);
		System.out.println(this.getPlayerName() + " rolled a " + roll);
		int movedIndex = boardLayout.indexOf(currentLocation) + roll;
		if (movedIndex >= boardLayout.size()) {
			movedIndex = movedIndex - boardLayout.size();
			Start start = (Start) boardLayout.get(0);
			System.out.println(this.getPlayerName() + " passed " + start.getSquareName() + ", collect "
					+ start.getResourcesToAdd());
			this.setResources(this.getResources() + start.getResourcesToAdd());
		}
		this.setLocation(boardLayout.get(movedIndex));
		System.out.println(this.getPlayerName() + " landed on " + this.getLocation().getSquareName());

	}

	/**
	 * checks that the square landed on is an element, and that player has enough
	 * resources to purchase. removes purchase price from players resources, sets
	 * elements owner as player, and adds the element to the players elementsOwned
	 * arraylist.
	 */
	public void purchaseElement() {
		Element element = null;
		int priceToPurchase = 0;
		if (this.location instanceof Element) {
			element = (Element) this.location;
			priceToPurchase = element.getPurchasePrice();
			if (this.resources > priceToPurchase) {
				this.setResources(this.resources - priceToPurchase);
				element.setOwner(this);
				this.elementsOwned.add(element);
				System.out.println("You've bought it!");
			} else {
				System.out.println("Not enough resources to purchase");
			}
		} else {
			System.out.println("Not an element, cannot purchase");
		}
		sortElements(elementsOwned);

	}

	/**
	 * checks that the square landed on is an element, that the player can afford
	 * the development, and that the element is not fully developed. if so,
	 * increases the elements development level and removes appropriate resources
	 * from player
	 */
	public void developElement(Element element) {

		int priceToDevelop = element.getCurrentPriceToDevelop();
		if (this.resources > priceToDevelop && element.getCurrentLevel() != DevelopmentLevel.MAJOR) {
			this.setResources(this.resources - priceToDevelop);
			element.increaseDevelopmentLevel();
			System.out.println(element.getCurrentLevel().toString());
			System.out.println("You've developed it!");
		} else {
			System.out.println("Not enough resources to develop or max development reached");
		}

	}

	/**
	 * checks that the element is owned by another player, and that the player can
	 * afford the rent. Removes appropriate resources from player.
	 */
	public void payRent() {
		Element element = null;
		int rentPrice = 0;
		String userInput = "";
		if (this.location instanceof Element) {
			element = (Element) this.location;
			if (element.getOwner() != this && element.getOwner() != null) {
				rentPrice = element.getTotalRentPrice();
				System.out.println(element.getOwner().getPlayerName() + ", would you like to charge " + this.playerName
						+ " rent? [Y/N]");
				userInput = sc.nextLine();
				if (userInput.equalsIgnoreCase("Y")) {

					this.setResources(this.resources - rentPrice);
					System.out.println("Congratulations " + element.getOwner().getPlayerName() + ", you're a jerk!");
				}
			}
		}
	}

	public void displayPropertyOwnedInfo() {
		System.out.println("*************************");
		if (this.elementsOwned.size()>0) {
			System.out.println(this.playerName+": Properties Owned");
			System.out.println("-------------------------");
			for (Element element : this.elementsOwned) {
				element.displayDevelopmentInfo();
				System.out.println("-------------------------");
			}
		}
		
	}

	public boolean developmentMenu(ArrayList<Square> boardLayout) {
		ArrayList<Element> developableElements = returnDevelopableElements(boardLayout);
		
		boolean gameWin = false;
		String userInput = "";
		int intUserInput = 0;
		int fullyDevelopedCount = 0;
		int elementCount = 0;
		
		sortElements(developableElements);
		
		do {
			if (noDevelopmentsToMakeChecker(boardLayout)) {
				break;
			}
			for (Element element : developableElements) {
				
				
				if (!element.getCurrentLevel().equals(DevelopmentLevel.MAJOR)) {
					System.out.println("To develop " + element.getSquareName() + " enter ["
							+ (developableElements.indexOf(element) + 1) + "]");
				}
			}
			System.out.println("Don't want to develop any more? Enter [" + (developableElements.size() + 1) + "]");
			userInput = sc.nextLine();
			intUserInput = Integer.parseInt(userInput);
			if (intUserInput <= developableElements.size() && intUserInput > 0) {
				this.developElement(developableElements.get(intUserInput - 1));
				for (Square square : boardLayout) {

					if (square instanceof Element) {
						elementCount++;
						Element element = (Element) square;
						if (element.getCurrentLevel().equals(DevelopmentLevel.MAJOR)) {
							fullyDevelopedCount++;
						}
					}
				}
				if (fullyDevelopedCount == elementCount) {
					gameWin = true;
					return gameWin;
				}
				if (noDevelopmentsToMakeChecker(boardLayout)) {
					break;
				}
			} else if (intUserInput == (developableElements.size() + 1)) {
				System.out.println("Exiting development menu");
			} else {
				System.out.println("Incorrect input try again");
			}
		} while (intUserInput != developableElements.size() + 1);
		return gameWin;
	}
	
	public boolean noDevelopmentsToMakeChecker(ArrayList<Square> boardLayout) {
		ArrayList<Element> developableElements = returnDevelopableElements(boardLayout);
		boolean breakIt = false;
		int fullyDevelopedCount = 0;
		int elementCount = 0;
		if (developableElements.size()==0) {
			System.out.println("You need to own all elements in a system before you can develop!");
			breakIt = true;
			return breakIt;
		}
		for (Element element : this.elementsOwned) {
			elementCount++;
			if (element.getCurrentLevel().equals(DevelopmentLevel.MAJOR)) {
				fullyDevelopedCount++;
			}
		}
		if (fullyDevelopedCount == elementCount) {
			System.out.println("You don't have any developments to make!");
			breakIt = true;
			return breakIt;
		}
		return breakIt;
	}
	
	public ArrayList<Element> returnDevelopableElements(ArrayList<Square> boardLayout) {
		ArrayList<Element> allSys1Elements = new ArrayList<>();
		ArrayList<Element> allSys2Elements = new ArrayList<>();
		ArrayList<Element> allSys3Elements = new ArrayList<>();
		ArrayList<Element> allSys4Elements = new ArrayList<>();
		ArrayList<Element> developableElements = new ArrayList<>();
		int counter = 0;
		for (Square square : boardLayout) {
			if (square instanceof Element) {
				Element element = (Element) square;
				if (element.getSystemName().equals(Sys.SYSTEM1)) {
					allSys1Elements.add(element);
				} else if (element.getSystemName().equals(Sys.SYSTEM2)) {
					allSys2Elements.add(element);
				} else if (element.getSystemName().equals(Sys.SYSTEM3)) {
					allSys3Elements.add(element);
				}else if (element.getSystemName().equals(Sys.SYSTEM4)) {
					allSys4Elements.add(element);
				}
			}
		}
		for (Element element : allSys1Elements) {
			if (this.getElementsOwned().contains(element)) {
				counter++;
			}
		}
		if (counter==allSys1Elements.size()) {
			for (Element element : allSys1Elements) {
				developableElements.add(element);
			}
		}
		counter=0;
		for (Element element : allSys2Elements) {
			if (this.getElementsOwned().contains(element)) {
				counter++;
			}
		}
		if (counter==allSys2Elements.size()) {
			for (Element element : allSys2Elements) {
				developableElements.add(element);
			}
		}
		counter=0;
		for (Element element : allSys3Elements) {
			if (this.getElementsOwned().contains(element)) {
				counter++;
			}
		}
		if (counter==allSys3Elements.size()) {
			for (Element element : allSys3Elements) {
				developableElements.add(element);
			}
		}
		counter=0;
		for (Element element : allSys4Elements) {
			if (this.getElementsOwned().contains(element)) {
				counter++;
			}
		}
		if (counter==allSys4Elements.size()) {
			for (Element element : allSys4Elements) {
				developableElements.add(element);
			}
		}
		
		return developableElements;
		
		
		
	}

	public boolean bankruptCheck(Board board) {
		if (this.getResources() < 0) {
			System.out.println("You've messed it up " + this.getPlayerName() + ", game over!");
			
			return true;
		} else {
			return false;
		}
	}
	
	public void sortElements(ArrayList<Element> elements) {
		if (elements.size() > 0) {
			  Collections.sort(elements, new Comparator<Element>() {
			      @Override
			      public int compare(final Element object1, final Element object2) {
			          return object1.getSquareName().compareTo(object2.getSquareName());
			      }
			  });
			}
	}

}
