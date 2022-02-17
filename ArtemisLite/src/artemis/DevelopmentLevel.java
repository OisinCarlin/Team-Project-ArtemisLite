/**
 * 
 */
package artemis;

/**
 * adds an int levelNum to each DevelopmentLevel value for ease of switch statement
 * @author crclarke
 *
 */
public enum DevelopmentLevel {
	NONE (0),
	MINOR1 (1),
	MINOR2 (2),
	MINOR3 (3),
	MAJOR (4);
	
	private final int levelNum;

	DevelopmentLevel(int levelNum) {
		this.levelNum = levelNum;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the levelNum
	 */
	public int getLevelNum() {
		return levelNum;
	}

}
