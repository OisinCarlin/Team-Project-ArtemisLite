/**
 * 
 */
package g11ArtemisLite;

/**
 * @author maeve
 *
 */
public class ArtemisLiteSystem implements java.io.Serializable {
	
	private static final long serialVersionUID = 2938313309603492644L;

	/**
	 * Instantiates artemisLiteSystem
	 * @param args
	 */
	public static void main(String[] args) {
		ArtemisLiteSystem artemisLiteSystem = new ArtemisLiteSystem();

	}
	
	/**
	 * Starts the game
	 */
	public ArtemisLiteSystem() {
		PlayerManager playerManager = new PlayerManager();
		
		GameManager gameManager = new GameManager(playerManager);
		gameManager.start();
	}

}
