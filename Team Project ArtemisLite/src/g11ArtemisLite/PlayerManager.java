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
public class PlayerManager implements java.io.Serializable {
	private static final long serialVersionUID = 2938313309603492644L;
	private static final int MAX_USERS = 4;
	private static final int MIN_USERS = 2;
	private List<Player> players;
	private Message message;

	/**
	 * 
	 */
	public PlayerManager() {
		this.message = new Message();
	}
	
	public int getUserCount() {
		return UserInput.getInt("Enter number of players between " + MIN_USERS + " - " + MAX_USERS,MIN_USERS, MAX_USERS);
	}
	
	/**
	 * Takes in a set number of users and requests usernames. Doesn't accept empty strings or repeated names.
	 * @param userCount - Total number of users
	 * @return The list of usernames
	 */
	public List<String> getUsernames() {
		boolean restore = false;
		List<String> usernames = new ArrayList<>();
		// collects boolean from welcome if user selects restore option
		restore = welcome();
		if (!restore) {
			// proceeds as standard if user does not select restore
			return UserInput.requestUsernames(usernames, getUserCount());
		} else {
			// returns an empty username list if restore selected
			return usernames;
		}
		
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
	 * allowing for a new game to begin. Also returns a boolean true value if user selects
	 * restore option
	 */
	private boolean welcome() {
		boolean restore = false;
		System.out.println("Welcome to ArtemisLite!\n");
		// adds a pause before displaying menu options
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// collects restore boolean from displayStartUpMenu if user selects restore
		restore = displayStartUpMenu();
		return restore;
	}
	
	private boolean displayStartUpMenu() {
		// boolean to track if user selects restore
		boolean restore = false;
		String line = "";
		int lineNum = 0;
		do {
			System.out.println("[1]:\tDisplay Rules");
			System.out.println("[2]:\tStart New Game");
			System.out.println("[3]:\tRestore Saved Game");
			
			line = UserInput.getString(message.inputOptionRequest);
			lineNum = UserInput.parseWithDefault(line, 0);
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
			case 3:
				System.out.println(message.restoringGame);
				// sets boolean to true if user restores
				restore = true;
				break;
			default:
				System.err.println(message.invalidOption);
				break;
			}
		} while (lineNum !=2 && lineNum !=3 );
		return restore;
	}
	
	/**
	 * Displays the game rules, exiting when a player presses [Enter]
	 */
	private void displayRules() {
		System.out.println(message.rules);
		UserInput.prompt(message.returnToMenu);;
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
			choice = UserInput.getInt("Enter number 1 - " + (playerMap.size() +1));
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
