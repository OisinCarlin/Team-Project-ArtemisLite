/**
 * 
 */
package g11ArtemisLite;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author maeve
 *
 */
public class UserInput implements java.io.Serializable {
	
	private static final long serialVersionUID = 2938313309603492644L;
	private static final Scanner scanner = new Scanner(System.in);
	private static boolean speak = false;

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
	public static String getString(String messageRequest) {
		String userInput = null;
		try {
			System.out.println(messageRequest);
			if(speak) {
				new Speech(messageRequest);
			}
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
	public static int getInt(String messageRequest) {
		int userInput = -1;
		try {
			System.out.println(messageRequest);
			if(speak) {
				new Speech(messageRequest);
			}
			userInput = scanner.nextInt();
			scanner.nextLine();
		} catch (InputMismatchException e) {
			System.err.println("Problem with input " + e.getMessage());
			scanner.nextLine();
		}
		return userInput;
	}

	/**
	 * Requesting user input within a speficied range and returning an int
	 * @param minUsers
	 * @param maxUsers
	 * @return
	 */
	public static int getInt(String message, int minUsers, int maxUsers) {
		int numUser = -1;

		do {
			numUser = getInt(message);

			if (numUser < minUsers) {
				System.out.println("Too few players. Min players is " + minUsers);
				if(speak) {
					new Speech("Too few players. Min players is " + minUsers);
				}
			}
			if (numUser > maxUsers) {
				System.out.println("Too many players. Max players is " + maxUsers);
				if(speak) {
					new Speech("Too many players. Max players is " + maxUsers);
				}
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
	public static List<String> requestUsernames(List<String> usernames, int userCount) {
		String username = null;

		for (int user = 0; user < userCount; user++) {
			do {
				username = getString("Enter player " + (user + 1) + " name");
				if (username.strip().isEmpty()) {
					System.out.println("Not valid input. Please enter at least one visible character.");
					if(speak) {
						new Speech("Not valid input. Please enter at least one visible character.");
					}
					username = null;
				}
				if (usernames.contains(username)) {
					System.out.println("Name already used. Please enter a different name.");
					if(speak) {
						new Speech("Name already used. Please enter a different name.");
					}
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
	public static boolean yesOrNo() {
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
				if(speak) {
					new Speech("Not valid input. Please enter Y / N");
				}
			}

		} while (userInput == null);

		return userChoice;
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
	 * Prints a message to the user and waits until they hit return before
	 * continuing.
	 * 
	 * @param message
	 */
	public static void prompt(String message) {
		System.out.println(message);
		scanner.nextLine();
	}

	/**
	 * @return the speak
	 */
	public static boolean isSpeak() {
		return speak;
	}

	/**
	 * @param speak the speak to set
	 */
	public static void setSpeak(boolean speak) {
		UserInput.speak = speak;
	}
}
