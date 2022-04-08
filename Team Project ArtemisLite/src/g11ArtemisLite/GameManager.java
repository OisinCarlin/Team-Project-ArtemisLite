/**
 * 
 */
package g11ArtemisLite;

import java.util.List;

/**
 * @author crclarke
 *
 */
public class GameManager implements java.io.Serializable {
	
	private static final long serialVersionUID = 2938313309603492644L;
	
	private PlayerManager pm;
	private Game game;

	/**
	 * Constructor instantiates new PlayerManager
	 */
	public GameManager(PlayerManager pm) {
		this.pm = new PlayerManager();
	}
	
	/**
	 * starts the game
	 */
	public void start() {
		List<String> usernames = pm.getUserData();
		
		game = new Game();
		game.start(usernames);
	}

}
