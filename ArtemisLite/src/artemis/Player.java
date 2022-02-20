/**
 * 
 */
package artemis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author crclarke
 *
 */
public class Player {

	public static final Scanner sc = new Scanner(System.in);
	public static final Dice dice = new Dice();
	public static final int STARTING_RESOURCES = 2000;

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
	 * Sets starting resources as defined by constant, starting location as first
	 * element of boardLayout ArrayList, and sets elementsOwned as an empty
	 * arrayList as per setElementsOwned business rule
	 * 
	 * @param playerName
	 * @param resources
	 * @param location
	 * @param elementsOwned
	 */
	public Player(String playerName, ArrayList<Square> boardLayout) {
		this.playerName = playerName;
		this.resources = STARTING_RESOURCES;
		this.location = boardLayout.get(0);
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
		int roll = dice.getDiceRoll();
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

	public void postMoveOptions() {
		System.out.println("Options...");
		System.out.println("1. View Development Menu");
		System.out.println("2. View Trade Menu");
		System.out.println("3. View Current Status");
		System.out.println("4. Leave Game");
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
				do {
					
				
				userInput = sc.nextLine();
				if (userInput.equalsIgnoreCase("Y")) {

					this.setResources(this.resources - rentPrice);
					System.out.println("Congratulations " + element.getOwner().getPlayerName() + ", you're a jerk!");
				} else if (userInput.equalsIgnoreCase("N")) {
					System.out.println("Well done "+element.getOwner().getPlayerName()+", you're a decent human being...");
				} else {
					System.out.println("Incorrect input try again");
				}
				} while (!userInput.equalsIgnoreCase("Y") || !userInput.equalsIgnoreCase("N"));
			}
		}
	}

	/**
	 * Displays development info for a player's owned elements
	 */
	public void displayPropertyOwnedInfo() {
		System.out.println("*************************");
		if (this.elementsOwned.size() > 0) {
			sortElements(this.elementsOwned);
			System.out.println(this.playerName + ": Properties Owned");
			System.out.println("-------------------------");
			for (Element element : this.elementsOwned) {
				element.displayDevelopmentInfo();
				System.out.println("-------------------------");
			}
		}

	}

	/**
	 * Presents a dynamically formed menu for a player to develop owned and
	 * developable elements
	 * 
	 * @param boardLayout
	 * @return
	 */
	public boolean developmentMenu(ArrayList<Square> boardLayout) {
		// returns the developableElements array of elements from
		// returnDevelopableElements method
		ArrayList<Element> developableElements = returnDevelopableElements(boardLayout);

		boolean gameWin = false;
		String userInput = "";
		int intUserInput = 0;
		int fullyDevelopedCount = 0;
		int elementCount = 0;

		do {
			// breaks the loop of the player has no elements to develop
			if (noDevelopmentsToMakeChecker(boardLayout)) {
				break;
			}
			for (Element element : developableElements) {

				// filters out elements that have been fully developed
				if (!element.getCurrentLevel().equals(DevelopmentLevel.MAJOR)) {
					System.out.println("To develop " + element.getSquareName() + " enter ["
							+ (developableElements.indexOf(element) + 1) + "]");
				}
			}
			System.out.println("Don't want to develop any more? Enter [" + (developableElements.size() + 1) + "]");
			userInput = sc.nextLine();
			intUserInput = parseWithDefault(userInput, 0);
			if (intUserInput <= developableElements.size() && intUserInput > 0) {
				this.developElement(developableElements.get(intUserInput - 1));
				// checks after each development if all elements are fully developed
				for (Square square : boardLayout) {

					if (square instanceof Element) {
						elementCount++;
						Element element = (Element) square;
						if (element.getCurrentLevel().equals(DevelopmentLevel.MAJOR)) {
							fullyDevelopedCount++;
						}
					}
				}
				// returns a true boolean if all elements are fully developed
				if (fullyDevelopedCount == elementCount) {
					gameWin = true;
					return gameWin;
				}
				// breaks the loop if there are no further developments to make
				if (noDevelopmentsToMakeChecker(boardLayout)) {
					break;
				}
				// exits menu on appropriate user input
			} else if (intUserInput == (developableElements.size() + 1)) {
				System.out.println("Exiting development menu");
			} else {
				System.out.println("Incorrect input try again");
			}
			// loop will continue until player hits the appropriate 'Exit' option
		} while (intUserInput != developableElements.size() + 1);
		return gameWin;
	}

	/**
	 * Returns a default value if an integer cannot be parsed from a string
	 * 
	 * @param number
	 * @param defaultVal
	 * @return
	 */
	public static int parseWithDefault(String number, int defaultVal) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

	/**
	 * Checks if the player has any developments to make, returning a true boolean
	 * value if either 1. the player doesn't own all elements in any given system 2.
	 * the player has developed all developable elements An appropriate message is
	 * displayed for each case
	 * 
	 * @param boardLayout
	 * @return
	 */
	public boolean noDevelopmentsToMakeChecker(ArrayList<Square> boardLayout) {
		ArrayList<Element> developableElements = returnDevelopableElements(boardLayout);
		boolean breakIt = false;
		int fullyDevelopedCount = 0;
		int elementCount = 0;
		if (developableElements.size() == 0) {
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

	/**
	 * Checks a players currently owned elements against those present on
	 * boardLayout, returning them to an ArrayList if the player owns all elements
	 * of a given system
	 * 
	 * @param boardLayout
	 * @return
	 */
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
				} else if (element.getSystemName().equals(Sys.SYSTEM4)) {
					allSys4Elements.add(element);
				}
			}
		}
		for (Element element : allSys1Elements) {
			if (this.getElementsOwned().contains(element)) {
				counter++;
			}
		}
		if (counter == allSys1Elements.size()) {
			for (Element element : allSys1Elements) {
				developableElements.add(element);
			}
		}
		counter = 0;
		for (Element element : allSys2Elements) {
			if (this.getElementsOwned().contains(element)) {
				counter++;
			}
		}
		if (counter == allSys2Elements.size()) {
			for (Element element : allSys2Elements) {
				developableElements.add(element);
			}
		}
		counter = 0;
		for (Element element : allSys3Elements) {
			if (this.getElementsOwned().contains(element)) {
				counter++;
			}
		}
		if (counter == allSys3Elements.size()) {
			for (Element element : allSys3Elements) {
				developableElements.add(element);
			}
		}
		counter = 0;
		for (Element element : allSys4Elements) {
			if (this.getElementsOwned().contains(element)) {
				counter++;
			}
		}
		if (counter == allSys4Elements.size()) {
			for (Element element : allSys4Elements) {
				developableElements.add(element);
			}
		}

		sortElements(developableElements);

		return developableElements;

	}

	/**
	 * Checks if a player has a negative number of resources, returning a boolean
	 * true value if so Returns false if not
	 * 
	 * @param board
	 * @return
	 */
	public boolean bankruptCheck(Board board) {
		if (this.getResources() < 0) {
			System.out.println("You've messed it up " + this.getPlayerName() + ", game over!");

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Sorts an ArrayList of elements by squareName
	 * 
	 * @param elements
	 */
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

	public void tradeElementMenu(ArrayList<Square> boardLayout, ArrayList<Player> players) {
		String userInput = "";
		String ynInput = "";
		int intUserInput = 0;
		Element elementToTrade = null;
		displayPropertyOwnedInfo();
		do {
			// breaks the loop of the player has no elements to trade
			if (this.elementsOwned.size() == 0) {
				System.out.println("You have no elements to trade");
				break;
			}
			for (Element element : this.elementsOwned) {

				System.out.println("To trade " + element.getSquareName() + " enter ["
						+ (this.elementsOwned.indexOf(element) + 1) + "]");

			}
			System.out.println("Don't want to trade any more? Enter [" + (this.elementsOwned.size() + 1) + "]");
			userInput = sc.nextLine();
			intUserInput = parseWithDefault(userInput, 0);
			if (intUserInput <= this.elementsOwned.size() && intUserInput > 0) {
				elementToTrade = this.elementsOwned.get(intUserInput - 1);
				System.out.println("Who would you like to trade with?");

				Map<Integer, Player> playerMap = new TreeMap<Integer, Player>();
				int counter = 1;
				for (Player player : players) {
					if (!player.equals(this)) {
						playerMap.put(counter, player);
						counter++;
					}
				}

				for (Integer key : playerMap.keySet()) {
					System.out.println("To trade with " + playerMap.get(key).getPlayerName() + " press [" + key + "]");
				}
				System.out.println("To cancel trade press [" + (playerMap.size() + 1) + "]");
				userInput = sc.nextLine();
				intUserInput = parseWithDefault(userInput, 0);
				if (intUserInput == 0 || intUserInput > playerMap.size() + 1) {
					System.out.println("Incorrect selection");
				} else if (intUserInput == playerMap.size() + 1) {
					break;
				} else if (intUserInput > 0 && intUserInput <= playerMap.size()) {
					System.out.println(playerMap.get(intUserInput).getPlayerName() + ", would you like to buy "
							+ elementToTrade.getSquareName() + " from " + this.playerName + " ? [Y/N]");
					ynInput = sc.nextLine();
					if (ynInput.equalsIgnoreCase("Y")) {
						tradeElement(elementToTrade, playerMap.get(intUserInput));
					} else if (ynInput.equalsIgnoreCase("N")) {
						System.out.println(
								playerMap.get(intUserInput).getPlayerName() + " doesn't want to trade, hard luck!");
					} else {
						System.out.println("Incorrect input try again");
					}

				}

			} else if (intUserInput == (this.elementsOwned.size() + 1)) {
				System.out.println("Exiting trade menu");
			} else {
				System.out.println("Incorrect input try again");
			}
			// loop will continue until player hits the appropriate 'Exit' option
		} while (intUserInput != this.elementsOwned.size() + 1);

	}

	private void tradeElement(Element element, Player buyer) {
		if (element.getPurchasePrice()<=buyer.getResources()) {
		
		this.elementsOwned.remove(element);
		buyer.elementsOwned.add(element);
		element.setOwner(buyer);
		this.resources = this.resources - element.getPurchasePrice();
		buyer.setResources(buyer.getResources() - element.getPurchasePrice());
		System.out.println(
				this.getPlayerName() + ", you sold " + element.getSquareName() + " to " + buyer.getPlayerName());
		} else {
			System.out.println(buyer.getPlayerName()+", you can't afford this purchase!");
		}
	}

}
