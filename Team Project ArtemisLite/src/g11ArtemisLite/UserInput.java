/**
 * 
 */
package g11ArtemisLite;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import artemis.Element;
import artemis.Player;
import artemis.Square;

/**
 * @author maeve
 *
 */
public class UserInput {
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
	public String requestUserInputReturnString(String messageRequest) {
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
	 * Requesting user input and returning a String
	 * 
	 * @param messageRequest - Question requesting specific input
	 * @return input requested as int
	 */
	public int requestUserInputReturnInt(String messageRequest) {
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
	 * 
	 * @param minUsers
	 * @param maxUsers
	 * @return
	 */
	public int requestUserNumber(int minUsers, int maxUsers) {
		int numUser = -1;

		do {
			numUser = requestUserInputReturnInt("Enter number of players 2-4");

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
				username = requestUserInputReturnString("Enter player " + (user + 1) + " name");
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
			userInput = requestUserInputReturnString("Enter YES or NO");

			if (userInput.equalsIgnoreCase("YES")) {
				userChoice = true;
			} else if (userInput.equalsIgnoreCase("NO")) {
				userChoice = false;
			} else {
				userInput = null;
				System.out.println("Not valid input. Please enter YES or NO");
			}

		} while (userInput == null);

		return userChoice;
	}

	/**
	 * 
	 * @param players
	 * @param currentPlayer
	 * @return
	 */
	public Player chooseAPlayer(List<Player> players, Player currentPlayer) {
		Map<Integer, Player> playerMap = new TreeMap<Integer, Player>();
		int counter = 1;
		for (Player player : players) {
			if (!player.equals(this)) {
				playerMap.put(counter, player);
				counter++;
			}
		}

		for (Integer key : playerMap.keySet()) {
			System.out.println("To select " + playerMap.get(key).getPlayerName() + " press [" + key + "]");
		}
		System.out.println("To cancel press [" + (playerMap.size() + 1) + "]");
		String userInput = "";
		String ynInput = "";
		int intUserInput = 0;
		do {
			userInput = scanner.nextLine();
			intUserInput = parseWithDefault(userInput, 0);
			if (intUserInput == 0 || intUserInput > playerMap.size() + 1) {
				System.out.println("Incorrect selection");
			} else if (intUserInput == playerMap.size() + 1) {
				return null;
			} else if (intUserInput > 0 && intUserInput <= playerMap.size()) {
				return playerMap.get(intUserInput);

			}
		} while (intUserInput == 0 || intUserInput > playerMap.size() + 1);
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
}
