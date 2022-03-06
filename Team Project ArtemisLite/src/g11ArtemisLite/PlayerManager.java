/**
 * 
 */
package g11ArtemisLite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Maeve Higgins
 *
 */
public class PlayerManager {
	private static final int MAX_USERS = 4;
	private static final int MIN_USERS = 2;
	private UserInput userInput;
	private List<Player> players;
	private Message message;

	/**
	 * 
	 */
	public PlayerManager() {
		this.userInput = new UserInput();
		this.message = new Message();
	}
	
	public int getUserCount() {
		return userInput.getInt("Enter number of players between " + MIN_USERS + " - " + MAX_USERS,MIN_USERS, MAX_USERS);
	}
	
	/**
	 * Takes in a set number of users and requests usernames. Doesn't accept empty strings or repeated names.
	 * @param userCount - Total number of users
	 * @return The list of usernames
	 */
	public List<String> getUsernames() {
		List<String> usernames = new ArrayList<>();
		welcome();
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
	private void welcome() {
		System.out.println("Welcome to ArtemisLite!\n");
		// adds a pause before displaying menu options
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		displayStartUpMenu();
	}
	
	private void displayStartUpMenu() {
		int lineNum = 0;
		do {
			System.out.println("[1]:\tDisplay Rules");
			System.out.println("[2]:\tStart New Game");
			
			lineNum = userInput.getInt(message.inputOptionRequest);
			switch (lineNum) {
			case 1:
				displayRules();
				break;
			case 2:
				System.out.println(message.startingMessage);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.err.println(message.invalidOption);
				break;
			}
		} while (lineNum != 2);
	}
	
	/**
	 * Displays the game rules, exiting when a player presses [Enter]
	 */
	public void displayRules() {
		System.out.println(message.rules);
		userInput.prompt(message.returnToMenu);;
	}

	public Map<Integer, Player> mapPlayers(List<Player> allPlayers, Player currentPlayer){
		Map<Integer, Player> playerMap = new TreeMap<Integer, Player>();
		int counter = 1;
		for (Player player : allPlayers) {
			if (!player.equals(currentPlayer)) {
				playerMap.put(counter, player);
				counter++;
			}
		}
		return playerMap;
	}
	
	public Player choosePlayer(Map<Integer, Player> playerMap) {
		Player chosenPlayer = null;
		int choice = -1;
		
		for(Integer key : playerMap.keySet()) {
			System.out.printf("To select %s enter [ %d ]\n", playerMap.get(key).getName(), key);
		}
		System.out.printf("To cancel enter [ %d ]\n", playerMap.size() + 1);
		
		do {
			choice = userInput.getInt("Enter number 1 - " + (playerMap.size() +1));
			if(choice > 0 && choice <= playerMap.size()) {
				chosenPlayer = playerMap.get(choice);
			} else if(choice == playerMap.size() + 1) {
				System.err.println("Cancelling");
				chosenPlayer = null;
			} else {
				System.err.println(message.invalidOption);
			}
		} while(choice <= 0 || choice > playerMap.size() +1);
		
		return chosenPlayer;
	}
}
