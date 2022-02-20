/**
 * 
 */
package artemis;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author crclarke
 *
 */
public class Game {

	public static final Scanner sc = new Scanner(System.in);
	public static final String INTRO_MESSAGE = "will lead an innovative and sustainable program of exploration with commercial and international partners\n"
			+ "to enable human expansion across the solar system and to bring back to earth new knowledge and opportunities. Beginning with missions beyond\n"
			+ "low-earth orbit, the US will lead the return of humans to the Moon for long-term exploration and utilisation, followed by human missions to Mars"
			+ "and other destinations.";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		playTheGame();
		System.out.println("Richards branch test message");

	}

	/**
	 * Displays a welcome message on game initialisation, then offers the players a
	 * menu with options to display rules (invoking the displayRules method), or
	 * allowing for a new game to begin
	 */
	public static void welcome() {
		String line = "";
		int lineNum = 0;
		System.out.println("Welcome to ArtemisLite!");
		// adds a pause before diplaying menu options
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		do {
			System.out.println("Press [1]:\tDisplay Rules");
			System.out.println("Press [2]:\tStart New Game");
			line = sc.nextLine();
			lineNum = parseWithDefault(line, 0);
			switch (lineNum) {
			case 1:
				displayRules();
				break;
			case 2:
				System.out.println("Artemis to the moon blah blah blah...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Incorrect option selected, try again...");
				break;
			}
		} while (lineNum != 2);
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
	 * Displays the game rules, exiting when a player presses [Enter]
	 */
	public static void displayRules() {
		System.out.println("Rules");
		System.out.println("To return to main menu press [Enter]");
		sc.nextLine();
	}

	/**
	 * Displays a message indicating successful game completion
	 */
	public static void gameSuccess() {
		System.out.println("Congratulations, artemis launch!");
	}

	/**
	 * Displays a message indicating unsuccessful game completion
	 */
	public static void gameFailure() {
		System.out.println("Your mission is a failure, you are all failures!");
	}

	/**
	 * Calls methods appropriate for the sequence of events for a player turn.
	 * Initially calls the movePlayer method of Player, then displays information
	 * for the square the player has landed on using overridden displayAll method of
	 * Square. If the player's new location is an element, the method will either 1.
	 * offer the player the ability to purchase the element if it is not owned,
	 * calling the purchaseElement method of Player 2. display a message that the
	 * player already owns the element if appropriate 3. implement the payRent
	 * method of player if the element is owned by another player If payRent is
	 * implemented, the player method bankruptCheck is used to return a 'true'
	 * boolean if the player was made bankrupt by payRent. If this is so,
	 * gameFailure method displays the game loss message, and the boolean is
	 * returned to end the turn. If this does not occur, the players owned
	 * properties are displayed by the player displayPropertyOwnedInfo method The
	 * player can then develop elements owned up to their maximum. After each
	 * development, a boolean may be returned by the developmentMenu method, which
	 * is checked, implementing the gameSuccess method to display a successful
	 * launch message, and returns the endGameCheck = true boolean to end the turn
	 * if so. Otherwise returns a false value for endGameCheck once the turn is
	 * completed.
	 * 
	 * @param player
	 * @param board
	 * @param boardLayout
	 * @return
	 */
	public static boolean playerTurn(Player player, Board board, ArrayList<Square> boardLayout,
			ArrayList<Player> players) {
		// boolean to flag for game-ending conditions (player bankrupt, or all elements
		// fully developed)
		boolean endGameCheck = false;
		String userInput = "";
		System.out.println(player.getPlayerName() + ", when you're ready to roll the dice press [Enter]");
		sc.nextLine();
		player.movePlayer(boardLayout);
		player.getLocation().displayAll();
		if (player.getLocation() instanceof Element) {
			Element element = (Element) player.getLocation();
			if (element.getOwner() == null) {
				System.out.println("Would you like to purchase this element? [Y/N]");
				userInput = sc.nextLine();
				if (userInput.equalsIgnoreCase("Y")) {
					player.purchaseElement();
				}
			} else if (element.getOwner().equals(player)) {
				System.out.println("You already own this property!");
			} else {
				player.payRent();
				endGameCheck = player.bankruptCheck(board);
			}

		}
		if (endGameCheck) {
			gameFailure();
			return endGameCheck;
		} else {
			player.displayPropertyOwnedInfo();
			if (player.getElementsOwned().size() > 0) {
				System.out.println("Would you like to trade an element? [Y/N]");
				userInput = sc.nextLine();
				if (userInput.equalsIgnoreCase("Y")) {
					player.tradeElementMenu(boardLayout, players);
				} else {
					System.out.println(player.getPlayerName() + ", you don't want to trade? Sadface!");
				}
			} else {
				System.out.println(player.getPlayerName() + ", you don't have any properties to trade, sadface!");
			}

			
			if (player.getElementsOwned().size() > 0) {
				System.out.println("Would you like to develop an element? [Y/N]");
				userInput = sc.nextLine();
				if (userInput.equalsIgnoreCase("Y"))

				{
					endGameCheck = player.developmentMenu(boardLayout);
					if (endGameCheck) {
						gameSuccess();
						return endGameCheck;
					}
				}
			} else {
				System.out.println(player.getPlayerName() + ", you don't have any properties to develop, sadface!");
			}

		}
		return endGameCheck;
	}

	public static void postMoveMenu(Player player) {

	}

	/**
	 * Method to play the game Instantiates the board (which implements
	 * setGamelayout to set the board), then implements getGameLayout method of
	 * board to return the programmed Artemis board layout to an ArrayList of type
	 * Square. Instantiates a PlayerManager, which implements a setPlayers method to
	 * get player names from user input. This Player ArrayList is then instantiated
	 * using the getPlayers method. setPlayerStartingLocation sets the current
	 * location for each player to the Start Square. The boolean endGame flag tracks
	 * a game-ending return from playerTurn. Loops playerTurn method for all players
	 * until endGame boolean is returned by playerTurn. When this occurs
	 * displayEndGame displays all Elements, their owners, and final development
	 * level
	 * 
	 */
	public static void playTheGame() {
		// instantiates the board
		Board board = new Board();
		// sets the board as per the layout defined by setGameLayout
		ArrayList<Square> boardLayout = board.getGameLayout();
		welcome();
		PlayerManager pm = new PlayerManager(boardLayout);
		ArrayList<Player> players = pm.getPlayers();

		boolean endGame = false;
		displayIntroMessage(players);
		do {
			for (Player player : players) {
				endGame = playerTurn(player, board, boardLayout, players);
				if (endGame) {
					board.displayEndGame();
					break;
				}
			}
		} while (!endGame);
	}
	
	public static void displayIntroMessage(ArrayList<Player> players) {
		for (int loop=0; loop<players.size(); loop++) {
			System.out.printf(players.get(loop).getPlayerName());
			if (loop==players.size()-1) {
				System.out.printf(" ");
			} else {
				System.out.printf(", ");
			}
			
		}
		System.out.println(INTRO_MESSAGE);
	}

}
