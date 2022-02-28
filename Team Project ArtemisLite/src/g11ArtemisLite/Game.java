/**
 * 
 */
package g11ArtemisLite;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import artemis.DevelopmentLevel;
import artemis.Element;
import artemis.Player;
import artemis.Square;

/**
 * Please note this is a work in progress... ive added methods from my game version
 * Some have been partially adapted, some haven't, just wanted to give an idea of my plans
 * @author crclarke
 *
 */
public class Game {

	private PlayerManager playerManager;
	private List<Player> players;
	private UserInput userInput;
	private Board board;
	private boolean isProgress;
	private Roller diceRoller;
	private ElementSystems sysOne;
	private ElementSystems sysTwo;
	private ElementSystems sysThree;
	private ElementSystems sysFour;
	private Set<ElementSystems> allSystems;

	/**
	 * @param usernames
	 * 
	 */
	public Game() {
		this.playerManager = new PlayerManager();
		this.userInput = new UserInput();
		this.isProgress = true;

		this.board = new Board();
		Square square1 = new Start("Start", 10);
		Element square2 = new Element("Element 1", 0, 0, 0);
		Element square3 = new Element("Element 2", 0, 0, 0);
		Element square4 = new Element("Element 3", 0, 0, 0);
		Element square5 = new Element("Element 4", 0, 0, 0);
		Element square6 = new Element("Element 5", 0, 0, 0);
		Element square7 = new Element("Element 6", 0, 0, 0);
		Element square8 = new Element("Element 7", 0, 0, 0);
		Element square9 = new Element("Element 8", 0, 0, 0);
		Element square10 = new Element("Element 9", 0, 0, 0);
		Element square11 = new Element("Element 10", 0, 0, 0);
		Square square12 = new Square("Blank");
		board.addSquareToBoard(square1);
		board.addSquareToBoard(square2);
		board.addSquareToBoard(square3);
		board.addSquareToBoard(square4);
		board.addSquareToBoard(square5);
		board.addSquareToBoard(square6);
		board.addSquareToBoard(square7);
		board.addSquareToBoard(square8);
		board.addSquareToBoard(square9);
		board.addSquareToBoard(square10);
		board.addSquareToBoard(square11);
		board.addSquareToBoard(square12);

		this.sysOne = new ElementSystems("System 1");
		sysOne.addElement(square2);
		sysOne.addElement(square3);
		sysOne.addElement(square4);

		this.sysTwo = new ElementSystems("System 2");
		sysTwo.addElement(square5);
		sysTwo.addElement(square6);
		sysTwo.addElement(square7);

		this.sysThree = new ElementSystems("System 3");
		sysThree.addElement(square8);
		sysThree.addElement(square9);

		this.sysFour = new ElementSystems("System 4");
		sysFour.addElement(square10);
		sysFour.addElement(square11);

		allSystems = new HashSet<>();
		allSystems.add(sysOne);
		allSystems.add(sysTwo);
		allSystems.add(sysThree);
		allSystems.add(sysFour);

		List<Dice> dice = new ArrayList<>();
		dice.add(new Dice(6));
		dice.add(new Dice(6));
		diceRoller = new Roller(dice);
	}

	public void start(List<String> usernames) {
		// Creating the players from the usernames and adding them to a list
		playerManager.createPlayers(usernames);
		players = playerManager.getPlayers();

		// Setting the starting square of all players
		playerManager.getPlayers().stream().forEach((Player player) -> {
			player.setCurrentSquare(board.getSquares().get(0));
		});

		int turnCount = 0;
		while (isProgress) {
			// Each player takes a turn - 1 round
			for (Player player : players) {
				int squaresToMove = diceRoller.roll();
				System.out.println(player.getName() + " has rolled " + squaresToMove);

				board.move(player, squaresToMove);

				System.out.println("\n" + player.getName() + " " + player.getResources());
				player.displayAll();

				// loops through all element systems and if the player owns that system, offers
				// the chance to develop
				for (ElementSystems elementSystems : allSystems) {
					if (player.ownsFullSystem(elementSystems)) {
						offerDevelopElement(player, elementSystems);
					}
				}
			}

			// Limiting game to 10 rounds - do prevent infinte loop
			turnCount++;
			if (turnCount == 40) {
				break;
			}
		}
	}

	/**
	 * displays a menu for options after initial move
	 * 
	 * @param player
	 */
	private void postMoveOptions(Player player) {
		int userInputNum = 0;
		do {
			System.out.println("Would you like to...");
			System.out.println("1. Develop an element");
			System.out.println("2. Trade an Element");
			System.out.println("3. End your turn");
			System.out.println("4. Quit the game");
			userInputNum = userInput.requestUserInputReturnInt("Choose option 1-4 and press [Enter]");
			switch (userInputNum) {
			case 1:
				System.out.println("Opening development menu...");
				developmentMenu();
				break;
			case 2:
				System.out.println("Opening trade menu...");
				tradeMenu();
				break;
			case 3:
				System.out.println("Ending your turn...");
				break;
			case 4:
				endGame();
				break;
			}
		} while (userInputNum != 3);
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
	 * Offers the current player the chance to develop an Element they own. Element
	 * is develop if they enter yes, have enough resources and the development level
	 * is < 4.
	 * 
	 * @param player
	 */
	private void offerDevelopElement(Player player, ElementSystems elementSystems) {
		for (Element square : elementSystems.getElements()) {
			System.out.println("Do you want to develop " + square.getName());
			boolean develop = userInput.yesOrNo();

			if (develop && player.getResources() >= square.getDevelopmentPrice() && square.getDevLevel() < 4) {
				square.increaseDevLevel();
				player.removeResources(square.getDevelopmentPrice());
				System.out.println("Congratulations you have developed " + square.getName()
						+ ". The new development level is " + square.getDevLevel());
			} else if (develop && player.getResources() < square.getDevelopmentPrice() && square.getDevLevel() < 4) {
				System.err.println("Sorry not enough resourses to develop " + square.getName());
			} else if (develop && player.getResources() >= square.getDevelopmentPrice() && square.getDevLevel() == 4) {
				System.err.println(square.getName() + " is already fully developed");
			} else {
				System.err.println("Sorry you don't want to develop " + square.getName());
			}
		}
		System.out.println("All possible developments are completed.");
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
