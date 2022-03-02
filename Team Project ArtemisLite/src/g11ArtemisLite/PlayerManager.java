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

}
