/**
 * 
 */
package g11ArtemisLite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Please note this is a work in progress... ive added methods from my game
 * version Some have been partially adapted, some haven't, just wanted to give
 * an idea of my plans
 * 
 * @author Richard Clarke and Maeve Higgins
 *
 */
public class Game {

	private PlayerManager playerManager;
	private Message message;
	private List<Player> players;
	private UserInput userInput;
	private Board board;
	private boolean isProgress;
	private Roller diceRoller;
	private ElementSystem sysOne;
	private ElementSystem sysTwo;
	private ElementSystem sysThree;
	private ElementSystem sysFour;
	private Set<ElementSystem> allSystems;

	/**
	 * @param usernames
	 * 
	 */
	public Game() {
		this.playerManager = new PlayerManager();
		this.userInput = new UserInput();
		this.message = new Message();
		this.isProgress = true;

		this.board = new Board();
		Square square1 = new StartSquare("Start", 10);
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

		this.sysOne = new ElementSystem("System 1");
		sysOne.addElement(square2);
		sysOne.addElement(square3);
		sysOne.addElement(square4);

		this.sysTwo = new ElementSystem("System 2");
		sysTwo.addElement(square5);
		sysTwo.addElement(square6);
		sysTwo.addElement(square7);

		this.sysThree = new ElementSystem("System 3");
		sysThree.addElement(square8);
		sysThree.addElement(square9);

		this.sysFour = new ElementSystem("System 4");
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

		// <<<<<<<<<<displays intro message>>>>>>>>>>
		displayIntroMessage(players);

		while (isProgress) {
			// Each player takes a turn - 1 round
			for (Player player : players) {
				int squaresToMove = diceRoller.roll();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(player.getName() + " has rolled " + squaresToMove);

				board.move(players, player, squaresToMove);

				player.displayAll();

				// <<<<<<<<<<calls method to display options post-move>>>>>>>>>>
				if (postMoveOptions(players, player)) {
					// <<<<<<<<<<postMoveOptions returns a boolean to signify endGame>>>>>>>>>>
					// this can be pulled out to the single method you suggested but have left it as
					// is
					// for now so the game will play cleanly
					isProgress = false;
					break;
				}
			}
			// breaks outer loop when isProgress set to false by returned boolean from
			// postMoveOptions
			if (!isProgress) {
				System.out.println("Game over");
				break;
			}
		}
	}

	/**
	 * Displays intro message once players have entered their names
	 * 
	 * @param players
	 */
	public void displayIntroMessage(List<Player> players) {
		for (int loop = 0; loop < players.size(); loop++) {
			System.out.printf(players.get(loop).getName());
			if (loop == players.size() - 2) {
				System.out.printf(" & ");
			} else if (loop == players.size() - 1) {
				System.out.printf(" ");
			} else {
				System.out.printf(", ");
			}
		}
		System.out.println(message.intro);
	}

	/**
	 * displays a menu for options after initial move
	 * 
	 * @param player
	 */
	private boolean postMoveOptions(List<Player> allPlayers, Player player) {
		boolean endGame = false;
		int userInputNum = 0;
		do {
			System.out.println("Would you like to...");
			System.out.println("1. Develop an element");
			System.out.println("2. Trade an Element");
			System.out.println("3. End your turn");
			System.out.println("4. Quit the game");
			userInputNum = userInput.getInt("Choose option 1-4 and press [Enter]");
			switch (userInputNum) {
			case 1:
				System.out.println("Opening development menu...");
				developmentMenu(player);
				break;
			case 2:
				System.out.println("Opening trade menu...");
				tradeElementMenu(allPlayers, player);
				break;
			case 3:
				System.out.println("Ending your turn...");
				break;
			case 4:
				endGame = true;
				break;
			}
		} while (userInputNum != 3 && userInputNum != 4);
		return endGame;
	}

	// <<<<development-related methods>>>>
	/**
	 * Adds elements for which a player owns all in a system, and adds to a new list
	 * 
	 * @param player
	 * @return
	 */
	public List<Element> returnDevelopableElements(Player player) {
		List<Element> developableElements = new ArrayList<>();
		for (ElementSystem system : allSystems) {
			if (player.ownsFullSystem(system)) {
				Set<Element> elements = system.getElements();
				for (Element element : elements) {
					developableElements.add(element);
				}
			}
		}
		return developableElements;
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
	public boolean noDevelopmentsToMakeChecker(Player player) {
		List<Element> developableElements = returnDevelopableElements(player);
		boolean breakIt = false;
		int fullyDevelopedCount = 0;
		int elementCount = 0;
		if (developableElements.size() == 0) {
			System.out.println("You need to own all elements in a system before you can develop!");
			breakIt = true;
			return breakIt;
		}
		for (Element element : player.getSquaresOwned()) {
			elementCount++;
			if (element.getDevLevel() == 4) {
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
	 * checks that the square landed on is an element, that the player can afford
	 * the development, and that the element is not fully developed. if so,
	 * increases the elements development level and removes appropriate resources
	 * from player
	 */
	public void developElement(Element element, Player player) {
		int priceToDevelop = element.getDevelopmentPrice();
		if (player.getResources() > priceToDevelop && element.getDevLevel() != 4) {
			player.removeResources(priceToDevelop);
			element.increaseDevLevel();
			System.out.println("Upgraded to level " + element.getDevLevel());
			System.out.println("You've developed it!");
			// element.displayDevelopmentUpgradeInfo();
		} else {
			System.out.println("Not enough resources to develop or max development reached");
		}
	}

	/**
	 * Presents a dynamically formed menu for a player to develop owned and
	 * developable elements
	 * 
	 * @param boardLayout
	 * @return
	 */
	public boolean developmentMenu(Player player) {
		List<Square> boardLayout = board.getSquares();
		// returns the developableElements array of elements from
		// returnDevelopableElements method
		List<Element> developableElements = returnDevelopableElements(player);

		boolean gameWin = false;
		String userText = "";
		int intUserInput = 0;
		int fullyDevelopedCount = 0;
		int elementCount = 0;

		do {
			// breaks the loop of the player has no elements to develop
			if (noDevelopmentsToMakeChecker(player)) {
				break;
			}
			for (Element element : developableElements) {

				// filters out elements that have been fully developed
				if (element.getDevLevel() != 4) {
					System.out.println("To develop " + element.getName() + " enter ["
							+ (developableElements.indexOf(element) + 1) + "]");
				}
			}
			System.out.println("Don't want to develop any more? Enter [" + (developableElements.size() + 1) + "]");
			userText = userInput.getString("Please choose an option followed by [Enter]");
			intUserInput = UserInput.parseWithDefault(userText, 0);
			if (intUserInput <= developableElements.size() && intUserInput > 0) {
				developElement(developableElements.get(intUserInput - 1), player);
				// checks after each development if all elements are fully developed
				for (Square square : boardLayout) {

					if (square instanceof Element) {
						elementCount++;
						Element element = (Element) square;
						if (element.getDevLevel() == 4) {
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
				if (noDevelopmentsToMakeChecker(player)) {
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

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Trade element
	// and stuff like that>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	/**
	 * 
	 * @param players
	 * @param player
	 */
	public void tradeElementMenu(List<Player> players, Player player) {
		Set<Element> playerElements;
		List<Element> playerElementList;
		String userText = "";
		String ynInput = "";
		int intUserInput = 0;
		Element elementToTrade = null;
		do {
			// repeats these steps after each trade so the list is correctly populated
			playerElements = player.getSquaresOwned();
			playerElementList = new ArrayList<>(playerElements);
			player.displayPropertyOwnedInfo();
			// breaks the loop of the player has no elements to trade
			if (playerElementList.size() == 0) {
				System.out.println("You have no elements to trade");
				break;
			}
			for (Element element : playerElementList) {

				System.out.println(
						"To trade " + element.getName() + " enter [" + (playerElementList.indexOf(element) + 1) + "]");

			}
			System.out.println("Don't want to trade any more? Enter [" + (playerElementList.size() + 1) + "]");
			userText = userInput.getString("Please choose an option followed by [Enter]");
			intUserInput = UserInput.parseWithDefault(userText, 0);
			if (intUserInput <= playerElementList.size() && intUserInput > 0) {
				elementToTrade = playerElementList.get(intUserInput - 1);
				System.out.println("Who would you like to trade with?");

				Map<Integer, Player> playerMap = new TreeMap<Integer, Player>();
				int counter = 1;
				for (Player p : players) {
					if (!p.equals(player)) {
						playerMap.put(counter, p);
						counter++;
					}
				}
				do {
					for (Integer key : playerMap.keySet()) {
						System.out.println("To trade with " + playerMap.get(key).getName() + " press [" + key + "]");
					}
					System.out.println("To cancel trade press [" + (playerMap.size() + 1) + "]");

					userText = userInput.getString("Please choose an option followed by [Enter]");
					intUserInput = UserInput.parseWithDefault(userText, 0);
					if (intUserInput == 0 || intUserInput > playerMap.size() + 1) {
						System.out.println("Incorrect selection");
						// breaks if user enters the cancel trade number
					} else if (intUserInput == playerMap.size() + 1) {
						break;
					} else if (intUserInput > 0 && intUserInput <= playerMap.size()) {
						do {
							System.out.println(playerMap.get(intUserInput).getName() + ", would you like to buy "
									+ elementToTrade.getName() + " from " + player.getName() + " ? [Y/N]");
							ynInput = userInput.getString("Please enter [Y] or [N]");
							if (ynInput.equalsIgnoreCase("Y")) {
								tradeElement(elementToTrade, player, playerMap.get(intUserInput));
							} else if (ynInput.equalsIgnoreCase("N")) {
								System.out.println(
										playerMap.get(intUserInput).getName() + " doesn't want to trade, hard luck!");
							} else {
								System.out.println("Incorrect input try again");
							}
						} while (!ynInput.equalsIgnoreCase("Y") && !ynInput.equalsIgnoreCase("N"));
					}
				} while (intUserInput == 0 || intUserInput > playerMap.size() + 1);
			} else if (intUserInput == (playerElementList.size() + 1)) {
				System.out.println("Exiting trade menu");
			} else {
				System.out.println("Incorrect input try again");
			}
			// loop will continue until player hits the appropriate 'Exit' option
		} while (intUserInput != playerElementList.size() + 1);

	}

	/**
	 * Adds element to buyers owned list, removes it from sellers owned list Also
	 * sets the elements owner as buyer, adds/removes appropriate resources
	 * 
	 * @param element
	 * @param player
	 * @param buyer
	 */
	private void tradeElement(Element element, Player player, Player buyer) {
		if (element.getPurchasePrice() <= buyer.getResources()) {

			player.removeSquare(element);
			buyer.addSquare(element);
			element.setOwner(buyer);
			player.addResources(element.getPurchasePrice());
			buyer.removeResources(element.getPurchasePrice());
			System.out.println(player.getName() + ", you sold " + element.getName() + " to " + buyer.getName());
		} else {
			System.out.println(buyer.getName() + ", you can't afford this purchase!");
		}
	}

}
