/**
 * 
 */
package g11ArtemisLite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * @author Richard Clarke and Maeve Higgins
 *
 */
public class Game {

	private PlayerManager playerManager;
	private Message message;
	private List<Player> players;
	private Board board;
	private DevelopmentInfoManager developmentInfoManager;
	private Map<Element, DevelopmentInfo> myDevMap;
	private boolean isProgress;
	private Roller diceRoller;
	private ElementSystem sysOne;
	private ElementSystem sysTwo;
	private ElementSystem sysThree;
	private ElementSystem sysFour;
	private Set<ElementSystem> allSystems;
	private RandomEvents randomEvents;
	private Serializaion serializaion;

	/**
	 * @param usernames
	 * 
	 */
	public Game() {
		this.playerManager = new PlayerManager();
		this.developmentInfoManager = new DevelopmentInfoManager();
		this.message = new Message();
		this.serializaion = new Serializaion();
		this.isProgress = true;

		this.board = new Board();
		Square square1 = new StartSquare("Mission Control", 10);
		Element square2 = new Element("Power and Propulsion System", 1, 0, 0, 0);
		Element square3 = new Element("Habitation and Logistics Outpost", 2, 0, 0, 0);
		Element square4 = new Element("Avionics", 3, 0, 0, 0);
		Element square5 = new Element("Core Stage and Propulsion", 4, 0, 0, 0);
		Element square6 = new Element("Interim Cryogenic Propulsion Stage", 5, 0, 0, 0);
		Element square7 = new Element("Crew Module", 6, 0, 0, 0);
		Element square8 = new Element("Launch Abort Systems", 7, 0, 0, 0);
		Element square9 = new Element("Service Module", 8, 0, 0, 0);
		Element square10 = new Element("Human Landing System", 9, 0, 0, 0);
		Element square11 = new Element("xEMU Spacesuit", 10,  0, 0, 0);
		Square square12 = new Square("Press Conference");
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

		// linking each element to it's developmentInfo class
		this.developmentInfoManager = new DevelopmentInfoManager();
		List<DevelopmentInfo> allDevelopmentInfo = developmentInfoManager.getAllDevelopmentInfo();
		myDevMap = new HashMap<Element, DevelopmentInfo>();
		myDevMap.put(square2, allDevelopmentInfo.get(0));
		myDevMap.put(square3, allDevelopmentInfo.get(1));
		myDevMap.put(square4, allDevelopmentInfo.get(2));
		myDevMap.put(square5, allDevelopmentInfo.get(3));
		myDevMap.put(square6, allDevelopmentInfo.get(4));
		myDevMap.put(square7, allDevelopmentInfo.get(5));
		myDevMap.put(square8, allDevelopmentInfo.get(6));
		myDevMap.put(square9, allDevelopmentInfo.get(7));
		myDevMap.put(square10, allDevelopmentInfo.get(8));
		myDevMap.put(square11, allDevelopmentInfo.get(9));

		this.randomEvents = new RandomEvents();

		this.sysOne = new ElementSystem("Gateway");
		sysOne.addElement(square2);
		sysOne.addElement(square3);

		this.sysTwo = new ElementSystem("Space Launch System");
		sysOne.addElement(square4);
		sysTwo.addElement(square5);
		sysTwo.addElement(square6);

		this.sysThree = new ElementSystem("Orion Spacecraft");
		sysTwo.addElement(square7);
		sysThree.addElement(square8);
		sysThree.addElement(square9);

		this.sysFour = new ElementSystem("Lunar Base Camp");
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

		// userNames passed as an empty list if player selects restore
		if (usernames.isEmpty()) {
			// board restored
			this.board = serializaion.RestoreBoard();
			// players restored
			players = serializaion.RestorePlayers();
			// matches players current square to the equivalent square of the newly
			// instantiated board (fixes non-matching IDs)
			for (Player player : players) {
				String squareName = player.getCurrentSquare().getName();
				for (Square square : board.getSquares()) {
					if (squareName.equals(square.getName())) {
						player.setCurrentSquare(square);
					}
				}
			}
		} else {
			// Creating the players from the usernames and adding them to a list
			playerManager.createPlayers(usernames);
			players = playerManager.getPlayers();

			// Setting the starting square of all players
			playerManager.getPlayers().stream().forEach((Player player) -> {
				player.setCurrentSquare(board.getSquares().get(0));
			});

			displayIntroMessage(players);
			//sets the first player's currentTurn status as true
			players.get(0).setCurrentTurn(true);
			//sets the first player's hasMoved status to false
			players.get(0).setHasMoved(false);
		}

		while (isProgress) {
			// Each player takes a turn
			// <<<<<<<<<<< I changed this loop so as to have access to player.get(loop+1)
			for (int loop=0;loop<players.size();loop++) {
				// finds the player whos currentTurn status is true
				if (players.get(loop).isCurrentTurn()) {
					// checks if the current player has moved
					if (!players.get(loop).hasMoved()) {
						int squaresToMove = diceRoller.roll();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(players.get(loop).getName() + " has rolled " + squaresToMove);
						if(UserInput.isSpeak()) {
							new Speech(players.get(loop).getName() + " has rolled " + squaresToMove);
						}

						board.move(players, players.get(loop), squaresToMove);

						if (players.get(loop).bankruptCheck()) {
							isProgress = false;
							break;
						}
						// sets current player's hasMoved status to true
						players.get(loop).setHasMoved(true);
					}
					players.get(loop).displayAll();
					// saves current game state after player has moved, been offered purchase etc...
					serializaion.SaveData(players, board);

					// calls method to display options post-move
					if (postMoveOptions(players, players.get(loop))) {
						// postMoveOptions returns a boolean to signify endGame
						
						// breaks the loop if endGame conditions have been met
						isProgress = false;
						break;
					}
					// resets current players turn and moved status to false at the end of their turn
					players.get(loop).setCurrentTurn(false);
					players.get(loop).setHasMoved(false);
					
					// sets the next players currentTurn status to true
					int nextPlayerIndex = 0;
					if (loop==players.size()-1) {
						nextPlayerIndex=0;
					} else {
						nextPlayerIndex=loop+1;
					}
					players.get(nextPlayerIndex).setCurrentTurn(true);
					
					// saves the game state
					serializaion.SaveData(players, board);
					
				}
			}

			// breaks outer loop when isProgress set to false by returned boolean from
			// postMoveOptions
			if (!isProgress) {
				displayStateOfPlay();
				System.out.println("Game over");
				if(UserInput.isSpeak()) {
					new Speech("Game Over");
				}
				break;
			}

			randomEvents.generateRandomEvent(players);
			for (Player player : players) {
				if (player.bankruptCheck()) {
					System.out.println(message.randomEventBankrupt);
					if(UserInput.isSpeak()) {
						new Speech(message.randomEventBankrupt);
					}
					isProgress = false;
					break;
				}
			}
		}
	}

	private void displayStateOfPlay() {
		System.out.println("This is the final state of play...");
		if(UserInput.isSpeak()) {
			new Speech("This is the final state of play...");
		}
		board.displayElementDetails();
	}

	/**
	 * Displays intro message once players have entered their names
	 * 
	 * @param players
	 */
	public void displayIntroMessage(List<Player> players) {
		for (int loop = 0; loop < players.size(); loop++) {
			System.out.printf(players.get(loop).getName());
			if(UserInput.isSpeak()) {
				new Speech(players.get(loop).getName());
			}
			if (loop == players.size() - 2) {
				System.out.printf(" & ");
				if(UserInput.isSpeak()) {
					new Speech("and");
				}
			} else if (loop == players.size() - 1) {
				System.out.printf(" ");
			} else {
				System.out.printf(", ");
			}
		}
		System.out.println(message.intro);
		if(UserInput.isSpeak()) {
			new Speech(message.intro);
		}
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
			System.out.println("1. Display your Resources & Properties Owned");
			System.out.println("2. Develop an element");
			System.out.println("3. Trade an Element");
			System.out.println("4. End your Turn");
			System.out.println("5. Save Game");
			System.out.println("6. Quit the Game");
			
			if(UserInput.isSpeak()) {
				new Speech("Would you like to."
						+ "1 Display your Resources and Properties Owned."
						+ "2 Develop an element."
						+ "3 Trade an Element."
						+ "4 End your Turn."
						+ "5 Save Game."
						+ "6 Quit the Game.");
			}
			
			userInputNum = UserInput.getInt("Choose option 1-6 and press [Enter]");
			switch (userInputNum) {
			case 1:
				player.displayAll();
				break;
			case 2:
				System.out.println("Opening development menu...");
				if(UserInput.isSpeak()) {
					new Speech("Opening development menu");
				}
				endGame = developmentMenu(player);
				break;
			case 3:
				System.out.println("Opening trade menu...");
				if(UserInput.isSpeak()) {
					new Speech("Opening trade menu");
				}
				tradeElementMenu(allPlayers, player);
				break;
			case 4:
				System.out.println("Ending your turn...");
				if(UserInput.isSpeak()) {
					new Speech("Ending your turn");
				}
				break;
			case 5:
				System.out.println("Saving game...");
				if(UserInput.isSpeak()) {
					new Speech("Saving game");
				}
				serializaion.SaveData(players, board);
				break;
			case 6:
				endGame = quitGame();
				break;
			default:
				System.out.println(message.invalidOption);
				if(UserInput.isSpeak()) {
					new Speech(message.invalidOption);
				}
				break;
			}
			if (endGame) {
				break;
			}
		} while (userInputNum != 4 && userInputNum != 6);
		return endGame;
	}

	/**
	 * Quits the game
	 * 
	 * @return
	 */
	public boolean quitGame() {
		System.out.println(message.userQuitFail);
		if(UserInput.isSpeak()) {
			new Speech(message.userQuitFail);
		}
		boolean quit = true;
		return quit;
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
		player.sortElements(developableElements);
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
	public boolean noDevelopmentsToMakeChecker(Player player, List<Element> developableElements) {
		boolean breakIt = false;
		List<Element> tempList = new ArrayList<>();
		if (developableElements.size() == 0) {
			System.out.println("You need to own all elements in a system before you can develop!");
			if(UserInput.isSpeak()) {
				new Speech("You need to own all elements in a system before you can develop!");
			}
			breakIt = true;
			return breakIt;
		}
		for (int loop = 0; loop < developableElements.size(); loop++) {
			if (developableElements.get(loop).getDevLevel() == 4) {
				tempList.add(developableElements.get(loop));
			}
		}
		for (Element element : tempList) {
			developableElements.remove(element);
		}
		
		if (developableElements.size() == 0) {
			System.out.println("You don't have any developments to make!");
			if(UserInput.isSpeak()) {
				new Speech("You don't have any developments to make!");
			}
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
		if (player.getResources() >= priceToDevelop && element.getDevLevel() != 4) {
			player.removeResources(priceToDevelop);
			element.increaseDevLevel();
			System.out.println("Upgraded to level " + element.getDevLevel());
			System.out.println("You've developed it!");
			if(UserInput.isSpeak()) {
				new Speech("Upgraded to level " + element.getDevLevel() + "You've developed it!");
			}
		} else {
			System.out.println("Not enough resources to develop or max development reached");
			if(UserInput.isSpeak()) {
				new Speech("Not enough resources to develop or max development reached");
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
	public boolean developmentMenu(Player player) {
		List<Square> boardLayout = board.getSquares();
		// returns the developableElements array of elements from
		// returnDevelopableElements method
		List<Element> developableElements = returnDevelopableElements(player);

		boolean gameWin = false;
		String userText = "";
		int intUserInput = 0;

		do {
			// breaks the loop of the player has no elements to develop
			if (noDevelopmentsToMakeChecker(player, developableElements)) {
				break;
			}
			for (Element element : developableElements) {
				// filters out elements that have been fully developed
				if (element.getDevLevel() != 4) {
					System.out.println("To develop " + element.getName() + " enter ["
							+ (developableElements.indexOf(element) + 1) + "]");
					if(UserInput.isSpeak()) {
						new Speech("To develop" + element.getName() + "enter" + (developableElements.indexOf(element) + 1));
					}
				}
			}
			System.out.println("Don't want to develop any more? Enter [" + (developableElements.size() + 1) + "]");
			if(UserInput.isSpeak()) {
				new Speech("Don't want to develop any more? Enter" + (developableElements.size() + 1));
			}
			userText = UserInput.getString("Please choose an option followed by [Enter]");
			intUserInput = UserInput.parseWithDefault(userText, 0);
			if (intUserInput <= developableElements.size() && intUserInput > 0) {
				developElement(developableElements.get(intUserInput - 1), player);
				myDevMap.get(developableElements.get(intUserInput - 1)).displayCurrentDevInfo(developableElements.get(intUserInput - 1).getDevLevel());
				// checks after each development if all elements are fully developed
				int fullyDevelopedCount = 0;
				int elementCount = 0;
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
					displayEpilogue();
					break;
				}
				// breaks the loop if there are no further developments to make
				if (noDevelopmentsToMakeChecker(player, developableElements)) {
					break;
				}
				// exits menu on appropriate user input
			} else if (intUserInput == (developableElements.size() + 1)) {
				System.out.println("Exiting development menu");
				if(UserInput.isSpeak()) {
					new Speech("Exiting development menu");
				}
			} else {
				System.out.println(message.invalidInput);
				if(UserInput.isSpeak()) {
					new Speech(message.invalidInput);
				}
			}
			// loop will continue until player hits the appropriate 'Exit' option
		} while (intUserInput != developableElements.size() + 1);
		return gameWin;
	}

	private void displayEpilogue() {
		System.out.println(message.epilogue1);
		message.delay(5000);
		System.out.println(message.epilogue2);
		message.delay(5000);
		System.out.println(message.epilogue3);
		message.delay(5000);
		System.out.println(message.epilogue4);
		message.delay(5000);
		System.out.println(message.epilogue5);
		message.delay(5000);
		System.out.println(message.epilogue6);
		message.delay(5000);
		System.out.println(message.epilogue7);
		message.delay(3000);
		System.out.println(message.epilogue8);
		message.delay(1000);
		System.out.println(message.epilogueBooster);
		message.delay(500);
		System.out.println(message.epilogueGO);
		message.delay(500);
		System.out.println(message.epilogueRetro);
		message.delay(500);
		System.out.println(message.epilogueGO);
		message.delay(500);
		System.out.println(message.epilogueFIDO);
		message.delay(500);
		System.out.println(message.epilogueGO);
		message.delay(500);
		System.out.println(message.epilogueGuidance);
		message.delay(500);
		System.out.println(message.epilogueGO);
		message.delay(500);
		System.out.println(message.epilogueSurgeon);
		message.delay(500);
		System.out.println(message.epilogueGO);
		message.delay(500);
		System.out.println(message.epilogueEECOM);
		message.delay(500);
		System.out.println(message.epilogueGO);
		message.delay(500);
		System.out.println(message.epilogueControl);
		message.delay(500);
		System.out.println(message.epilogueGO);
		message.delay(500);
		System.out.println(message.epilogueProcedures);
		message.delay(500);
		System.out.println(message.epilogueGO);
		message.delay(500);
		System.out.println(message.epilogueINCO);
		message.delay(500);
		System.out.println(message.epilogueGO);
		message.delay(500);
		System.out.println(message.epilogueNetwork);
		message.delay(500);
		System.out.println(message.epilogueGO);
		message.delay(500);
		System.out.println(message.epilogueRecovery);
		message.delay(500);
		System.out.println(message.epilogueGO);
		message.delay(500);
		System.out.println(message.epilogueCAPCOM);
		message.delay(500);
		System.out.println(message.epilogueGO);
		message.delay(2000);
		System.out.println(message.epilogue9);
		message.delay(2000);
		message.epilogueCountdown();
		System.out.println(message.epilogue10);
		message.delay(5000);
		
		if(UserInput.isSpeak()) {
			new Speech(message.epilogue1);
			new Speech(message.epilogue2);
			new Speech(message.epilogue3);
			new Speech(message.epilogue4);
			new Speech(message.epilogue5);
			new Speech(message.epilogue6);
			new Speech(message.epilogue7);
			new Speech(message.epilogue8);
			new Speech(message.epilogue9);
			new Speech(message.epilogue10);
			
		}
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
			player.sortElements(playerElementList);
			player.displayPropertyOwnedInfo();
			// breaks the loop of the player has no elements to trade
			if (playerElementList.size() == 0) {
				System.out.println("You have no elements to trade");
				if(UserInput.isSpeak()) {
					new Speech("You have no elements to trade");
				}
				break;
			}
			for (Element element : playerElementList) {
				System.out.println(
						"To trade " + element.getName() + " enter [" + (playerElementList.indexOf(element) + 1) + "]");
				if(UserInput.isSpeak()) {
					new Speech("To trade " + element.getName() + " enter " + (playerElementList.indexOf(element) + 1) );
				}
			}
			System.out.println("Don't want to trade any more? Enter [" + (playerElementList.size() + 1) + "]");
			
			if(UserInput.isSpeak()) {
				new Speech("Don't want to trade any more? Enter " + (playerElementList.size() + 1));
			}
			userText = UserInput.getString("Please choose an option followed by [Enter]");
			intUserInput = UserInput.parseWithDefault(userText, 0);
			if (intUserInput <= playerElementList.size() && intUserInput > 0) {
				elementToTrade = playerElementList.get(intUserInput - 1);
				System.out.println("Who would you like to trade with?");
				if(UserInput.isSpeak()) {
					new Speech("Who would you like to trade with?");
				}
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
						if(UserInput.isSpeak()) {
							new Speech("To trade with " + playerMap.get(key).getName() + " press [" + key + "]");
						}
					}
					System.out.println("To cancel trade press [" + (playerMap.size() + 1) + "]");
					if(UserInput.isSpeak()) {
						new Speech("To cancel trade press [" + (playerMap.size() + 1) );
					}
					userText = UserInput.getString("Please choose an option followed by [Enter]");
					intUserInput = UserInput.parseWithDefault(userText, 0);
					if (intUserInput == 0 || intUserInput > playerMap.size() + 1) {
						System.out.println("Incorrect selection");
						if(UserInput.isSpeak()) {
							new Speech(message.invalidInput);
						}
						// breaks if user enters the cancel trade number
					} else if (intUserInput == playerMap.size() + 1) {
						break;
					} else if (intUserInput > 0 && intUserInput <= playerMap.size()) {
						do {
							System.out.println(playerMap.get(intUserInput).getName() + ", would you like to buy "
									+ elementToTrade.getName() + " from " + player.getName() + " ? [Y/N]");
							if(UserInput.isSpeak()) {
								new Speech(playerMap.get(intUserInput).getName() + ", would you like to buy "
										+ elementToTrade.getName() + " from " + player.getName());
							}
							ynInput = UserInput.getString("Please enter [Y] or [N]");
							if (ynInput.equalsIgnoreCase("Y")) {
								tradeElement(elementToTrade, player, playerMap.get(intUserInput));
							} else if (ynInput.equalsIgnoreCase("N")) {
								System.out.println(
										playerMap.get(intUserInput).getName() + " doesn't want to trade, hard luck!");
								if(UserInput.isSpeak()) {
									new Speech(playerMap.get(intUserInput).getName() + " doesn't want to trade, hard luck!");
								}
							} else {
								System.out.println(message.invalidInput);
								if(UserInput.isSpeak()) {
									new Speech(message.invalidInput);
								}
							}
						} while (!ynInput.equalsIgnoreCase("Y") && !ynInput.equalsIgnoreCase("N"));
					}
				} while (intUserInput == 0 || intUserInput > playerMap.size() + 1);
			} else if (intUserInput == (playerElementList.size() + 1)) {
				System.out.println("Exiting trade menu");
				if(UserInput.isSpeak()) {
					new Speech("Exiting trade menu");
				}
			} else {
				System.out.println(message.invalidInput);
				if(UserInput.isSpeak()) {
					new Speech(message.invalidInput);
				}
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
	public void tradeElement(Element element, Player player, Player buyer) {
		if (element.getPurchasePrice() <= buyer.getResources()) {

			player.removeSquare(element);
			buyer.addSquare(element);
			element.setOwner(buyer);
			player.addResources(element.getPurchasePrice());
			buyer.removeResources(element.getPurchasePrice());
			System.out.println(player.getName() + ", you sold " + element.getName() + " to " + buyer.getName());
			if(UserInput.isSpeak()) {
				new Speech(player.getName() + ", you sold " + element.getName() + " to " + buyer.getName());
			}
		} else {
			System.out.println(buyer.getName() + ", you can't afford this purchase!");
			if(UserInput.isSpeak()) {
				new Speech(buyer.getName() + ", you can't afford this purchase!");
			}
		}
	}

}
