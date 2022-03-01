/**
 * 
 */
package g11ArtemisLite;

import java.util.List;

/**
 * This class returns the values of userCount, userNames and creates a list of players
 * 
 * IMPORTANT - Potential fixes needed for getUsernames and createPlayer methods,
 * getUserCount should be grand
 * @author jamielarkin
 *
 */
public class PlayerManager {
	
	private List<Player> createPlayers;
	private UserInput userInput;
	
	
	// maxUsers and minUsers values can be changed depending on game specification.
	public int maxUsers = 4;
	public int minUsers = 2;
	
	
	/**
	 * @param createPlayers
	 * @param userInput
	 */
	public PlayerManager(List<Player> createPlayers, UserInput userInput) {
		super();
		this.createPlayers = createPlayers;
		this.userInput = userInput;
	}
	
	
		/**
		 * Getting the userNames from the requestUsernames method in UserInput
		 * @param userInput
		 * @return
		 */
		public List<String> getUsernames(UserInput userInput) {
			return userInput.requestUsernames(null, 0);
			
		}

		/**
		 * Getting the userCount from the requestUserNumber method in UserInput
		 * @param userInput
		 * @return
		 */
		public int getUserCount(UserInput userInput) {
			return userInput.requestUserNumber(maxUsers, minUsers);
	}
		
		/**
		 *  Creating the players from the array list in UserInput
		 * @param usernames
		 * @param userCount
		 */
		public void createPlayers(UserInput userInput) {
			List<String> usernames = List.of();
			List<String> createPlayers = List.copyOf(usernames);
			
			
		}
		
	}
	
	



