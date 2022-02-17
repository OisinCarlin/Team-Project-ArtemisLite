/**
 * 
 */
package artemis;

/**
 * @author crclarke
 *
 */
public abstract class Square {

	private String squareName;

	public Square() {

	}

	/**
	 * @param squareName
	 */
	public Square(String squareName) {
		this.squareName = squareName;
	}

	/**
	 * @return the squareName
	 */
	public String getSquareName() {
		return squareName;
	}

	/**
	 * @param squareName the squareName to set
	 */
	public void setSquareName(String squareName) {
		this.squareName = squareName;
	}
	
	public void displayAll() {
		System.out.println("Square Name:\t\t"+this.squareName);
	}

}
