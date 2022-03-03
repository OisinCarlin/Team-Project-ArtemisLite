/**
 * 
 */
package g11ArtemisLite;

/**
 * @author maeve
 *
 */
public class ArtemisLiteSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArtemisLiteSystem artemisLiteSystem = new ArtemisLiteSystem();

	}
	
	public ArtemisLiteSystem() {
		PlayerManager playerManager = new PlayerManager();
		
		GameManager gameManager = new GameManager(playerManager);
		gameManager.start();
	}

}
