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
	private String requestUserInputReturnString(String messageRequest) {
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
	private int requestUserInputReturnInt(String messageRequest) {
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
}
