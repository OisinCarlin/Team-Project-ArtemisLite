/**
 * 
 */
package g11ArtemisLite;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author maeve
 *
 */
public class UserInput implements java.io.Serializable {
	
	private static final long serialVersionUID = 2938313309603492644L;
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 */
	public UserInput() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Requesting user input and returning a String
	 * 
	 * @param messageRequest - Question requesting specific input
	 * @return input requested as String
	 */
	public String getString(String messageRequest) {
		String userInput = null;
		try {
			System.out.println(messageRequest);

			userInput = scanner.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Problem with input " + e.getMessage());
		}
		return userInput;
	}

	/**
	 * Requesting user input and returning an int
	 * 
	 * @param messageRequest - Question requesting specific input
	 * @return input requested as int
	 */
	public int getInt(String messageRequest) {
		int userInput = -1;
		try {
			System.out.println(messageRequest);

			userInput = scanner.nextInt();
			scanner.nextLine();
		} catch (InputMismatchException e) {
			System.err.println("Problem with input " + e.getMessage());
		}
		return userInput;
	}

	/**
	 * Requesting user input within a speficied range and returning an int
	 * @param minUsers
	 * @param maxUsers
	 * @return
	 */
	public int getInt(String message, int minUsers, int maxUsers) {
		int numUser = -1;

		do {
			numUser = getInt(message);

			if (numUser < minUsers) {
				System.err.println("Too few players. Min players is " + minUsers);
			}
			if (numUser > maxUsers) {
				System.err.println("Too many players. Max players is " + maxUsers);
			}
		} while (numUser < minUsers || numUser > maxUsers);

		return numUser;
	}

	/**
	 * 
	 * @param usernames
	 * @param userCount
	 * @return
	 */
	public List<String> requestUsernames(List<String> usernames, int userCount) {
		String username = null;

		for (int user = 0; user < userCount; user++) {
			do {
				username = getString("Enter player " + (user + 1) + " name");
				if (username.strip().isEmpty()) {
					System.err.println("Not valid input. Please enter at least one visible character.");
					username = null;
				}
				if (usernames.contains(username)) {
					System.err.println("Name already used. Please enter a different name.");
					username = null;
				}
			} while (username == null);

			usernames.add(username);
		}

		return usernames;
	}

	/**
	 * Ask user YES or NO? Not case sensitive
	 * 
	 * @return true if answer is yes
	 */
	public boolean yesOrNo() {
		boolean userChoice = false;
		String userInput = null;

		do {
			userInput = getString("Enter Y / N");

			if (userInput.equalsIgnoreCase("Y")) {
				userChoice = true;
			} else if (userInput.equalsIgnoreCase("N")) {
				userChoice = false;
			} else {
				userInput = null;
				System.out.println("Not valid input. Please enter Y / N");
			}

		} while (userInput == null);

		return userChoice;
	}

	// <<<<<<<<<<<<<<<<<<left this in, but not used it as
	// yet>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * 
	 * @param players
	 * @param currentPlayer
	 * @return
	 */
	public Player chooseAPlayer(List<Player> players, Player currentPlayer) {
		Player playerToReturn = null;
		Map<Integer, Player> playerMap = new TreeMap<Integer, Player>();
		int counter = 1;
		for (Player player : players) {
			if (!player.equals(currentPlayer)) {
				playerMap.put(counter, player);
				counter++;
			}
		}

		for (Integer key : playerMap.keySet()) {
			System.out.println("To select " + playerMap.get(key).getName() + " press [" + key + "]");
		}
		System.out.println("To cancel press [" + (playerMap.size() + 1) + "]");
		String userInput = "";
		int intUserInput = 0;
		do {
			userInput = scanner.nextLine();
			intUserInput = parseWithDefault(userInput, 0);
			if (intUserInput == 0 || intUserInput > playerMap.size() + 1) {
				System.out.println("Incorrect selection");
			} else if (intUserInput == playerMap.size() + 1) {
				break;
			} else if (intUserInput > 0 && intUserInput <= playerMap.size()) {
				playerToReturn = playerMap.get(intUserInput);

			}
		} while (intUserInput == 0 || intUserInput > playerMap.size() + 1);
		return playerToReturn;
	}

	/**
	 * Returns a default value if an integer cannot be parsed from a string
	 * 
	 * @param number
	 * @param defaultVal
	 * @return
	 */
	public int parseWithDefault(String number, int defaultVal) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

	/**
	 * Prints a message to the user and waits until they hit return before
	 * continuing.
	 * 
	 * @param message
	 */
	public void prompt(String message) {
		System.out.println(message);
		scanner.nextLine();
	}
}
