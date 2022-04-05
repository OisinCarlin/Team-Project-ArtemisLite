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
		this.serializaion = new Serializaion();
		this.isProgress = true;

		this.board = new Board();
		Square square1 = new StartSquare("Mission Control", 200);
		Element square2 = new Element("Power and Propulsion System", 1, 100, 10, 20);
		Element square3 = new Element("Habitation and Logistics Outpost", 2, 100, 10, 20);
		Element square4 = new Element("Avionics", 3, 200, 20, 40);
		Element square5 = new Element("Core Stage and Propulsion", 4, 200, 20, 40);
		Element square6 = new Element("Interim Cryogenic Propulsion Stage", 5, 200, 20, 40);
		Element square7 = new Element("Crew Module", 6, 250, 25, 50);
		Element square8 = new Element("Launch Abort Systems", 7, 250, 25, 50);
		Element square9 = new Element("Service Module", 8, 250, 25, 50);
		Element square10 = new Element("Human Landing System", 9, 300, 30, 60);
		Element square11 = new Element("xEMU Spacesuit", 10,  300, 30, 60);
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
		sysTwo.addElement(square4);
		sysTwo.addElement(square5);
		sysTwo.addElement(square6);

		this.sysThree = new ElementSystem("Orion Spacecraft");
		sysThree.addElement(square7);
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
						Message.delay(1000);
						System.out.println(players.get(loop).getName() + " has rolled " + squaresToMove);
						if(UserInput.isSpeak()) {
							new Speech(players.get(loop).getName() + " has rolled " + squaresToMove);
						}
						Message.delay(1000);
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
			
			if(isProgress) {
				randomEvents.generateRandomEvent(players);
				for (Player player : players) {
					if (player.bankruptCheck()) {
						System.out.println(Message.randomEventBankrupt);
						if(UserInput.isSpeak()) {
							new Speech(Message.randomEventBankrupt);
						}
						isProgress = false;
						break;
					}
				}
			}
			
			// breaks outer loop when isProgress set to false by returned boolean from
			// postMoveOptions
			if (!isProgress) {
				displayStateOfPlay();
				System.out.println(Message.gameOver);
				if(UserInput.isSpeak()) {
					new Speech(Message.gameOver);
				}
				break;
			}
		}
	}

	private void displayStateOfPlay() {
		System.out.println(Message.finalSOP);
		if(UserInput.isSpeak()) {
			new Speech(Message.finalSOP);
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
		System.out.println(Message.intro);
		if(UserInput.isSpeak()) {
			new Speech(Message.intro);
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
			System.out.println(Message.likeTo);
			System.out.println(Message.moveMenuOpShowSystems);
			System.out.println(Message.moveMenuOpShowRes);
			System.out.println(Message.moveMenuOpDevelop);
			System.out.println(Message.moveMenuOpTrade);
			System.out.println(Message.moveMenuOpEnd);
			System.out.println(Message.moveMenuOpSave);
			System.out.println(Message.moveMenuOpQuit);
			
			if(UserInput.isSpeak()) {
				new Speech(Message.likeTo
						+ Message.moveMenuOpShowSystems
						+ Message.moveMenuOpShowRes
						+ Message.moveMenuOpDevelop
						+ Message.moveMenuOpTrade
						+ Message.moveMenuOpEnd
						+ Message.moveMenuOpSave
						+ Message.moveMenuOpQuit);
			}
			
			userInputNum = UserInput.getInt(Message.inputOptionRequest);
			switch (userInputNum) {
			case 1:
				allSystems.forEach(ElementSystem:: displayAll);
				break;
			case 2:
				player.displayAll();
				break;
			case 3:
				System.out.println(Message.openDevMenu);
				if(UserInput.isSpeak()) {
					new Speech(Message.openDevMenu);
				}
				endGame = developmentMenu(player);
				break;
			case 4:
				System.out.println(Message.openTradeMenu);
				if(UserInput.isSpeak()) {
					new Speech(Message.openTradeMenu);
				}
				tradeElementMenu(allPlayers, player);
				break;
			case 5:
				System.out.println(Message.endingTurn);
				if(UserInput.isSpeak()) {
					new Speech(Message.endingTurn);
				}
				break;
			case 6:
				System.out.println(Message.saveGame);
				if(UserInput.isSpeak()) {
					new Speech(Message.saveGame);
				}
				serializaion.SaveData(players, board);
				break;
			case 7:
				endGame = quitGame();
				break;
			default:
				System.out.println(Message.invalidOption);
				if(UserInput.isSpeak()) {
					new Speech(Message.invalidOption);
				}
				break;
			}
			if (endGame) {
				break;
			}
		} while (userInputNum != 5 && userInputNum != 7);
		return endGame;
	}

	/**
	 * Quits the game
	 * 
	 * @return
	 */
	public boolean quitGame() {
		System.out.println(Message.userQuitFail);
		if(UserInput.isSpeak()) {
			new Speech(Message.userQuitFail);
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
			System.out.println(Message.ownAllElements);
			if(UserInput.isSpeak()) {
				new Speech(Message.ownAllElements);
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
			System.out.println(Message.noDevToMake);
			if(UserInput.isSpeak()) {
				new Speech(Message.noDevToMake);
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
			System.out.println(Message.upgradeLevel + element.getDevLevel());
			System.out.println(Message.developedIt);
			if(UserInput.isSpeak()) {
				new Speech(Message.upgradeLevel + element.getDevLevel() + Message.developedIt);
			}
		} else {
			System.out.println(Message.maxDev + "or" + Message.notEnoughRes);
			if(UserInput.isSpeak()) {
				new Speech(Message.maxDev + "or" + Message.notEnoughRes);
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
					System.out.println(Message.develop + element.getName() + Message.enter
							+ (developableElements.indexOf(element) + 1));
					if(UserInput.isSpeak()) {
						new Speech(Message.develop + element.getName() + Message.enter + (developableElements.indexOf(element) + 1));
					}
				}
			}
			System.out.println(Message.dontDevMore + Message.enter + (developableElements.size() + 1));
			if(UserInput.isSpeak()) {
				new Speech(Message.dontDevMore + Message.enter + (developableElements.size() + 1));
			}
			userText = UserInput.getString(Message.inputOptionRequest);
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
				System.out.println(Message.exitMenu);
				if(UserInput.isSpeak()) {
					new Speech(Message.exitMenu);
				}
			} else {
				System.out.println(Message.invalidInput);
				if(UserInput.isSpeak()) {
					new Speech(Message.invalidInput);
				}
			}
			// loop will continue until player hits the appropriate 'Exit' option
		} while (intUserInput != developableElements.size() + 1);
		return gameWin;
	}

	private void displayEpilogue() {
		System.out.println(Message.epilogue1);
		Message.delay(5000);
		System.out.println(Message.epilogue2);
		Message.delay(5000);
		System.out.println(Message.epilogue3);
		Message.delay(5000);
		System.out.println(Message.epilogue4);
		Message.delay(5000);
		System.out.println(Message.epilogue5);
		Message.delay(5000);
		System.out.println(Message.epilogue6);
		Message.delay(5000);
		System.out.println(Message.epilogue7);
		Message.delay(3000);
		System.out.println(Message.epilogue8);
		Message.delay(1000);
		System.out.println(Message.epilogueBooster);
		Message.delay(500);
		System.out.println(Message.epilogueGO);
		Message.delay(500);
		System.out.println(Message.epilogueRetro);
		Message.delay(500);
		System.out.println(Message.epilogueGO);
		Message.delay(500);
		System.out.println(Message.epilogueFIDO);
		Message.delay(500);
		System.out.println(Message.epilogueGO);
		Message.delay(500);
		System.out.println(Message.epilogueGuidance);
		Message.delay(500);
		System.out.println(Message.epilogueGO);
		Message.delay(500);
		System.out.println(Message.epilogueSurgeon);
		Message.delay(500);
		System.out.println(Message.epilogueGO);
		Message.delay(500);
		System.out.println(Message.epilogueEECOM);
		Message.delay(500);
		System.out.println(Message.epilogueGO);
		Message.delay(500);
		System.out.println(Message.epilogueControl);
		Message.delay(500);
		System.out.println(Message.epilogueGO);
		Message.delay(500);
		System.out.println(Message.epilogueProcedures);
		Message.delay(500);
		System.out.println(Message.epilogueGO);
		Message.delay(500);
		System.out.println(Message.epilogueINCO);
		Message.delay(500);
		System.out.println(Message.epilogueGO);
		Message.delay(500);
		System.out.println(Message.epilogueNetwork);
		Message.delay(500);
		System.out.println(Message.epilogueGO);
		Message.delay(500);
		System.out.println(Message.epilogueRecovery);
		Message.delay(500);
		System.out.println(Message.epilogueGO);
		Message.delay(500);
		System.out.println(Message.epilogueCAPCOM);
		Message.delay(500);
		System.out.println(Message.epilogueGO);
		Message.delay(2000);
		System.out.println(Message.epilogue9);
		Message.delay(2000);
		Message.epilogueCountdown();
		System.out.println(Message.epilogue10);
		Message.delay(5000);
		
		if(UserInput.isSpeak()) {
			new Speech(Message.epilogue1);
			new Speech(Message.epilogue2);
			new Speech(Message.epilogue3);
			new Speech(Message.epilogue4);
			new Speech(Message.epilogue5);
			new Speech(Message.epilogue6);
			new Speech(Message.epilogue7);
			new Speech(Message.epilogue8);
			new Speech(Message.epilogue9);
			new Speech(Message.epilogue10);
			
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
				System.out.println(Message.noElementsTrade);
				if(UserInput.isSpeak()) {
					new Speech(Message.noElementsTrade);
				}
				break;
			}
			for (Element element : playerElementList) {
				System.out.println(
						Message.trade + element.getName() + Message.enter + (playerElementList.indexOf(element) + 1));
				if(UserInput.isSpeak()) {
					new Speech(Message.trade + element.getName() + Message.enter + (playerElementList.indexOf(element) + 1) );
				}
			}
			System.out.println(Message.dontTradeMore + Message.enter + (playerElementList.size() + 1));
			
			if(UserInput.isSpeak()) {
				new Speech(Message.dontTradeMore + Message.enter + (playerElementList.size() + 1));
			}
			userText = UserInput.getString(Message.inputOptionRequest);
			intUserInput = UserInput.parseWithDefault(userText, 0);
			if (intUserInput <= playerElementList.size() && intUserInput > 0) {
				elementToTrade = playerElementList.get(intUserInput - 1);
				System.out.println(Message.whoTrade);
				if(UserInput.isSpeak()) {
					new Speech(Message.whoTrade);
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
						System.out.println(Message.trade + Message.with + playerMap.get(key).getName() + Message.enter + key);
						if(UserInput.isSpeak()) {
							new Speech(Message.trade + Message.with + playerMap.get(key).getName() + Message.enter + key);
						}
					}
					System.out.println(Message.cancel + Message.enter + (playerMap.size() + 1));
					if(UserInput.isSpeak()) {
						new Speech(Message.cancel + Message.enter + (playerMap.size() + 1) );
					}
					userText = UserInput.getString(Message.inputOptionRequest);
					intUserInput = UserInput.parseWithDefault(userText, 0);
					if (intUserInput == 0 || intUserInput > playerMap.size() + 1) {
						System.out.println(Message.invalidInput);
						if(UserInput.isSpeak()) {
							new Speech(Message.invalidInput);
						}
						// breaks if user enters the cancel trade number
					} else if (intUserInput == playerMap.size() + 1) {
						break;
					} else if (intUserInput > 0 && intUserInput <= playerMap.size()) {
						do {
							System.out.println(playerMap.get(intUserInput).getName() + Message.likeToBuy
									+ elementToTrade.getName() + " from " + player.getName());
							if(UserInput.isSpeak()) {
								new Speech(playerMap.get(intUserInput).getName() + Message.likeToBuy
										+ elementToTrade.getName() + " from " + player.getName());
							}
							ynInput = UserInput.getString(Message.enterYN);
							if (ynInput.equalsIgnoreCase("Y")) {
								tradeElement(elementToTrade, player, playerMap.get(intUserInput));
							} else if (ynInput.equalsIgnoreCase("N")) {
								System.out.println(
										playerMap.get(intUserInput).getName() + Message.noToTrade);
								if(UserInput.isSpeak()) {
									new Speech(playerMap.get(intUserInput).getName() + Message.noToTrade);
								}
							} else {
								System.out.println(Message.invalidInput);
								if(UserInput.isSpeak()) {
									new Speech(Message.invalidInput);
								}
							}
						} while (!ynInput.equalsIgnoreCase("Y") && !ynInput.equalsIgnoreCase("N"));
					}
				} while (intUserInput == 0 || intUserInput > playerMap.size() + 1);
			} else if (intUserInput == (playerElementList.size() + 1)) {
				System.out.println(Message.exitMenu);
				if(UserInput.isSpeak()) {
					new Speech(Message.exitMenu);
				}
			} else {
				System.out.println(Message.invalidInput);
				if(UserInput.isSpeak()) {
					new Speech(Message.invalidInput);
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
			System.out.println(buyer.getName() + Message.notEnoughRes);
			if(UserInput.isSpeak()) {
				new Speech(buyer.getName() + Message.notEnoughRes);
			}
		}
	}

}
