/**
 * 
 */
package g11ArtemisLite;

import java.util.List;

/**
 * @author crclarke
 *
 */
public class GameManager {
	
	private PlayerManager pm;
	private Game game;

	/**
	 * 
	 */
	public GameManager(PlayerManager pm) {
		this.pm = new PlayerManager();
	}
	
	public void start() {
		List<String> usernames = pm.getUserData();
		
		game = new Game();
		game.start(usernames);
	}

}
