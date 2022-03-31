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

	/**
	 * 
	 */
	public PlayerManager() {
	}
	
	public int getUserCount() {
		return UserInput.getInt(Message.enterNumPlayers + MIN_USERS + " to " + MAX_USERS,MIN_USERS, MAX_USERS);
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
	 * Creates players from a list of usernames and maps them to the list of players
	 * @param usernames
	 */
	public void createPlayers(List<String> usernames) {
		players = usernames.stream().map((String username) -> {
			return new Player(username);
		}).collect(Collectors.toList());		
	}

	/**
	 * Returns the list of players
	 * @return list of players
	 */
	public List<Player> getPlayers(){
		return players;
	}
	
	/**
	 * Returns a player at a specified index
	 * @param index
	 * @return
	 */
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
		System.out.println(Message.welcome);
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
	
	/**
	 * Displays the startup menu options 
	 * @return a boolean if restoring a saved game
	 */
	private boolean displayStartUpMenu() {
		// boolean to track if user selects restore
		boolean restore = false;
		String line = "";
		int lineNum = 0;
		do {
			System.out.println(Message.menuOpRules);
			System.out.println(Message.menuOpNewGame);
			System.out.println(Message.menuOpRestoreGame);
			
			if(!UserInput.isSpeak()) {
				System.out.println(Message.menuOpEnableSpeech);
			} else {
				System.out.println(Message.menuOpDisableSpeech);
			}
			
			if(UserInput.isSpeak()) {
				new Speech(Message.menuOpRules + Message.menuOpNewGame + Message.menuOpRestoreGame + Message.menuOpDisableSpeech);
			}
			
			line = UserInput.getString(Message.inputOptionRequest);
			lineNum = UserInput.parseWithDefault(line, 0);
			switch (lineNum) {
			case 1:
				displayRules();
				break;
			case 2:
				if(UserInput.isSpeak()) {
					new Speech(Message.startingMessage);
				}
				System.out.println(Message.startingMessage);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				if(UserInput.isSpeak()) {
					new Speech(Message.restoringGame);
				}
				System.out.println(Message.restoringGame);
				// sets boolean to true if user restores
				restore = true;
				break;
			case 4:
				if(!UserInput.isSpeak()) {
					new Speech(Message.toEnableSpeech + Message.enterYN);
					if(UserInput.yesOrNo()) {
						UserInput.setSpeak(true);
						System.out.println(Message.speechEnabled);
						if(UserInput.isSpeak()) {
							new Speech(Message.speechEnabled);
						}
					}
				} else {
					new Speech(Message.toDisableSpeech + Message.enterYN);
					if(UserInput.yesOrNo()) {
						UserInput.setSpeak(false);
						System.out.println(Message.speechDisabled);
					}
				}
				
				break;
			default:
				if(UserInput.isSpeak()) {
					new Speech(Message.invalidOption);
				}
				System.out.println(Message.invalidOption);
				break;
			}
		} while (lineNum !=2 && lineNum !=3 );
		return restore;
	}
	
	/**
	 * Displays the game rules, exiting when a player presses [Enter]
	 */
	private void displayRules() {
		System.out.println(Message.rules);
		if(UserInput.isSpeak()) {
			new Speech(Message.rules);
		}
		UserInput.prompt(Message.returnToMenu);;
	}

	/**
	 * Maps all players to a number excluding the current player
	 * @param allPlayers
	 * @param currentPlayer
	 * @return map of numbers and players
	 */
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
	
	/**
	 * Loops through the map of players for the current player to select from by entering the corresponding number
	 * @param playerMap
	 * @return the chosen player
	 */
	public Player choosePlayer(Map<Integer, Player> playerMap) {
		Player chosenPlayer = null;
		int choice = -1;
		
		for(Integer key : playerMap.keySet()) {
			System.out.println(Message.select + playerMap.get(key).getName() + Message.enter + key);
			if(UserInput.isSpeak()) {
				new Speech(Message.select + playerMap.get(key).getName() + Message.enter + key);
			}
		}
		System.out.println(Message.toCancel + (playerMap.size() + 1));
		if(UserInput.isSpeak()) {
			new Speech(Message.toCancel + (playerMap.size() + 1));
		}
		
		do {
			choice = UserInput.getInt(Message.enterNum1 + (playerMap.size() +1));
			if(choice > 0 && choice <= playerMap.size()) {
				chosenPlayer = playerMap.get(choice);
			} else if(choice == playerMap.size() + 1) {
				System.out.println(Message.cancelling);
				if(UserInput.isSpeak()) {
					new Speech(Message.cancelling);
				}
				chosenPlayer = null;
			} else {
				System.out.println(Message.invalidOption);
				if(UserInput.isSpeak()) {
					new Speech(Message.invalidOption);
				}
			}
		} while(choice <= 0 || choice > playerMap.size() +1);
		
		return chosenPlayer;
	}
}
