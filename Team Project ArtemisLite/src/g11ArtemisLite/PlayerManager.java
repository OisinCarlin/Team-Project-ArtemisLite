/**
 * 
 */
package g11ArtemisLite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author maeve
 *
 */
public class PlayerManager {
	private static final int MAX_USERS = 4;
	private static final int MIN_USERS = 2;
	private UserInput userInput;
	private List<Player> players;

	/**
	 * 
	 */
	public PlayerManager() {
		this.userInput = new UserInput();
	}
	
	public int getUserCount() {
		return userInput.requestUserNumber(MIN_USERS, MAX_USERS);
	}
	
	/**
	 * Takes in a set number of users and requests usernames. Doesn't accept empty strings or repeated names.
	 * @param userCount - Total number of users
	 * @return The list of usernames
	 */
	public List<String> getUsernames() {
		List<String> usernames = new ArrayList<>();
		welcome(userInput);
		return userInput.requestUsernames(usernames, getUserCount());
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getUserData() {
		return getUsernames();
	}
	
	/**
	 * 
	 * @param usernames
	 */
	public void createPlayers(List<String> usernames) {
		players = usernames.stream().map((String username) -> {
			return new Player(username);
		}).collect(Collectors.toList());		
	}

	public List<Player> getPlayers(){
		return players;
	}
	
	public Player getPlayer(int index) {
		return players.get(index);
	}
	
	/**
	 * Displays a welcome message on game initialisation, then offers the players a
	 * menu with options to display rules (invoking the displayRules method), or
	 * allowing for a new game to begin
	 */
	public static void welcome(UserInput uI) {
		int lineNum = 0;
		System.out.println("Welcome to ArtemisLite!");
		// adds a pause before displaying menu options
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		do {
			System.out.println("Press [1]:\tDisplay Rules");
			System.out.println("Press [2]:\tStart New Game");
			
			lineNum = uI.requestUserInputReturnInt("Input a number and press [Enter]");
			switch (lineNum) {
			case 1:
				displayRules(uI);
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
	 * Displays the game rules, exiting when a player presses [Enter]
	 */
	public static void displayRules(UserInput uI) {
		System.out.println("Rules");
		uI.requestUserInputReturnString("To return to the main menu press [Enter]");
	}

}
